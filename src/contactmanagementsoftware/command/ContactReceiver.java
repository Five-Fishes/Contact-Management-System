package contactmanagementsoftware.command;

import contactmanagementsoftware.*;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ContactReceiver {
    static MUI mui;
    JList jList1;
    JXTable jXTable1;
    JPanel jPanel1, jPanel2, jPanel3;
    ArrayList<ArrayList<Acquaintances>> a, temp;
    boolean flag;
    int x;

    public ContactReceiver(){
        mui = mui.getInstance();
        jList1 = mui.getJList1();
        jPanel1 = mui.getPanel1();
        jPanel2 = mui.getPanel2();
        jPanel3 = mui.getPanel3();
        jXTable1 = mui.getjXTable1();
        a = mui.getA();
    }

    public void addContact(){
        x = mui.getX();
        flag = mui.getFlag();
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

    public void deleteContact(){
        int index = jList1.getSelectedIndex();
        if(index<0){
            JOptionPane.showMessageDialog(mui, "Select a category!");
            return;
        }

        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mui, "Select an entry!");
            return;
        }

        int n = JOptionPane.showConfirmDialog(
                mui,
                "Are you sure you want to delete this?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        if(n==0){
            a.get(index).remove(tindex);
            JOptionPane.showMessageDialog(mui, "Successfully Deleted");
            mui.setUpTableData();
        }
    }

    public void editContact(){
        int index = jList1.getSelectedIndex();
        if(index<0){
            JOptionPane.showMessageDialog(mui, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mui, "Select an entry!");
            return;
        }

        mui.setNum(tindex);
        mui.setFlag(false);
        mui.setDFlag(false);
        mui.setX(index);
        mui.setDescription();
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
    }

    public void viewFullDetail(){

        int index = jList1.getSelectedIndex();
        if(index<0){
            JOptionPane.showMessageDialog(mui, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mui, "Select an entry!");
            return;
        }

        mui.setNum(tindex);
        mui.setFlag(false);
        mui.setX(index);
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        mui.setDFlag(true);
        mui.setDescription();

    }

    public void searchContact() {
        JTextPane details = mui.getDetails();

        String s = (String) JOptionPane.showInputDialog(
                mui,
                "Enter name: ",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");
        if(s==null)
            return;
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        mui.setStr(s);
        details.setContentType( "text/html" );
        mui.runn();
    }

    public void uploadContacts(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(mui);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                mui.setTemp((ArrayList<ArrayList<Acquaintances>>) SerializationUtil.deserialize(selectedFile));
                temp = mui.getTemp();
            }
            catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(mui, "Error");
                return;
            }
        }
        else{
            return;
        }
        try{
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < temp.get(i).size(); j++){
                    a.get(i).add(temp.get(i).get(j));
                }
            }
        }
        catch(Exception e){

        }
        mui.setUpTableData();
    }

    public void saveContacts(){
        String s = (String) JOptionPane.showInputDialog(
                mui,
                "Enter file name: (*.ser)",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "output.ser");
        if(s==null)
            return;
        if(!s.endsWith(".ser")){
            JOptionPane.showMessageDialog(mui, "File name should end with .ser");
            return;
        }
        File[] fileList = (new File(".")).listFiles((File pathname) -> pathname.getName().endsWith(".ser"));
        boolean flag = false;
        for(File f : fileList){
            if(f.getName().matches(s)){
                flag = true;
            }
        }
        if(flag){
            int q = JOptionPane.showConfirmDialog(mui, s + " already exists:\nAre you sure you want to overwrite?");
            if(q!=0)
                return;
        }
        try {
            SerializationUtil.serialize(a, s);
        } catch (IOException e) {
            return;
        }
        JOptionPane.showMessageDialog(mui, s + " saved successfully");
    }

}
