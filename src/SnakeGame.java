import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class SnakeGame extends JPanel {

    final static int SCREEN_X = 600;
    final static int SCREEN_Y = 600;

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
    }

    public static void main (String[] args){

        JFrame mainFrame = new JFrame();
        SnakeObject mySnake = new SnakeObject(400, 100);

        mainFrame.add(mySnake);

        mainFrame.setTitle("Snake!");
        mainFrame.setSize(SCREEN_X, SCREEN_Y);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.black);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}