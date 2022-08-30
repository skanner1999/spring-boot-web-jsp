package com.mkyong;

import java.sql.*;
import java.util.*;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.mysql.cj.xdevapi.Result;

public class Database {

    public void CreateDB() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        System.out.println("Connection established......");
        //Creating the Statement
        Statement stmt = con.createStatement();

        //Query to create a database
        String query = "CREATE database IF NOT EXISTS Employee";
        String query2 = "CREATE TABLE IF NOT EXISTS Employee.employees (username VARCHAR(20), first_name VARCHAR(20),last_name VARCHAR(20));";
        //String query3 = "INSERT INTO Employee.employees (username, first_name, last_name) VALUES ('skanner', 'Shayne','Kanner');";


        //Executing the query
        stmt.execute(query);
        stmt.execute(query2);
        //stmt.execute(query3);
        //System.out.println(rs);
        }
    public List<String[]> getUsers() throws SQLException {
            List<String[]> users = new ArrayList<>();
            String[] user = new String[3];
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
            Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
            String query4 = "SELECT * FROM eCommerceDB.customers;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query4);
            while (rs.next()) {
                user = new String[3];
                System.out.println(rs.getString("first_name"));
                user[0] = rs.getString("phone_number");
                user[1] = rs.getString("first_name");
                user[2] = rs.getString("last_name");
                users.add(user);
            }
            return users;
        }
    public void getName() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String query4 = "SELECT * FROM Employee.employees;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query4);
        while (rs.next()) {
            System.out.println(rs.getString("first_name"));
        }
    }

    public void Insert(String x, String y, String z, String p) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String InsertQ = "INSERT INTO eCommerceDB.customers (phone_number,first_name,last_name, password) VALUES (?,?,?,?);";
        PreparedStatement preparedStmt = con.prepareStatement(InsertQ);
        preparedStmt.setString(1, x);
        preparedStmt.setString(2, y);
        preparedStmt.setString(3, z);
        preparedStmt.setString(4, p);
        preparedStmt.executeUpdate();
    }

    public ResultSet Validated(String x) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String SelectQ = "SELECT * FROM eCommerceDB.customers WHERE phone_number=?";
        PreparedStatement preparedStmt = con.prepareStatement(SelectQ);
        preparedStmt.setString(1, x);
        ResultSet rs = preparedStmt.executeQuery();
        System.out.println(rs);
        return rs;

    }

    public void getAll() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String SelectQ = "SELECT * FROM items;";
        PreparedStatement preparedStmt = con.prepareStatement(SelectQ);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String path = rs.getString("path");
        }
    }

    public boolean login(String username, String password) throws SQLException {
        ResultSet result = Validated(username);
        boolean valid = false;
        if(result == null){
            valid = false;
        }
        else{
            while (result.next()) {
                String pwd = result.getString("password");
                if (BCrypt.checkpw(password, pwd)) {
                    valid = true;
                }
                else {
                    valid = false;
                }
            }
        }
        System.out.println(valid);
        return valid;
    }

    public void addToCart(int itemId, String user, int quantity) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String InsertQ = "INSERT INTO eCommerceDB.cart (item_id, customers_phone_number, quantity) VALUES (?,?,?);";
        PreparedStatement preparedStmt = con.prepareStatement(InsertQ);
        preparedStmt.setInt(1, itemId);
        preparedStmt.setString(2, user);
        preparedStmt.setInt(3, quantity);
        preparedStmt.executeUpdate();
    }

    public void removeItem(int itemId) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String DeleteQ = "DELETE FROM eCommerceDB.cart WHERE item_id = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(DeleteQ);
        preparedStmt.setInt(1, itemId);
        preparedStmt.executeUpdate();
    }

    public void updateCart(int itemId, int quantity) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String UpdateQ = "UPDATE eCommerceDB.cart SET quantity = ? WHERE item_id = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(UpdateQ);
        preparedStmt.setInt(1, itemId);
        preparedStmt.setInt(2, quantity);
        preparedStmt.executeUpdate();
    }

    public int getSum(int itemId, String user) throws SQLException {
        int sum = 0;
        int price = 0;
        int quantity = 0;
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://shayne-brandon-server.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String SELECTQ = "SELECT * FROM eCommerceDB.getSum WHERE item_id = ? AND phone_number = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(SELECTQ);
        preparedStmt.setInt(1, itemId);
        preparedStmt.setString(2, user);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            price = rs.getInt("price");
            quantity = rs.getInt("quantity");
        }
        sum = price * quantity;
        return sum;
    }

    public void testInsert() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String query3 = "INSERT INTO Employee.employees (username, first_name, last_name) VALUES ('BCoss', 'Brandon','Cossin');";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query3);
    }

    public void DeleteEmployee(String x) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String DeleteQ = "DELETE FROM Employee.employees WHERE username = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(DeleteQ);
        preparedStmt.setString(1, x);
        preparedStmt.executeUpdate();
    }

    public void ChangeUsername(String x, String y) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String DeleteQ = "UPDATE Employee.employees SET username = ? WHERE username = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(DeleteQ);
        preparedStmt.setString(1, x);
        preparedStmt.setString(2, y);
        preparedStmt.executeUpdate();
    }

}

