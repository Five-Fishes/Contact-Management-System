package contactmanagementsoftware;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Relatives extends Acquaintances implements Serializable{
    private String BDate;
    private String LDate;
    public static int numberRel = 0;
    private static Scanner reader = new Scanner(System.in);
    
    public Relatives(){
        numberRel++;
    }

    public Relatives(Relatives rel){
        super.setName(rel.getName());
        super.setMobileNo(rel.getMobileNo());
        super.setEmail(rel.getEmail());
        BDate = rel.getBDate();
        LDate = rel.getLDate();
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
    
    public String getBDate() {
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public String getLDate() {
        return LDate;
    }

    public void setLDate(String LDate) {
        this.LDate = LDate;
    }
}
