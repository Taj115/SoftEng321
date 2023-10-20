public class bobj {
    private String dhsName, dhsId;

    public int immigrantId;
    public String immigrantStatus;
    protected String newStatus;

    public boolean isFormatValid;
    protected boolean approved;

    public bobj(String dhsName, String dhsId, int immigrantId, String immigrantStatus) {
        this.dhsName = dhsName;
        this.dhsId = dhsId;

        this.immigrantId = immigrantId;
        this.immigrantStatus = immigrantStatus;

        this.newStatus = immigrantStatus;

        this.isFormatValid = false;
        this.approved = false;
    }

    // Data Entry
    private boolean validateInfo() {

        return false;
    }

    private boolean returnIsValidated() {

        return false;

    }

    protected String sendImmigrantStatus() {

        return "";

    }

    // Revewier
    private boolean changeStatus() {

        return false;

    }

    private boolean submitReview() {

        return false;

    }

    // Approver
    private boolean validateStatusChange() {

        return false;

    }

    private boolean reportToDHS() {

        return false;

    }

    private void backToReview() {

    }
}