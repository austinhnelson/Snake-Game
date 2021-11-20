import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class SnakeObject extends JPanel {
    
    final int OFFSET_TO_MOVE = 30; 
    int positionX, positionY;
    Graphics snake;

    public SnakeObject(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public void incrementPositionX(){
        positionX += OFFSET_TO_MOVE;
    }

    public void incrementPositionY(){
        positionY += OFFSET_TO_MOVE;
    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(positionX, positionY, 10, 10);
    }


}
