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
public class CheckModel {
    private String ano;
    private int uid;
    private boolean valid;
    private String loc;
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public void setValid(boolean b){
        valid = b;
        System.out.println("In CheckModel valid");
    }
    
    public boolean isValid(){
        return valid;
    }
    
    public void setLocation(String location){
        loc = location;
    }
    public String getLocation(){
        System.out.println(loc);
        return loc;
    }
}
