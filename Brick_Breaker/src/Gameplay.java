import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 35;
    private  Timer timer;
    private int delay=8;
    private int playerX=310;
    private  int ballpoX=120;
    private  int ballpoY=150;
    private  int ballXdir=-2;
    private  int ballYdir=-3;
    private MapGenerator map;
    private Timer paddleTimer;
    private int paddleDelay = 20;
    private boolean moveRight = false;
    private boolean moveLeft = false;


    public Gameplay(){
        map=new MapGenerator(5,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
        paddleTimer = new Timer(paddleDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moveRight) {
                    moveRight();
                }
                if (moveLeft) {
                    moveLeft();
                }
            }
        });
        paddleTimer.start();
    }



    public void paint(Graphics g){
        //bg
        g.setColor(Color.lightGray);
        g.fillRect(1,1,902,592);

        //map draw
        map.draw((Graphics2D)g);

        // borders
        g.setColor(Color.black);
        g.fillRect(0,0,10,592);
        g.fillRect(0,0,875,10);
        g.fillRect(874,0,10,592);

        //score
        g.setColor(Color.RED);
        g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString("Score:"+ score,730,40);

        //paddle
        g.setColor(Color.DARK_GRAY);
        g.fillRect(playerX,400,80,8);

        //ball
        g.setColor(Color.BLUE);
        g.fillOval(ballpoX,ballpoY,15,15);

        if (totalBricks<=0){
            play=false;
            ballXdir=0;
            ballYdir=0;
            g.setColor(Color.RED);
            g.setFont(new Font("italic", Font.BOLD,25));
            g.drawString("You Win",300,240);
            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced", Font.BOLD,25));
            g.drawString("Press Enter to restart.",280,310);

        }

        if (ballpoY>490){
            play=false;
            ballXdir=0;
            ballYdir=0;
            g.setColor(Color.RED);
            g.setFont(new Font("italic", Font.BOLD,25));
            g.drawString("Game over",300,240);

            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD,25));
            g.drawString("Score: "+ score,300,265);

            g.setColor(Color.RED);
            g.setFont(new Font("Monospaced", Font.BOLD,25));
            g.drawString("Press Enter to restart.",280,310);

        }

        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    timer.start();
    if(play){
        Rectangle ballRect = new Rectangle(ballpoX, ballpoY, 15, 15);
        Rectangle paddleRect = new Rectangle(playerX, 400, 100, 8);
        //if (new Rectangle(ballpoX,ballpoY,15,15).intersects(new Rectangle(playerX,400,100,8))){
            //ballYdir=-ballYdir;
            if (ballRect.intersects(paddleRect)) {
                // checking where the ball hits the paddle
                int paddleCenter = playerX + 50; // Center of the paddle
                if (ballpoX < paddleCenter) {
                    ballXdir = -Math.abs(ballXdir); // Move left
                } else {
                    ballXdir = Math.abs(ballXdir); // Move right
                }
                ballYdir = -ballYdir; // Reverse Y direction
            }
       // }
        A: for (int i=0;i<map.map.length;i++){
            for (int j=0;j<map.map[0].length; j++){
                if (map.map[i][j]>0){
                    int briX=j*map.briwid+map.startX;
                    int briY=i*map.brihei+map.startY;
                    int briwid=map.briwid;
                    int brihei= map.brihei;
                    Rectangle rect = new Rectangle(briX,briY,briwid,brihei);
                   // Rectangle ballRect=new Rectangle(ballpoX,ballpoY,15,15);
                    Rectangle briRect=rect;
                    if (ballRect.intersects(briRect)){
                        map.setBrickValue(0,i,j);
                        totalBricks--;
                        score +=1;

                        if (ballpoX+19<= briRect.x || ballpoX+1>= briRect.x +briRect.width){
                            ballXdir=-ballXdir;
                        } else {
                            ballYdir=-ballYdir;
                        }
                        break A;
                    }
                }
            }
        }
        ballpoX +=ballXdir;
        ballpoY+=ballYdir;
        if(ballpoX<0 ){
            ballXdir=-ballXdir;}
        if(ballpoY<0){
            ballYdir=-ballYdir;}
        if(ballpoX>860){
            ballXdir=-ballXdir;}
    }
    repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = false;
        }
        if (e.getKeyCode()== KeyEvent.VK_ENTER){
            if (!play){
                play = true;
                ballpoX=120;
                ballpoY=150;
                ballXdir=-2;
                ballYdir=-3;
                playerX=310;
                score=0;
                totalBricks=35;
                map=new MapGenerator(5,7);
                repaint();
            }
        }
    }

public void moveRight() {
    play = true;
    playerX += 10;
    if (playerX >= 800) {
        playerX = 800;
    }
}

public void moveLeft() {
    play = true;
    playerX -= 10;
    if (playerX <= 10) {
        playerX = 10;
    }
    }

   }

