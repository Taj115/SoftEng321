import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

class workflowTest {

    //Test to make sure that the workflow constructor doesn't allow for an id of 0
    @Test
    void workflowConstructorZeroTest(){
        workflow obj = new workflow(0, "James Carter");

        assertFalse("Workflow object shouldn't have an id of 0", obj.immigrantId == 0);
    }

    //Test to make sure that the workflow constructor doesn't allow for an immigrantStatus of null
    @Test
    void workflowConstructorNullTest(){
        workflow obj = new workflow(25, null);

        assertFalse("Workflow object shouldn't have a string of null", obj.immigrantStatus == null);
    }



}