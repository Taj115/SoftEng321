package tests;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import src.workflow;

public class workflowtest {

    //Test to make sure that the workflow constructor doesn't allow for an id of 0 - Tajveer Saini
    @Test
    public void workflowConstructorZeroTest(){
        workflow obj = new workflow(0, "James Carter");

        assertFalse("Workflow object shouldn't have an id of 0", obj.immigrantId == 0);
    }

    //Test to make sure that the workflow constructor doesn't allow for an immigrantStatus of null - Tajveer Saini
    @Test
    public void workflowConstructorNullTest(){
        workflow obj = new workflow(25, null);
        assertFalse("Workflow object shouldn't have a string of null", obj.immigrantStatus == null);
    }

    //Test to make sure there's no empty string - Taj
    @Test
    public void workflowConstructorEmptyStringTest(){
        workflow obj = new workflow(71, "");
        assertFalse("Workflow object shouldn't have a string that's empty", obj.immigrantStatus == "");
    }
    
    //Test to make sure there's no negative tests - Taj
    @Test
    public void workflowConstructorNegativeTest(){
        workflow obj = new workflow(-5, "Bob");
        assertTrue("Workflow object shouldn't have a negative number", obj.immigrantId > 0);
    }

    //Test to see if database updated - Taj
    @Test
    public void workflowUpdateDatabase(){
        workflow obj = new workflow(50, "James");
        assertEquals(obj.updateDatabase(obj.immigrantId, obj.immigrantStatus), true);
    }

    //Push to reviewer test - Taj
    @Test
    public void workflowPushToReviewerTest(){

        workflow obj = new workflow(50, "Martin");
        assertEquals(obj.pushToReviewer(), "Message has been approved");

    }

    //Test to check for invalid workflow object status- NULL check- Siddharth
    @Test
    public void pushToApproverNullStatusTest() {
        workflow obj = new workflow(123, null);
        assertEquals("Cannot push workflow object with NULL status", obj.pushToApprover(obj.immigrantId, obj.immigrantStatus));
    }

    //Test to check for an empty status being pushed to Approver- Siddharth
    @Test
    public void pushToApproverEmptyStatusTest() {
        workflow obj = new workflow(123, "");
        assertEquals("Cannot push workflow object with empty status", obj.pushToApprover(obj.immigrantId, obj.immigrantStatus));
    }

    //Test to check for negative ID being pushed to Approver- Siddharth
    @Test
    public void pushToApproverNegIdTest() {
        workflow obj = new workflow(-234, "Bob");
        assertEquals("Cannot push workflow object with negative ID.", obj.pushToApprover(obj.immigrantId, obj.immigrantStatus));
    }

    //Test to check that an expected log message is printed on a succesful push to approver- Siddharth
    @Test
    public void workflowPushToApproverTest() {
        workflow obj = new workflow(123, "Jan");
        assertEquals("Message has been pushed to approver", obj.pushToApprover(obj.immigrantId, obj.immigrantStatus));
    }

}