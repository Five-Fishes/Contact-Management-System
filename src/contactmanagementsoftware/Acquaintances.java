package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

public class Acquaintances implements Serializable{
    private String Name;
    private String MobileNo;
    private String Email;
    public static int number = 0;
    
    public Acquaintances(){
        number++;
    }
        
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getEmail() {
        return Email;
    }
    
    
    public void setMobileNo(String MobileNo){
        this.MobileNo = MobileNo;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }
}
