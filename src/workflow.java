package src;
public class workflow {
    public int immigrantId;
    public String immigrantStatus;

    public workflow(int immigrantId, String immigrantStatus) {
        this.immigrantId = immigrantId;
        this.immigrantStatus = immigrantStatus;
    }

    // Updates the Database with new information 
    public boolean updateDatabase(int immigrantId, String immigrantStatus) {

        return false;
    }

    // Pushes the information of the immigrant to the reviewer to make changes
    public String pushToReviewer(int immigrantId, String immigrantStatus) {

        return "";

    }

    // Pushes the information of the immigrant to the approver to approve changes and submit
    public String pushToApprover(int immigrantId, String immigrantStatus) {

        return "";
    }


}
