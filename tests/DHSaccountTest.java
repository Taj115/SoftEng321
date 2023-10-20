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
        assertEquals(-1, test.immigrantId);
    }

    @Test
    public void DHSconstructorTest2() { // Antonios
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, null);
        assertEquals(null, test.immigrantStatus);
    }

    @Test
    public void DHSconstructorTest3() { // Antonios
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, "");
        assertEquals(null, test.immigrantStatus);
    }

    @Test
    public void SendImmigrantStatusTest1() { // Antonios
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, "Test Status 123");
        assertEquals(true, test.sendImmigrantStatus(test.immigrantStatus));
    }

    @Test
    public void SendImmigrantStatusTest2() { // Antonios
        DHSaccount test = new DHSaccount("Fred Zach", "bfranz", 1, " ");
        assertEquals(false, test.sendImmigrantStatus(test.immigrantStatus));
    }

    @Test
    public void SendImmigrantStatusTest3() { // Antonios
        DHSaccount test = new DHSaccount("Pop Man", "bfranz", 3, null);
        assertEquals(false, test.sendImmigrantStatus(test.immigrantStatus));
    }
}
