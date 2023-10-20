public class workflow {
    public int immigrantId;
    public String immigrantStatus;

    public workflow(int immigrantId, String immigrantStatus) {
        this.immigrantId = immigrantId;
        this.immigrantStatus = immigrantStatus;
    }

    private boolean updateDatabase(int immigrantId, String immigrantStatus) {

        return false;
    }

    public String pushToReviewer() {

        return "";

    }

    public String pushToApprover(int immigrantId, String immigrantStatus) {
        
        return "";
    }
}
