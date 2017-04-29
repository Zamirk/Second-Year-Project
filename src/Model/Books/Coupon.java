package Model.Books;
//****************************
//Created by Zamir on 14/04/2015.  
//****************************
import Database.Operations.Operations;
import Model.Objects.SingleCoupon;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Coupon {
    Operations o;
    ResultSet rset;
    public Coupon(Operations oIn){
        o = oIn;
    }
    ArrayList<SingleCoupon> couponList = new ArrayList<SingleCoupon>();
    DefaultTableModel tableModel = new DefaultTableModel();

    public void rsetSearchCoupons(String a, String b){
        rset = o.searchCoupons(a,b);
        updateCouponList();
        fillTable();
    }
    public void rsetGetCoupons(){
        rset = o.getCoupons();
        updateCouponList();
        fillTable();
    }
    public void updateCouponList() {
        try {
            ArrayList<SingleCoupon> listOfCoupons = new ArrayList<SingleCoupon>();

            while (rset.next()) {

                String name = rset.getObject(1).toString();
                String expireyDate = rset.getObject(2).toString();
                String couponId = rset.getObject(3).toString();
                double discount = Double.parseDouble(rset.getObject(4).toString());

                listOfCoupons.add(new SingleCoupon(name,expireyDate,discount,couponId));
            }
            setCouponList(listOfCoupons);

        }catch (SQLException Z){
            System.out.print(Z.getMessage());
        }
    }
    public void updateCoupon(String a, String b, java.util.Date c, double d ){
        o.editCoupon(a,b,c,d);
        rsetGetCoupons();
    }
    public void insertCoupon(String a, java.util.Date b, double c){
        o.insertCoupon(a,b,c);
        rsetGetCoupons();
    }
    public void deleteCoupon(String a){
        o.deleteCoupon(a);
    }
    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Coupon Name");
        columns.add("Expire Date");
        columns.add("Code");
        columns.add("Discount");
        columns.add("Click to Edit");
        columns.add("Click to delete");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < couponList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String name = couponList.get(i).getName();
            String code = couponList.get(i).getCode();
            String date = couponList.get(i).getExpireyDate();
            double discount = couponList.get(i).getDiscount();
            information.add(name);
            information.add(code);
            information.add(date);
            information.add(discount);
            information.add("Edit");
            information.add("Delete");
            data.add(information);
        }
        setTableModel(new DefaultTableModel(data, columns));
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    public void setCouponList(ArrayList<SingleCoupon> couponList) {
        this.couponList = couponList;
    }
}