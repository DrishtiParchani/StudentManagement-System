import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import java.io.*;

public class LoginDemo extends JFrame implements ActionListener {

    Container c;
    JLabel user_label, password_label, message, ig;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;

    LoginDemo() {
                
        user_label = new JLabel();
        user_label.setText("User Name : ");
        userName_text = new JTextField(10);
        
       
        password_label = new JLabel();
        password_label.setText("Password :  ");
        password_text = new JPasswordField(10);

        submit = new JButton("SUBMIT");
        c = getContentPane();
        c.setLayout(new FlowLayout());
   
       c.add(user_label);
        c.add(userName_text);
        c.add(password_label);
        c.add(password_text);

        message = new JLabel();
        c.add(message);
        c.add(submit);
        
        
        
        
        submit.addActionListener(this);
        
        setTitle("Please Login Here !");
        setSize(250, 300);
        setVisible(true);
        c.setBackground(Color.PINK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 

 public static void main(String[] args) {
        new LoginDemo();
    }
  
    
    public void actionPerformed(ActionEvent ae) {
        String userName = userName_text.getText();
        String password = password_text.getText();
        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            message.setText(" Hello " + userName
                    + "");

		StudentMain a = new StudentMain();
			dispose();
		
		}
		
		
     
         else {
            message.setText(" Invalid user.. ");
			userName_text.setText("");
			password_text.setText("");
        }

	
		


    }


}