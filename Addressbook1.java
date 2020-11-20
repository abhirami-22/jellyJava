import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
class Addressbook1 implements ActionListener
{

JFrame f;
JLabel lmain,lname,ladd,lcity,lstate,lzip,lph,lemail;
JTextArea tName,tAdd,tCity,tState,tZip,tPh,tEmail;
JButton ent,exit,prev,next,first,last;
int n=0;

    public void registrationform()
    {
        		f=new JFrame("Address Book");
		
		f.setLayout(null);
        
       		lmain=new JLabel("Address Book");
		lmain.setFont(new Font("Arial Black", Font.PLAIN, 20)); 
		lmain.setSize(300,30);
		lmain.setLocation(370,70);
		f.add(lmain);	
	
		lname=new JLabel("Name ");
		lname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		lname.setSize(300,30);
		lname.setLocation(200,200);
		f.add(lname);
		
		tName= new JTextArea();
		tName.setSize(300,30);
		tName.setLocation(280,200);
		f.add(tName); 

		ladd=new JLabel("Address ");
		ladd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		ladd.setSize(300,30);
		ladd.setLocation(200,250);
		f.add(ladd);
				
		tAdd= new JTextArea();
		tAdd.setSize(300,30);
		tAdd.setLocation(280,250);
		f.add(tAdd); 

	    	lcity=new JLabel("City ");
		lcity.setFont(new Font("Arial", Font.PLAIN, 15));
		lcity.setSize(300,30);
		lcity.setLocation(200,300);
		f.add(lcity);
		
		tCity=new JTextArea();
		tCity.setSize(300,30);
		tCity.setLocation(280,300);
		f.add(tCity); 

		lstate=new JLabel("State");
		lstate.setFont(new Font("Arial", Font.PLAIN, 15));
		lstate.setSize(300,30);
		lstate.setLocation(200,350);
		f.add(lstate);
				
		tState=new JTextArea();
		tState.setSize(300,30);
		tState.setLocation(280,350);
		f.add(tState); 

		lzip=new JLabel("Zip Code");
		lzip.setFont(new Font("Arial", Font.PLAIN, 15));
		lzip.setSize(300,30);
		lzip.setLocation(200,400);
		f.add(lzip);
				
		tZip=new JTextArea();
		tZip.setSize(300,30);
		tZip.setLocation(280,400);
		f.add(tZip); 

		lph=new JLabel("Phone ");
		lph.setFont(new Font("Arial", Font.PLAIN, 15));
		lph.setSize(300,30);
		lph.setLocation(200,450);
		f.add(lph);
				
		tPh=new JTextArea();
		tPh.setSize(300,30);
		tPh.setLocation(280,450);
		f.add(tPh); 

		lemail=new JLabel("Email ");
		lemail.setFont(new Font("Arial", Font.PLAIN, 15));
		lemail.setSize(300,30);
		lemail.setLocation(200,500);
		f.add(lemail);
				
		tEmail=new JTextArea();
		tEmail.setSize(300,30);
		tEmail.setLocation(280,500);
		f.add(tEmail); 

        ent=new JButton("Enter Record");
        	ent.setSize(120, 20); 
        	ent.setLocation(300, 570);
            ent.addActionListener(this); 
            f.add(ent);
        	
        	 	

		 exit = new JButton("Exit");
        	exit.setSize(100, 20); 
        	exit.setLocation(450, 570); 
        	exit.addActionListener(this); 
        	f.add(exit);
            
           /* exit.addActionListener(e -> {
            f.dispose();
            });*/

		 first = new JButton("First");
        	first.setSize(120, 20); 
        	first.setLocation(300, 620); 
        	first.addActionListener(this); 
        	f.add(first);

		last = new JButton("Last");
        	last.setSize(100, 20); 
        	last.setLocation(450, 620); 
        	last.addActionListener(this); 
        	f.add(last);

		next = new JButton("Next");
        	next.setSize(120, 20); 
        	next.setLocation(300,670); 
        	next.addActionListener(this); 
           //next.setEnabled(false);
        	f.add(next);

		prev = new JButton("Previous"); 
        	prev.setSize(100, 20); 
        	prev.setLocation(450, 670); 
        	prev.addActionListener(this); 
           // prev.setEnabled(false);
        	f.add(prev);				

		f.setVisible(true);
		f.setSize(900,900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
	

	
    
	public void actionPerformed(ActionEvent e) 
	{
        //int pos=0;
      
      //Enter record button 
        if(e.getSource()==ent)   
        {
            try {
               
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
		System.out.println("Connected..");
		/*PreparedStatement ps=con.prepareStatement("create table addressbook(Name varchar(20),Address varchar(70),City varchar(30),state varchar(30), ZipCode int, PhoneNo varchar(10), Email varchar(70))");
		ps.executeUpdate();*/

		PreparedStatement ps1=con.prepareStatement("insert into addressbook values(?,?,?,?,?,?,?)");

                ps1.setString(1,tName.getText());
                ps1.setString(2,tAdd.getText());
                ps1.setString(3,tCity.getText());
                ps1.setString(4,tState.getText());
                ps1.setString(5,tZip.getText());
                ps1.setString(6,tPh.getText());
                ps1.setString(7,tEmail.getText());
               
                ps1.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                
                 
               tName.setText("");
               tAdd.setText("");
               tCity.setText("");
               tState.setText("");
               tZip.setText("");
               tPh.setText("");
               tEmail.setText("");               
                
                con.close();        
                }
       
	    catch(SQLException e1)
	    {
         JOptionPane.showMessageDialog(null,"Please enter appropriate values.");
	    }
        catch(Exception e2)
        {
         System.out.println("Error is: "+e2);
        }
	 }
     
     //Exit button
     if(e.getSource()==exit)
     {
        System.exit(0);
     }
     
     //First button
     if(e.getSource()==first)
     {
       n=1;
        try {
               
        Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
        PreparedStatement ps2=con.prepareStatement("select * from addressbook");
        ResultSet rs1=ps2.executeQuery();
        while(rs1.next())
        {
         if (rs1.isFirst())
         {
               tName.setText(rs1.getString(1));
               tAdd.setText(rs1.getString(2));
               tCity.setText(rs1.getString(3));
               tState.setText(rs1.getString(4));
               tZip.setText(""+rs1.getInt(5));
               tPh.setText(rs1.getString(6));
               tEmail.setText(rs1.getString(7));
         }
        } 
   
        con.close();
        }
        catch(Exception e3)
        {
         System.out.println("Error is: "+e3);
        }
     }
     
     //Last button
     if(e.getSource()==last)
     {
        try {
               
        Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
        PreparedStatement ps2=con.prepareStatement("select * from addressbook");
        ResultSet rs1=ps2.executeQuery();
        while(rs1.next())
        {
         if (rs1.isLast())
         {
               tName.setText(rs1.getString(1));
               tAdd.setText(rs1.getString(2));
               tCity.setText(rs1.getString(3));
               tState.setText(rs1.getString(4));
               tZip.setText(""+rs1.getInt(5));
               tPh.setText(rs1.getString(6));
               tEmail.setText(rs1.getString(7));
         }
        } 
         n=rs1.getRow();
	     con.close();
        }
        catch(Exception e4)
        {
         System.out.println("Error is: "+e4);
        }
        
     }
     
     //Next button
     if(e.getSource()==next)
     {
     
       try
       {
                
        Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
        ResultSet rs2=stmt.executeQuery("select * from addressbook"); 
        if (n==0)
        JOptionPane.showMessageDialog(null, "Starting from first record");
        
        n=n+1;
        rs2.absolute(n);
               tName.setText(rs2.getString(1));
               tAdd.setText(rs2.getString(2));
               tCity.setText(rs2.getString(3));
               tState.setText(rs2.getString(4));
               tZip.setText(""+rs2.getInt(5));
               tPh.setText(rs2.getString(6));
               tEmail.setText(rs2.getString(7));
       if(rs2.isLast())
         n=0;
        con.close();
       }
       catch(Exception er2)
       {
         System.out.println("Error :"+e);
       }
    }
    
    if(e.getSource()==prev)
     {
     
       try
       {
                
        Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
        Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
        ResultSet rs2=stmt.executeQuery("select * from addressbook"); 
        
        if (n==1)
        {
         JOptionPane.showMessageDialog(null, "Starting from last record");
         rs2.last();
         n=rs2.getRow();
        }
        
        n=n-1;
        rs2.absolute(n);
               tName.setText(rs2.getString(1));
               tAdd.setText(rs2.getString(2));
               tCity.setText(rs2.getString(3));
               tState.setText(rs2.getString(4));
               tZip.setText(""+rs2.getInt(5));
               tPh.setText(rs2.getString(6));
               tEmail.setText(rs2.getString(7));
    
        con.close();
       }
       catch(Exception er2)
       {
         System.out.println("Error :"+e);
       }
    }
    
    
    
   
    
}
                       
    public static void main(String arg[])
	{
        Addressbook1 obj=new Addressbook1();
	    obj.registrationform();
		
	}
    
}

