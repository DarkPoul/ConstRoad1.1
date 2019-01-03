package com.ntu.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigurationTest {
    public static void main(String[] args) {
        ApplicationContext contex =
                new ClassPathXmlApplicationContext(
                        "com/ntu/api/spring/database/configuration.xml");
    }
}
