package Model.Objects;

/**
 * Created by x00110033 on 15/04/2015.
 */
public class SingleStaff {
    String staffID = "";
    String fName = "";
    String lName = "";
    String password = "";
    String position = "";

    public SingleStaff(String sID, String fN,String lN,String pw, String p){
        staffID = sID;
        fName = fN;
        lName = lN;
        password = pw;
        position = p;
    }

    public String getStaffID() {
        return staffID;
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getPassword() {
        return password;
    }
    public String getPosition() {
        return position;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}