package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.JournalEntry;
import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
@Autowired
    private JournalEntryRepository journalEntryRepository;
@Autowired
UserService userService;


@Transactional
public void saveEntry(JournalEntry journalEntry, String userName){
    try {
        User user=userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry save = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(save);
        userService.saveUser(user);
    }catch (Exception e){
//        System.out.println(e.getMessage());
        throw new RuntimeException(e);
    }
}
public void saveEntry(JournalEntry journalEntry){
    journalEntryRepository.save(journalEntry);
}
public List<JournalEntry> getAll(){
    return journalEntryRepository.findAll();
}
public Optional<JournalEntry> findById(ObjectId Id){
    return journalEntryRepository.findById(Id);
}
@Transactional
 public boolean deleteById(ObjectId Id, String userName){
    boolean removed=false;
try {
    User user=userService.findByUserName(userName);
    removed=user.getJournalEntries().removeIf(x->x.getId().equals(Id));
    if(removed){
        userService.saveUser(user);
        journalEntryRepository.deleteById(Id);
    }
}catch (Exception e){
    System.out.println(e.getMessage());
    throw new RuntimeException("An error occur while deleting an entry");
}
   return removed;
}
}
