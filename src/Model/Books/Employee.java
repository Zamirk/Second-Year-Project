package Model.Books;
//****************************
//Created by Zamir on 18/04/2015.  
//****************************
import Database.Operations.Operations;
import Model.Objects.SingleEmployee;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Employee {
    Operations o;
    ResultSet rset;
    public Employee(Operations oIn){
        o = oIn;
    }

    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<SingleEmployee> employeeList = new ArrayList<SingleEmployee>();

    public void rsetGetAll(){
        rset = o.getStaff();
        updateEmployees();
        fillTable();
    }
    public void searchEmployees(String a, String b){
        rset = o.searchEmployee(a, b);
        updateEmployees();
        fillTable();
    }
    public void updateEmployees() {
        try {
            ArrayList<SingleEmployee> listOfEmployees = new ArrayList<SingleEmployee>();

            while (rset.next()) {
                String staffId =rset.getObject(1).toString();
                String fname =rset.getObject(2).toString();
                String lname =rset.getObject(3).toString();
                int password =Integer.parseInt(rset.getObject(4).toString());
                String position =rset.getObject(5).toString();

                listOfEmployees.add(new SingleEmployee(staffId,fname,lname,password,position));
            }
            setEmployeeList(listOfEmployees);

        }catch (SQLException Z){
            System.out.print(Z.getMessage());
        }
    }
    public void insertEmployee(String a,String b,String c,String d){
        o.insertEmployee(a,b,c,d);
        rsetGetAll();
    }
    public void deleteEmployee(String a){
        o.deleteStaff(a);
    }
    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Employee Id");
        columns.add("First Name");
        columns.add("Last Name");
        columns.add("Password");
        columns.add("Position");
        columns.add("Click to Delete");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < employeeList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String empId = employeeList.get(i).getStaffId();
            String fname = employeeList.get(i).getFname();
            String lname = employeeList.get(i).getLname();
            int password = employeeList.get(i).getPassword();
            String position = employeeList.get(i).getPosition();

            information.add(empId);
            information.add(fname);
            information.add(lname);
            information.add(password);
            information.add(position);
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
    public void setEmployeeList(ArrayList<SingleEmployee> employeeList) {
        this.employeeList = employeeList;
    }
}

