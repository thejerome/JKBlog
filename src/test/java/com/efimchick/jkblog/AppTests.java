package com.efimchick.jkblog;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


public class AppTests {
    private MockMvc mockMvc;

    static ApplicationContext applicationContext;

    @BeforeClass
    public static void setUp() throws Exception {
        applicationContext = new GenericGroovyApplicationContext("classpath:repos.groovy");
    }

    @Test
    public void simple1() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isMovedTemporarily());


    }@Test
    public void simple2() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}
