package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String pin;
    
    Withdrawal(String pin){
        
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter The Amount You Want To withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(180,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setBounds(180,350,320,20);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw  ){
            
            String number= amount.getText();
            Date date= new Date();
            if(amount.equals("")){
                
                JOptionPane.showMessageDialog(null, "Please Enter the Amount You Want To Withdraw");
            }else{
                try {
                    
                Conn conn = new Conn();
                String query="insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ number +" Withdraw Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                
            }
                    
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        
    }
    }
    
    public static void main(String[] args) {
        
        new Withdrawal("");
    }
    
}
