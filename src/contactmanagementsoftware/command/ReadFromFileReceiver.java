package contactmanagementsoftware.command;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.SerializationUtil;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFileReceiver extends Receiver {
    ArrayList<ArrayList<Acquaintances>> temp;

    public void readFromFile(){
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
}
