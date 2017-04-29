package Database.Operations;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Operations {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rset;
    private Statement stmt;

    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS
    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS
    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS
    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS
    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS
    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS
    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS
    // This must not stay like this THIS MUST BE SEPERATED INTO DIFFERNT CLASSES OR WE LOOSE MARKS


    //Coupon Shtuff
    public Operations() {
        conn = openDB();
    }
    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

         ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
         ods.setUser("X00111325");
         ods.setPassword("db27Feb95");

            conn = ods.getConnection();
            System.out.println("connected.");
        } catch (Exception e) {
            System.out.print("Unable to load driver " + e);
            System.exit(1);
        }
        return conn;
    }
    public void closeDB() {
        try {
            conn.close();
            System.out.print("Connection closed");
        } catch (SQLException e) {
            System.out.print("Could not close connection ");
            e.printStackTrace();
        }
    }
    public ResultSet getCoupons() {
        try {
            String query = "Select * from COUPON order by NAME desc";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet searchCoupons(String column, String keyword) {
        try {
            String query = "Select * from coupon where " + column + " like '%" + keyword + "%' order by NAME desc";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public String getTotalPrice(String cVal) {
        String totalPrice="";
        try {
            String query = "SELECT SUM(ITEM.PRICE) from ORDER_ITEM INNER JOIN ITEM ON ORDER_ITEM.BARCODE = ITEM.BARCODE WHERE ORDER_ITEM.OrderID = '"+cVal+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            while(rset.next()) {
                totalPrice = rset.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return totalPrice;
    }
    public String getHistoryTotalPrice(String oID) {
        String totalPrice="";
        try {
            String query = "SELECT AMOUNTSPENT FROM ORDER_HISTORY WHERE ORDERID = '"+oID+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            while(rset.next()) {
                totalPrice = rset.getString(1);
                System.out.println(totalPrice);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return totalPrice;
    }
    public double getDiscount(String couponCode){
        double discount =0.0;
        try {

            String query = "SELECT DISCOUNT from COUPON WHERE COUPONID ='"+couponCode+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            while(rset.next()) {
                discount = rset.getDouble(1);
                System.out.println(discount);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return discount;
    }
    public boolean validateCustomer(String username, String password){
        boolean validation = false;
        try {
            String query = "Select CUSTID,PASSWORD FROM CUSTOMER WHERE CUSTID = '"+username+"' AND PASSWORD = "+Integer.parseInt(password)+"";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            while(rset.next()) {
                System.out.println(rset.getString(1)+rset.getInt(2));
                if((rset.getString(1).equals(username))&&(rset.getInt(2)==Integer.parseInt(password))){
                    validation = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return validation;

    }
    public ResultSet getPayBasket(String cVal) {
        try {
            String query = "SELECT ITEM.NAME, ITEM.PRICE, COUNT(ORDER_ITEM.BARCODE) from ORDER_ITEM INNER JOIN ITEM ON ORDER_ITEM.BARCODE = ITEM.BARCODE WHERE ORDER_ITEM.OrderID = '"+cVal+"' GROUP BY ITEM.NAME, ITEM.PRICE";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void insertCoupon(String a, java.util.Date b, double d) {
        try {
            java.sql.Date date = new Date(b.getTime());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-YY");
            String query = "INSERT INTO COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT) " +
                    "values(?,to_date('" + format.format(date) + "', 'DD.MM.RR')," +
                    "to_char(DBMS_Random.Value(10000,99999), 'FM00000'),?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, a);
            pstmt.setDouble(2, d);
            pstmt.executeUpdate();
        } catch (Exception se) {
            System.out.println(se);
        }
    }
    public void deleteCoupon(String code) {
        try {
            String query = "Delete from coupon where COUPONID = '" + code + "'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void editCoupon(String code, String name, java.util.Date b, double discount) {
        try {
            java.sql.Date date = new Date(b.getTime());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-YY");
            String query = "UPDATE coupon SET " +
                    "name = '"+name+"'," +
                    "EXPIRYDATE = to_date('" + format.format(date) + "', 'DD.MM.RR')," +
                    "discount = "+discount+"" +
                    "where COUPONID = '"+code+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //CustomerHistory shtuff
    public ResultSet getSpecificCustomerHistory(String custId) {
        try {
            String query = "Select * from order_history where CUSTID = '"+custId+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getName(String custId) {
        try {
            String query = "Select FNAME, LNAME from CUSTOMER where CUSTID = '"+custId+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    //CustomerManagment shtuff
    public ResultSet getCustomerMHistory() {
        try {
            String query = "Select * from CUSTOMER";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void insertCustomer(String a, String b, String c) {
        try {
            String query = "INSERT INTO CUSTOMER(FNAME, LNAME, PASSWORD, POINTS, CUSTID) " +
                    "values(?,?,?,?," +
                    "'CUST' || to_char(cust_seq.nextval, 'FM000')" + ")";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            pstmt.setInt(4, 0);
            pstmt.executeUpdate();
        } catch (SQLException z) {
            System.out.println(z);
        }
    }
    public void editCustomer(String a, String b, String c, String d) {
        try {
            String query = "UPDATE customer SET " +
                    "FNAME = '"+b+"'," +
                    "LNAME = '"+c+"'," +
                    "PASSWORD = '"+d+"'" +
                    "where CUSTID = '"+a+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteCustomer(String a) {
        try {
            updateCustomerHistory(a);
            String query = "Delete from CUSTOMER where CUSTID = '" + a + "'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateCustomerHistory(String a) {
        try {
            String query = "UPDATE ORDER_HISTORY SET "+
                    "CUSTID = '',"+
                    "PointsEarned = 0"+
                    "where CUSTID = '"+a+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateOrderHistory(String a, String b, double c) {
        try {
            String query = "UPDATE ORDER_HISTORY SET "+
                    "CUSTID = '"+a+"',"+
                    "AMOUNTSPENT = "+c+","+
                    "PointsEarned = 0"+
                    "where ORDERID = '"+b+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void payUpdate(String custID, Double totalSpent, String cVal, String fBack) {
        try {
            String query ="UPDATE ORDER_HISTORY SET custid= '" + custID + "',orderdate = sysdate, PointsEarned = " + (totalSpent * 0.1) + ", amountspent = " + totalSpent + ",feedback='" + fBack + "' where ORDERID = '" + cVal + "'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateFeedback(String a, String b) {
        try {
            String query = "UPDATE ORDER_HISTORY SET "+
                    "Feedback = '"+b+"'"+
                    "where ORDERID = '"+a+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ResultSet searchCustomers(String column, String keyword) {
        try {
            String query = "Select * from Customer where " + column + " like '%" + keyword + "%'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    //Employee shtuff
    public ResultSet getStaff() {
        try {
            String query = "Select * from STAFF";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void deleteStaff(String code) {
        try {
            String query = "Delete from STAFF where StaffID = '" + code + "'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insertEmployee(String a, String b, String c, String d) {
        try {
            String query = "INSERT INTO STAFF(FName, LName, Password, Position, StaffID) " +
                    "values(?,?,?,?,"+
                    "'EMP' || to_char(item_seq.nextval, 'FM000')"+")";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            pstmt.setString(4, d);
            pstmt.executeUpdate();
        } catch (Exception se) {
            System.out.println(se);
        }
    }
    public ResultSet searchEmployee(String column, String keyword) {
        try {
            String query = "Select * from STAFF where " + column + " like '%" + keyword + "%'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    //Feedback shtuff
    public ResultSet getFeedBackInformation() {
        try {
            String query = "Select ORDERID, ORDERDATE, FEEDBACK from ORDER_HISTORY";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getFeedBack(String a) {
        try {
            String query = "Select FEEDBACK from ORDER_HISTORY where ORDERID = '"+a+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void deleteFeedback(String a){
        try {
            String query = "UPDATE ORDER_HISTORY SET "+
                    "feedback =''"+
                    "where CUSTID = '"+a+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //Login shtuff
    public ResultSet getLogin() {
        try {
            String query = "Select Password, Position from Staff";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    //MenuManagment shtuff
    public ResultSet getMMenu() {
        try {
            String query = "Select * from ITEM";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getRating() {
        try {
            String query = "Select * from RATING";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getAllStock() {
        try {
            String query = "Select * from STOCK";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet searchItems(String column, String keyword) {
        try {
            String query = "Select * from ITEM where " + column + " like '%" + keyword + "%' order by NAME desc";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void editItem(String a, double b, String c, String d) {
        try {
            String query = "UPDATE item SET " +
                    "NAME = '"+a+"',"+
                    "PRICE = "+b+","+
                    "CATEGORY = '"+c+"'"+
                    "where BARCODE = '"+d+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void insertItem(String a, double b, String c) {
        try {
            String query = "INSERT INTO ITEM(NAME, PRICE, CATEGORY, DESCRIPTION, BARCODE) " +
                    "values(?,?,?,?,"+
                    "'ITEM' || to_char(item_seq.nextval, 'FM00000')"+")";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, a);
            pstmt.setDouble(2, b);
            pstmt.setString(3, c);
            pstmt.setString(4, "No Description");
            pstmt.executeUpdate();
            insertStartRating();
            insertStartStock();
        } catch (Exception se) {
            System.out.println(se);
        }
    }
    public void insertStartRating(){
        try {
            String query = "INSERT INTO RATING(RATING, BARCODE) " +
                    "values(?,"+
                    "'ITEM' || to_char(item_seq.currval, 'FM00000')"+")";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.executeUpdate();
        } catch (Exception se) {
            System.out.println(se);
        }
    }
    public ResultSet getItemRating(String barcode) {
        try {
            String query = "select item.name, item.price, AVG(RATING.rating) from RATING INNER JOIN ITEM ON ITEM.BARCODE = RATING.BARCODE WHERE ITEM.BARCODE = '"+barcode+"' GROUP BY item.name,item.price";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getOrders() {
        try {
            newOrder();
            String query = "select count(orderid),custid from order_history group by custid";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getCouponDiscount() {
        try {
            newOrder();
            String query = "select couponID, discount from coupon ";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getCustomer() {
        try {
            newOrder();
            String query = "Select CustID, Points from CUSTOMER";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void insertStartStock(){
        try {
            String query = "INSERT INTO STOCK(QUANTITY, BARCODE) " +
                    "values(?,"+
                    "'ITEM' || to_char(item_seq.currval, 'FM00000')"+")";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.executeUpdate();
        } catch (Exception se) {
            System.out.println(se);
        }
    }
    public void deleteItem(String barcode) {
        try {
            String query1 = "Delete from STOCK where Barcode = '" + barcode + "'";
            String query2 = "Delete from RATING where Barcode = '" + barcode + "'";
            String query = "Delete from ITEM where Barcode = '" + barcode + "'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query1);
            rset = stmt.executeQuery(query2);
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //Menu page
    public ResultSet getMenu() {
        try {
            String query = "Select BARCODE, NAME, PRICE from ITEM";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getFirstMenu() {
        try {
            String query = "Select BARCODE, NAME, PRICE from ITEM";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void newOrder() {
        try {
            String query = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('27.04.15', 'DD.MM.RR'), '0', '0', '')";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String currVal(){
        String cV = "";
        try {
            String query = "SELECT 'ORDER' || to_char(order_seq.currval, 'FM0000') FROM DUAL";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            while(rset.next()) {
                cV = rset.getString(1);
            }
            System.out.println(cV);
        } catch (Exception e) {
            System.out.println(e);
        }

        return cV;
    }


    public ResultSet getBasket() {
        try {
            String query = "SELECT ITEM.NAME, COUNT(ORDER_ITEM.BARCODE) from ORDER_ITEM INNER JOIN ITEM ON ORDER_ITEM.BARCODE = ITEM.BARCODE WHERE ORDER_ITEM.OrderID = '"+currVal()+"' GROUP BY ITEM.NAME";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
 	public void cancelOrder(String cVal) {
    try {
            System.out.println(cVal);
            String query = "DELETE FROM ORDER_ITEM WHERE (ORDERID,BARCODE,QUANTITY) IN (SELECT * FROM ORDER_ITEM WHERE ORDERID = '"+cVal+"' )";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
}
    public void addToCart(String item) {
        try {
            String query = "Insert into ORDER_ITEM(ORDERID, BARCODE, QUANTITY) values('ORDER' || to_char(order_seq.currval, 'FM0000'), '"+item+"', '1') ";;
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void removeFromCart(String item) {
        try {
            String query = "DELETE FROM ORDER_ITEM WHERE (ORDERID,BARCODE,QUANTITY) IN (SELECT * FROM ORDER_ITEM WHERE BARCODE = '"+item+"' AND ORDERID = '"+currVal()+"' )";//FETCH FIRST 1 ROWS ONLY
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //Order History
    public ResultSet getOrderHistory() {
        try {
            String query = "Select * from ORDER_HISTORY";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet searchHistory(String column, String keyword) {
        try {
            String query = "Select * from ORDER_HISTORY where " + column + " like '%" + keyword + "%'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    //Report pages
    public ResultSet getItemDetails() {
        try {
            String query = "Select NAME, BARCODE, CATEGORY from ITEM";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getStock() {
        try {
            String query = "Select barcode, quantity from STOCK";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    //StockControll
    public ResultSet getItemInformation() {
        try {
            String query = "Select NAME, BARCODE, CATEGORY from ITEM";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet getStockInformation() {
        try {
            String query = "Select quantity from STOCK";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public void addStock(int addStock, String barcode) {
        try {
            String query = "UPDATE STOCK SET " +
                    "quantity = '"+addStock+"'" +
                    "where BARCODE = '"+barcode+"'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public ResultSet searchStockItems(String keyword) {
        try {
            String query = "Select NAME, BARCODE, CATEGORY from ITEM where BARCODE like '%" + keyword + "%'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
    public ResultSet searchedStock(String keyword) {
        try {
            String query = "Select quantity from STOCK where BARCODE like '%" + keyword + "%'";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rset;
    }
}




