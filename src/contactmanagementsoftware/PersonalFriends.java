package contactmanagementsoftware;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonalFriends extends Acquaintances implements Serializable{
    private String AContext;
    private String ADate;
    private String Events;
    private static Scanner reader = new Scanner(System.in);
    public static int numberPerF = 0;
    
    public PersonalFriends(){
        numberPerF++;
    }

    public PersonalFriends(PersonalFriends perF){
        super.setName(perF.getName());
        super.setMobileNo(perF.getMobileNo());
        super.setEmail(perF.getEmail());
        AContext = perF.getAContext();
        ADate = perF.getADate();
        Events = perF.getEvents();
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
    
    public String getAContext() {
        return AContext;
    }

    public void setAContext(String AContext) {
        this.AContext = AContext;
    }

    public String getADate() {
        return ADate;
    }

    public void setADate(String ADate) {
        this.ADate = ADate;
    }

    public String getEvents() {
        return Events;
    }

    public void setEvents(String Events) {
        this.Events = Events;
    }
}
