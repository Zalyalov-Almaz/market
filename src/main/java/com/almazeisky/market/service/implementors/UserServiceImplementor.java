package com.almazeisky.market.service.implementors;

import com.almazeisky.market.exception.PasswordCreationException;
import com.almazeisky.market.mapper.UserMapper;
import com.almazeisky.market.model.dto.UserDto;
import com.almazeisky.market.model.entity.User;
import com.almazeisky.market.repository.UserRepository;
import com.almazeisky.market.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImplementor implements UserDetailsService, UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public User create(UserDto dto) {
        if (!Objects.equals(dto.password(), dto.matchingPassword())) {
            throw new PasswordCreationException("Passwords don't match");
        }
        User user = mapper.toEntity(dto);
        user.setPassword(encoder.encode(dto.password()));

        return repository.save(user);
    }

    @Override
    public User getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Page<User> getAll(Integer offset, Integer limit) {
        return repository.findAll(PageRequest.of(offset, limit));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.getFirstByUsername(username)
                         .orElseThrow(() -> new UsernameNotFoundException(
                         "User with " + "\"" + username + "\"" + " username not found"));
    }
}
