package com.guenther.spring2.controller;

import com.guenther.spring2.controller.model.DAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView helloWorld()
    {
        ModelAndView mv = new
                ModelAndView("welcome");
        //mv.addObject("message","Hello World!!!");
        //mv.addObject("bob", "This is another string");
        mv.addObject("title", "Welcome to The Drunk'n Java Shop");
        return mv;
    }

    @RequestMapping("/userform")
    public ModelAndView userform () {
        return new ModelAndView("form", "inst",
                "Please enter info: ");
    }

    @RequestMapping("/formhandler")
    public ModelAndView formhandler (
            @RequestParam("fName") String fName,
            @RequestParam("lName") String lName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            @RequestParam("preference") String preference

    )

    //server side validation

    {

        //here's where the magic happens

        ModelAndView mv = new ModelAndView("addResults");
        mv.addObject("fName", fName);
        mv.addObject("lName", lName);
        mv.addObject("email", email);
        mv.addObject("phone", phone);
        mv.addObject("password", password);
        mv.addObject("preference",preference);
        return mv;
    }


    @RequestMapping(value = "/getAllItems")
    public ModelAndView getAllItems()
    {
        ArrayList<Items> itemsList = DAO.getAllItems();

        if (itemsList == null) {
            return new ModelAndView("error", "errmsg", "Customer list is null");
        }

        return new ModelAndView("itemsView","iList",itemsList);
    }


    //handle the submit of the customer form
    @RequestMapping(value = "/addUser")
    public ModelAndView addCustomer (
            @RequestParam("fName") String fName,
            @RequestParam("lName") String lName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            @RequestParam("preference") String preference
    ) {

        //add the info to DB through DAO
        boolean result = DAO.addUser(fName, lName, email, phone, password, preference);
        //best to check the result
        if (result == false) {
            //still have to write this view
            return new ModelAndView("error", "errmsg", "customer add failed");
        }

        ModelAndView mv = new ModelAndView("addResult");
        mv.addObject("CustomerID", fName);
        mv.addObject("CompanyName", lName);
        mv.addObject("ContactName", email);
        mv.addObject("ContactTitle", phone);
        mv.addObject("ContactTitle", password);
        mv.addObject("ContactTitle", preference);

        return mv;
    }
//        //define the data for connection
//        String dbAddress = "jdbc:mysql://localhost:3306/coffeeshopdb";
//        String userName = "root";
//        String password = "s4nk0f4256";
//        //load driver
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//
//            //creadte the db connection object
//            Connection mysqlConnection;
//            mysqlConnection = DriverManager.getConnection(dbAddress,userName,password);
//
//            //create db statement
//
//            String readItemCommand = "select name, description, quantity, price from items";
//            Statement readItem = mysqlConnection.createStatement();
//
//            ResultSet results = readItem.executeQuery(readItemCommand);//executes the statement
//
//            //Array list of customers
//
//            //map from the ResultSet to ArrayList
//
//            while (results.next())
//            {
//
//                Items temp = new Items(results.getString(1),results.getString(2),
//                        results.getInt(3), results.getFloat(4));
//                itemsList.add(temp);
//            }
//
//            return new ModelAndView("itemsView", "iList",itemsList);
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;// todo: create an error page with custom error messages !!!!
    }
