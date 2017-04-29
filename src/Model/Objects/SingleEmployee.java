package Model.Objects;
//****************************
//Created by Zamir on 18/04/2015.  
//****************************


public class SingleEmployee {
    String staffId;
    String fname;
    String lname;
    int password;
    String position;
        public SingleEmployee(String a, String b, String c, int d, String e) {
            staffId = a;
            fname = b;
            lname = c;
            password = d;
            position = e;
        }
    public int getPassword() {
        return password;
    }
    public String getFname() {
        return fname;
    }
    public String getPosition() {
        return position;
    }
    public String getStaffId() {
        return staffId;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
}

