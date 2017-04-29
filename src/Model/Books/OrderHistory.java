package Model.Books;
//****************************
//Created by Zamir on 18/04/2015.  
//****************************


import Database.Operations.Operations;
import Model.Objects.SingleCustomerHistory;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class OrderHistory {
    Operations o;
    ResultSet rset;
    public OrderHistory(Operations oIn){
        o = oIn;
    }

    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<SingleCustomerHistory> orderHistoryList = new ArrayList<SingleCustomerHistory>();

    public void rsetGetAll() {
        rset = o.getOrderHistory();
        updateHistory();
        fillTable();
    }
    public void searchHistory(String a, String b) {
        rset = o.searchHistory(a, b);
        updateHistory();
        fillTable();
    }
    public void updateHistory() {
        try {
            ArrayList<SingleCustomerHistory> listOfCHistory = new ArrayList<SingleCustomerHistory>();

            while (rset.next()) {
                String orderId = rset.getObject(1).toString();
                String custId = "";
                if(rset.getObject(2)!=null){
                    custId = rset.getObject(2).toString();
                }
                String orderdate = rset.getObject(3).toString();
                double amountSpent = Double.parseDouble(rset.getObject(4).toString());
                int pointsEarned = Integer.parseInt(rset.getObject(5).toString());

                listOfCHistory.add(new SingleCustomerHistory(orderId, custId, orderdate, amountSpent, pointsEarned, ""));
            }
            setOrderHistoryList(listOfCHistory);
        } catch (SQLException Z) {
            System.out.print(Z.getMessage());
        }
    }
    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Order Id");
        columns.add("Customer Id");
        columns.add("Order Date");
        columns.add("Amount Spent");
        columns.add("Points Earned");
        columns.add("Click for Receipt");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < orderHistoryList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String orderId = orderHistoryList.get(i).getOrderId();
            String custId = orderHistoryList.get(i).getCustId();
            String orderdate = orderHistoryList.get(i).getOrderdate();
            double amountSpent = orderHistoryList.get(i).getAmountSpent();
            int pointsEarned = orderHistoryList.get(i).getPointsEarned();

            information.add(orderId);
            information.add(custId);
            information.add(orderdate);
            information.add(amountSpent);
            information.add(pointsEarned);
            information.add("View Receipt");
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

    public void setOrderHistoryList(ArrayList<SingleCustomerHistory> orderHistoryList) {
        this.orderHistoryList = orderHistoryList;
    }
}


