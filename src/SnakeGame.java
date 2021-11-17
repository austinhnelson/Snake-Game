import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class SnakeGame extends JPanel {

    final static int SCREEN_X = 600;
    final static int SCREEN_Y = 600;

    public void paintComponent(Graphics g){

    }
    public static void main (String[] args){

        JFrame mainFrame = new JFrame();

        mainFrame.setTitle("Snake!");
        mainFrame.setSize(SCREEN_X, SCREEN_Y);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}