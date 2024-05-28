import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Proj extends JFrame {
    Proj(){
        setSize(1100,700); //framesize
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("saic pic.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 650, Image.SCALE_DEFAULT); //bg pic size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        // initial menu
        JMenu newinfo=new JMenu("Enter Information");
        newinfo.setForeground(Color.blue);
        mb.add(newinfo);

        // menu's items
        JMenuItem fcltyInfo=new JMenuItem("Faculty information");
        fcltyInfo.setBackground(Color.WHITE);
        fcltyInfo.addActionListener(this::actionPerformed);
        newinfo.add(fcltyInfo);

        // menu's items
        JMenuItem stuInfo=new JMenuItem("Student information");
        stuInfo.setBackground(Color.WHITE);
        stuInfo.addActionListener(this::actionPerformed);
        newinfo.add(stuInfo);

        JMenu newDetails=new JMenu("View Details");
        newDetails.setForeground(Color.blue);
        mb.add(newDetails);

        JMenuItem fcltyDetails=new JMenuItem("Faculty Details");
        fcltyDetails.setBackground(Color.WHITE);
        fcltyDetails.addActionListener(this::actionPerformed);
        newDetails.add(fcltyDetails);

        JMenuItem stuDetails=new JMenuItem("Student Details");
        stuDetails.setBackground(Color.WHITE);
        stuDetails.addActionListener(this::actionPerformed);
        newDetails.add(stuDetails);

        JMenu newup=new JMenu("Update Details");
        newup.setForeground(Color.blue);
        mb.add(newup);

        JMenuItem fu=new JMenuItem("Faculty information update");
        fu.setBackground(Color.WHITE);
        newup.add(fu);

        JMenuItem stu=new JMenuItem("Student information update");
        stu.setBackground(Color.WHITE);
        stu.addActionListener(this::actionPerformed);
        newup.add(stu);

//        JMenu newExm = new JMenu("Examination");
//        newExm.setForeground(Color.blue);
//        mb.add(newExm);
//
//        JMenuItem exRs = new JMenuItem("Examination Result");
//        exRs.setBackground(Color.WHITE);
//        newExm.add(exRs);
//
//        JMenuItem exmrks = new JMenuItem("Examination Marks");
//        exmrks.setBackground(Color.WHITE);
//        newExm.add(exmrks);
//
//        JMenu newFee= new JMenu("Fee");
//        newFee.setForeground(Color.MAGENTA);
//        mb.add(newFee);
//
//        JMenuItem fstrc=new JMenuItem("Fee Details");
//        fstrc.setBackground(Color.WHITE);
//        newFee.add(fstrc);
//
//        JMenuItem due=new JMenuItem("Due Fees");
//        due.setBackground(Color.WHITE);
//        newFee.add(due);

        JMenu newutil=new JMenu("Utility");
        newutil.setForeground(Color.blue);
        mb.add(newutil);

        JMenuItem note=new JMenuItem("Notepad");
        note.setBackground(Color.WHITE);
        note.addActionListener(this::actionPerformed);
        newutil.add(note);

        JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this::actionPerformed);
        newutil.add(calc);

        JMenu newexit=new JMenu("Exit");
        newexit.setForeground(Color.red);
        mb.add(newexit);

        JMenuItem exit=new JMenuItem("EXIT");
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this::actionPerformed);
        newexit.add(exit);

        setJMenuBar(mb);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("EXIT")){
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception e){}
        }

        else if (msg.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e){}
        }
        else if (msg.equals("Faculty information")) {
            new AddTchr();
        }
        else if (msg.equals("Student information")) {
            new AddStu();
        }
        else if (msg.equals("Faculty Details")) {
            new Teach_details();
        }
        else if (msg.equals("Student Details")) {
            new Stu_details();
        }
        else if (msg.equals("Student information update")) {
            new UpStu();
        }

    }
    public static void main (String[] args){
        new Proj();
    }
}
