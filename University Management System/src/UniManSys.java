import javax.swing.*;
import java.awt.*;
public class UniManSys extends JFrame implements Runnable{
        Thread t;
    UniManSys () {
        getContentPane().setBackground(Color.BLACK);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("simtec.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        t= new Thread(this);
        t.start();
        setVisible(true);
        int x = 1;
        for (int i = 2; i <= 500; i += 4, x = x + 1) {
            setLocation(400 - ((i + x) / 2), 20 );
            setSize(i + 3 * x, i + x / 3);
            try {
                Thread.sleep(4);
            } catch (Exception e) {}
          }

    }
    public void run(){
        try{
            Thread.sleep(4000);
            setVisible(false);
            new Login();
        }
        catch(Exception e){

        }
    }

    public static void main(String [] args){
        new UniManSys();

    }
}
