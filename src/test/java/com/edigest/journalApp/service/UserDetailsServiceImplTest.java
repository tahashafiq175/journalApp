//package com.edigest.journalApp.service;
//import com.edigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.edigest.journalApp.entity.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//@ExtendWith(MockitoExtension.class)
//public class UserDetailsServiceImplTest {
//    @InjectMocks
//    UserDetailsServiceImpl userDetailsService;
//    @Mock
//    private UserRepository userRepository;
//    @BeforeEach
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//    @Test
//    @Disabled
//void loadByUserNameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn( User.builder().userName("taha").password("tahaa").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("taha");
//        Assertions.assertNotNull(user);
//    }
//}
//
//
