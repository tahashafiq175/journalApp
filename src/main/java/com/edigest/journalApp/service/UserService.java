package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j

public class UserService {
    private  static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;
//    private static final Logger logger= LoggerFactory.getLogger(JournalEntryService.class);
    public boolean saveNewUser(User userEntry){
 try {
     userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
     userEntry.setRoles(Arrays.asList("USER"));
     userRepository.save(userEntry);
     return true;
 }catch (Exception e) {
     log.error("error occured for {}:", userEntry.getUserName(),e);
     log.warn("hahaha");
     log.info("hahaha");
     log.trace("hahaha");
     log.debug("hahaha");

     return false;
 }
}
public void saveUser(User user){
    userRepository.save(user);
}
public List<User> getAll(){
    return userRepository.findAll();
}
public Optional<User> findById(ObjectId Id){
    return userRepository.findById(Id);
}
 public void deleteById(ObjectId Id){
     userRepository.deleteById(Id);
 }
 public User findByUserName(String userName){
    return userRepository.findByUserName(userName);
 }

    public void deleteByUserName(String userName) {
    userRepository.deleteByUserName(userName);
    }
}
