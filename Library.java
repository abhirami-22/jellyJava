import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
class Library implements ActionListener
{
	JFrame f;
	JLabel l1,l2,l3,l4,l5;
	JTextArea t1,t2,t3;
	JButton insertbtn, updatebtn, deletebtn, readbtn,savebtn;
	String upid;
	public void bookdetails()
	{
		f=new JFrame("CRUD Operations");
		
		f.setLayout(null);
        
       		l1=new JLabel("BOOK DETAILS");
		l1.setFont(new Font("Arial Black", Font.PLAIN, 20)); 
		l1.setSize(300,30);
		l1.setLocation(370,70);
		f.add(l1);	
	
		l2=new JLabel("Book ID");
		l2.setFont(new Font("Arial", Font.PLAIN, 15)); 
		l2.setSize(300,30);
		l2.setLocation(200,200);
		f.add(l2);
		
		t1= new JTextArea();
		t1.setSize(300,30);
		t1.setLocation(280,200);
		f.add(t1); 

		l3=new JLabel("Book Title");
		l3.setFont(new Font("Arial", Font.PLAIN, 15)); 
		l3.setSize(300,30);
		l3.setLocation(200,250);
		f.add(l3);
				
		t2= new JTextArea();
		t2.setSize(300,30);
		t2.setLocation(280,250);
		f.add(t2); 

	    	l4=new JLabel("Author");
		l4.setFont(new Font("Arial", Font.PLAIN, 15));
		l4.setSize(300,30);
		l4.setLocation(200,300);
		f.add(l4);
	
		
		t3=new JTextArea();
		t3.setSize(300,30);
		t3.setLocation(280,300);
		f.add(t3); 

		l4=new JLabel("NOTE: Press save button after Update");
		l4.setFont(new Font("Arial", Font.PLAIN, 15));
		l4.setSize(300,30);
		l4.setLocation(200,370);
		f.add(l4);

		insertbtn=new JButton("Insert");
        		insertbtn.setSize(120, 20); 
        		insertbtn.setLocation(300, 570);
           	 	insertbtn.addActionListener(this); 
            		f.add(insertbtn);
        	
        	 	

		readbtn = new JButton("Read");
        		readbtn.setSize(100, 20); 
        		readbtn.setLocation(450, 570); 
        		readbtn.addActionListener(this); 
        		f.add(readbtn);
            
        
		updatebtn = new JButton("Update");
        		updatebtn.setSize(120, 20); 
        		updatebtn.setLocation(300, 620); 
        		updatebtn.addActionListener(this); 
        		f.add(updatebtn);

		deletebtn = new JButton("Delete");
        		deletebtn.setSize(100, 20); 
        		deletebtn.setLocation(450, 620); 
        		deletebtn.addActionListener(this); 
        		f.add(deletebtn);

		savebtn = new JButton("Save");
        		savebtn.setSize(240, 20); 
        		savebtn.setLocation(300, 680); 
        		savebtn.addActionListener(this); 
        		f.add(savebtn);

		f.setVisible(true);
		f.setSize(900,900);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
	}

	public void actionPerformed(ActionEvent e) 
	{
       	
      
      	//INSERT
       	if(e.getSource()==insertbtn)   
        	{
            	try {
               
        		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
		System.out.println("Connected..");

		PreparedStatement ps1=con.prepareStatement("insert into bookdetails values(?,?,?)");

                ps1.setString(1,t1.getText());
                ps1.setString(2,t2.getText());
                ps1.setString(3,t3.getText());
              
                ps1.executeUpdate();

	
                JOptionPane.showMessageDialog(null,"Data Inserted Successfully!");
                
                 
               t1.setText("");
               t2.setText("");
               t3.setText("");
             
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
	
	//READ
	if(e.getSource()==readbtn)
     	{

        	try {
               
        	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
		
	    String id=JOptionPane.showInputDialog(f,"Enter book ID to show details ");   
	    
        	    PreparedStatement ps2=con.prepareStatement("select * from bookdetails where bookid="+id);
        	    ResultSet rs1=ps2.executeQuery();
        	    if(rs1.next())
        	    {
         		
               		t1.setText(rs1.getString(1));
               		t2.setText(rs1.getString(2));
               		t3.setText(rs1.getString(3));
               		
         	   }
	  else
	  {
		JOptionPane.showMessageDialog(null,"Invalid book id !");
	  }
        
   
                con.close();
               }
        catch(Exception e3)
        {
         System.out.println("Error is: "+e3);
        }
     }
	
	//UPDATE
	if(e.getSource()==updatebtn)
     	{

        	try {
               
        	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
		
	    upid=JOptionPane.showInputDialog(f,"Enter book ID to update ");   
	  
        	    PreparedStatement ps2=con.prepareStatement("select * from bookdetails where bookid="+upid);
        	    ResultSet rs1=ps2.executeQuery();
        	    if(rs1.next())
        	    {
         		
               		t1.setText(rs1.getString(1));
               		t2.setText(rs1.getString(2));
               		t3.setText(rs1.getString(3));
               		
         	  }
                  else
	  {
		JOptionPane.showMessageDialog(null,"Invalid book id !");
	  }
 	   con.close();
               }  
        catch(Exception e3)
        {
         System.out.println("Error is: "+e3);
        }
     }
	//SAVE
	if(e.getSource()==savebtn)
     	{

        	try {
               
        	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
	    String bid=t1.getText();
	    String bt=t2.getText();
	    String ba=t3.getText();
	  
        	   PreparedStatement ps3=con.prepareStatement("update bookdetails set bookid='"+bid+"',title='"+ bt +"',author='"+ba+"' where bookid='"+upid+"';");
	   ps3.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Data Updated Successfully!");
   
                con.close();
	 }  
        catch(Exception e3)
        {
         System.out.println("Error is: "+e3);
        }
     }

	//DELETE
	if(e.getSource()==deletebtn)
     	{

        	try {
               
        	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytesta","root","root123");
	    System.out.println("Connected..");
		
	    String id=JOptionPane.showInputDialog(f,"Enter book ID to delete ");   
	  
        	    PreparedStatement ps2=con.prepareStatement("delete from bookdetails where bookid="+id);
        	     ps2.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully!");
 	   con.close();
               }  
        catch(Exception e3)
        {
         System.out.println("Error is: "+e3);
        }
     }

 }
  public static void main(String arg[])
	{
       Library obj=new Library();
	    obj.bookdetails();
}
}
