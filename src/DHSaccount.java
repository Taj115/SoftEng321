package src;
public class DHSaccount {
    private String dhsName, dhsId;

    public int immigrantId;
    public String immigrantStatus;
    protected String newStatus;

    public boolean isFormatValid;
    protected boolean approved;

    // Basic constructor for DHS to do what they need to do for their job
    public DHSaccount(String dhsName, String dhsId, int immigrantId, String immigrantStatus) {
        this.dhsName = dhsName;
        this.dhsId = dhsId;

        this.immigrantId = immigrantId;
        this.immigrantStatus = immigrantStatus;

        this.newStatus = immigrantStatus;

        this.isFormatValid = false;
        this.approved = false;
    }


    // Checks if the info provided is valid.
    public boolean validateInfo(String immigrantStaus, int immigrantId) {

        return true;
    }

    // Sends Immigrant Status to workflow table to be updated
    public boolean sendImmigrantStatus(String immigrantStatus) {

        return true;
    }
}