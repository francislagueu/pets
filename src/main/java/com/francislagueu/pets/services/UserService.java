package com.francislagueu.pets.services;

import com.francislagueu.pets.models.user.User;
import com.francislagueu.pets.repositories.user.UserRepository;
import com.francislagueu.pets.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username or email: "+usernameOrEmail));

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String id){
        User user = userRepository.findById(id).orElseThrow(
                ()->new UsernameNotFoundException("User not found with id: "+ id)
        );

        return UserPrincipal.create(user);
    }
}
