package com.StatefulApplication.StatefulApplication.model;

import org.springframework.stereotype.Component;

@Component
public class UserLogin {
    private String gmail;
    private String password1 ;
     public UserLogin(){

     }
    public UserLogin(String password1, String gmail) {
        this.gmail = gmail;
        this.password1 = password1;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }


}
