package com.guenther.spring2.controller.model;

import com.guenther.spring2.controller.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Gateway on 8/16/2017.
 */
public class DAO {

//    public static ArrayList<User> getCustomerList () {
//        // define the data for the connection
//        //connection info was pulled out into DBCredentials
//        //so that file can be hidden
//
//        try {
//            // Load driver
//            Class.forName("com.mysql.jdbc.Driver");
//            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//
//            // create the db connection object
//            Connection mysqlConnection;
//            mysqlConnection = DriverManager.getConnection(
//                    DBCredentials.DB_ADDRESS,
//                    DBCredentials.USERNAME,
//                    DBCredentials.PASSWORD);
//
//            // create the db statement
//
//            String readCustomersCommand = "select customerid,companyname from customers";
//
//            Statement readCustomers = mysqlConnection.createStatement();// creates the statement
//
//            ResultSet results = readCustomers.executeQuery(readCustomersCommand);// executes the statement
//            // array list of customers
//            ArrayList<User> customerList = new ArrayList<User>();
//
//            // map from the ResultSet to the ArrayList
//            while(results.next())
//            {
//                User temp = new User(results.getString(1),
//                        results.getString(2));
//                customerList.add(temp);
//
//            }
//
//            return customerList;
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//            return null; //null result indicates an issue
//        }
//    }
//
//    public static boolean addCustomer (
//            String custID,
//            String compName,
//            String contactName,
//            String contactTitle
//    ) {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection mysqlConnection;
//            mysqlConnection = DriverManager.getConnection(
//                    DBCredentials.DB_ADDRESS,
//                    DBCredentials.USERNAME,
//                    DBCredentials.PASSWORD);
//
//            String addCustomerCommand = "INSERT INTO Customers " +
//                    "(CustomerID, CompanyName, ContactName, ContactTitle) " +
//                    "VALUES ('" +
//                    custID + "', '" +
//                    compName + "', '" +
//                    contactName + "', '" +
//                    contactTitle + "')";
//            System.out.println("SQL Query " + addCustomerCommand);
//
//            Statement st = mysqlConnection.createStatement();// creates the statement
//
//            int result = st.executeUpdate(addCustomerCommand);// executes the statement
//            // array list of customers
//
//            //if (result == 1)
//            return true;
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//            return false; //null result indicates an issue
//        }
//    }
//
//    public static boolean deleteCustomer (String custID) {
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection mysqlConnection;
//            mysqlConnection = DriverManager.getConnection(
//                    DBCredentials.DB_ADDRESS,
//                    DBCredentials.USERNAME,
//                    DBCredentials.PASSWORD);
//
//            String deleteCustomerCommand = "DELETE FROM Customers " +
//                    "WHERE CustomerID = '" +
//                    custID + "'";
//            System.out.println("SQL Deletion Query " + deleteCustomerCommand);
//
//            Statement st = mysqlConnection.createStatement();// creates the statement
//
//            int result = st.executeUpdate(deleteCustomerCommand);// executes the statement
//            // array list of customers
//
//            //if (result == 1)
//            return true;
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//            return false; //null result indicates an issue
//        }
//    }


    public static ArrayList<Items> getAllItems () {
        // define the data for the connection
        //connection info was pulled out into DBCredentials
        //so that file can be hidden

        try {
            // Load driver
            Class.forName("com.mysql.jdbc.Driver");
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // create the db connection object
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            // create the db statement

            String readItemCommand = "select name, description, quantity, price from items";

            Statement readItem = mysqlConnection.createStatement();// creates the statement

            ResultSet results = readItem.executeQuery(readItemCommand); // executes the statement
            // array list of customers


            ArrayList<Items> itemsList = new ArrayList<Items>();

            // map from the ResultSet to the ArrayList
            while(results.next())
            {

                Items temp = new Items(results.getString(1),results.getString(2),
                        results.getInt(3), results.getFloat(4));
                itemsList.add(temp);

            }

            return itemsList;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null; //null result indicates an issue
        }
    }

    public static boolean addUser (
            String fName,
            String lName,
            String email,
            String phone,
            String password,
            String preference
    ) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String addUserCommand = "INSERT INTO users " +
                    "(fName, lName, email, phone, password, preference) " +
                    "VALUES ('" +
                    fName + "', '" +
                    lName + "', '" +
                    email + "', '" +
                    phone + "', '" +
                    password + "', '" +
                    preference + "')";
            System.out.println("SQL Query " + addUserCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(addUserCommand);// executes the statement
            // array list of customers

            //if (result == 1)
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }

    public static boolean deleteuser (String fName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(
                    DBCredentials.DB_ADDRESS,
                    DBCredentials.USERNAME,
                    DBCredentials.PASSWORD);

            String deleteUserCommand = "DELETE FROM users " +
                    "WHERE fName = '" +
                    fName + "'";
            System.out.println("SQL Deletion Query " + deleteUserCommand);

            Statement st = mysqlConnection.createStatement();// creates the statement

            int result = st.executeUpdate(deleteUserCommand);// executes the statement
            // array list of customers

            //if (result == 1)
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false; //null result indicates an issue
        }
    }
}



