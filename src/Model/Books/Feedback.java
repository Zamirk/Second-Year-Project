package Model.Books;
//****************************
//Created by Zamir on 19/04/2015.  
//****************************


import Database.Operations.Operations;
import Model.Objects.SingleCustomerHistory;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Feedback {
    Operations o;
    ResultSet rset;
    public Feedback(Operations oIn){
        o = oIn;
    }

    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<SingleCustomerHistory> feedbackList = new ArrayList<SingleCustomerHistory>();

    public void rsetGetAll() {
        rset = o.getOrderHistory();
        updateFeedback();
        fillTable();
    }
    public void updateFeedback() {
        try {
            ArrayList<SingleCustomerHistory> listOfCFeedback = new ArrayList<SingleCustomerHistory>();

            while (rset.next()) {
                if(rset.getObject(6)!=null){
                    String orderId = rset.getObject(1).toString();
                    String orderdate = rset.getObject(3).toString();
                    String feedback = rset.getObject(6).toString();
                    listOfCFeedback.add(new SingleCustomerHistory(orderId, "", orderdate, 0, 0, feedback));
                }
            }
            setFeedbackList(listOfCFeedback);
        } catch (SQLException Z) {
            System.out.print(Z.getMessage());
        }
    }
    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Order Id");
        columns.add("Order Date");
        columns.add("Feedback Preview");
        columns.add("View");
        columns.add("Delete");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < feedbackList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String orderId = feedbackList.get(i).getOrderId();
            String orderdate = feedbackList.get(i).getOrderdate();
            String feedback = feedbackList.get(i).getFeedback();
            information.add(orderId);
            information.add(orderdate);
            information.add(feedback);
            information.add("View");
            information.add("Delete");
            data.add(information);
        }
        setTableModel(new DefaultTableModel(data, columns));
    }
    public void deleteFeedback(String a){
        o.deleteFeedback(a);
    }
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    public void setFeedbackList(ArrayList<SingleCustomerHistory> feedbackList) {
        this.feedbackList = feedbackList;
    }
}
