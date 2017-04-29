package Database;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class CreateDB {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rset;

    public CreateDB()
    {
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
    public void dropTables(){
        String s1 = "DROP TABLE STAFF CASCADE CONSTRAINTS ";
        String s2 = "DROP TABLE CUSTOMER CASCADE CONSTRAINTS ";
        String s3 = "DROP TABLE ITEM CASCADE CONSTRAINTS ";
        String s4 = "DROP TABLE ORDER_HISTORY CASCADE CONSTRAINTS ";
        String s5 = "DROP TABLE COUPON CASCADE CONSTRAINTS ";
        String s6 = "DROP TABLE ORDER_ITEM CASCADE CONSTRAINTS ";
        String s7 = "DROP TABLE STOCK CASCADE CONSTRAINTS ";
        String s8 = "DROP TABLE RATING CASCADE CONSTRAINTS ";

        try {
            Statement pstmt = conn.createStatement();
            pstmt.executeUpdate(s1);
            pstmt.executeUpdate(s2);
            pstmt.executeUpdate(s3);
            pstmt.executeUpdate(s4);
            pstmt.executeUpdate(s5);
            pstmt.executeUpdate(s6);
            pstmt.executeUpdate(s7);
            pstmt.executeUpdate(s8);

        }catch (SQLException e ) {
            System.out.println(e);
        }
    }
    public void dropSequence() {
        String s9 = "DROP SEQUENCE emp_seq ";
        String s10 = "DROP SEQUENCE cust_seq ";
        String s11 = "DROP SEQUENCE item_seq ";
        String s12 = "DROP SEQUENCE order_seq ";
        String s13 = "DROP SEQUENCE coupon_seq ";

        try {
            Statement  pstmt = conn.createStatement();
            pstmt.executeUpdate(s9);
            pstmt.executeUpdate(s10);
            pstmt.executeUpdate(s11);
            pstmt.executeUpdate(s12);
            pstmt.executeUpdate(s13);

        }catch (SQLException e ) {
            System.out.println(e);
        }
    }
    public void createTables() {
        String s14 = "CREATE TABLE STAFF(StaffID Varchar2(255) NOT NULL, FName Varchar2(255), LName Varchar2(255), Password Varchar2(255), Position Varchar2(255), PRIMARY KEY (StaffID)) ";
        String s15 = "CREATE TABLE CUSTOMER(CustID Varchar2(255) NOT NULL, FName Varchar2(255), LName Varchar2(255), Password number, Points Number(20), PRIMARY KEY (CustID)) ";
        String s16 = "CREATE TABLE ITEM( Barcode Varchar2(255) NOT NULL, Name Varchar2(255), Price FLOAT(20), Category Varchar2(255), Description Varchar2(255), PRIMARY KEY (Barcode)) ";
        String s17 = "CREATE TABLE ORDER_HISTORY(OrderID Varchar2(255) NOT NULL,CustID Varchar2(255), OrderDate Date, AmountSpent float(3), PointsEarned Number(20), Feedback Varchar2(255), PRIMARY KEY (OrderID), FOREIGN KEY (CustID) REFERENCES Customer(CustID)) ";
        String s18 = "CREATE TABLE COUPON(Name Varchar2(255), ExpiryDate date, CouponID Varchar2(255) NOT NULL, Discount Float(20), PRIMARY KEY (CouponID)) ";
        String s19 = "CREATE TABLE ORDER_ITEM( OrderID Varchar2(255) NOT NULL, Barcode Varchar2(255), Quantity NUMBER(20), FOREIGN KEY (OrderID) REFERENCES ORDER_HISTORY(OrderID)) ";
        String s20 = "CREATE TABLE STOCK(Barcode Varchar2(255) NOT NULL, Quantity Number(20), FOREIGN KEY (Barcode) REFERENCES Item(Barcode),PRIMARY KEY (Barcode)) ";
        String s21 = "CREATE TABLE RATING(Barcode Varchar2(255) NOT NULL, Rating FLOAT(2), FOREIGN KEY (Barcode) REFERENCES Item(Barcode), PRIMARY KEY (Barcode)) ";

        try {
            Statement  pstmt = conn.createStatement();
            pstmt.executeUpdate(s14);
            pstmt.executeUpdate(s15);
            pstmt.executeUpdate(s16);
            pstmt.executeUpdate(s17);
            pstmt.executeUpdate(s18);
            pstmt.executeUpdate(s19);
            pstmt.executeUpdate(s20);
            pstmt.executeUpdate(s21);

        }catch (SQLException e ) {
            System.out.println(e);
        }
    }
    public void createSequence(){
        String s22 = "create sequence emp_seq start with 1 increment by 1 ";
        String s23 = "create sequence cust_seq start with 1 increment by 1 ";
        String s24 = "create sequence item_seq start with 1 increment by 1 ";
        String s25 = "create sequence order_seq start with 1 increment by 1 ";
        String s26 = "create sequence coupon_seq start with 1 increment by 1 ";

        try {
            Statement pstmt = conn.createStatement();
            pstmt.executeUpdate(s22);
            pstmt.executeUpdate(s23);
            pstmt.executeUpdate(s24);
            pstmt.executeUpdate(s25);
            pstmt.executeUpdate(s26);

        }catch (SQLException e ) {
            System.out.println(e);
        }
    }
    public void insert() {
        String s27 = "INSERT INTO STAFF(STAFFID, FNAME, LNAME, PASSWORD, POSITION)VALUES('EMP' || to_char(emp_seq.nextval, 'FM000'), 'Martin', 'Futas', '1234', 'Manager') ";
        String s28 = "INSERT INTO STAFF(STAFFID, FNAME, LNAME, PASSWORD, POSITION)VALUES('EMP' || to_char(emp_seq.nextval, 'FM000'), 'Samir', 'Kahvedzic', '4321', 'Employee') ";
        String s131 = "INSERT INTO STAFF(STAFFID, FNAME, LNAME, PASSWORD, POSITION)VALUES('EMP' || to_char(emp_seq.nextval, 'FM000'), 'Glen', 'Dowling', '9988', 'Employee') ";
        String s132 = "INSERT INTO STAFF(STAFFID, FNAME, LNAME, PASSWORD, POSITION)VALUES('EMP' || to_char(emp_seq.nextval, 'FM000'), 'Gavin', 'Hickey', '1122', 'Manager') ";

        String s33 = "Insert into ORDER_ITEM(ORDERID, BARCODE, QUANTITY) values('ORDER' || to_char(order_seq.currval, 'FM0000'), 'ITEM00001', '4') ";

        String s37 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('10% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'),  0.1 ) ";
        String s38 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('2% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'), 0.02 ) ";
        String s39 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('5% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'), 0.05 ) ";
        String s40 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('1% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'), 0.01) ";
        String s41 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('3% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'), 0.03 ) ";
        String s42 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('15% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'),  0.15) ";
        String s43 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('3.5% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'),  0.035 ) ";
        String s44 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('11% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'),  0.11 ) ";
        String s45 = "Insert into COUPON(NAME, EXPIRYDATE, COUPONID, DISCOUNT)values('20% Off', to_date('27.04.15', 'DD.MM.RR'), 'COUPON' || to_char(DBMS_Random.Value(10000,99999), 'FM00000'),  0.2) ";

        String s29 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Daniel', 'Rogers', 6969, 20) ";
        String s46 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Ted', 'Crilly', 7846, 30) ";
        String s47 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Desmond', 'Chang', 9856, 40) ";
        String s48 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Nicole', 'Martin', 1578, 10) ";
        String s49 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Michael', 'Murphy', 1234, 70) ";
        String s50 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Terrence', 'Edwards', 1324, 40) ";
        String s51 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Gregory', 'Cooke', 9087, 90) ";
        String s155 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Niamh', 'Hennessey', 6464, 50) ";
        String s156 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Peter', 'Johnson', 1965, 30) ";
        String s157 = "INSERT INTO CUSTOMER(CUSTID, FNAME, LNAME, PASSWORD, POINTS)VALUES('CUST' || to_char(cust_seq.nextval, 'FM000'), 'Lisa', 'Maguire', 1000, 40) ";

        String s32 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST001', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s52 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST001', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s53 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST001', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s54 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST001', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s111 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST001', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s112 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST001', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s113 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST001', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";

        String s55 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s56 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s57 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s58 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s107 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s108 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s109 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s110 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST002', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";

        String s75 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST003', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s76 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST003', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s77 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST003', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s78 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST003', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";

        String s79 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST004', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s80 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST004', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s81 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST004', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s82 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST004', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";

        String s83 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST005', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s84 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST005', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s85 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST005', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s86 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST005', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";

        String s87 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s88 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s89 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s90 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s103 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s104 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s105 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s106 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST006', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";

        String s91 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s92 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s93 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s94 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s95 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s96 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s97 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s98 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s99 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s100 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s101 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s102 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), 'CUST007', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";

        String s114 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s115 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s116 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s117 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s118 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s119 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s120 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s121 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s122 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s123 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s124 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s125 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s126 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s127 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s128 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', 'Very nice apples, Thanks.') ";
        String s129 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";
        String s130 = "INSERT INTO ORDER_HISTORY(ORDERID, CUSTID, ORDERDATE, AMOUNTSPENT, POINTSEARNED, FEEDBACK)VALUES('ORDER' || to_char(order_seq.nextval, 'FM0000'), '', to_date('06.03.15', 'DD.MM.RR'), '3', '0', '') ";

        String s30 = "INSERT INTO ITEM(BARCODE, NAME, PRICE, CATEGORY, DESCRIPTION)VALUES('ITEM' || to_char(item_seq.nextval, 'FM00000'), 'Potatoes', 2.00, 'Vegetables', 'New Malta Potatoes') ";
        String s31 = "INSERT INTO ITEM(BARCODE, NAME, PRICE, CATEGORY, DESCRIPTION)VALUES('ITEM' || to_char(item_seq.nextval, 'FM00000'), 'Apples', 3.00, 'Fruits', 'Granny Smiths Apples') ";
        String s59 = "INSERT INTO ITEM(BARCODE, NAME, PRICE, CATEGORY, DESCRIPTION)VALUES('ITEM' || to_char(item_seq.nextval, 'FM00000'), 'Chicken Dippers', 1.80, 'Extra', 'Temp') ";
        String s60 = "INSERT INTO ITEM(BARCODE, NAME, PRICE, CATEGORY, DESCRIPTION)VALUES('ITEM' || to_char(item_seq.nextval, 'FM00000'), 'Burger', 1.99, 'Burgers', 'Temp') ";
        String s61 = "INSERT INTO ITEM(BARCODE, NAME, PRICE, CATEGORY, DESCRIPTION)VALUES('ITEM' || to_char(item_seq.nextval, 'FM00000'), 'Chips', 2.60, 'Chips', 'Temp') ";
        String s62 = "INSERT INTO ITEM(BARCODE, NAME, PRICE, CATEGORY, DESCRIPTION)VALUES('ITEM' || to_char(item_seq.nextval, 'FM00000'), 'Twisty Fries', 2.45, 'Chips', 'Temp') ";
        String s63 = "INSERT INTO ITEM(BARCODE, NAME, PRICE, CATEGORY, DESCRIPTION)VALUES('ITEM' || to_char(item_seq.nextval, 'FM00000'), 'Fried Cod', 3.00, 'Fish', 'Temp') ";

        String s36 = "Insert into RATING(BARCODE, RATING) values('ITEM00001', '10') ";
        String s64 = "Insert into RATING(BARCODE, RATING) values('ITEM00002', '9') ";
        String s65 = "Insert into RATING(BARCODE, RATING) values('ITEM00003', '8') ";
        String s66 = "Insert into RATING(BARCODE, RATING) values('ITEM00004', '4') ";
        String s67 = "Insert into RATING(BARCODE, RATING) values('ITEM00005', '7') ";
        String s68 = "Insert into RATING(BARCODE, RATING) values('ITEM00006', '4') ";
        String s69 = "Insert into RATING(BARCODE, RATING) values('ITEM00007', '9') ";

        String s34 = "Insert into STOCK(BARCODE, QUANTITY) values('ITEM00001', '10') ";
        String s35 = "Insert into STOCK(BARCODE, QUANTITY) values('ITEM00002', '17') ";
        String s70 = "Insert into STOCK(BARCODE, QUANTITY) values('ITEM00003', '9') ";
        String s71 = "Insert into STOCK(BARCODE, QUANTITY) values('ITEM00004', '10') ";
        String s72 = "Insert into STOCK(BARCODE, QUANTITY) values('ITEM00005', '5') ";
        String s73 = "Insert into STOCK(BARCODE, QUANTITY) values('ITEM00006', '10') ";
        String s74 = "Insert into STOCK(BARCODE, QUANTITY) values('ITEM00007', '8') ";

        try {
            Statement  pstmt = conn.createStatement();
            pstmt.executeUpdate(s27);
            pstmt.executeUpdate(s28);
            pstmt.executeUpdate(s29);
            pstmt.executeUpdate(s30);
            pstmt.executeUpdate(s31);
            pstmt.executeUpdate(s32);
            pstmt.executeUpdate(s33);
            pstmt.executeUpdate(s34);
            pstmt.executeUpdate(s35);
            pstmt.executeUpdate(s36);
            pstmt.executeUpdate(s37);
            pstmt.executeUpdate(s38);
            pstmt.executeUpdate(s39);
            pstmt.executeUpdate(s40);
            pstmt.executeUpdate(s41);
            pstmt.executeUpdate(s42);
            pstmt.executeUpdate(s43);
            pstmt.executeUpdate(s44);
            pstmt.executeUpdate(s45);
            pstmt.executeUpdate(s46);
            pstmt.executeUpdate(s47);
            pstmt.executeUpdate(s48);
            pstmt.executeUpdate(s49);
            pstmt.executeUpdate(s50);
            pstmt.executeUpdate(s51);
            pstmt.executeUpdate(s52);
            pstmt.executeUpdate(s53);
            pstmt.executeUpdate(s54);
            pstmt.executeUpdate(s55);
            pstmt.executeUpdate(s56);
            pstmt.executeUpdate(s57);
            pstmt.executeUpdate(s58);
            pstmt.executeUpdate(s59);
            pstmt.executeUpdate(s60);
            pstmt.executeUpdate(s61);
            pstmt.executeUpdate(s62);
            pstmt.executeUpdate(s63);
            pstmt.executeUpdate(s64);
            pstmt.executeUpdate(s65);
            pstmt.executeUpdate(s66);
            pstmt.executeUpdate(s67);
            pstmt.executeUpdate(s68);
            pstmt.executeUpdate(s69);
            pstmt.executeUpdate(s70);
            pstmt.executeUpdate(s71);
            pstmt.executeUpdate(s72);
            pstmt.executeUpdate(s73);
            pstmt.executeUpdate(s74);
            pstmt.executeUpdate(s75);
            pstmt.executeUpdate(s76);
            pstmt.executeUpdate(s77);
            pstmt.executeUpdate(s78);
            pstmt.executeUpdate(s79);
            pstmt.executeUpdate(s80);
            pstmt.executeUpdate(s81);
            pstmt.executeUpdate(s82);
            pstmt.executeUpdate(s83);
            pstmt.executeUpdate(s84);
            pstmt.executeUpdate(s85);
            pstmt.executeUpdate(s86);
            pstmt.executeUpdate(s87);
            pstmt.executeUpdate(s88);
            pstmt.executeUpdate(s89);
            pstmt.executeUpdate(s90);
            pstmt.executeUpdate(s91);
            pstmt.executeUpdate(s92);
            pstmt.executeUpdate(s93);
            pstmt.executeUpdate(s94);
            pstmt.executeUpdate(s95);
            pstmt.executeUpdate(s96);
            pstmt.executeUpdate(s97);
            pstmt.executeUpdate(s98);
            pstmt.executeUpdate(s99);
            pstmt.executeUpdate(s100);
            pstmt.executeUpdate(s101);
            pstmt.executeUpdate(s102);
            pstmt.executeUpdate(s103);
            pstmt.executeUpdate(s104);
            pstmt.executeUpdate(s105);
            pstmt.executeUpdate(s106);
            pstmt.executeUpdate(s107);
            pstmt.executeUpdate(s108);
            pstmt.executeUpdate(s109);
            pstmt.executeUpdate(s110);
            pstmt.executeUpdate(s111);
            pstmt.executeUpdate(s112);
            pstmt.executeUpdate(s113);
            pstmt.executeUpdate(s114);
            pstmt.executeUpdate(s115);
            pstmt.executeUpdate(s116);
            pstmt.executeUpdate(s117);
            pstmt.executeUpdate(s118);
            pstmt.executeUpdate(s119);
            pstmt.executeUpdate(s120);
            pstmt.executeUpdate(s121);
            pstmt.executeUpdate(s122);
            pstmt.executeUpdate(s123);
            pstmt.executeUpdate(s124);
            pstmt.executeUpdate(s125);
            pstmt.executeUpdate(s126);
            pstmt.executeUpdate(s127);
            pstmt.executeUpdate(s128);
            pstmt.executeUpdate(s129);
            pstmt.executeUpdate(s130);
            pstmt.executeUpdate(s131);
            pstmt.executeUpdate(s132);
        }catch (SQLException e ) {
            System.out.println(e);
        }

    }
    public void querryDB() {
        String s37 = "Select * From Staff ";
        String s38 = "Select * From Customer ";
        String s39 = "Select * From Item ";
        String s40 = "Select * From Order_History ";
        ResultSet r1;
        ResultSet r2;
        ResultSet r3;
        ResultSet r4;

        try {
            Statement  pstmt = conn.createStatement();
            r1=pstmt.executeQuery(s37);
            r2=pstmt.executeQuery(s38);
            r3=pstmt.executeQuery(s39);
            r4=pstmt.executeQuery(s40);


        }catch (SQLException e ) {
            System.out.println(e);
        }

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
    public static void main(String [] args){
        CreateDB db1 = new CreateDB();
        db1.dropTables();
        db1.dropSequence();
        db1.createTables();
        db1.createSequence();
        db1.insert();
        db1.closeDB();
        //db1.querryDB();
    }
}
