import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.sql.*;

class StudentMain extends JFrame
{
		Container c;
		JButton add;
		JButton view;
		JButton update;
		JButton delete;
	StudentMain()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		add = new JButton("Add Student");
		view = new JButton("View Student");
		update = new JButton("Update Student");
		delete = new JButton("Delete Student");
		c.add(add);
		c.add(view);
		c.add(update);
		c.add(delete);

		
		ActionListener a1 = (ae) -> {
			AddStu a = new AddStu();
			dispose();
		};
		add.addActionListener(a1);

		ActionListener a2 = (ae) -> {
			ViewStu a = new ViewStu();
			dispose();
		};
		view.addActionListener(a2);

		ActionListener a3 = (ae) -> {
			UpdateStu a = new UpdateStu();
			dispose();
		};
		update.addActionListener(a3);

		ActionListener a4 = (ae) -> {
			DeleteStu a = new DeleteStu();
			dispose();
		};
		delete.addActionListener(a4);


	
		setTitle("Student Management System ");
		setSize(300,300);
		c.setBackground(Color.CYAN);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[])
	{
		StudentMain l = new StudentMain();
	}
}

class DbHandler{
	public void addStudent(int rno,String name,float marks)
	{
		try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","abc123");

			String s1 = "insert into student1 values(?,?,?)";
			PreparedStatement s2 = con.prepareStatement(s1);

			s2.setInt(1,rno);
			
			s2.setString(2,name);
			s2.setFloat(3,marks);

			int r = s2.executeUpdate();
			System.out.println(r + " records inserted");
			JOptionPane.showMessageDialog(new JDialog(), r + "records inserted ");


			con.close();
		}
		catch(SQLException se){
			System.out.println("issue " + se);
			JOptionPane.showMessageDialog(new JDialog(),"issue " + se );
}  
	}

public String ViewStudent() {
	StringBuffer sb = new StringBuffer();
	try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","abc123");
            
			String s1 = "select * from student1";
			Statement s2 = con.createStatement();
			ResultSet rs = s2.executeQuery(s1);

			while(rs.next())
			{
				int rno = rs.getInt("rno");
				String name = rs.getString("name");
				int marks = rs.getInt("marks");
				System.out.println(rno + " " + name + " " + marks);
				sb.append(rno + " " + name +" "+ marks+"\n");
			}
			rs.close();
		    con.close();
		}
		catch(SQLException se){
			System.out.println("issue " + se);}
			return sb.toString();
}  
public void deleteStudent(int rno) {
	try{
	
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","abc123");

                       Statement s1 = con.createStatement(); 
                       String s2 = "delete from student1 where rno = ' "+ rno+" ' ";
                       int r = s1.executeUpdate(s2);
             
		
System.out.println(r+ " row deleted");
if(r==0){
JOptionPane.showMessageDialog(new JDialog(), r + " records deleted ..Enter valid roll no.");}
else{	
	
	JOptionPane.showMessageDialog(new JDialog(), r + " records deleted ");}
 

			con.close();
		
		
	}catch(SQLException se){
			System.out.println("issue " + se);
			JOptionPane.showMessageDialog(new JDialog(),"issue " + se );
}  
}
public void updateStudent(String name,float marks,int rno)
{
	        StringBuffer sb = new StringBuffer();
	try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","abc123");
		 String s2 = "UPDATE student1 SET name = ? , marks = ? WHERE rno = ? " ;
                        PreparedStatement s1 = con.prepareStatement(s2); 
	              s1.setString(1,name);
		s1.setFloat(2,marks);
		s1.setInt(3,rno);
		
			
                        int r = s1.executeUpdate();

                  if(r==0)
{ System.out.println("Enter valid roll no");
JOptionPane.showMessageDialog(new JDialog(), r + " records updated..Enter vaild roll no ");}
             
	else{	
	System.out.println(r+ " row updated");
	JOptionPane.showMessageDialog(new JDialog(), r + " records updated ");}


			con.close();
}
		catch(SQLException se){
			System.out.println("issue " + se);
			JOptionPane.showMessageDialog(new JDialog(),"issue " + se );
}  
}
}


