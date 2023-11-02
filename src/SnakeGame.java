import javax.swing.JFrame;

public class SnakeGame extends JFrame {

    static final int WINDOW_X = 505;
    static final int WINDOW_Y = 512;

    public SnakeGame() {
        super.setTitle("Snake!");
        super.setSize(WINDOW_X, WINDOW_Y);
        super.setLocation(0, 0);
        super.setResizable(true);
        super.add(new Board());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
