package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton eyes, eno, syes, sno;
    JComboBox category1, religion1,income1, education, occupation1; 
    String formno;
    
    SignupTwo(String formno){
       
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICAION FORM- PAGE 2");
        
        JLabel additionaldetails= new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel religion= new JLabel("Religion: ");
        religion.setFont(new Font("raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valreligion[]={"Hindu", "Muslim", "Sikh", "Christian","Other"};
        religion1=new JComboBox(valreligion);
        religion1.setBounds(300,140,400,30);
        religion1.setBackground(Color.WHITE);
        add(religion1);
        
        JLabel category= new JLabel("Category: ");
        category.setFont(new Font("raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valcategory[]={"General","OBC","SC","ST","Other"};
        category1=new JComboBox(valcategory);
        category1.setBounds(300,190,400,30);
        category1.setBackground(Color.WHITE);
        add(category1);
        
        JLabel income= new JLabel("Income: ");
        income.setFont(new Font("raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String incomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000 "};
        income1=new JComboBox(incomecategory);
        income1.setBounds(300,240,400,30);
        income1.setBackground(Color.WHITE);
        add(income1);
        
        JLabel educational= new JLabel("Educational");
        educational.setFont(new Font("raleway",Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);
        
        JLabel qualifi= new JLabel("Qualification: ");
        qualifi.setFont(new Font("raleway",Font.BOLD,20));
        qualifi.setBounds(100,315,200,30);
        add(qualifi);
        
        String educationalvalues[]={"Non Graduation","Graduate","Post Graduation","Doctrate","Others"};
        education=new JComboBox(educationalvalues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occupation= new JLabel("Occupation: ");
        occupation.setFont(new Font("raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String OccupationValues[]={"Salaried","Self Employed","Business","Student","Retired","Others"};
        occupation1=new JComboBox(OccupationValues);
        occupation1.setBounds(300,390,400,30);
        occupation1.setBackground(Color.WHITE);
        add(occupation1);
        
        JLabel pan= new JLabel("PAN Number: ");
        pan.setFont(new Font("raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel aadhar= new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel seniorcitizen= new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new Font("raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup citizenship=new ButtonGroup();
        citizenship.add(syes);
        citizenship.add(sno);
        
        
        JLabel existinga= new JLabel("Existing Account: ");
        existinga.setFont(new Font("raleway",Font.BOLD,20));
        existinga.setBounds(100,590,200,30);
        add(existinga);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existAc=new ButtonGroup();
        existAc.add(syes);
        existAc.add(sno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        
        String sreligion=(String)religion1.getSelectedItem();
        String scategory=(String)category1.getSelectedItem();
        String sincome=(String)income1.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation1.getSelectedItem();
        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();
        
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if (sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existinga=null;
        if(eyes.isSelected()){
            existinga="Yes";
        }else if(eno.isSelected()){
            existinga="No";
        }
        
        try {
                
                Conn c= new Conn();
                String query= "insert into signuptwo values( '"+formno+"','"+sreligion+"','"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existinga+"')";
                c.s.executeUpdate(query);
            
                //Signup 3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new SignupTwo("");
    }
    
}

