import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;

class UpdateStu extends JFrame
{
		Container c;
		JLabel rno ;
		JLabel name ;
		JLabel marks ;
		JTextField txtrno;
		JTextField txtname;
		JTextField txtmarks;
		JButton save;
		JButton back;
	UpdateStu()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		rno = new JLabel("enter roll no ");
		name = new JLabel("enter name  ");
		marks = new JLabel("enter marks ");
		txtrno = new JTextField(10);
		txtname = new JTextField(10);
		txtmarks = new JTextField(10);
		save = new JButton("Save");
		back = new JButton("Back");
		c.add(rno);
		c.add(txtrno);
		c.add(name);
		c.add(txtname);
		c.add(marks);
		c.add(txtmarks);
		c.add(save);
		c.add(back);

        	ActionListener a1 = (ae) ->{
		StudentMain a = new StudentMain();
		dispose();
		};
		back.addActionListener(a1);
	ActionListener a2 = (ae) ->{    
                    try{
						String rnos=txtrno.getText();
					String name = txtname.getText();
					String mark = txtmarks.getText();
					if(rnos.equals("") || name.equals("") || mark.equals(""))
					{
						throw new Exception( "Please enter some data ");
					}
					char [] checkers = rnos.toCharArray();
									for(int abc:checkers)
									{
										if(Character.isDigit(abc))
										{
											continue;
										}
										else
										{
											txtrno.setText("");
											txtrno.requestFocus();
											JOptionPane.showMessageDialog(new JDialog(), "Please enter only numbers ");
											return;
										}
									}
					int rno =Integer.parseInt(rnos);  
				        
				
			
           
					
			char[] checker = name.toCharArray();
			for(char abc:checker)
			{
				if(Character.isLetter(abc) && name.length() >=2){
					continue;
				}
				else{
					JOptionPane.showMessageDialog(new JDialog(), "only letters allowed and length should be greater than 2");
					txtname.setText("");
					txtname.requestFocus();
					return;
				}
			}

			
			char[] checkerss = mark.toCharArray();
			for(int abc:checkerss)
									{
										if(Character.isDigit(abc))
										{
											continue;
										}
										else
										{
											txtmarks.setText("");
											txtmarks.requestFocus();
											JOptionPane.showMessageDialog(new JDialog(), "Please enter only valid marks ");
											return;
										}
									}
			
			
				 
				 
				 float marks = Float.parseFloat(mark); 
			
			DbHandler db = new DbHandler();
if(rno <= 0 )
			{
				txtrno.setText("");
				txtrno.requestFocus();
				JOptionPane.showMessageDialog(new JDialog(), "Please enter only valid numbers ");
				throw new Exception("Enter valid data");
			}
	
		
		else if(marks < 0 || marks > 100)	{
			txtmarks.setText("");
			txtmarks.requestFocus();
			JOptionPane.showMessageDialog(new JDialog(), "Please enter marks betwwen 0 to 100 ");
			throw new Exception("Enter marks between 0 and 100 ");
											
			} 
			else{
				db.updateStudent(name,marks,rno);
					txtrno.setText("");
					txtname.setText("");
					txtmarks.setText("");
					txtrno.requestFocus();
		}
					}
  catch(Exception e){
		JOptionPane.showMessageDialog(new JDialog(),"please enter valid data");}
		txtrno.setText("");
		txtname.setText("");
		txtmarks.setText("");
		txtrno.requestFocus();
		};
		save.addActionListener(a2);

		setTitle("Update Student");
		setSize(250,300);
		c.setBackground(Color.CYAN);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[])
	{
		UpdateStu update = new UpdateStu();
	}
}
