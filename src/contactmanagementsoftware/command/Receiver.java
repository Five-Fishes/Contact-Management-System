package contactmanagementsoftware.command;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.MUI;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;
import java.util.ArrayList;

public class Receiver {
    static MUI mui;
    JList jList1;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JXTable jXTable1;
    ArrayList<ArrayList<Acquaintances>> a;
    boolean flag;

    public Receiver(){
        mui = mui.getInstance();
        jList1 = mui.getJList1();
        jPanel1 = mui.getPanel1();
        jPanel2 = mui.getPanel2();
        jPanel3 = mui.getPanel3();
        jXTable1 = mui.getjXTable1();
        a = mui.getA();
        flag = mui.getFlag();
    }
}
