package contactmanagementsoftware;

import javafx.beans.binding.When;

import java.io.Serializable;
import java.util.Scanner;

public class CasualAcquaintances extends Acquaintances implements Serializable{
    private String WhenWhere;
    private String Circumstances;
    private String OtherInfo;
    public static int numberCA = 0;
    
    public CasualAcquaintances(){
        numberCA++;
    }

    public CasualAcquaintances(CasualAcquaintances ca){
        super.setName(ca.getName());
        super.setMobileNo(ca.getMobileNo());
        super.setEmail(ca.getEmail());
        WhenWhere = ca.getWhenWhere();
        Circumstances = ca.getCircumstances();
        OtherInfo = ca.OtherInfo;
    }
    
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String Name) {
        super.setName(Name); 
    }

    @Override
    public String getMobileNo() {
        return super.getMobileNo();
    }

    @Override
    public void setMobileNo(String MobileNo) {
        super.setMobileNo(MobileNo);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String Email) {
        super.setEmail(Email);
    }
    
    public String getWhenWhere() {
        return WhenWhere;
    }

    public void setWhenWhere(String WhenWhere) {
        this.WhenWhere = WhenWhere;
    }

    public String getCircumstances() {
        return Circumstances;
    }

    public void setCircumstances(String Circumstances) {
        this.Circumstances = Circumstances;
    }

    public String getOtherInfo() {
        return OtherInfo;
    }

    public void setOtherInfo(String OtherInfo) {
        this.OtherInfo = OtherInfo;
    }
}
