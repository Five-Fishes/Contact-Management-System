package contactmanagementsoftware.command;

import contactmanagementsoftware.*;

import javax.swing.*;
import java.util.ArrayList;

public class AddContactButton {
    static MUI mui;
    
    public void addContact(){
        mui = mui.getInstance();
        JPanel jPanel1 = mui.getPanel1();
        JPanel jPanel3 = mui.getPanel3();

        int x = mui.getX();
        boolean flag = mui.getFlag();
        ArrayList<ArrayList<Acquaintances>> a = mui.getA();
        JTextField name = mui.getContactName();
        JTextField mobile = mui.getContactMobile();
        JTextField email = mui.getContactEmail();
        JTextArea one = mui.getOne();
        JTextArea two = mui.getTwo();
        JTextArea three = mui.getThree();
        int num = mui.getNum();


        mui.setDFlag(true);
        String Name = name.getText();
        if(Name.isEmpty()){
            JOptionPane.showMessageDialog(mui, "Enter a name");
            return;
        }
        String Mobile = mobile.getText();
        if(!mui.MobileNoChecker(Mobile)){
            JOptionPane.showMessageDialog(mui, "Enter a valid mobile number (6-15 digits)");
            return;
        }
        String Email = email.getText();
        if(!Email.contains("@")){
            JOptionPane.showMessageDialog(mui, "Enter a valid email");
            return;
        }
        String One,Two,Three;
        switch(x){
            case 0: //perF
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if(!mui.validDate(Three)){
                    return;
                }
                if(Three.isEmpty() || Three.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                PersonalFriends perF;
                if(flag)
                    perF = new PersonalFriends();
                else
                    perF = (PersonalFriends)a.get(x).get(num);
                perF.setName(Name);
                perF.setMobileNo(Mobile);
                perF.setEmail(Email);
                perF.setEvents(One);
                perF.setAContext(Two);
                perF.setADate(Three);
                if(flag)
                    a.get(x).add(perF);
                break;
            case 1: //rel
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if(!mui.validDate(One)){
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if(!mui.validDate(Two)){
                    return;
                }
                Relatives rel;
                if(flag)
                    rel = new Relatives();
                else
                    rel = (Relatives)a.get(x).get(num);
                rel.setName(Name);
                rel.setMobileNo(Mobile);
                rel.setEmail(Email);
                rel.setBDate(One);
                rel.setLDate(Two);
                if(flag)
                    a.get(x).add(rel);
                break;
            case 2: //proF
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                ProfessionalFriends proF;
                if(flag)
                    proF = new ProfessionalFriends();
                else
                    proF = (ProfessionalFriends)a.get(x).get(num);
                proF.setName(Name);
                proF.setMobileNo(Mobile);
                proF.setEmail(Email);
                proF.setCommonInterests(One);
                if(flag)
                    a.get(x).add(proF);
                break;
            case 3: //ca
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if(Three.isEmpty() || Three.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                CasualAcquaintances ca;
                if(flag)
                    ca = new CasualAcquaintances();
                else
                    ca = (CasualAcquaintances)a.get(x).get(num);
                ca.setName(Name);
                ca.setMobileNo(Mobile);
                ca.setEmail(Email);
                ca.setWhenWhere(One);
                ca.setCircumstances(Two);
                ca.setOtherInfo(Three);
                if(flag)
                    a.get(x).add(ca);
                break;
            default:
                break;
        
        }
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
        mui.setUpTableData();
    }
}
