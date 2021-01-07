/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import contactmanagementsoftware.Interpreter.Expression;
import contactmanagementsoftware.Interpreter.Parser;
import contactmanagementsoftware.command.*;

import contactmanagementsoftware.strategy.pattern.*;
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
    public ArrayList<ArrayList<Acquaintances>> a;
    private boolean isAddContact;
    private boolean isDisplayOnly;
    public String op;
    private String str;
    private Command addCommand;
    private Command deleteCommand;
    private Command searchCommand;
    private Command exitCommand;
    private Command editCommand;
    private Command vfdCommand;
    private Command addContactCommand;
    private Command cancelCommand;
    private Command backToMainMenuCommand;
    private Command readFromFileCommand;
    private Command saveCommand;
    private ContactReceiver contactReceiver;
    private NavigateReceiver navigateReceiver;
    private Invoker invoker;
    private UISetter contactDetailsPanelSetter;
    
    public void setMg(MUI mg) {
        this.mg = mg;
    }
    
    //return Acquaintance list
    public ArrayList<ArrayList<Acquaintances>> getAllAcquantanceList(){
        return a;
    }
    
    //return Acquaintance that is being selected
    public Acquaintances getCurrentAcquaintance(){
        if(getSelectedContactTypeIndex() >= 0 && getSelectedContactIndex() >= 0){
            return a.get(getSelectedContactTypeIndex()).get(getSelectedContactIndex());
        }
        return null;
    }
    
    //the index of category of the Acquaintances
    public int getSelectedContactTypeIndex(){
        return jList1.getSelectedIndex();
    }
    
    //the index of selected row in display table
    public int getSelectedContactIndex(){
        return jXTable1.getSelectedRow();
    }

    public boolean getIsAddContact() {
        return isAddContact;
    }

    public void setIsAddContact(boolean addContact) {
        this.isAddContact = addContact;
    }

    public boolean getIsDisplayOnly() {
        return isDisplayOnly;
    }

    public void setIsDisplayOnly(boolean displayOnly) {
        this.isDisplayOnly = displayOnly;
    }
    
    public void contactDetailsPanelSetterSetUI(){
        contactDetailsPanelSetter.setUI();
    }
    
    public void setOp(String op) {
        this.op = op;
    }
    
    public String getOp() {
        return op;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    
    public void setA(ArrayList<ArrayList<Acquaintances>> a) {
        this.a = a;
    }
    
    public MUI() {
        initComponents();
        String[] columnNames = {"S.No", "Name", "Mobile"," Email"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        jXTable1.setModel(model);
        setUpTableData();
        invoker = new Invoker();
    }

    public void loadCommands(){
        contactReceiver = new ContactReceiver();
        navigateReceiver = new NavigateReceiver();

        addContactCommand = new AddContactCommand(contactReceiver);
        deleteCommand = new DeleteCommand(contactReceiver);
        searchCommand = new SearchCommand(contactReceiver);
        readFromFileCommand = new ReadFromFileCommand(contactReceiver);
        saveCommand = new SaveCommand(contactReceiver);
        addCommand = new AddCommand(navigateReceiver);
        editCommand = new EditCommand(navigateReceiver);
        vfdCommand = new VFDCommand(navigateReceiver);
        backToMainMenuCommand = new BackToMainMenuCommand(navigateReceiver);
        cancelCommand = new CancelCommand(navigateReceiver);
        exitCommand = new ExitCommand(navigateReceiver);

        invoker.setCommand("add",addCommand);
        invoker.setCommand("delete",deleteCommand);
        invoker.setCommand("search", searchCommand);
        invoker.setCommand("exit", exitCommand);
        invoker.setCommand("edit", editCommand);
        invoker.setCommand("vfd", vfdCommand);
        invoker.setCommand("addContact", addContactCommand);
        invoker.setCommand("cancel", cancelCommand);
        invoker.setCommand("backToMainMenu", backToMainMenuCommand);
        invoker.setCommand("readFromFile", readFromFileCommand);
        invoker.setCommand("save", saveCommand);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mainMenuPageAddButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        viewFullDetailButton = new javax.swing.JButton();
        readFromFileButton = new javax.swing.JButton();
        saveAsFileButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextPane();
        backToMainMenuButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaTwo = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaThree = new javax.swing.JTextArea();
        addContactPageAddButton = new javax.swing.JButton();
        mobileTextField = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        textAreaOne = new javax.swing.JTextArea();
        addContactPageCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu Medium", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><u>Contact Management System</u></html>");

        mainMenuPageAddButton.setText("Add");
        mainMenuPageAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuPageAddButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
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

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        viewFullDetailButton.setText("View full detail");
        viewFullDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFullDetailButtonActionPerformed(evt);
            }
        });

        readFromFileButton.setText("Read from file");
        readFromFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readFromFileButtonActionPerformed(evt);
            }
        });

        saveAsFileButton.setText("Save as file");
        saveAsFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsFileButtonActionPerformed(evt);
            }
        });

        undoButton.setText("Undo");
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(viewFullDetailButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(readFromFileButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(mainMenuPageAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(saveAsFileButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(undoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, editButton, exitButton, mainMenuPageAddButton, readFromFileButton, saveAsFileButton, searchButton, viewFullDetailButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(mainMenuPageAddButton)
                    .addComponent(editButton)
                    .addComponent(searchButton)
                    .addComponent(undoButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewFullDetailButton)
                    .addComponent(readFromFileButton)
                    .addComponent(saveAsFileButton)
                    .addComponent(exitButton))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        details.setEditable(false);
        jScrollPane3.setViewportView(details);

        backToMainMenuButton.setText("Back to main menu");
        backToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(backToMainMenuButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backToMainMenuButton)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel2, "card3");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Casual Acquaintance Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); // NOI18N

        jLabel4.setText("Name:");

        jLabel5.setText("Mobile No:");

        jLabel6.setText("Email:");

        jLabel7.setText("First meeting time & location:");

        jLabel8.setText("First meeting CIrcumstances:");

        jLabel9.setText("Other useful information:");

        textAreaTwo.setColumns(20);
        textAreaTwo.setRows(5);
        textAreaTwo.setAutoscrolls(false);
        jScrollPane4.setViewportView(textAreaTwo);

        textAreaThree.setColumns(20);
        textAreaThree.setRows(5);
        jScrollPane5.setViewportView(textAreaThree);

        addContactPageAddButton.setText("Add");
        addContactPageAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactPageAddButtonActionPerformed(evt);
            }
        });

        textAreaOne.setColumns(20);
        textAreaOne.setRows(5);
        jScrollPane6.setViewportView(textAreaOne);

        addContactPageCancelButton.setText("Cancel");
        addContactPageCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactPageCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addContactPageAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addContactPageCancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addGap(132, 132, 132)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(mobileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addContactPageAddButton)
                    .addComponent(addContactPageCancelButton))
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPanel3, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        setUpTableData();
        
        /**
         * Assign UI setter
         * - Personal
         * - Relatives
         * - Professional
         * - Casual
         */ 
        switch(jList1.getSelectedIndex()){
            case 0:
                contactDetailsPanelSetter = new PersonalFriendsUISetter(this);
                break;
            case 1:
                contactDetailsPanelSetter = new RelativesUISetter(this);
                break;
            case 2:
                contactDetailsPanelSetter = new ProfessionalFriendsUISetter(this);
                break;
            case 3:
                contactDetailsPanelSetter = new CasualAcquaintancesUISetter(this);
                break;
            default:
                break;
            
        }
    }//GEN-LAST:event_jList1ValueChanged

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
        
    private void mainMenuPageAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuPageAddButtonActionPerformed
        invoker.execute("add" ,evt);
    }//GEN-LAST:event_mainMenuPageAddButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        invoker.execute("delete", evt);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        invoker.execute("edit", evt);
    }//GEN-LAST:event_editButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        invoker.execute("search", evt);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        invoker.undo(evt);
    }//GEN-LAST:event_undoButtonActionPerformed

    private void viewFullDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewFullDetailButtonActionPerformed
        invoker.execute("vfd", evt);
    }//GEN-LAST:event_viewFullDetailButtonActionPerformed

    private void readFromFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readFromFileButtonActionPerformed
        invoker.execute("readFromFile", evt);
    }//GEN-LAST:event_readFromFileButtonActionPerformed

    private void saveAsFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsFileButtonActionPerformed
        invoker.execute("save", evt);
    }//GEN-LAST:event_saveAsFileButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        invoker.execute("exit", evt);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void backToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainMenuButtonActionPerformed
        invoker.execute("backToMainMenu", evt);
    }//GEN-LAST:event_backToMainMenuButtonActionPerformed

    private void addContactPageAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContactPageAddButtonActionPerformed
        invoker.execute("addContact", evt);
    }//GEN-LAST:event_addContactPageAddButtonActionPerformed

    private void addContactPageCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContactPageCancelButtonActionPerformed
        invoker.execute("cancel", evt);
    }//GEN-LAST:event_addContactPageCancelButtonActionPerformed

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

    //UI component getter and setter will be here
    public static MUI getInstance() {
        return mg;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public JTextField getMobileTextField() {
        return mobileTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }
    
    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JTextArea getTextAreaOne() {
        return textAreaOne;
    }

    public JTextArea getTextAreaThree() {
        return textAreaThree;
    }

    public JTextArea getTextAreaTwo() {
        return textAreaTwo;
    }

    public JButton getjButton10() {
        return addContactPageAddButton;
    }

    public JButton getjButton11() {
        return addContactPageCancelButton;
    }

    public JTextPane getDetails() {
        return details;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addContactPageAddButton;
    private javax.swing.JButton addContactPageCancelButton;
    private javax.swing.JButton backToMainMenuButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextPane details;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JButton mainMenuPageAddButton;
    private javax.swing.JTextField mobileTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton readFromFileButton;
    private javax.swing.JButton saveAsFileButton;
    private javax.swing.JButton searchButton;
    public javax.swing.JTextArea textAreaOne;
    public javax.swing.JTextArea textAreaThree;
    public javax.swing.JTextArea textAreaTwo;
    private javax.swing.JButton undoButton;
    private javax.swing.JButton viewFullDetailButton;
    // End of variables declaration//GEN-END:variables
}
