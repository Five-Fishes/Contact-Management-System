package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;

import javax.swing.*;

public class SearchButton {
    static MUI mui;

    public void search() {
        mui = MUI.getInstance();
        JPanel jPanel1 = mui.getPanel1();
        JPanel jPanel2 = mui.getPanel2();
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

}
