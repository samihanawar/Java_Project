import java.awt.*;

public class MapGenerator {
    public int map[][];
    public int briwid;
    public int brihei;
    public int startX;
    public int startY = 50;
    public MapGenerator(int row, int col){
        map=new int[row][col];
        for(int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                map[i][j]=1;
            }
        }
        briwid = 540/col; //size of blocks
        brihei=150/row;
        int totalWidth = col * briwid;
        startX = (875 - totalWidth) / 2;
    }
//    public void draw(Graphics2D g){
//        for(int i=0;i<map.length;i++){
//            for (int j=0;j<map[0].length;j++){
//                if(map[i][j]>0){
//                    g.setColor(Color.YELLOW);
//                    g.fillRect(j*briwid+ startX,i*brihei+ startY,briwid,brihei); //position change
//
//                    g.setStroke(new BasicStroke(3));
//                    g.setColor(Color.lightGray);
//                    g.drawRect(j*briwid + startX, i*brihei + startY, briwid,brihei);
//                }
//            }
//        }
//    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    // Set different colors for different rows
                    if (i % 2 == 0) {
                        g.setColor(Color.YELLOW);
                    } else {
                        g.setColor(Color.GREEN);
                    }
                    g.fillRect(j * briwid + startX, i * brihei + startY, briwid, brihei);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.lightGray);
                    g.drawRect(j * briwid + startX, i * brihei + startY, briwid, brihei);
                }
            }
        }
    }


    public void setBrickValue(int value , int row , int col){
        map[row][col]=value;
    }
}
