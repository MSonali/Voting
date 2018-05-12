/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.UserDao.currentCon;
import Model.CandidateRegModel;
import Model.CheckModel;
import Model.ECLoginModel;
import Model.LoginModel;
import Model.RegisterModel;
import Model.SMS;
import Model.VoteNowModel;
import Model.VoterDetailsModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sonali
 */
public class UserDao {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static LoginModel loginDB(LoginModel login) {
        Statement stmt = null;
        String username = login.getUserName();
        String password = login.getPassword();
        boolean more = false;
        String searchQuery
                = "select * from voter1 where v_name='"
                + username
                + "' and passwd= AES_ENCRYPT('"
                + password
                + "',UNHEX('F3229A0B371ED2D9441B830D21A390C3'))";
        try {
            currentCon = DBConnection.connect();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            if (rs.next()) {
                more = true;
            }
            System.out.println(more);
            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                login.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {
                String firstName = rs.getString("v_name");

                System.out.println("Welcome " + firstName);
                login.setValid(true);
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling
        finally {
            DBConnection.close(rs, stmt, currentCon);
        }
        return login;
    }

    public static RegisterModel regDB(RegisterModel reg) {
        System.out.println("In Registration db module");
        Statement stmt = null;
        String ano = reg.getAno();
        String name = reg.getName();
        String psswd = reg.getPassword();
//insert into voter1 (v_id,v_name,passwd) values(5058,'yoga',AES_ENCRYPT('mytext','yoga'));

        String insert_query = "insert into voter1(v_id,v_name,passwd) values('" + ano + "','" + name + "',AES_ENCRYPT('" + psswd + "',UNHEX('F3229A0B371ED2D9441B830D21A390C3')))";

        try {
            currentCon = DBConnection.connect();
            stmt = currentCon.createStatement();
            int i = stmt.executeUpdate(insert_query);

            if (i > 0) {
                System.out.println("registration successful");
                reg.setValid(true);
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION!!" + e);
        } finally {
            DBConnection.close(rs, stmt, currentCon);
        }
        return reg;
    }

    public static VoterDetailsModel vdDB(VoterDetailsModel vdm) {
        Statement stmt = null;
        String ano = vdm.getAno();
        String password = vdm.getPassword();

        String getDetailsQuery = "select status from voter1 where v_id = '" + ano + "' and passwd =AES_ENCRYPT('" + password + "',UNHEX('F3229A0B371ED2D9441B830D21A390C3'))";
        String genrand = "update voter1 set uin = floor(1 + rand() *1000)";
        String getuid = "select uin from voter1 where v_id = '" + ano + "'";
        try {
            currentCon = DBConnection.connect();
            stmt = currentCon.createStatement();
            System.out.println("Checking for the correctness of ano and psswd...");
            rs = stmt.executeQuery(getDetailsQuery);
            if (rs.next()) {
                vdm.setValid(true);
            } else {
                System.out.println("Invalid Input");
                vdm.setValid(false);
            }
            System.out.println("Checking if voted/not...");
            String status = rs.getString("status");
            System.out.println(status);
            if (status.equals("nv")) {
                System.out.println("Not Voted");
                vdm.setStatus(true);
            } else {
                System.out.println("Voted");
                vdm.setStatus(false);
            }
            if (vdm.getStatus()) {
                System.out.println("Setting UID");
                PreparedStatement ps = currentCon.prepareStatement(genrand);
                ps.execute();
                System.out.println("Getting UId...");
                rs = stmt.executeQuery(getuid);
                if (rs.next()) {
                    int uid = rs.getInt("uin");
                    System.out.println(uid);
                    vdm.setUid(uid);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        } finally {
            DBConnection.close(rs, stmt, currentCon);
            return vdm;
        }
    }

    public static CheckModel chkDB(CheckModel cm) {
        Statement stmt = null;
        String ano = cm.getAno();
        int uid = cm.getUid();
        boolean more = false;
        String verify_query = "select * from voter1 where v_id = '" + ano + "' and uin = '" + uid + "'";
        String loc_query = "select Location from aadhar where Ano = '" + ano + "'";
        try {
            currentCon = DBConnection.connect();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(verify_query);
            System.out.println("Checking...");
            if (rs.next()) {
                more = true;
            }
            if (!more) {
                System.out.println("Invalid ano/uid");
                cm.setValid(false);
            } else {
                cm.setValid(true);

                rs = stmt.executeQuery(loc_query);
                System.out.println("Getting Location...");
                if (rs.next()) {
                    String location = rs.getString("Location");
                    cm.setLocation(location);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception" + e);
        } finally {
            DBConnection.close(rs, stmt, currentCon);
            return cm;
        }

    }

    public static VoteNowModel vnDB(VoteNowModel vnm) {
        //VoterDetailsModel vdm = new VoterDetailsModel();

        String c_name = vnm.getCandiname();
        System.out.println("c_name " + c_name);
        String ano = vnm.getAno();
        System.out.println(ano);
        System.out.println("ano " + ano);
        boolean voter_bool = false;
        String updvoter = "update voter1 set status='vo' where v_id = '" + ano + "'";
        String sendmsg = "select mobile from aadhar where Ano = '" + ano + "'";
        try {
            currentCon = DBConnection.connect();
            PreparedStatement ps1 = currentCon.prepareStatement(updvoter);
            ps1.execute();
            System.out.println("Voter Updated!");
            voter_bool = true; // voteStatus
            vnm.setVoterUp(true);
        } catch (SQLException e) {
            vnm.setVoterUp(false);
            System.out.println("Exception" + e);
        }
        if (voter_bool == true) {
            String upd = "update candidate set vote_count=vote_count+1 where c_name='" + c_name + "'";
            try {
                currentCon = DBConnection.connect();
                PreparedStatement ps = currentCon.prepareStatement(upd);
                ps.execute();
                System.out.println("Candidate updated!");

                vnm.setVaid(true);
            } catch (SQLException e) {
                System.out.println("Exception " + e);
            }
            try {
                SMS sms = new SMS();
                currentCon = DBConnection.connect();
                Statement stmt = currentCon.createStatement();
                rs = stmt.executeQuery(sendmsg);
                if (rs.next()) {
                    String mobile = rs.getString("mobile");
                    System.out.println(mobile);
                    sms.setMobile(mobile);
                }

            } catch (SQLException e) {
                System.out.println("Exception " + e);
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                    }
                    rs = null;
                }

                if (currentCon != null) {
                    try {
                        currentCon.close();
                    } catch (SQLException e) {
                    }

                    currentCon = null;
                }
            }

        }
        return vnm;
    }

    public static CandidateRegModel cand_reg_db(CandidateRegModel crm) {
        String name = crm.getName();
        System.out.println(name);
        int insertValid;
        String insert_candidate = "insert into candidate (c_name) values('" + name + "')";
        currentCon = DBConnection.connect();
        try {
            PreparedStatement ps = currentCon.prepareStatement(insert_candidate);
            insertValid = ps.executeUpdate();
            System.out.println(insertValid);
            crm.setValid(insertValid);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crm;
    }

    public static ECLoginModel ECLoginDb(ECLoginModel elm) {
        try {
            String id = elm.getId();
            String password = elm.getPassword();
            currentCon = DBConnection.connect();
            String check = "select * from electioncommission where ID = '" + id + "' and Password = '" + password + "'";
            PreparedStatement ps = currentCon.prepareStatement(check);
            rs = ps.executeQuery();
            if (rs.next()) {
                elm.setValid(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elm;
    }

   /* public static SMS smsMobile(SMS sms) {
        try {
            String sendmsg = "select mobile from aadhar where Ano = '" + ano + "'";
            currentCon = DBConnection.connect();
            Statement stmt = currentCon.createStatement();
            rs = stmt.executeQuery(sendmsg);
            if (rs.next()) {
                String mobile = rs.getString("mobile");
                System.out.println(mobile);
                sms.setMobile(mobile);
            }

        } catch (SQLException e) {
            System.out.println("Exception " + e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
                rs = null;
            }
        }
        return sms;
    }*/
}
    /*if(rs.next()){
                // this.dispose();
                logincnt++;
            }
        }
        catch(Exception e){
            
        }
        return logincnt;*/
