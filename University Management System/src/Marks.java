import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
public class Marks extends JFrame implements ActionListener {
    String rollno;
    JButton cancel;
    Marks(String rollno){
        this.rollno=rollno;

        setSize(700,500);
        setLocation(160,50);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("SIMTEC");
        heading.setBounds(280, 30, 450, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        JLabel subheading = new JLabel("Result of examination");
        subheading.setBounds(200, 70, 450, 30);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll number----" + rollno);
        lblrollno.setBounds(100, 140, 450, 30);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblrollno);

        JLabel lblsmstr = new JLabel();
        lblsmstr.setBounds(100, 160, 450, 30);
        lblsmstr.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblsmstr);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 450, 30);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 220, 450, 30);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 240, 450, 30);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 260, 450, 30);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub4 );

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 280, 450, 30);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(sub5 );

        try{
            Conn c=new Conn();
            ResultSet rs1  = c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while (rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            ResultSet rs2  = c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while (rs2.next()){
                sub1.setText(sub1.getText() +"---------------" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() +"---------------" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() +"---------------" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() +"---------------" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() +"---------------" + rs2.getString("marks5"));
                lblsmstr.setText("Semester-----" + rs2.getString("semsester"));

            } } catch (Exception e){e.printStackTrace();}

            cancel = new JButton("Back");
            cancel.setBounds(370, 390, 150, 30);
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(cancel);

            setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static  void main(String [] args){
        new Marks("");
    }

}
