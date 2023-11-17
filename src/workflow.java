package src;
import java.util.LinkedList;
import java.util.Queue;

public class workflow {
    private Queue<DHSaccount> list;

    public workflow() {
        list = new LinkedList<>();
    }

    // Updates the Database with new information 
    public boolean addAccDatabase(DHSaccount acc) {
        list.add(acc);
        return true;
    }

    public boolean remAccDatabase() {
        list.remove();
        return true;
    }

    public void startDataEntry() {
        @SuppressWarnings("unused")
        DataEntry d = new DataEntry(this);
    }

    // Pushes the information of the immigrant to the reviewer to make changes
    public void pushToReviewer(DHSaccount acc) {
        @SuppressWarnings("unused")
        Reviewer r = new Reviewer(acc, this, "Reviewer BETA");
    }

    // Pushes the information of the immigrant to the approver to approve changes and submit
    public void pushToApprover(DHSaccount acc) {
        @SuppressWarnings("unused")
        Approver a = new Approver(acc, this);
    }


}
