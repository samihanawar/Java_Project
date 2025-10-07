//
//package com.crimeRepo.crs;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.List;
//import java.util.Optional;
//
//@DataJpaTest
//@ActiveProfiles("test") // Uses src/test/resources/application-test.properties
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    void testSaveUser() {
//        User user = new User();
//        user.setName("John");
//        user.setPassword("pass123");
//        user.setRole("USER");
//
//        User saved = userRepository.save(user);
//        assertNotNull(saved.getName());
//        assertEquals("John", saved.getName());
//    }
//
//
//    @Test
//    void testUpdateUserPassword() {
//        User user = new User();
//        user.setName("Mike");
//        user.setPassword("oldpass");
//        user.setRole("USER");
//        User saved = userRepository.save(user);
//
//        saved.setPassword("newpass");
//        User updated = userRepository.save(saved);
//
//        assertEquals("newpass", updated.getPassword());
//    }
//
//    @Test
//    void testDeleteUser() {
//        User user = new User();
//        user.setName("Sarah");
//        user.setPassword("delete123");
//        user.setRole("ADMIN");
//        User saved = userRepository.save(user);
//
//        userRepository.delete(saved);
//        Optional<User> found = userRepository.findByname(saved.getName());
//
//        assertFalse(found.isPresent());
//    }
//
//    @Test
//    void testFindAllUsers() {
//        User user1 = new User();
//        user1.setName("U1");
//        user1.setPassword("p1");
//        user1.setRole("USER");
//
//        User user2 = new User();
//        user2.setName("U2");
//        user2.setPassword("p2");
//        user2.setRole("POLICE");
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//
//        List<User> all = userRepository.findAll();
//        assertEquals(2, all.size());
//    }
//
////    @Test
////    public void testFindByRoleCustomQuery() {
////        // Arrange: Insert two police users
////        User u1 = new User();
////        u1.setName("Ravi");
////        u1.setPassword("pass123");
////        u1.setRole("Police");
////        userRepository.save(u1);
////
////        User u2 = new User();
////        u2.setName("Amit");
////        u2.setPassword("pass456");
////        u2.setRole("Police");
////        userRepository.save(u2);
////
////        // Act: Fetch police users using custom query
////        List<User> policeUsers = userRepository.findByRoleCustomQuery("Police");
////
////        // Assert: Check number of police users
////        assertEquals(2, policeUsers.size(), "Should return 2 police users");
////
////        // Assert: Check details of first user
////        assertEquals("Ravi", policeUsers.get(0).getName());
////        assertEquals("Police", policeUsers.get(0).getRole());
////    }
//
//}
