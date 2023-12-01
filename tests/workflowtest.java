package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import src.DHSaccount;
import src.workflow;

public class workflowtest {

    //Test to make sure that the workflow constructor doesn't allow for an id of 0 - Tajveer Saini
    @Test
    public void workflowConstructorZeroTest(){
        workflow obj = new workflow();
        obj.addAccDatabase(new DHSaccount("bob", "0"));

        assertFalse("Workflow object shouldn't have an id of 0", obj.getImmigrantStatus().equals("0"));
    }

    //Test to make sure that the workflow constructor doesn't allow for an immigrantStatus of null - Tajveer Saini
    @Test
    public void workflowConstructorNullTest(){
        workflow obj = new workflow();
        obj.addAccDatabase(new DHSaccount("nullBob", null));

        assertFalse("Workflow object shouldn't have a string of null", obj.getImmigrantStatus().equals("null"));
    }

    //Test to make sure there's no empty string - Taj
    @Test
    public void workflowConstructorEmptyStringTest(){
        workflow obj = new workflow();
        obj.addAccDatabase(new DHSaccount("", "71"));
        
        assertFalse("Workflow object shouldn't have a string that's empty", obj.getImmigrantStatus().equals(""));
    }
    
    //Test to make sure there's no negative tests - Taj
    @Test
    public void workflowConstructorNegativeTest(){
        workflow obj = new workflow();
        obj.addAccDatabase(new DHSaccount("Bob", "-5"));
        
        assertTrue("Workflow object shouldn't have a negative number", Integer.parseInt(obj.getImmigrantID()) < 0);
    }

}