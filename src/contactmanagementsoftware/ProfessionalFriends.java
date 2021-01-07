package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

public class ProfessionalFriends extends Acquaintances implements Serializable{
    
    private String CommonInterests;
    public static int numberProF = 0;
    
    public ProfessionalFriends(){
        numberProF++;
    }

    public ProfessionalFriends(ProfessionalFriends proF){
        super.setName(proF.getName());
        super.setMobileNo(proF.getMobileNo());
        super.setEmail(proF.getEmail());
        CommonInterests = proF.getCommonInterests();
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

    public String getCommonInterests() {
        return CommonInterests;
    }

    public void setCommonInterests(String CommonInterests) {
        this.CommonInterests = CommonInterests;
    }
}
