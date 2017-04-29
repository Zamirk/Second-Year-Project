package Model.Objects;

/**
 * Created by x00109563 on 15/04/2015.
 */

public class SingleCustomer {
    String custID ="";
    String firstName ="";
    String lastName ="";
    int password = 0;
    int pointNum = 0;

    public SingleCustomer(String cID, String fN, String lN, int p, int pN){
        custID = cID;
        firstName = fN;
        lastName = lN;
        password = p;
        pointNum = pN;

    }
    public String getCustID() {
        return custID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPassword() {
        return password;
    }
    public int getPointNum() {
        return pointNum;
    }
    public void setCustID(String custID) {
        this.custID = custID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public void setPointNum(int pointNum) {
        this.pointNum = pointNum;
    }
}
