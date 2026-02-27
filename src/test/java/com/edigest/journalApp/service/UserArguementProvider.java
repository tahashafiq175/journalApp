//package com.edigest.journalApp.service;
//
//import com.edigest.journalApp.entity.User;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//
//import java.util.Arrays;
//import java.util.stream.Stream;
//
//public class UserArguementProvider implements ArgumentsProvider {
//
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
//
//        // First test user (valid)
//        User user1 = new User();
//        user1.setUserName("usman");
//        user1.setPassword("usman");
//        user1.setRoles(Arrays.asList("USER"));
//
//        // Second test user (invalid / edge case)
//        User user2 = new User();
//        user2.setUserName("ali");
//        user2.setPassword("jkjk");
//        user2.setRoles(Arrays.asList("ali"));
//
//        return Stream.of(
//                Arguments.of(user1),
//                Arguments.of(user2)
//        );
//    }
//}