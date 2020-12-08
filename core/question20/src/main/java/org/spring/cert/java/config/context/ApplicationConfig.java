package org.spring.cert.java.config.context;


import org.apache.commons.codec.digest.DigestUtils;
import org.spring.cert.java.config.context.beans.SpringBean1;
import org.spring.cert.java.config.context.beans.SpringBean2;
import org.spring.cert.java.config.context.beans.SpringBean3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.MessageDigest;

@Configuration
public class ApplicationConfig {
    @Bean
    @Autowired
    public SpringBean1 springBean1(SpringBean2 springBean2, SpringBean3 springBean3) {
        return new SpringBean1(springBean2, springBean3);
    }

    @Bean
    public SpringBean2 springBean2() {
        return new SpringBean2();
    }

    @Bean
    @Autowired
    public SpringBean3 springBean3(MessageDigest messageDigest) {
        return new SpringBean3(messageDigest);
    }

    @Bean
    public MessageDigest messageDigest() {
        return DigestUtils.getSha384Digest();
    }
}