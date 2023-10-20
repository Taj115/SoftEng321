package tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
// import org.junit.jupiter.api.Test;

import org.junit.Test;

import src.DHSaccount;

public class DHSaccountTest {
    @Test
    public void DHSconstructorTest1() { // Antonios - Test for Negative ID numbers to be sent to -1
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", -123124, "Test Status");
        assertEquals(-1, test.immigrantId);
    }

    @Test
    public void DHSconstructorTest2() { // Antonios - Test for a NULL immigrant Status in constructor
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, null);
        assertEquals(null, test.immigrantStatus);
    }

    @Test
    public void DHSconstructorTest3() { // Antonios - Test for an EMPTY immigrant Status in constructor
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, "");
        assertEquals(null, test.immigrantStatus);
    }

    @Test
    public void SendImmigrantStatusTest1() { // Antonios - Test for a valid immigrant Status
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, "Test Status 123");
        assertEquals(true, test.sendImmigrantStatus(test.immigrantStatus));
    }

    @Test
    public void SendImmigrantStatusTest2() { // Antonios - Test for a invalid immigrant status in Method
        DHSaccount test = new DHSaccount("Fred Zach", "bfranz", 1, " ");
        assertEquals(false, test.sendImmigrantStatus(test.immigrantStatus));
    }

    @Test
    public void SendImmigrantStatusTest3() { // Antonios - Test for invalid immigrant status in method
        DHSaccount test = new DHSaccount("Pop Man", "bfranz", 3, null);
        assertEquals(false, test.sendImmigrantStatus(test.immigrantStatus));
    }
}