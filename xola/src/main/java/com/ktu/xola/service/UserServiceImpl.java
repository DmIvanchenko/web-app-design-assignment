package com.ktu.xola.service;

import com.ktu.xola.exception.EmailAlreadyInUseException;
import com.ktu.xola.exception.ResourceNotFoundException;
import com.ktu.xola.model.User;
import com.ktu.xola.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User createUser(User user) throws EmailAlreadyInUseException {
        if(userRepository.findByEmail(user.getEmail())!=null){
            throw new EmailAlreadyInUseException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userDb = this.userRepository.findById(user.getId());
        if (userDb.isPresent()){
            User updatedUser = userDb.get();
            updatedUser.setId(user.getId());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            userRepository.save(updatedUser);
            return updatedUser;
        }else {
            throw new ResourceNotFoundException("Record not found " + user.getId());
        }
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User findUserById(int userId) {
        Optional<User> userDb = this.userRepository.findById(userId);
        if (userDb.isPresent()){
            return userDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found " + userId);
        }

    }

    @Override
    public void deleteUser(int id) {
        Optional<User> userDb = this.userRepository.findById(id);

        if (userDb.isPresent()){
            this.userRepository.delete(userDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found " + id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        System.out.println(username);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }
}
