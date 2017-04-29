package Model.Books;

import Database.Operations.Operations;
import Model.Objects.SingleItem;
import Model.Objects.SingleRating;
import Model.Objects.SingleStock;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by x00110033 on 15/04/2015.
 */
public class Item {
    Operations o;
    public Item(Operations oIn){
        o = oIn;
    }

    DefaultTableModel tableModel = new DefaultTableModel();

    ResultSet rset;
    ResultSet ratingRset;
    ResultSet stockRset;

    ArrayList<SingleItem> itemList = new ArrayList<SingleItem>();
    ArrayList<SingleRating> ratingValues = new ArrayList<SingleRating>();
    ArrayList<SingleStock> stockValues = new ArrayList<SingleStock>();

    public void searchMenu(String a, String b){
        rset = o.searchItems(a, b);
        updateMenuStockRating();
        fillTable();
    }
    public void rsetGetAll(){
        rset = o.getMMenu();
        updateMenuStockRating();
        fillTable();
    }
    public void updateMenuStockRating(){
        updateItemList();
        updateRatingValues();
        updateStockValues();
    }
    public void updateRatingValues(){
        try {
            ArrayList<SingleRating> values = new ArrayList<SingleRating>();
            ratingRset = o.getRating();
            while (ratingRset.next()) {

                String barcode = ratingRset.getString(1);
                String ratingValue = ratingRset.getString(2);
                values.add(new SingleRating(barcode, ratingValue));
            }
            setRatingValues(values);
        }catch(SQLException Z){
            System.out.print(Z.getMessage());
        }
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
    public void editItem(String a,double b,String c,String d){
        o.editItem(a,b,c,d);
        rsetGetAll();
    }
    public void insertItem(String a,double b,String c){
        o.insertItem(a, b, c);
        rsetGetAll();
    }
    public void deleteItem(String a){
        o.deleteItem(a);
    }

    public void fillTable() {
        Vector<String> columns = new Vector<String>();
        columns.add("Item Name");
        columns.add("Price");
        columns.add("Category");
        columns.add("Barcode");
        columns.add("Rating");
        columns.add("View Stock");
        columns.add("View Description");
        columns.add("Click to edit");
        columns.add("Click to delete");

        //Data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int i = 0; i < itemList.size(); i++) {
            Vector<Object> information = new Vector<Object>();
            String barcode = itemList.get(i).getItem();
            String name = itemList.get(i).getName();
            double price = itemList.get(i).getPrice();
            String category = itemList.get(i).getCategory();
            String rating ="";
            int stock = 0;
            for(int n=0;n<ratingValues.size();n++){
                if (barcode.equals(ratingValues.get(n).getBarcode())){
                    rating = ratingValues.get(n).getRating();
                }
            }
            for(int z=0;z<stockValues.size();z++){
                if (barcode.equals(stockValues.get(z).getBarcode())){
                    stock = stockValues.get(z).getQuantity();
                }
            }
            information.add(name);
            information.add(price);
            information.add(category);
            information.add(barcode);
            information.add(rating);
            information.add(stock);
            information.add("View/Edit");
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
    public void setItemList(ArrayList<SingleItem> itemList) {
        this.itemList = itemList;
    }
    public void setRatingValues(ArrayList<SingleRating> ratingValues) {
        this.ratingValues = ratingValues;
    }
    public void setStockValues(ArrayList<SingleStock> stockValues) {
        this.stockValues = stockValues;
    }
}
