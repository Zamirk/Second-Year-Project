package Model.Books;
//****************************
//Created by Zamir on 15/04/2015.  
//****************************
import Database.Operations.Operations;
import Model.Objects.SingleItem;
import Model.Objects.SingleStock;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Stock {
    Operations o;
    public Stock(Operations oIn){
        o = oIn;
    }

    DefaultTableModel tableModel = new DefaultTableModel();

    ResultSet rset;
    ResultSet stockRset;

    ArrayList<SingleItem> itemList = new ArrayList<SingleItem>();
    ArrayList<SingleStock> stockValues = new ArrayList<SingleStock>();

    public void searchStock(String a, String b){
        rset = o.searchItems(a, b);
        updateMenuStockRating();
        fillTable();
    }
    public void rsetMenuAndRatings(){
        rset = o.getMMenu();
        updateMenuStockRating();
        fillTable();
    }
    public void updateMenuStockRating(){
        updateItemList();
        updateStockValues();
    }
    public void updateStockValues(){
        try {
            ArrayList<SingleStock> values = new ArrayList<SingleStock>();
            stockRset = o.getAllStock();
            while (stockRset.next()) {

                String barcode = stockRset.getString(1);
                int stockValue = stockRset.getInt(2);
                values.add(new SingleStock(barcode,stockValue));
            }
            setStockValues(values);
        }catch(SQLException Z){
            System.out.print(Z.getMessage());
        }
    }
    public void updateItemList() {
        try {
            ArrayList<SingleItem> listOfItems = new ArrayList<SingleItem>();

            while (rset.next()) {

                String barcode = rset.getObject(1).toString();
                String name = rset.getObject(2).toString();
                double price = Double.parseDouble(rset.getObject(3).toString());
                String category = rset.getObject(4).toString();
                String description = rset.getObject(5).toString();
                listOfItems.add(new SingleItem(barcode,name,price,category,description));
            }
            setItemList(listOfItems);

        }catch (SQLException Z){
            System.out.print(Z.getMessage());
        }
    }
    public void addStock(int a,int b, String barcode){
        int newStock = a+b;
        o.addStock(newStock, barcode);
    }
    public void removeStock(int a,int b, String barcode){
        int newStock = a-b;
        o.addStock(newStock, barcode);
    }
    public void updateStock(int a, String barcode){
        o.addStock(a, barcode);
    }
    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Item Name");
        columns.add("Barcode");
        columns.add("Category");
        columns.add("In Stock");
        columns.add("Add Stock");
        columns.add("Remove Stock");
        columns.add("Update Stock");
        columns.add("Input");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < itemList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String barcode = itemList.get(i).getItem();
            String name = itemList.get(i).getName();
            String category = itemList.get(i).getCategory();
            int stock = 0;
            for(int z=0;z<stockValues.size();z++){
                if (barcode.equals(stockValues.get(z).getBarcode())){
                    stock = stockValues.get(z).getQuantity();
                }
            }
            information.add(name);
            information.add(barcode);
            information.add(category);
            information.add(stock);
            information.add("Add Stock");
            information.add("Remove Stock");
            information.add("Update Stock");
            information.add("0");
            data.add(information);
        }
        Vector<Object> extraLine = new Vector<Object>();
        extraLine.add("");
        extraLine.add("");
        extraLine.add("");
        extraLine.add("");
        extraLine.add("Add All Stock");
        extraLine.add("Remove All Stock");
        extraLine.add("Update All Stock");
        data.add(extraLine);
        setTableModel(new DefaultTableModel(data, columns));
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
    public void setItemList(ArrayList<SingleItem> itemList) {
        this.itemList = itemList;
    }
    public void setStockValues(ArrayList<SingleStock> stockValues) {
        this.stockValues = stockValues;
    }
}
