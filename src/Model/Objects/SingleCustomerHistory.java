package Model.Objects;
//****************************
//Created by Zamir on 16/04/2015.  
//****************************


public class SingleCustomerHistory {
    String orderId;
    String custId;
    String orderdate;
    double amountSpent;
    int pointsEarned;
    String feedback;
    public SingleCustomerHistory(String a, String b, String c, double d, int e, String f){
        orderId = a;
        custId = b;
        orderdate = c;
        amountSpent = d;
        pointsEarned = e;
        feedback = f;
    }
    public double getAmountSpent() {
        return amountSpent;
    }
    public int getPointsEarned() {
        return pointsEarned;
    }
    public String getCustId() {
        return custId;
    }
    public String getFeedback() {
        return feedback;
    }
    public String getOrderdate() {
        return orderdate;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }
    public void setCustId(String custId) {
        this.custId = custId;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }
}
