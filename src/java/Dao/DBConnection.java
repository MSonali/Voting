package Dao;

import static Dao.UserDao.rs;
import Model.LoginModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import static sun.security.jgss.GSSUtil.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sonali
 */
public class DBConnection {

    static Connection con;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection successful!");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection failed" + e);
        }
        String url = "jdbc:mysql://localhost:3306/vote1";
        try {
            con = DriverManager.getConnection(url, "root", "admin");
            System.out.println("Database Connected");
        } catch (SQLException se) {
            System.out.println("No Database" + se);
        }
        return con;
    }

    public static void close(ResultSet rs, Statement stmt, Connection currentCon) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }
            stmt = null;
        }

        if (currentCon != null) {
            try {
                currentCon.close();
            } catch (Exception e) {
            }

        }
    }
}
/* public int loginVer(String email,String Password){
        String sql1 = "select * from voter1 where e_mail=? and passwd=? ";
        //String sql2 = "select status = "nv" from voter1 where e_mail=?";
        
        int logincnt = 0;
        try{
            PreparedStatement ps = DBConnection.prepareStatement(sql1);
            ps.setString(1,"email");
            ps.setString(2,"password");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                // this.dispose();
                logincnt++;
            }
        }
        catch(Exception e){
            
        }
        return logincnt;
    }*/
