package tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
// import org.junit.jupiter.api.Test;

import org.junit.Test;

import src.DHSaccount;

public class DHSaccountTest {
    @Test
    public void DHSconstructorTest1() { // Antonios
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", -123124, "Test Status");
        assertEquals(test.immigrantId, -1);
    }

    @Test
    public void DHSconstructorTest2() { // Antonios
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, null);
        assertEquals(test.immigrantStatus, null);
    }

    @Test
    public void DHSconstructorTest3() { // Antonios
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, "");
        assertEquals(test.immigrantStatus, null);
    }

    @Test
    public void SendImmigrantStatusTest1() { // Antonios
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, "Test Status 123");
        assertEquals(test.sendImmigrantStatus(test.immigrantStatus), true);
    }

    @Test
    public void SendImmigrantStatusTest2() { // Antonios
        DHSaccount test = new DHSaccount("Fred Zach", "bfranz", 1, " ");
        assertEquals(test.sendImmigrantStatus(test.immigrantStatus), false);
    }

    @Test
    public void SendImmigrantStatusTest3() { // Antonios
        DHSaccount test = new DHSaccount("Pop Man", "bfranz", 3, null);
        assertEquals(test.sendImmigrantStatus(test.immigrantStatus), false);
    }
}
