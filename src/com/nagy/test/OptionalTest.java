package com.nagy.test;

import com.nagy.java.OptionalMethods;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OptionalTest {
    public final String USER_STATUS = "UNKNOWN";
    public static OptionalMethods optional;

    @BeforeClass
    public static void setUp() {
        System.out.println("Set up optional" );
        optional = new OptionalMethods();
    }

    @Test()
    public void findUserSatusTest(){
        System.out.println("Check orElse ");
        assertEquals(USER_STATUS,optional.findUserStatus(1) );
    }

    @Test
    public void findUserStatusComputedTest(){
        System.out.println("Check orElseGet" );
        assertEquals("Messi",  optional.findUserSatusComputed(1));
    }

    @Test(expected = IllegalStateException.class)
    public void findUserThrownAnException() {
        System.out.println("Check Illegalstatiexception with orElseThrown");
        assertNotEquals("Mesii", optional.findUserStatusExceptionThrown(1));
    }

    @Test
    public void optionalMapTransferTest() {
        assertEquals("MESSI", optional.optionalMapTransfer());
    }

    @Test
    public void optionalMapTest() {
        assertEquals("LABDA", optional.optionalStreamMap());
    }
}
