package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.JournalEntry;
import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.service.JournalEntryService;
import com.edigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<?> getAllJournalEntriesOfUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(!all.isEmpty() && all!=null){
           return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody JournalEntry myEntry){
       try {
//           myEntry.setDate(LocalDateTime.now());
//           User user=userService.findByUserName(userName);
//           user.setJournalEntries(Arrays.asList(myEntry));
           Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
           String userName = authentication.getName();
           journalEntryService.saveEntry(myEntry,userName);
           return new ResponseEntity<>(HttpStatus.CREATED);
       }catch(Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry>collect = user.getJournalEntries().stream().filter(journalEntry -> journalEntry.getId().equals(myId)).collect(Collectors.toList());
        if(!collect.isEmpty()){
            Optional<JournalEntry> byId = journalEntryService.findById((myId));
            if(byId.isPresent()){
                return new ResponseEntity<>(byId.get(), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed=journalEntryService.deleteById(myId,userName);
        if(removed){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("id/{myId}")
    public ResponseEntity<?> putJournalEntryById(
            @PathVariable ObjectId myId,
            @RequestBody JournalEntry newEntry
    ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntry> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
        if(!collect.isEmpty()) {
            JournalEntry oldEntry=journalEntryService.findById(myId).orElse(null);
            if(oldEntry!=null){
                oldEntry.setContent(newEntry.getContent()!=null && newEntry.getContent()!=""?newEntry.getContent():oldEntry.getContent());
                oldEntry.setTitle(newEntry.getTitle()!=null && newEntry.getTitle()!=""?newEntry.getTitle():oldEntry.getTitle());
                journalEntryService.saveEntry(oldEntry);
                return new ResponseEntity<>(oldEntry,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
