import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Teach_details extends JFrame implements ActionListener {
    Choice cemployid;
    JTable table;
    JButton search,print,update,add,cancel;
    Teach_details(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employ ID");
        heading.setBounds(50,45,127,30);
        heading.setFont(new Font("serif", Font.BOLD,16));
        add(heading);

        cemployid= new Choice();
        cemployid.setBounds(180,50,130,30);
        add(cemployid);

        try{ Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){cemployid.add(rs.getString("employ_id"));}
        } catch (Exception e){e.printStackTrace();}

        table=new JTable();
        try{ Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){e.printStackTrace();}
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,200,900,600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(50,100,80,20);
        search.addActionListener(this);
        add(search);


        print=new JButton("Print");
        print.setBounds(150,100,80,20);
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setBounds(250,100,80,20);
        update.addActionListener(this);
        add(update);

        add=new JButton("Add");
        add.setBounds(350,100,80,20);
        add.addActionListener(this);
        add(add);

        cancel=new JButton("Cancel");
        cancel.setBounds(450,100,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(920,550);
        setLocation(110,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==search){ String query ="select * from teacher where employ_id ='" + cemployid.getSelectedItem()+"'";
            try{ Conn c=new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));}catch (Exception e) {e.printStackTrace();} }
        else if (ae.getSource()==print){try { table.print(); } catch (Exception e) {e.printStackTrace();} }
        else if (ae.getSource()==add){setVisible(false);
            new AddTchr();}
        else if (ae.getSource()==update){ /*update info frame */}
        else {setVisible(false);}
    }

    public static void main(String[] args){
        new Teach_details();
    }
}
