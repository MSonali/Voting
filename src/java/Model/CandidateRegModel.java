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
public class CandidateRegModel {
    private String name;
    private int valid;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setValid(int b){
        valid = b;
    }
    public int getValid(){
        return valid;
    }
}
