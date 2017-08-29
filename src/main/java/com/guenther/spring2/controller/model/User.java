package com.guenther.spring2.controller.model;

/**
 * Created by Gateway on 8/20/2017.
 */
public class User {
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String password;
    private String preference;



    public User()
    {
        fName = "";
        lName = "";
        email = "";
        phone = "";
        password = "";
        preference ="";


    }
    public User(String fN, String cname)
    {
        fName=fN;
        lName=cname;
    }
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }


}
