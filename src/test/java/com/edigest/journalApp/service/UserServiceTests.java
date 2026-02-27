//package com.edigest.journalApp.service;
//
//import com.edigest.journalApp.entity.User;
//import com.edigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class UserServiceTests {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserService userService;
//    @Disabled
//    @Test
//    public void testFindByUserName(){
//        User user =userRepository.findByUserName("taha");
//        assertTrue(!user.getJournalEntries().isEmpty());
//        assertEquals(4,2+2);
//        assertNotNull(userRepository.findByUserName("taha"));
//    }
//    @Disabled
//    @ParameterizedTest
//    @ArgumentsSource(UserArguementProvider.class)
//    public void testNewUser(User user){
//        assertTrue(userService.saveNewUser(user));
//    }
//        @ParameterizedTest
//    @ValueSource(strings={
//            "taha",
//            "shafiq",
//            "usama"
//    })
//        @Disabled
//    public void testFindByUserName2(String userName){
//      assertNotNull(userRepository.findByUserName(userName),"failed for "+userName);
//    }
//
////    @ParameterizedTest
////    @CsvSource({
////            "taha",
////            "shafiq",
////            "usama"
////    })
////    public void testFindByUserName2(String userName){
////      assertNotNull(userRepository.findByUserName(userName),"failed for "+userName);
////    }
//
//
//}
