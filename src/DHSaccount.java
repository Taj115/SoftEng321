package src;

import java.util.regex.*;

public class DHSaccount {
    private String dhsName, dhsID;

    private String immigrantID;
    private String immigrantStatus;
    protected String newStatus;

    // Basic constructor for DHS to do what they need to do for their job
    public DHSaccount(String dhsName, String dhsID) {
        this.dhsName = dhsName;
        this.dhsID = dhsID;

        this.immigrantID = null;
        this.immigrantStatus = null;

        this.newStatus = null;
    }

    // Sends Immigrant Status to workflow table to be updated
    public boolean validateImmigrantStatus(String Status) {
        newStatus = Pattern.matches("[a-zA-Z\s]*", Status) ? Status : null;
        return (newStatus != null) ? true : false;
    }

    public boolean validateImmigrantID(String ID) {
        immigrantID = Pattern.matches("[0-9]*", ID) ? ID : null;
        return (immigrantID != null) ? true : false;
    }

    public String getAccName() {
        return dhsName;
    }

    public void setAccName(String name) {
        dhsName = name;
    }

    public String getAccID() {
        return dhsID;
    }

    public void setAccID(String ID) {
        dhsID = ID;
    }

    public String getImmigrantID() {
        return immigrantID;
    }

    public void setImmigrantID(String ID) {
        immigrantID = ID;
    }

    public String getimmigrantStatus() {
        return immigrantStatus;
    }

    public void setImmigrantStatus(String status) {
        immigrantStatus = status;
    }

    public String getRequestedImmigrantStatus() {
        return newStatus;
    }
}