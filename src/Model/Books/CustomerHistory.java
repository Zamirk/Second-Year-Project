package Model.Books;
//****************************
//Created by Zamir on 16/04/2015.  
//****************************


import Database.Operations.Operations;
import Model.Objects.SingleCustomerHistory;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class CustomerHistory {
    String custId = "";
    Operations o;
    ResultSet rset;
    public CustomerHistory(Operations oIn) {
        o = oIn;
    }
    public void setCustId(String custId) {
        this.custId = custId;
    }
    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<SingleCustomerHistory> customerHistoryList = new ArrayList<SingleCustomerHistory>();

    public void rsetGetAll() {
        rset = o.getSpecificCustomerHistory(custId);
        updateHistory();
        fillTable();
    }
    public void updateHistory() {
        try {
            ArrayList<SingleCustomerHistory> listOfCHistory = new ArrayList<SingleCustomerHistory>();

            while (rset.next()) {
                String orderId = rset.getObject(1).toString();
                String custId = rset.getObject(2).toString();
                String orderdate = rset.getObject(3).toString();
                double amountSpent = Double.parseDouble(rset.getObject(4).toString());
                int pointsEarned = Integer.parseInt(rset.getObject(5).toString());

                listOfCHistory.add(new SingleCustomerHistory(orderId, custId, orderdate, amountSpent, pointsEarned, ""));
            }
            setCustomerHistoryList(listOfCHistory);
        } catch (SQLException Z) {
            System.out.print(Z.getMessage());
        }
    }
    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Order Id");
        columns.add("Date");
        columns.add("Spent");
        columns.add("Points");
        columns.add("Click for Receipt");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < customerHistoryList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String orderId = customerHistoryList.get(i).getOrderId();
            String custId = customerHistoryList.get(i).getCustId();
            String orderdate = customerHistoryList.get(i).getOrderdate();
            double amountSpent = customerHistoryList.get(i).getAmountSpent();
            int pointsEarned = customerHistoryList.get(i).getPointsEarned();

            information.add(orderId);
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
    public void setCustomerHistoryList(ArrayList<SingleCustomerHistory> customerHistoryList) {
        this.customerHistoryList = customerHistoryList;
    }
}
