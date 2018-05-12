/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Login;
import Dao.UserDao;

/**
 *
 * @author Sonali
 */
public class LoginModel {

    private String userName;
    private String password;
    public boolean valid;
    
    public String getUserName() {
        System.out.println(this.userName);
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        System.out.println(this.password);
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setValid(boolean b) {
        valid = b;
    }

    public boolean isValid() {
        System.out.println("check valididty...");
        return valid;
    }
    


}
