package com.efimchick.jkblog;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: efimchick
 * Date: 11.10.13
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration("classpath:db.xml")
public class H2Tests {

    @Test
    public void test(String[] args) throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());

        Connection conn = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");

        conn.close();
    }
}
