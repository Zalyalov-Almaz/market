package com.almazeisky.market.service.implementors;

import com.almazeisky.market.exception.PasswordCreationException;
import com.almazeisky.market.exception.UserIdNotFoundException;
import com.almazeisky.market.mapper.UserMapper;
import com.almazeisky.market.model.entity.User;
import com.almazeisky.market.model.entity.dto.UserDto;
import com.almazeisky.market.repository.UserRepository;
import com.almazeisky.market.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    /*private final PasswordEncoder encoder;
    private final KeyCloakUtils keyCloakUtils;*/

    @Override
    @Transactional
    public User create(UserDto dto) {
        if (!Objects.equals(dto.password(), dto.matchingPassword())) {
            throw new PasswordCreationException("Passwords don't match");
        }
        User user = mapper.toEntity(dto);
        user.setPassword(dto.password());
        /*user.setPassword(encoder.encode(dto.password()));*/
        /*keyCloakUtils.createKeycloakUser(user);*/

        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User userToUpdate = repository.getReferenceById(user.getId().toString());
        userToUpdate.setUsername(user.getUsername());
        /*userToUpdate.setPassword(encoder.encode(user.getPassword()));*/
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRequisites(user.getRequisites());
        userToUpdate.setRoles(user.getRoles());
        userToUpdate.setBucket(user.getBucket());
        userToUpdate.setArchived(user.isArchived());
        return repository.save(userToUpdate);
    }

    @Override
    public User getById(UUID id) {
        Optional<User> oneByUuid = repository.findOneById(id);
        User user = oneByUuid.orElseThrow(() -> new UserIdNotFoundException("User ID not found"));
        return user;
    }

    @Override
    public Page<User> getAll(Integer offset, Integer limit) {
        return repository.findAll(PageRequest.of(offset, limit));
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

}
