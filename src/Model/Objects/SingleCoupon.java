package Model.Objects;
//****************************
//Created by Zamir on 14/04/2015.  
//****************************


public class SingleCoupon {
    String name = "";
    String expireyDate = "";
    String code = "";
    double discount = 0.0;

    public SingleCoupon(String n, String c, double d, String e) {
        name = n;
        code = c;
        discount = d;
        expireyDate = e;
    }

    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public double getDiscount() {
        return discount;
    }
    public String getExpireyDate() {
        return expireyDate;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public void setExpireyDate(String expireyDate) {
        this.expireyDate = expireyDate;
    }
    public void setName(String name) {
        this.name = name;
    }

}