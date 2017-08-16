package com.guenther.spring2.controller;

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
            @RequestParam("password") String password

    )

    //server side validation

    {

        //here's where the magic happens

        ModelAndView mv = new ModelAndView("formresponse");
        mv.addObject("fName", fName);
        mv.addObject("lName", lName);
        mv.addObject("email", email);
        mv.addObject("phone", phone);
        mv.addObject("password", password);
        return mv;
    }


    @RequestMapping(value = "/getAllItems")
    public ModelAndView getAllItems()
    {
        //define the data for connection
        String dbAddress = "jdbc:mysql://localhost:3306/coffeeshopdb";
        String userName = "root";
        String password = "s4nk0f4256";
        //load driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //creadte the db connection object
            Connection mysqlConnection;
            mysqlConnection = DriverManager.getConnection(dbAddress,userName,password);

            //create db statement

            String readItemCommand = "select name, description, quantity, price from items";
            Statement readItem = mysqlConnection.createStatement();

            ResultSet results = readItem.executeQuery(readItemCommand);//executes the statement

            //Array list of customers
            ArrayList<Items> itemsList = new ArrayList<Items>();
            //map from the ResultSet to ArrayList

            while (results.next())
            {

                Items temp = new Items(results.getString(1),results.getString(2),
                        results.getInt(3), results.getFloat(4));
                itemsList.add(temp);
            }

            return new ModelAndView("itemsView", "iList",itemsList);



        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;// todo: create an error page with custom error messages !!!!
    }
}