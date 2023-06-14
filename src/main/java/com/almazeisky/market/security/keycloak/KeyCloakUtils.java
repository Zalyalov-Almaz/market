package com.almazeisky.market.security.keycloak;

import com.almazeisky.market.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class KeyCloakUtils {

    @Value("${keycloak.auth-server-url}")
    private String serverURL;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.access.username}")
    private String username;
    @Value("${keycloak.access.password}")
    private String password;

    private final PasswordEncoder encoder;

    private static Keycloak keycloak;

    public Keycloak getInstance() {
        if (keycloak == null) {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverURL)
                    .realm(realm)
                    .clientId(clientId)
                    .grantType(OAuth2Constants.PASSWORD)
                    .username(username)
                    .password(encoder.encode(password))
                    .build();
        }
        return keycloak;
    }

    public Response createKeycloakUser(User user) {
        RealmResource realmResource = getInstance().realm(realm);
        UsersResource usersResource = realmResource.users();
        CredentialRepresentation credentialRepresentation = createPasswordCredentials(user.getPassword());

        UserRepresentation kcUser = new UserRepresentation();
        kcUser.setUsername(user.getUsername());
        kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
        kcUser.setEmail(user.getRequisites().get(0).getEmail());
        kcUser.setEnabled(true);
        kcUser.setEmailVerified(false);

        return usersResource.create(kcUser);
    }

    private CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(password);
        return credentialRepresentation;
    }
}
