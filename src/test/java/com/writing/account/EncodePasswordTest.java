package com.writing.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncodePasswordTest {

    @Test
    public void testEncodePassword() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String passwordRaw = "cuongabc123";
        String encode = passwordEncoder.encode(passwordRaw);
        System.out.println("after: " + encode);
    }
}
