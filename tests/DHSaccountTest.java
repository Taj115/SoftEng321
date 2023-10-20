package tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
// import org.junit.jupiter.api.Test;

import org.junit.Test;

import src.DHSaccount;

public class DHSaccountTest {
    
    @Test
    public void SendImmigrantStatusTest1() {
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, "Test Status 123");
        assertEquals(test.sendImmigrantStatus(test.immigrantStatus), true);
    }
    
    @Test
    public void SendImmigrantStatusTest2() {
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, " ");
        assertEquals(test.sendImmigrantStatus(test.immigrantStatus), false);
    }

    @Test
    public void SendImmigrantStatusTest3() {
        DHSaccount test = new DHSaccount("Bob Franz", "bfranz", 123, null);
        assertEquals(test.sendImmigrantStatus(test.immigrantStatus), false);
    }
}
