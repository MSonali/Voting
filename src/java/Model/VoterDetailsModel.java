/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Shyamil
 */
public class VoterDetailsModel {
    
    private String ano;
    private String password;
    private boolean valid;
    private boolean status;
    private int uid;
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setValid(boolean b){
        valid = b;
    }
    
    public boolean isValid(){
        return valid;
    }
    
    public void setStatus(boolean b){
        status = b;
        System.out.println(b);
    }
    
    public boolean getStatus(){
        return status;
    }
    
    public void setUid(int uid){
        this.uid = uid;
    }
    
    public int getUid(){
        return this.uid;
    }
}
