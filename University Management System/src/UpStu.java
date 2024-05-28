import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpStu extends JFrame implements ActionListener{
    JTextField name,Fname,adrs,phn,eml,cgpa,Mname, labeldp;
    JButton submit, cancel;
    JLabel labelrollno;
    Choice crollno;

    UpStu(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE STUDENT INFORMATION");
        heading.setBounds(210,30,450,30);
        heading.setFont(new Font("Tahoma", Font.ITALIC,25));
        heading.setForeground(Color.black);
        add(heading);

        JLabel lblrollno= new JLabel("Select Roll No");
        lblrollno.setBounds(90,80,150,20);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(240,80,200,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");//which table
            while (rs.next()){crollno.add(rs.getString("rollno")); //which column
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(90,120,250,20);
       // lblname.setFont(new Font("serif", Font.BOLD,20));
        lblname.setForeground(Color.black);
        add(lblname);
        JLabel labelname= new JLabel();
        labelname.setBounds(180,120,170,20);
        //labelname.setFont();
        add(labelname);

        JLabel lblFname = new JLabel("FATHER'S NAME");
        lblFname.setBounds(400,120,650,20);
        //lblFname.setFont(new Font("serif", Font.BOLD,20));
        lblFname.setForeground(Color.black);
        add(lblFname);
        JLabel labelFname= new JLabel();
        labelFname.setBounds(510,120,170,20);
        add(labelFname);

        JLabel lblroll = new JLabel("ROLL NO");
        lblroll.setBounds(90,170,250,20);
        //lblroll.setFont(new Font("serif", Font.BOLD,20));
        lblroll.setForeground(Color.black);
        add(lblroll);

        labelrollno = new JLabel();
        labelrollno.setBounds(180,153,250,50);
        labelrollno.setFont(new Font("serif", Font.BOLD,18));
        add(labelrollno);

        JLabel lblMname = new JLabel("MOTHER'S NAME");
        lblMname.setBounds(400,170,650,20);
        //lblMname.setFont(new Font("serif", Font.BOLD,20));
        lblMname.setForeground(Color.black);
        add(lblMname);
        JLabel labelMname= new JLabel();
        labelMname.setBounds(510,170,170,20);
        add(labelMname);

        JLabel lbldob = new JLabel("DATE OF BIRTH");
        lbldob.setBounds(400,220,650,20);
        //lbldob.setFont(new Font("serif", Font.BOLD,20));
        lbldob.setForeground(Color.black);
        add(lbldob);

        JLabel labeldcdob=new JLabel();
        labeldcdob.setBounds(510,220,170,20);
        add(labeldcdob);

        JLabel lbladrs = new JLabel("ADDRESS");
        lbladrs.setBounds(90,220,250,20);
        // lbladrs.setFont(new Font("serif", Font.BOLD,20));
        lbladrs.setForeground(Color.black);
        add(lbladrs);
        adrs= new JTextField();
        adrs.setBounds(180,220,170,20);
        add(adrs);

        JLabel lblphn = new JLabel("PHONE NUMBER");
        lblphn.setBounds(400,270,650,20);
        //  lblphn.setFont(new Font("serif", Font.BOLD,13));
        lblphn.setForeground(Color.black);
        add(lblphn);
        phn= new JTextField();
        phn.setBounds(510,270,170,20);
        add(phn);

        JLabel lbleml = new JLabel("E-MAIL");
        lbleml.setBounds(90,270,250,20);
        //  lbleml.setFont(new Font("serif", Font.BOLD,20));
        lbleml.setForeground(Color.black);
        add(lbleml);
        eml= new JTextField();
        eml.setBounds(180,270,170,20);
        add(eml);

        JLabel lblgpa = new JLabel("GPA (SSC+HSC)");
        lblgpa.setBounds(400,320,650,20);
        //  lblgpa.setFont(new Font("serif", Font.BOLD,20));
        lblgpa.setForeground(Color.black);
        add(lblgpa);
        cgpa= new JTextField();
        cgpa.setBounds(510,320,170,20);
        add(cgpa);

        JLabel lbldp= new JLabel("DEPARTMENT");
        lbldp.setBounds(90,320,250,20);
        //lbldp.setFont(new Font("serif", Font.BOLD,13));
        add(lbldp);
//        String dp[]={"Computer Science & Engineering","Civil Engineering","Electrical & Electronics Engineering","Mechanical Engineering"};
//        JComboBox cbdp = new JComboBox(dp);
//        cbdp.setBounds(180,280,210,20);
//        cbdp.setBackground(Color.white);
//        add(cbdp);
         labeldp=new JTextField();
        labeldp.setBounds(180,320,170,20);
        add(labeldp);


        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query); //
            while(rs.next()) {
                labelname.setText(rs.getString("nname"));
                labelFname.setText(rs.getString("fFname"));
                labelMname.setText(rs.getString("mMname"));
                labeldcdob.setText(rs.getString("dobb"));
                adrs.setText(rs.getString("addrss"));
                phn.setText(rs.getString("phone"));
                eml.setText(rs.getString("email"));
                labelrollno.setText(rs.getString("rollno"));
                cgpa.setText(rs.getString("cgpa"));
                labeldp.setText(rs.getString("dpt"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("nname"));
                        labelFname.setText(rs.getString("fFname"));
                        labelMname.setText(rs.getString("mMname"));
                        labeldcdob.setText(rs.getString("dobb"));
                        adrs.setText(rs.getString("addrss"));
                        phn.setText(rs.getString("phone"));
                        eml.setText(rs.getString("email"));
                        labelrollno.setText(rs.getString("rollno"));
                        cgpa.setText(rs.getString("cgpa"));
                        labeldp.setText(rs.getString("dpt"));

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        submit = new JButton("Update");
        submit.setBounds(210,390,100,30);
        submit.setBackground(Color.white);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(440,390,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD,15));
        add(cancel);

        setSize(800,500);
        setLocation(160,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String nname = name.getText(); //variable name should be unique
            //String fFname= Fname.getText();
            //String mMname= Mname.getText();
            String rollno= labelrollno.getText();
            //String dobb=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String addrss= adrs.getText();
            String phone= phn.getText();
            String email= eml.getText();
            //String cgpa=cgpa.getText();
           // ComboBoxModel<Object> cbdp = null;
            String dpt=labeldp.getText();

            try{
                String query = "update student set addrss='"+addrss+"',nname='"+name+"', phone='"+phone+"', email='"+email+"' cgpa='"+cgpa+"', dpt='"+dpt+"' where rollno='"+rollno+"'";
                //String query ="insert into student values( '"+addrss+"', '"+phone+"', '"+email+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student details updated successfully.");
                setVisible(false);
            }
            catch (Exception e){e.printStackTrace();}

        }
        else{setVisible(false);}
    }
    public static void main (String [] args){ new UpStu();}
}
