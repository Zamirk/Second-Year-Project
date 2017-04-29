package Model.Books;
//****************************
//Created by Zamir on 19/04/2015.  
//****************************


import Database.Operations.Operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Report {
    ArrayList<String> barcodes = new ArrayList<String>();
    ArrayList<Integer> quantities = new ArrayList<Integer>();
    ArrayList<String> ItemName = new ArrayList<String>();

    Operations o;
    ResultSet rset;

    public Report(Operations oIn){
        o = oIn;

    }
    public void getStockR2() {
        rset = o.getStock();
        try {
            ArrayList<String> listOfBarcodes = new ArrayList<String>();
            ArrayList<Integer> listOfQuantities = new ArrayList<Integer>();
            ArrayList<String> listOfNames = new ArrayList<String>();
            while(rset.next()) {
                listOfBarcodes.add(rset.getString(1));
                listOfQuantities.add(rset.getInt(2));
            }
            setQuantities(listOfQuantities);
            setBarcodes(listOfBarcodes);

        }catch (SQLException z){
            System.out.print(z.getMessage());
        }
    }
    public void getStockR3() {
        rset = o.getRating();
        try {
            ArrayList<String> listOfBarcodes2 = new ArrayList<String>();
            ArrayList<Integer> listOfRatings = new ArrayList<Integer>();

            while(rset.next()) {
                listOfBarcodes2.add(rset.getString(1));
                listOfRatings.add(rset.getInt(2));

            }

            //
            setBarcodes2(listOfBarcodes2);
            setRatings(listOfRatings);

        }catch (SQLException z){
            System.out.print(z.getMessage());
        }
    }
    public void getStockR4() {
        rset = o.getCustomer();
        try {
            ArrayList<String> listOfCustomers = new ArrayList<String>();
            ArrayList<Integer> listOfPoints = new ArrayList<Integer>();
            while(rset.next()) {
                listOfCustomers.add(rset.getString(1));
                listOfPoints.add(rset.getInt(2));
            }
            setPoints(listOfPoints);
            setCustomer(listOfCustomers);


        }catch (SQLException z){
            System.out.print(z.getMessage());
        }
    }

    public void getStockR5() {
        rset = o.getOrders();
        try {
            ArrayList<String> listOfCustomers2 = new ArrayList<String>();
            ArrayList<Integer> listOfOrders = new ArrayList<Integer>();
            while(rset.next()) {
                listOfCustomers2.add(rset.getString(1));
                listOfOrders.add(rset.getInt(2));
            }
            setOrders(listOfOrders);
            setCustomer(listOfCustomers2);

        }catch (SQLException z){
            System.out.print(z.getMessage());
        }
    }
    public void getStockR6() {
        rset = o.getCouponDiscount();
        try {
            ArrayList<String> listOfCoupons = new ArrayList<String>();
            ArrayList<Double> listOfDiscounts = new ArrayList<Double>();
            while(rset.next()) {
                listOfCoupons.add(rset.getString(1));
                listOfDiscounts.add(rset.getDouble(2));
            }
            setDiscounts(listOfDiscounts);
            setCoupons(listOfCoupons);

        }catch (SQLException z){
            System.out.print(z.getMessage());
        }
    }
    public void getStockR7() {
        rset = o.getCouponDiscount();
        try {
            ArrayList<String> listOfStaffId = new ArrayList<String>();
            ArrayList<String> listOfPositions = new ArrayList<String>();
            while(rset.next()) {
                listOfStaffId.add(rset.getString(1));
                listOfPositions.add(rset.getString(2));
            }
            setStaffid(listOfStaffId);
            setPosition(listOfPositions);

        }catch (SQLException z){
            System.out.print(z.getMessage());
        }
    }

    //These are for the report page 1 piechart
    ArrayList<String> barcodes2 = new ArrayList<String>();
    ArrayList<Integer> ratings = new ArrayList<Integer>();
    //These are for page 3 barchart
    ArrayList<String> customer = new ArrayList<String>();
    ArrayList<Integer> points = new ArrayList<Integer>();
    //These are for page 4 barchart
    ArrayList<String> customer2 = new ArrayList<String>();
    ArrayList<Integer> orders = new ArrayList<Integer>();
    //These are for page 5
    ArrayList<String> coupons = new ArrayList<String>();
    ArrayList<Double>discounts = new ArrayList<Double>();
    // the revamped page 4
    ArrayList<String> staffid = new ArrayList<String>();
    ArrayList<String> position = new ArrayList<String>();

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }
    public ArrayList<String> getBarcodes() {
        return barcodes;
    }
    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }
    public void setBarcodes(ArrayList<String> barcodes) {
        this.barcodes = barcodes;
    }
    //-----------------------------------------------------------------------------------
    public ArrayList<String> getBarcodes2() {
        return barcodes2;
    }
    public void setBarcodes2(ArrayList<String> barcodes2) {
        this.barcodes2 = barcodes2;
    }
    public ArrayList<Integer> getRatings() {
        return ratings;
    }
    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }
    //-----------------------------------------------------------------------------------
    public ArrayList<Integer> getPoints() {
        return points;
    }
    public void setPoints(ArrayList<Integer> points) {
        this.points = points;
    }
    public ArrayList<String> getCustomer() {
        return customer;
    }
    public void setCustomer(ArrayList<String> customer) {
        this.customer = customer;
    }
    //-----------------------------------------------------------------------------------
    public ArrayList<String> getCustomer2() {
        return customer2;
    }
    public void setCustomer2(ArrayList<String> customer2) {
        this.customer2 = customer2;
    }
    public ArrayList<Integer> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<Integer> orders) {
        this.orders = orders;
    }
    //-----------------------------------------------------------------------------------
    public ArrayList<Double> getDiscounts() {
        return discounts;
    }
    public void setDiscounts(ArrayList<Double> discounts) {
        this.discounts = discounts;
    }
    public ArrayList<String> getCoupons() {
        return coupons;
    }
    public void setCoupons(ArrayList<String> coupons) {
        this.coupons = coupons;
    }
    //-----------------------------------------------------------------------------------
    public ArrayList<String> getStaffid() {
        return staffid;
    }
    public void setStaffid(ArrayList<String> staffid) {
        this.staffid = staffid;
    }
    public ArrayList<String> getPosition() {
        return position;
    }
    public void setPosition(ArrayList<String> position) {
        this.position = position;
    }
}