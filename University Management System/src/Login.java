import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField tfusername,tfuserpassword;
    Login(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,30,150,20);
        add(lblusername);

        tfusername= new JTextField();
        tfusername.setBounds(160,30,250,20);
        add(tfusername);

        JLabel lbluserpassword = new JLabel("Password");
        lbluserpassword.setBounds(60,70,150,20);
        add(lbluserpassword);

       tfuserpassword= new JPasswordField();
        tfuserpassword.setBounds(160,70,250,20);
        add(tfuserpassword);

        login = new JButton("Login");
        login.setBounds(100,150,100,30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma", Font.BOLD,15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(310,150,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD,15));
        add(cancel);

        setSize(600,400);
        setLocation(270,90);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==login){
        String username = tfusername.getText();
        String password = tfuserpassword.getText();

        String query="select * from login where username='"+username+"' and password='"+password+"'";
        try{
            Conn c= new Conn();
            Resultset rs = (Resultset) c.s.executeQuery(query);
            if(rs.getRows().hasNext()){setVisible(false);
            new Proj();
            }
            else{JOptionPane.showMessageDialog(null,"Invalid Username or Password");
            setVisible(false);
            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
    else if (ae.getSource()==cancel) {setVisible(false);}
    }
    public static void main(String [] args){
        new Login();
    }
}
