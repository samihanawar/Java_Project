import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpTchr extends JFrame implements ActionListener{
    JTextField adrs,phn,eml,qlfctn,labeldp;
    JButton submit, cancel;
    JLabel labelEmpId;
    Choice cEmpId;

    UpTchr(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE TEACHER INFORMATION");
        heading.setBounds(210,30,450,30);
        heading.setFont(new Font("Tahoma", Font.ITALIC,25));
        heading.setForeground(Color.black);
        add(heading);

        JLabel lbleid= new JLabel("Select Employee ID");
        lbleid.setBounds(90,80,200,20);
        lbleid.setFont(new Font("serif", Font.BOLD, 20));
        add(lbleid);

        cEmpId = new Choice();
        cEmpId.setBounds(300,80,200,20);
        add(cEmpId);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");//which table
            while (rs.next()){cEmpId.add(rs.getString("employ_id")); //which column
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

        JLabel lbled = new JLabel("Employee Id");
        lbled.setBounds(90,170,250,20);
        //lbled.setFont(new Font("serif", Font.BOLD,20));
        lbled.setForeground(Color.black);
        add(lbled);

        labelEmpId = new JLabel();
        labelEmpId.setBounds(180,153,250,50);
        labelEmpId.setFont(new Font("serif", Font.BOLD,18));
        add(labelEmpId);

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

        JLabel lblqlfctn = new JLabel("QUALIFICATION");
        lblqlfctn.setBounds(400,320,650,20);
        //  lblqlfctn.setFont(new Font("serif", Font.BOLD,20));
        lblqlfctn.setForeground(Color.black);
        add(lblqlfctn);
        qlfctn= new JTextField();
        qlfctn.setBounds(510,320,170,20);
        add(qlfctn);

        JLabel lbldp= new JLabel("DEPARTMENT");
        lbldp.setBounds(90,320,250,20);
        lbldp.setForeground(Color.black);
        add(lbldp);

        JLabel labeldp=new JLabel();
        labeldp.setBounds(180,320,170,20);
        add(labeldp);


        try {
            Conn c = new Conn();
            String query = "select * from teacher where employ_id='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query); //
            while(rs.next()) {
                labelname.setText(rs.getString("nname"));
                labelFname.setText(rs.getString("fFname"));
                labelMname.setText(rs.getString("mMname"));
                labeldcdob.setText(rs.getString("dobb"));
                adrs.setText(rs.getString("addrss"));
                phn.setText(rs.getString("phone"));
                eml.setText(rs.getString("email"));
                labelEmpId.setText(rs.getString("employ_id"));
                qlfctn.setText(rs.getString("qualification"));
                labeldp.setText(rs.getString("dpt"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where employ_id='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query); //
                    while(rs.next()) {
                        labelname.setText(rs.getString("nname"));
                        labelFname.setText(rs.getString("fFname"));
                        labelMname.setText(rs.getString("mMname"));
                        labeldcdob.setText(rs.getString("dobb"));
                        adrs.setText(rs.getString("addrss"));
                        phn.setText(rs.getString("phone"));
                        eml.setText(rs.getString("email"));
                        labelEmpId.setText(rs.getString("employ_id"));
                        qlfctn.setText(rs.getString("qualification"));
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
            String employ_id= labelEmpId.getText();
            String addrss= adrs.getText();
            String phone= phn.getText();
            String email= eml.getText();
            String qualification= qlfctn.getText();


            try{
                String query = "update teacher set addrss='"+addrss+"', phone='"+phone+"', email='"+email+"' , qualification='"+qualification+"' where employ_id='"+employ_id+"'";
                //String query ="insert into student values( '"+addrss+"', '"+phone+"', '"+email+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher details updated successfully.");
                setVisible(false);
            }
            catch (Exception e){e.printStackTrace();}

        }
        else{setVisible(false);}
    }
    public static void main (String [] args){ new UpTchr();}
}
