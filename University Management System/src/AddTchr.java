import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class AddTchr extends JFrame implements ActionListener{
    JTextField name,Fname,adrs,phn,eml,qlfctn,Mname;
    JComboBox cbdp;
    JDateChooser dcdob;
    JButton submit, cancel;
    Random rn= new Random();
    long first2 =Math.abs((rn.nextLong()% 90L)+10L); // 2 digits
    JLabel lebelemployid;

    AddTchr(){
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("NEW TEACHER INFORMATION");
        heading.setBounds(210,30,450,22);
        heading.setFont(new Font("serif", Font.BOLD,25));
        heading.setForeground(Color.black);
        add(heading);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(90,80,250,20);
        //lblname.setFont(new Font("serif", Font.BOLD,20));
        lblname.setForeground(Color.black);
        add(lblname);
        name= new JTextField();
        name.setBounds(180,80,170,20);
        add(name);

        JLabel lblFname = new JLabel("FATHER'S NAME");
        lblFname.setBounds(400,80,650,20);
        //lblFname.setFont(new Font("serif", Font.BOLD,20));
        lblFname.setForeground(Color.black);
        add(lblFname);
        Fname= new JTextField();
        Fname.setBounds(510,80,170,20);
        add(Fname);

        JLabel lblroll = new JLabel("ID NO");
        lblroll.setBounds(90,130,250,20);
        //lblroll.setFont(new Font("serif", Font.BOLD,20));
        lblroll.setForeground(Color.black);
        add(lblroll);

        lebelemployid = new JLabel("2024-"+first2);
        lebelemployid.setBounds(180,113,250,50);
        lebelemployid.setFont(new Font("serif", Font.BOLD,18));
        add(lebelemployid);

        JLabel lblMname = new JLabel("MOTHER'S NAME");
        lblMname.setBounds(400,130,650,20);
        //lblMname.setFont(new Font("serif", Font.BOLD,20));
        lblMname.setForeground(Color.black);
        add(lblMname);
        Mname= new JTextField();
        Mname.setBounds(510,130,170,20);
        add(Mname);

        JLabel lbldob = new JLabel("DATE OF BIRTH");
        lbldob.setBounds(400,180,650,20);
        //lbldob.setFont(new Font("serif", Font.BOLD,20));
        lbldob.setForeground(Color.black);
        add(lbldob);
        //adding calender for dob;
        dcdob=new JDateChooser();
        dcdob.setBounds(510,180,170,20);
        add(dcdob);

        JLabel lbladrs = new JLabel("ADDRESS");
        lbladrs.setBounds(90,180,250,20);
        // lbladrs.setFont(new Font("serif", Font.BOLD,20));
        lbladrs.setForeground(Color.black);
        add(lbladrs);
        adrs= new JTextField();
        adrs.setBounds(180,180,170,20);
        add(adrs);

        JLabel lblphn = new JLabel("PHONE NUMBER");
        lblphn.setBounds(400,230,650,20);
        //  lblphn.setFont(new Font("serif", Font.BOLD,13));
        lblphn.setForeground(Color.black);
        add(lblphn);
        phn= new JTextField();
        phn.setBounds(510,230,170,20);
        add(phn);

        JLabel lbleml = new JLabel("E-MAIL");
        lbleml.setBounds(90,230,250,20);
        //  lbleml.setFont(new Font("serif", Font.BOLD,20));
        lbleml.setForeground(Color.black);
        add(lbleml);
        eml= new JTextField();
        eml.setBounds(180,230,170,20);
        add(eml);

        JLabel lblqlfctn = new JLabel("QUALIFICATION");
        lblqlfctn.setBounds(400,280,650,20);
        //  lblgpa.setFont(new Font("serif", Font.BOLD,20));
        lblqlfctn.setForeground(Color.black);
        add(lblqlfctn);
        qlfctn= new JTextField();
        qlfctn.setBounds(510,280,170,20);
        add(qlfctn);

        JLabel lbldp= new JLabel("DEPARTMENT");
        lbldp.setBounds(90,280,250,20);
        // lbldp.setFont(new Font("serif", Font.BOLD,13));
        add(lbldp);
        String dp[]={"Computer Science & Engineering","Civil Engineering","Electrical & Electronics Engineering","Mechanical Engineering"};
        cbdp=new JComboBox(dp);
        cbdp.setBounds(180,280,210,20);
        cbdp.setBackground(Color.white);
        add(cbdp);

        submit = new JButton("Submit");
        submit.setBounds(210,350,100,30);
        submit.setBackground(Color.white);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(440,350,100,30);
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
            String fFname= Fname.getText();
            String mMname= Mname.getText();
            String employ_id= lebelemployid.getText();
            String dobb=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String addrss= adrs.getText();
            String phone= phn.getText();
            String email= eml.getText();
            String qualification= qlfctn.getText();
            String dpt=(String)cbdp.getSelectedItem();

            try{
                String query ="insert into teacher values('"+nname+"', '"+fFname+"', '"+mMname+"', '"+employ_id+"' , '"+dobb+"', '"+addrss+"', '"+phone+"', '"+email+"', '"+qualification+"', '"+dpt+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher details updated successfully.");
                setVisible(false);
            }
            catch (Exception e){e.printStackTrace();}

        }
        else{setVisible(false);}
    }
    public static void main (String [] args){ new AddTchr();}
}
