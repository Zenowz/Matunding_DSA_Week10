import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class LNodeMenu extends JFrame implements ActionListener, ItemListener, KeyListener{
    private JLabel lblChoose, lblValue, lblPosition;
    private JTextField txtValue, txtPosition;
    private JComboBox cboChoose;
    private JTextArea txtAreaUp, txtAreaDown;
    private JButton btnProcess, btnClose;
    private LNodeObject myNode; 
    String hold="";

    public LNodeMenu() {
        myNode = new LNodeObject();
        lblChoose = new JLabel(" Choose");
        
        String menu[] = {"Add At First","Add At Position","Add At Last",
                         "Delete At First", "Delete At Position", "Delete At Last",
                         "Get First", "Get At Position", "IndexAt", "Get Last", 
                         "AddInMiddle", "deleteInMiddle"};

        cboChoose = new JComboBox(menu); 
        txtAreaUp = new JTextArea();
        txtAreaDown = new JTextArea();
        btnProcess = new JButton("Process");
        btnClose = new JButton("Close");
        lblValue = new JLabel("Value");
        lblPosition = new JLabel("Position");
        txtValue = new JTextField();
        txtPosition = new JTextField();
        txtPosition.setEditable(false);

        setTitle("LinkedList Application");
        setSize(400, 300);
        
        setLayout(null); 
        
        getContentPane().setBackground(new Color(100,50,90,80));
        txtAreaUp.setEditable(false);
        txtAreaDown.setEditable(false);

        hold = "Empty: " + myNode.isEmpty() + "\tCurrent Size:" + myNode.currentSize();
        txtAreaUp.setText(hold);

        txtAreaUp.setBounds(20,20,330,20);
        add(txtAreaUp);

        JScrollPane scrollPane = new JScrollPane(txtAreaDown);
        scrollPane.setBounds(20,40,330,100);
        add(scrollPane);
        
        lblChoose.setBounds(20,140,70,20);
        add(lblChoose);
        
        cboChoose.setBounds(100,140,150,20);
        add(cboChoose);
        
        lblValue.setBounds(20,170,60,20); 
        add(lblValue);
        
        lblPosition.setBounds(20,200,60,20);
        add(lblPosition);

        txtValue.setBounds(80,170,170,20);
        add(txtValue);
        
        txtPosition.setBounds(80,200,170,20);
        add(txtPosition);
        
        btnProcess.setBounds(260, 170, 90, 20);
        add(btnProcess);
        
        btnClose.setBounds(260, 200, 90, 20);
        add(btnClose);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnProcess.addActionListener(this);
        btnClose.addActionListener(this);
        cboChoose.addItemListener(this);
        txtPosition.addKeyListener(this);
        txtValue.addKeyListener(this);
        btnProcess.setEnabled(false);
    }

    public static void main(String[] args) {
        new LNodeMenu();
    } 

    public void itemStateChanged(ItemEvent e) {
        int ind=cboChoose.getSelectedIndex();

        if(ind==0){
            disable(1);
        } else if(ind==1){
            enable();
        } else if(ind==2){
            disable(1);
        } else if(ind==3){
            disableAll();
            btnProcess.setEnabled(true);
        } else if(ind==4){
            disableAll();
            btnProcess.setEnabled(true);
            txtPosition.setEditable(true);
        } else if(ind==5){
            disableAll();
            btnProcess.setEnabled(true);
        } else if(ind==6){
            disableAll();
            btnProcess.setEnabled(true);
        } else if(ind==7){
            disableAll();
            btnProcess.setEnabled(true);
            txtPosition.setEditable(true);
        } else if(ind==8){
            disableAll();
            btnProcess.setEnabled(true);
            txtValue.setEditable(true);
        } else if(ind==9){
            disableAll();
            btnProcess.setEnabled(true);
        } else if(ind==10){
            enable();
        } else if(ind==11){
            disableAll();
            btnProcess.setEnabled(true);
        }
    } 

    public void keyPressed(KeyEvent arg0) {
    }

    public void keyReleased(KeyEvent e) {
        if(e.getSource().equals(txtValue)){
            if(txtValue.getText().isEmpty()){
                btnProcess.setEnabled(false);
            } else {
                btnProcess.setEnabled(true);
            }
        } else if(e.getSource().equals(txtPosition)){
            if(txtPosition.getText().isEmpty()){
                btnProcess.setEnabled(false);
            } else {
                btnProcess.setEnabled(true);
            }
        }
    }

    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(txtPosition)){
            if(!(Character.isDigit(e.getKeyChar()))){
                e.consume(); 
            }
        } else if(e.getSource().equals(txtValue)){
            if(!(Character.isAlphabetic(e.getKeyChar()))){
                e.consume(); 
            }
        }
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            System.exit(0);
            return;
        }

        int pos;
        int ind=cboChoose.getSelectedIndex();
        String item=cboChoose.getSelectedItem().toString();

        if(ind==0){
            myNode.addAtFirst(txtValue.getText());
        } else if(ind==1){
            pos=Integer.parseInt(txtPosition.getText());
            myNode.addAtPosition(txtValue.getText(), pos);
        } else if(ind==2){
            myNode.addAtLast(txtValue.getText());
        } else if(ind==3){
            myNode.deleteAtFirst();
        } else if(ind==4){
            pos=Integer.parseInt(txtPosition.getText());
            myNode.deleteAtPosition(pos);
        } else if(ind==5){
            myNode.deleteAtLast();
        } else if(ind==6){
            JOptionPane.showMessageDialog(null, myNode.getFirst());
        } else if(ind==7){
            pos=Integer.parseInt(txtPosition.getText());
            JOptionPane.showMessageDialog(null, myNode.get(pos));
        } else if(ind==8){
            JOptionPane.showMessageDialog(null, myNode.indexOf(txtValue.getText()));
        } else if(ind==9){
            JOptionPane.showMessageDialog(null, myNode.getLast());
        } else if(ind==10){
            myNode.addInMiddle(txtValue.getText()); 
        } else if(ind==11){
            myNode.deleteInMiddle();
        } 
        
        txtAreaDown.setText(myNode.traverse());
        txtPosition.setText("");
        txtValue.setText("");
        hold="Empty: " + myNode.isEmpty() + "\tCurrent Size:" + myNode.currentSize();
        txtAreaUp.setText(hold);
        btnProcess.setEnabled(false);
    } 

    public void enable() {
        txtValue.setEditable(true);
        txtPosition.setEditable(true);
    } 

    public void disable(int choice) {
        txtValue.setEditable(true);
        txtPosition.setEditable(false);
        btnProcess.setEnabled(false);
    } 

    public void disableAll() {
        txtValue.setEditable(false);
        txtPosition.setEditable(false);
        btnProcess.setEnabled(false);
    } 
}
