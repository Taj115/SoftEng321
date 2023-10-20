package src;
public class DHSaccount {
    private String dhsName, dhsId;

    public int immigrantId;
    public String immigrantStatus;
    protected String newStatus;

    public boolean isFormatValid;
    protected boolean approved;

    public DHSaccount(String dhsName, String dhsId, int immigrantId, String immigrantStatus) {
        this.dhsName = dhsName;
        this.dhsId = dhsId;

        this.immigrantId = immigrantId;
        this.immigrantStatus = immigrantStatus;

        this.newStatus = immigrantStatus;

        this.isFormatValid = false;
        this.approved = false;
    }

    private boolean validateInfo(String immigrantStaus, int immigrantId) {

        return true;
    }

    public boolean sendImmigrantStatus(String immigrantStatus) {
        if(immigrantStatus == null || immigrantStatus.trim().isEmpty()) 
            return false;
        return true;
    }
}