package me.kavinduchamiran.urlshortener.service;

import lombok.RequiredArgsConstructor;
import me.kavinduchamiran.urlshortener.entities.User;
import me.kavinduchamiran.urlshortener.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final IUserRepository userRepository;

//    private final PasswordEncoder passwordEncoder;

    public User createUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        return userRepository.save(user);
    }

    public void activateUser(String id, User user) {
        user.setId(id);
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
