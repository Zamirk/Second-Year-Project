package Model.Books;
import Database.Operations.Operations;
import Model.Objects.SingleCustomer;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Customer {
    Operations o;
    ResultSet rset;
    public Customer(Operations oIn){
        o = oIn;
    }
    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<SingleCustomer> customerList = new ArrayList<SingleCustomer>();

    public void searchCustomers(String a, String b){
        rset = o.searchCustomers(a, b);
        updateCustomers();
        fillTable();
    }
    public void rsetGetAll(){
        rset = o.getCustomerMHistory();
        updateCustomers();
        fillTable();
    }
    public void updateCustomers() {
        try {
            ArrayList<SingleCustomer> listOfCustomers = new ArrayList<SingleCustomer>();

            while (rset.next()) {
                String custId = rset.getObject(1).toString();
                String fname = rset.getObject(2).toString();
                String lname = rset.getObject(3).toString();
                int pass = Integer.parseInt(rset.getObject(4).toString());
                int points = Integer.parseInt(rset.getObject(5).toString());
                listOfCustomers.add(new SingleCustomer(custId,fname,lname,pass,points));
            }
            setCustomerList(listOfCustomers);

        }catch (SQLException Z){
            System.out.print(Z.getMessage());
        }
    }
    public void insertCustomer(String a, String b, String c){
        o.insertCustomer(a,b,c);
        rsetGetAll();
    }
    public void editCustomer(String a,String b,String c,String d){
        o.editCustomer(a,b,c,d);
        rsetGetAll();
    }
    public void deleteCustomer(String a){
        o.deleteCustomer(a);
    }
    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Customer Id");
        columns.add("First Name");
        columns.add("Last Name");
        columns.add("Password");
        columns.add("Points");
        columns.add("History");
        columns.add("Click to Edit");
        columns.add("Click to Delete");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < customerList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String custId = customerList.get(i).getCustID();
            String fname = customerList.get(i).getFirstName();
            String lname = customerList.get(i).getLastName();
            int pass = customerList.get(i).getPassword();
            int points = customerList.get(i).getPointNum();

            information.add(custId);
            information.add(fname);
            information.add(lname);
            information.add(pass);
            information.add(points);
            information.add("View History");
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
    public void setCustomerList(ArrayList<SingleCustomer> customerList) {
        this.customerList = customerList;
    }
}

