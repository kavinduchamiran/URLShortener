package me.kavinduchamiran.urlshortener.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.kavinduchamiran.urlshortener.entities.User;
import me.kavinduchamiran.urlshortener.repository.IUserRepository;
import me.kavinduchamiran.urlshortener.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user, BindingResult bindingResult, UriComponentsBuilder ucb) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        User savedUser = userService.createUser(user);
        URI locationOfNewUser = ucb
                .path("/users/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(locationOfNewUser).build();
    }
}
