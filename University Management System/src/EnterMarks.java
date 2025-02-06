import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener  {

    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton cancel, submit;

    EnterMarks() {

        setSize(700,500);
        setLocation(160,50);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Final Exam Marked with 100  Stock Image - Image of background, degree_ 8254189.jpeg"));
//        Image i2 = i1.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(700, 40, 200, 100);
//        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(210, 30, 450, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(90, 80, 150, 30);
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 85, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(90, 120, 150, 30);
        add(lblsemester);

        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250, 125, 150, 20);
        //cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(90, 160, 150, 30);
        add(lblentersubject);

        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(350, 160, 150, 30);
        add(lblentermarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(90, 200, 200, 20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(90, 230, 200, 20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(90, 260, 200, 20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(90, 290, 200, 20);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(90, 320, 200, 20);
        add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(350, 200, 200, 20);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(350, 230, 200, 20);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(350, 260, 200, 20);
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(350, 290, 200, 20);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(350, 320, 200, 20);
        add(tfmarks5);

        submit = new JButton("Submit");
        submit.setBounds(90, 370, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(350, 370, 150, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();

                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfmarks1.getText()+"', '"+tfmarks2.getText()+"', '"+tfmarks3.getText()+"', '"+tfmarks4.getText()+"', '"+tfmarks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}


