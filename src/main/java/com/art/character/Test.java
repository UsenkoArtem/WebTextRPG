package com.art.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource(value = {"classpath:App.properties"})
public class Test {
    @Autowired
    private static Environment environment;

    public static void main(String[] args) {


    }
}
