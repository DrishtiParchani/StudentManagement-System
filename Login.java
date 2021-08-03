import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;

class Login extends JFrame
{
		Container c;
		JLabel lbl1 ;
		JLabel lbl2 ;
		JTextField txtname;
		JTextField txtpass;
		JButton login;
	Login()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		lbl1 = new JLabel("enter username ");
		lbl2 = new JLabel("enter password ");
		txtname = new JTextField(10);
		txtpass = new JTextField(10);
		login = new JButton("Login");
		c.add(lbl1);
		c.add(txtname);
		c.add(lbl2);
		c.add(txtpass);
		c.add(login);
		setTitle("Login");
		setSize(300,300);
		c.setBackground(Color.CYAN);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[])
	{
		Login l = new Login();
	}
}
