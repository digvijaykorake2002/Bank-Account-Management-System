package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton hundread,fiveHun,thousand,twothousand,fivethousand,tenthousand,back;
    String pin;
    FastCash(String pin){
        
        this.pin=pin;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        hundread= new JButton("Rs 100");
        hundread.setBounds(170,415,150,30);
        hundread.addActionListener(this);
        image.add(hundread);
        
        fiveHun= new JButton("Rs 500");
        fiveHun.setBounds(355,415,150,30);
        fiveHun.addActionListener(this);
        image.add(fiveHun);
        
        thousand= new JButton("Rs 1000");
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twothousand= new JButton("Rs 2000");
        twothousand.setBounds(355,450,150,30);
        twothousand.addActionListener(this);
        image.add(twothousand);
        
        fivethousand= new JButton("Rs 5000");
        fivethousand.setBounds(170,485,150,30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        tenthousand= new JButton("Rs 10000");
        tenthousand.setBounds(355,485,150,30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        back= new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }else {
            String amount= ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn ();
            try {
                
                ResultSet rs= conn.s.executeQuery("select * from bank where pin ='"+pin+"' ");
                   
                
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date= new Date();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount + " Debited Succesfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
        }
        
    }
    
    public static void main(String[] args) {
        
        new FastCash("");
    }
    
}



        
        