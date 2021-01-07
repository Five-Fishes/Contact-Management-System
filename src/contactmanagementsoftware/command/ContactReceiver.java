package contactmanagementsoftware.command;

import contactmanagementsoftware.*;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ContactReceiver {
    static MUI mui;
    JPanel jPanel1, jPanel2, jPanel3;
    int selectedContactTypeIndex = -1, selectedContactIndex = -1;
    ArrayList<ArrayList<Acquaintances>> a, temp;
    Acquaintances acquaintance;
    ArrayList<Integer> uploadedFileIndexes;
    private Logger logger = LoggerSingleton.getInstance();

    public ContactReceiver(){
        mui = mui.getInstance();
        jPanel1 = mui.getjPanel1();
        jPanel2 = mui.getjPanel2();
        jPanel3 = mui.getjPanel3();
        uploadedFileIndexes = new ArrayList<>();
        a = mui.getAllAcquantanceList();
    }

    public boolean addContact(){
        selectedContactTypeIndex = mui.getSelectedContactTypeIndex();
        JTextField nameTextField = mui.getNameTextField();
        JTextField mobileTextField = mui.getMobileTextField();
        JTextField emailTextField = mui.getEmailTextField();
        JTextArea one = mui.getTextAreaOne();
        JTextArea two = mui.getTextAreaTwo();
        JTextArea three = mui.getTextAreaThree();

        mui.setIsDisplayOnly(true);
        String name = nameTextField.getText();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(mui, "Enter a name");
            return false;
        }
        String mobile = mobileTextField.getText();
        if(!mui.MobileNoChecker(mobile)){
            JOptionPane.showMessageDialog(mui, "Enter a valid mobile number (6-15 digits)");
            return false;
        }
        String email = emailTextField.getText();
        if(!email.contains("@")){
            JOptionPane.showMessageDialog(mui, "Enter a valid email");
            return false;
        }
        String One,Two,Three;
        switch(selectedContactTypeIndex){
            case 0: //perF
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                Three = three.getText();
                if(!mui.validDate(Three)){
                    return false;
                }
                if(Three.isEmpty() || Three.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                PersonalFriends perF;
                if(mui.getIsAddContact())
                    perF = new PersonalFriends();
                else{
                    perF = (PersonalFriends)mui.getCurrentAcquaintance();
                    acquaintance = new PersonalFriends(perF);
                }
                perF.setName(name);
                perF.setMobileNo(mobile);
                perF.setEmail(email);
                perF.setEvents(One);
                perF.setAContext(Two);
                perF.setADate(Three);
                if(mui.getIsAddContact())
                    a.get(selectedContactTypeIndex).add(perF);
                break;
            case 1: //rel
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                if(!mui.validDate(One)){
                    return false;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                if(!mui.validDate(Two)){
                    return false;
                }
                Relatives rel;
                if(mui.getIsAddContact())
                    rel = new Relatives();
                else{
                    rel = (Relatives)mui.getCurrentAcquaintance();
                    acquaintance = new Relatives(rel);
                }

                rel.setName(name);
                rel.setMobileNo(mobile);
                rel.setEmail(email);
                rel.setBDate(One);
                rel.setLDate(Two);
                if(mui.getIsAddContact())
                    a.get(selectedContactTypeIndex).add(rel);
                break;
            case 2: //proF
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                ProfessionalFriends proF;
                if(mui.getIsAddContact())
                    proF = new ProfessionalFriends();
                else{
                    proF = (ProfessionalFriends)mui.getCurrentAcquaintance();
                    acquaintance = new ProfessionalFriends(proF);
                }
                proF.setName(name);
                proF.setMobileNo(mobile);
                proF.setEmail(email);
                proF.setCommonInterests(One);
                if(mui.getIsAddContact())
                    a.get(selectedContactTypeIndex).add(proF);
                break;
            case 3: //ca
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                Three = three.getText();
                if(Three.isEmpty() || Three.length() > 300){
                    JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
                    return false;
                }
                CasualAcquaintances ca;
                if(mui.getIsAddContact())
                    ca = new CasualAcquaintances();
                else{
                    ca = (CasualAcquaintances)mui.getCurrentAcquaintance();
                    acquaintance = new CasualAcquaintances(ca);
                }
                ca.setName(name);
                ca.setMobileNo(mobile);
                ca.setEmail(email);
                ca.setWhenWhere(One);
                ca.setCircumstances(Two);
                ca.setOtherInfo(Three);
                if(mui.getIsAddContact())
                    a.get(selectedContactTypeIndex).add(ca);
                break;
            default:
                break;
        }
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
        mui.setUpTableData();
        return true;
    }

    public void addContact(int selectedContactTypeIndex, int selectedContactIndex, Acquaintances acquaintance){
        a.get(selectedContactTypeIndex).add(selectedContactIndex, acquaintance);
        mui.setUpTableData();
    }

    public boolean deleteContact(){
        selectedContactTypeIndex = mui.getSelectedContactTypeIndex();
        if(selectedContactTypeIndex < 0){
            JOptionPane.showMessageDialog(mui, "Select a category!");
            return false;
        }
        selectedContactIndex = mui.getSelectedContactIndex();
        if(selectedContactIndex < 0){
            JOptionPane.showMessageDialog(mui, "Select an entry!");
            return false;
        }

        int n = JOptionPane.showConfirmDialog(
                mui,
                "Are you sure you want to delete this?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        if(n==0){
            acquaintance = a.get(mui.getSelectedContactTypeIndex()).remove(mui.getSelectedContactIndex());
            JOptionPane.showMessageDialog(mui, "Successfully Deleted");
            mui.setUpTableData();
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteContact(int selectedContactTypeIndex){
        a.get(selectedContactTypeIndex).remove(a.get(selectedContactTypeIndex).size() - 1);
        mui.setUpTableData();
    }

    public void viewFullDetail(){

        if(mui.getSelectedContactTypeIndex() < 0){
            JOptionPane.showMessageDialog(mui, "Select a category!");
            return;
        }
        
        if(mui.getSelectedContactIndex() < 0){
            JOptionPane.showMessageDialog(mui, "Select an entry!");
            return;
        }

        mui.setIsAddContact(false);
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        mui.setIsDisplayOnly(true);
        mui.contactDetailsPanelSetterSetUI();

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
        mui.searchNameAndDisplay();
    }

    public boolean uploadContacts(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(mui);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                temp = (ArrayList<ArrayList<Acquaintances>>) SerializationUtil.deserialize(selectedFile);
            }
            catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(mui, "Error");
                logger.error(e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        else{
            return false;
        }
        try{
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < temp.get(i).size(); j++){
                    a.get(i).add(temp.get(i).get(j));
                    uploadedFileIndexes.add(i);
                }
            }
        }
        catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
        mui.setUpTableData();
        return true;
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
            logger.error("fail to serialize " + e);
            return;
        }
        JOptionPane.showMessageDialog(mui, s + " saved successfully");
    }

    public Acquaintances getAcquaintance(){
        return acquaintance;
    }

    public int getSelectedContactTypeIndex(){
        return selectedContactTypeIndex;
    }

    public int getSelectedContactIndex(){
        return selectedContactIndex;
    }

    public ArrayList<Integer> getUploadedFileIndexes(){
        return uploadedFileIndexes;
    }

    public void cleanUploadedFileIndexes(){
        uploadedFileIndexes.clear();
    }

    public boolean getIsAddContact() {
        return mui.getIsAddContact();
    }

}
