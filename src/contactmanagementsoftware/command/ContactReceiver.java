package contactmanagementsoftware.command;

import contactmanagementsoftware.*;
import contactmanagementsoftware.Interpreter.Expression;
import contactmanagementsoftware.Interpreter.Parser;
import contactmanagementsoftware.chainOfResponsibility.resource.ContactValidatorChain;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ContactReceiver {
    static MUI mui;
    String str;
    JPanel jPanel1, jPanel2, jPanel3;
    JTextPane details;
    ArrayList<ArrayList<Acquaintances>> a, temp;
    Acquaintances acquaintance;
    ArrayList<Integer> uploadedFileIndexes;
    int selectedContactTypeIndex = -1, selectedContactIndex = -1;
    private final Logger logger = LoggerSingleton.getInstance();

    ConstructContact contactConstructor = new ConstructContact();
    ContactValidatorChain chain = new ContactValidatorChain();

    public ContactReceiver(){
        mui = mui.getInstance();
        str = mui.getStr();
        jPanel1 = mui.getjPanel1();
        jPanel2 = mui.getjPanel2();
        jPanel3 = mui.getjPanel3();
        details = mui.getDetails();
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

        String[] arr = {nameTextField.getText(), mobileTextField.getText(), emailTextField.getText(), one.getText(), two.getText(), three.getText()};
        Acquaintances contact = contactConstructor.createContact(selectedContactTypeIndex, arr);
        try {
            chain.validateContact(contact);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(mui, e.getMessage());
            return false;
        }

        if(mui.getIsAddContact())
            a.get(selectedContactTypeIndex).add(contact);
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
        searchNameAndDisplay();
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

    public void searchNameAndDisplay(){
        String s = "<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>";
        int j = 0;
        Expression searchExpression = new Parser().constructParser(str);
        for(int i = 0; i < a.get(0).size(); i++){
            //if(a.get(0).get(i).getName().matches(str)){
            if(searchExpression.interpret(a.get(0).get(i).getName())){
                j++;
                PersonalFriends perF = (PersonalFriends)a.get(0).get(i);
                if(j==1){
                    s = s.concat("<br>I. Personal Friends<br>");
                }
                s = s.concat(j + ". Name: " + perF.getName() + "<br>");
                s = s.concat("Mobile No: " + perF.getMobileNo() + "<br>");
                s = s.concat("Email: " + perF.getEmail() + "<br>");
                s = s.concat("Specific events: " + perF.getEvents() + "<br>");
                s = s.concat("First Acquaintance context: " + perF.getAContext() + "<br>");
                s = s.concat("First Acquaintance date: " + perF.getADate() + "<br>");
            }
        }
        j = 0;
        for(int i = 0; i < a.get(1).size(); i++){
            //if(a.get(1).get(i).getName().matches(str)){
            if(searchExpression.interpret(a.get(1).get(i).getName())){
                j++;
                Relatives rel = (Relatives)a.get(1).get(i);
                if(j==1){
                    s = s.concat("<br>II. Relatives<br>");
                }
                s = s.concat(j + ". Name: " + rel.getName() + "<br>");
                s = s.concat("Mobile No: " + rel.getMobileNo() + "<br>");
                s = s.concat("Email: " + rel.getEmail() + "<br>");
                s = s.concat("Relatives Birthday: " + rel.getBDate() + "<br>");
                s = s.concat("Last met date: " + rel.getLDate() + "<br>");
            }
        }
        j = 0;
        for(int i = 0; i < a.get(2).size(); i++){
            //if(a.get(2).get(i).getName().matches(str)){
            if(searchExpression.interpret(a.get(2).get(i).getName())){
                j++;
                ProfessionalFriends proF = (ProfessionalFriends)a.get(2).get(i);
                if(j==1){
                    s = s.concat("<br>III. Professional Friends<br>");
                }
                s = s.concat(j + ". Name: " + proF.getName() + "<br>");
                s = s.concat("Mobile No: " + proF.getMobileNo() + "<br>");
                s = s.concat("Email: " + proF.getEmail() + "<br>");
                s = s.concat("Common Interests: " + proF.getCommonInterests() + "<br>");
            }
        }
        j = 0;
        for(int i = 0; i < a.get(3).size(); i++){
            //if(a.get(3).get(i).getName().matches(str)){
            if(searchExpression.interpret(a.get(3).get(i).getName())){
                j++;
                CasualAcquaintances ca = (CasualAcquaintances)a.get(3).get(i);
                if(j==1){
                    s = s.concat("<br>IV. Casual Acquaintances<br>");
                }
                s = s.concat(j + ". Name: " + ca.getName() + "<br>");
                s = s.concat("Mobile No: " + ca.getMobileNo() + "<br>");
                s = s.concat("Email: " + ca.getEmail() + "<br>");
                s = s.concat("First met location & time: " + ca.getWhenWhere() + "<br>");
                s = s.concat("First met circumstances: " + ca.getCircumstances() + "<br>");
                s = s.concat("Other useful information: " + ca.getOtherInfo() + "<br>");
            }
        }
        if(s.matches("<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>")){
            s  = "<html>No result found</html>";
        }
        else{
            s = s.concat("</html>");
        }
        details.setText(s);
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
