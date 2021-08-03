import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;

class DeleteStu extends JFrame
{
		Container c;
		JLabel rno ;
		JLabel lbl;
		JTextField txtrno;
		JButton save;
		JButton back;
	DeleteStu()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		rno = new JLabel("enter roll no ");
		lbl = new JLabel("                                                                 ");
		txtrno = new JTextField(10);
		save = new JButton("Save");
		back = new JButton("Back");
		c.add(rno);
		c.add(txtrno);
		c.add(lbl);
		c.add(save);
		c.add(back);

              ActionListener a1 = (ae) -> {
    			StudentMain a = new StudentMain();
			dispose();
			};
		back.addActionListener(a1);

	ActionListener a2 = (ae) -> {
		try{int rno = Integer.parseInt(txtrno.getText());
		DbHandler db = new DbHandler();
		db.deleteStudent(rno);
}catch(NumberFormatException e){JOptionPane.showMessageDialog(new JDialog(), "numbers only ");}
                            
		};
		save.addActionListener(a2);	
		setTitle("Delete Student");
		setSize(250,300);
		c.setBackground(Color.CYAN);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[])
	{
		DeleteStu delete = new DeleteStu();
	}
}
