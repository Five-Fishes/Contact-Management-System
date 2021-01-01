/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import contactmanagementsoftware.command.*;
import org.jdesktop.swingx.JXTable;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ritz619
 */
public class MUI extends JFrame {

    /**
     * Creates new form MUI
     */
    private static MUI mg;
    private ArrayList<ArrayList<Acquaintances>> a;

    public JXTable getjXTable1() {
        return jXTable1;
    }

    public ArrayList<ArrayList<Acquaintances>> getA() {
        return a;
    }

    private ArrayList<ArrayList<Acquaintances>> temp;
    private int x;
    private int num;
    private boolean flag;
    private boolean dflag;
    private String op;
    private String str;
    private Command addCommand;
    private Command deleteCommand;
    private AddButton addButton;
    private DeleteButton deleteButton;
    private Invoker invoker;

    public void setMg(MUI mg) {
        this.mg = mg;
    }

    public void setA(ArrayList<ArrayList<Acquaintances>> a) {
        this.a = a;
    }
    
    public void setDescription(){
        name.setText("");
        mobile.setText("");
        email.setText("");
        one.setText("");
        two.setText("");
        three.setText("");
        if(!dflag){
            name.setEditable(true);
            mobile.setEditable(true);
            email.setEditable(true);
            one.setEditable(true);
            two.setEditable(true);
            three.setEditable(true);
        }
        if(flag)
            op = "Add";
        else
            op = "Edit";
        if(!flag){
            jButton10.setText("Save");
            Acquaintances e = a.get(x).get(num);            
            name.setText(e.getName());
            mobile.setText(e.getMobileNo());
            email.setText(e.getEmail());
            switch(x){
                case 0:
                    PersonalFriends perF = (PersonalFriends)e;
                    one.setText(perF.getEvents());
                    two.setText(perF.getAContext());
                    three.setText(perF.getADate());
                    break;
                case 1:
                    Relatives rel = (Relatives)e;
                    one.setText(rel.getBDate());
                    two.setText(rel.getLDate());
                    break;
                case 2:
                    ProfessionalFriends proF = (ProfessionalFriends)e;
                    one.setText(proF.getCommonInterests());
                    break;
                case 3:
                    CasualAcquaintances ca = (CasualAcquaintances)e;
                    one.setText(ca.getWhenWhere());
                    two.setVisible(true);
                    three.setVisible(true);
                    two.setText(ca.getCircumstances());
                    three.setText(ca.getOtherInfo());
                    break;
                default:
                    break;
            }
        }
        jButton10.setVisible(true);
        jButton11.setVisible(true);
        if(flag)
            jButton10.setText("Add");
        switch(x){
            case 0:
                two.setVisible(true);
                three.setVisible(true);
                jPanel3.setBorder(BorderFactory.createTitledBorder(null, op + " Personal Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setText("Specific Events:");
                jLabel8.setText("First Acquaintance Context:");
                jLabel9.setVisible(true);
                jLabel3.setVisible(true);
                jLabel8.setVisible(true);
                jLabel7.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                jLabel9.setText("<html>First Acquaintance Date:<br>(dd/mm/yyyy)</html>");
                break;
            case 1:
                jPanel3.setBorder(BorderFactory.createTitledBorder(null, op + " Relatives Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setText("<html>Relatives Birthday:<br> (dd/mm/yyyy)</html>");
                jLabel8.setVisible(true);
                jLabel7.setVisible(true);
                two.setVisible(true);
                jLabel8.setText("<html>Last Date met:<br> (dd/mm/yyyy)</html>");
                jLabel9.setVisible(false);
                three.setVisible(false);
                jScrollPane4.setVisible(true);
                jScrollPane5.setVisible(false);
                break;
            case 2:
                jPanel3.setBorder(BorderFactory.createTitledBorder(null, op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setText("Common Interests: ");
                jLabel7.setVisible(true);
                jLabel8.setVisible(false);
                two.setVisible(false);
                jScrollPane4.setVisible(false);
                jLabel9.setVisible(false);
                three.setVisible(false);
                jScrollPane5.setVisible(false);
                break;
            case 3:
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                two.setVisible(true);
                three.setVisible(true);
                jLabel7.setVisible(true);
                jLabel8.setVisible(true);
                jLabel9.setVisible(true);
                jLabel7.setText("First meeting time & location:");
                jLabel8.setText("First meeting CIrcumstances:");
                jLabel9.setText("Other useful information:");
                break;
            default:
                break;
        }
        if(dflag){
            name.setEditable(false);
            mobile.setEditable(false);
            email.setEditable(false);
            one.setEditable(false);
            two.setEditable(false);
            three.setEditable(false);
            jButton10.setText("Back to main menu");
            jButton11.setVisible(false);
            jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
        }
    }
    
    public MUI() {
        initComponents();
        String[] columnNames = {"S.No", "Name", "Mobile"," Email"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        jXTable1.setModel(model);
        setUpTableData();
        invoker = new Invoker();

        addButton = new AddButton();
        deleteButton = new DeleteButton();
        addCommand = new AddCommand(addButton);
        deleteCommand = new DeleteCommand(deleteButton);

        invoker.setCommand("add",addCommand);
        invoker.setCommand("delete",deleteCommand);
    }

    public final void setUpTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) jXTable1.getModel();
        tableModel.setRowCount(0);
        ArrayList<Acquaintances> list;
        try{        
            list = a.get(jList1.getSelectedIndex());
        }
        catch(Exception e){
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[4];
            data[0] = Integer.toString(i+1);
            data[1] = list.get(i).getName();
            data[2] = list.get(i).getMobileNo();
            data[3] = list.get(i).getEmail();
            tableModel.addRow(data);
        }
        jXTable1.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList();
        jScrollPane2 = new JScrollPane();
        jXTable1 = new JXTable();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jPanel2 = new JPanel();
        jScrollPane3 = new JScrollPane();
        details = new JTextPane();
        jButton9 = new JButton();
        jPanel3 = new JPanel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        name = new JTextField();
        email = new JTextField();
        jScrollPane4 = new JScrollPane();
        two = new JTextArea();
        jScrollPane5 = new JScrollPane();
        three = new JTextArea();
        jButton10 = new JButton();
        mobile = new JTextField();
        jScrollPane6 = new JScrollPane();
        one = new JTextArea();
        jButton11 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu Medium", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("<html><u>Contact Management System</u></html>");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoker.execute("add" ,evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoker.execute("delete", evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jList1.setModel(new AbstractListModel() {
            String[] strings = { "Personal Friends", "Relatives", "Professional Friends", "Casual Acquaintances" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "S.No", "Name", "Mobile No", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jXTable1);

        jLabel1.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
        jLabel1.setText("Select Category:");

        jLabel3.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
        jLabel3.setText("Details:");

        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("View full detail");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Read from file");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Save as file");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton8))
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton7)))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        details.setEditable(false);
        jScrollPane3.setViewportView(details);

        jButton9.setText("Back to main menu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jButton9)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, "card3");

        jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Add Casual Acquaintance Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); // NOI18N

        jLabel4.setText("Name:");

        jLabel5.setText("Mobile No:");

        jLabel6.setText("Email:");

        jLabel7.setText("First meeting time & location:");

        jLabel8.setText("First meeting CIrcumstances:");

        jLabel9.setText("Other useful information:");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        two.setColumns(20);
        two.setRows(5);
        two.setAutoscrolls(false);
        jScrollPane4.setViewportView(two);

        three.setColumns(20);
        three.setRows(5);
        jScrollPane5.setViewportView(three);

        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        one.setColumns(20);
        one.setRows(5);
        jScrollPane6.setViewportView(one);

        jButton11.setText("Cancel");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobile, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton10, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(132, 132, 132)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(mobile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPanel3, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String s = (String)JOptionPane.showInputDialog(
            mg,
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
        str = s;
        details.setContentType( "text/html" );
        runn();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        setUpTableData();
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int index = jList1.getSelectedIndex();
        if(index<0){
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        num = tindex;
        flag = false;
        dflag = false;
        x = index;
        setDescription();
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int index = jList1.getSelectedIndex();
        if(index<0){
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        num = tindex;
        flag = false;
        x = index;
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        dflag = true;
        setDescription();
    }//GEN-LAST:event_jButton6ActionPerformed

    public void runn(){
        String s = "<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>";
        int j = 0;
        for(int i = 0; i < a.get(0).size(); i++){
            if(a.get(0).get(i).getName().matches(str)){
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
            if(a.get(1).get(i).getName().matches(str)){
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
            if(a.get(2).get(i).getName().matches(str)){
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
            if(a.get(3).get(i).getName().matches(str)){
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
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                temp = (ArrayList<ArrayList<Acquaintances>>)SerializationUtil.deserialize(selectedFile);
            }
            catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(mg, "Error");
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
        mg.setUpTableData();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String s = (String)JOptionPane.showInputDialog(
            mg,
            "Enter file name: (*.ser)",
            "Input",
            JOptionPane.PLAIN_MESSAGE,
            null,
            null,
            "output.ser");
        if(s==null)
        return;
        if(!s.endsWith(".ser")){
            JOptionPane.showMessageDialog(mg, "File name should end with .ser");
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
            int q = JOptionPane.showConfirmDialog(mg, s + " already exists:\nAre you sure you want to overwrite?");
            if(q!=0)
            return;
        }
        try {
            SerializationUtil.serialize(a, s);
        } catch (IOException e) {
            return;
        }
        JOptionPane.showMessageDialog(mg, s + " saved successfully");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    public boolean MobileNoChecker(String str){
        int x;
        if(str.isEmpty() || str.length() < 6 || str.length() > 15)
            return false;
        for(int j = 0 ; j < str.length() ; j++)
        {
            x = (int)str.charAt(j);
            if( x < 48 || x > 57 )
            return false;    
        }
        return true;
    }
    
    public boolean validDate(String Date){
        String pattern = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(Date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(!m.find()){
            JOptionPane.showMessageDialog(mg, "Enter a valid date");
            return false;
        }
        else
            return true;
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dflag = true;
        String Name = name.getText();
        if(Name.isEmpty()){
            JOptionPane.showMessageDialog(mg, "Enter a name");
            return;
        }
        String Mobile = mobile.getText();
        if(!MobileNoChecker(Mobile)){
            JOptionPane.showMessageDialog(mg, "Enter a valid mobile number (6-15 digits)");
            return;
        }
        String Email = email.getText();
        if(!Email.contains("@")){
            JOptionPane.showMessageDialog(mg, "Enter a valid email");
            return;
        }
        String One,Two,Three;
        switch(x){
            case 0: //perF
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if(!validDate(Three)){
                    return;
                }
                if(Three.isEmpty() || Three.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
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
                    //this.a.get(x).add(perF);
                break;
            case 1: //rel
                One = one.getText();
                if(One.isEmpty() || One.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if(!validDate(One)){
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if(!validDate(Two)){
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
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
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
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if(Two.isEmpty() || Two.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if(Three.isEmpty() || Three.length() > 300){
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
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
        mg.setUpTableData();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MUI().setVisible(true);
            }
        });
    }

    //Command DP

    public JLabel getJLabel1() {
        return jLabel1;
    }

    public JLabel getJLabel2() {
        return jLabel2;
    }

    public JLabel getJLabel3() {
        return jLabel3;
    }

    public JLabel getJLabel4() {
        return jLabel4;
    }

    public JLabel getJLabel5() {
        return jLabel5;
    }

    public JLabel getJLabel6() {
        return jLabel6;
    }

    public JLabel getJLabel7() {
        return jLabel7;
    }

    public JLabel getJLabel8() {
        return jLabel8;
    }

    public JLabel getJLabel9() {
        return jLabel9;
    }

    public JList getJList1() {
        return jList1;
    }

    public JPanel getPanel1() {
        return jPanel1;
    }

    public JPanel getPanel2() {
        return jPanel2;
    }

    public JPanel getPanel3() {
        return jPanel3;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setDFlag(boolean dflag) {
        this.dflag = dflag;
    }

    public void setX (int x) {
        this.x = x;
    }

    public static MUI getInstance() {
        return mg;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextPane details;
    private JTextField email;
    private JButton jButton1;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JList jList1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JXTable jXTable1;
    private JTextField mobile;
    private JTextField name;
    private JTextArea one;
    private JTextArea three;
    private JTextArea two;
    // End of variables declaration//GEN-END:variables
}
