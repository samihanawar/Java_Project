import javax.swing.JFrame;
public class Main extends JFrame {
    Main(){
        // //JFrame obj =new JFrame();
        Gameplay gp = new Gameplay ();
        setBounds(100,30,900,520);
        setTitle("DX Ball");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gp);
    }
    public static void main(String[] args) {
        new Main();
    }
}