/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sonali
 */
public class VoteNowModel {
   
    private String candiname;
    private String ano;
    private boolean valid;
    private boolean voterup;
    VoterDetailsModel vdm = new VoterDetailsModel();
    

    public void setCandiname(String candiname) {
        this.candiname = candiname;
    }
    public String getCandiname() {
        
        return this.candiname;
    }
    public void setAno(String ano){
        this.ano = ano;
    }
    public String getAno(){
        return ano;
    }
    
    public void setVaid(boolean b){
        valid = b;
    }
    
    public boolean isValid(){
        return valid;
    }
    
    public void setVoterUp(boolean b){
        voterup = b;
    }
    
    public boolean getVoterUp(){
        return voterup;
    } 
    
}
