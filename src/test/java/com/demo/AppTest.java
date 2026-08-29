package com.demo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testGreet() {
        assertEquals("Hello Jenkins Pipeline!", App.greet());
    }
}