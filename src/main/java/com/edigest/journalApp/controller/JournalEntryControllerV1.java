//package com.edigest.journalApp.controller;
//
//import com.edigest.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV1 {
//    private Map<Long, JournalEntry> journalEntries=new HashMap();
//@GetMapping
//public List<JournalEntry> getAll(){
//    return new ArrayList<>(journalEntries.values());
//}
//@PostMapping
//public boolean createEntry(@RequestBody JournalEntry myEntry){
//    journalEntries.put(myEntry.getId(),myEntry);
//    return true;
//}
//@GetMapping("id/{myId}")
//public JournalEntry getJournalEntryById(@PathVariable Long myId){
//    return journalEntries.get(myId);
//}
//@DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournalEntryById(@PathVariable Long myId,@RequestBody JournalEntry myEntry){
//    return journalEntries.remove(myId);
//}
//    @PutMapping("id/{myId}")
//    public JournalEntry putJournalEntryById(@PathVariable Long myId,@RequestBody JournalEntry myEntry){
//        return journalEntries.put(myId,myEntry);
//    }
//}












//
//
//package com.edigest.journalApp.controller;
//
//import com.edigest.journalApp.entity.JournalEntry;
//import com.edigest.journalApp.entity.User;
//import com.edigest.journalApp.service.JournalEntryService;
//import com.edigest.journalApp.service.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.Authenticator;
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalEntryControllerV2 {
//    @Autowired
//    private JournalEntryService journalEntryService;
//    @Autowired
//    private UserService userService;
//    @GetMapping()
//    public ResponseEntity<?> getAllJournalEntriesOfUser(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = authentication.getName();
//        User user=userService.findByUserName(userName);
//        List<JournalEntry> all = user.getJournalEntries();
//        if(!all.isEmpty() && all!=null){
//            return new ResponseEntity<>(all,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @PostMapping("/{userName}")
//    public ResponseEntity<?> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String userName){
//        try {
////           myEntry.setDate(LocalDateTime.now());
////           User user=userService.findByUserName(userName);
////           user.setJournalEntries(Arrays.asList(myEntry));
//            journalEntryService.saveEntry(myEntry,userName);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }catch(Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//    @GetMapping("id/{myId}")
//    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
//        Optional<JournalEntry> byId = journalEntryService.findById((myId));
//        if(byId.isPresent()){
//            return new ResponseEntity<>(byId.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    @DeleteMapping("id/{userName}/{myId}")
//    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId,@PathVariable String userName){
//        journalEntryService.deleteById(myId,userName);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    @PutMapping("id/{myId}/{userName}")
//    public ResponseEntity<?> putJournalEntryById(
//            @PathVariable ObjectId myId,
//            @RequestBody JournalEntry newEntry,
//            String userName
//    ){
//        JournalEntry oldEntry=journalEntryService.findById(myId).orElse(null);
//        if(oldEntry!=null){
//            oldEntry.setContent(newEntry.getContent()!=null && newEntry.getContent()!=""?newEntry.getContent():oldEntry.getContent());
//            oldEntry.setTitle(newEntry.getTitle()!=null && newEntry.getTitle()!=""?newEntry.getTitle():oldEntry.getTitle());
//            journalEntryService.saveEntry(oldEntry);
//            return new ResponseEntity<>(oldEntry,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//    }
//}
