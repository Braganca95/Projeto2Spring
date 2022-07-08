package com.example.SpringProjeto2Web.DAL;

import org.springframework.stereotype.Controller;

@Controller
public class Login {


    private String userid;
    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
