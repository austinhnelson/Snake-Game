import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Snake snake;
    private Candy candy;
    private Timer timer;
    private long startTime, desiredTime;
    private int score;
    private BufferedImage image;

    private final int SNAKE_WIDTH = 20;
    private final int SNAKE_HEIGHT = 20;
    private final int SNAKE_INIT_POS_X = 1;
    private final int SNAKE_INIT_POS_Y = 1;

    static final int CANDY_WIDTH = 20;
    static final int CANDY_HEIGHT = 20;

    LinkedList<Snake> snakeCollection;

    enum Dir {
        UP,
        LEFT,
        DOWN,
        RIGHT
    }

    enum State {
        GAME_BEGIN,
        GAME_PLAYING,
        GAME_OVER
    }

    Dir snakeDir = Dir.RIGHT;
    State gameState = State.GAME_BEGIN;

    public Board() {
        super.setDoubleBuffered(true);
        timer = new Timer(5, this);
        timer.start();

        snake = new Snake(SNAKE_WIDTH, SNAKE_HEIGHT, SNAKE_INIT_POS_X, SNAKE_INIT_POS_Y);
        candy = new Candy(CANDY_WIDTH, CANDY_HEIGHT);

        snakeCollection = new LinkedList<Snake>();
        snakeCollection.add(snake);

        startTime = System.currentTimeMillis();

        try {
            image = ImageIO.read(new File("/Users/austinnelson/Code/Snake-Game/Untitled.png"));
        } catch (IOException ex) {

        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(image, 0, 0, this);
        desiredTime = System.currentTimeMillis() - startTime;

        if (gameState == State.GAME_BEGIN) {
            gameState = State.GAME_PLAYING;
        }

        if (gameState == State.GAME_PLAYING) {
            if (desiredTime > 100) {
                if (snakeDir == Dir.UP) {
                    snakeCollection.get(0).decrementPosY();
                } else if (snakeDir == Dir.LEFT) {
                    snakeCollection.get(0).decrementPosX();
                } else if (snakeDir == Dir.DOWN) {
                    snakeCollection.get(0).incrementPosY();
                } else if (snakeDir == Dir.RIGHT) {
                    snakeCollection.get(0).incrementPosX();
                }
                for (int i = 1; i < snakeCollection.size(); i++) {
                    int oldPosX = snakeCollection.get(i).getPosX();
                    int oldPosY = snakeCollection.get(i).getPosY();

                    int newPosX = snakeCollection.get(i - 1).getPrevX();
                    int newPosY = snakeCollection.get(i - 1).getPrevY();

                    snakeCollection.get(i).updatePrev(oldPosX, oldPosY);
                    snakeCollection.get(i).setPos(newPosX, newPosY);
                }
                repaint();
                startTime = System.currentTimeMillis();
            }

            if (snake.getPosX() < 0 || snake.getPosX() >= SnakeGame.WINDOW_X) {
                gameState = State.GAME_OVER;
            } else if (snake.getPosY() < 0 || snake.getPosY() >= SnakeGame.WINDOW_Y) {
                gameState = State.GAME_OVER;
            }

            if (snakeCollection.get(0).getPosX() == candy.getPosX()
                    && snakeCollection.get(0).getPosY() == candy.getPosY()) {

                candy.generateNewPos();
                for (int i = 0; i < snakeCollection.size(); i++) {
                    if (candy.getPosX() == snakeCollection.get(i).getPosX()
                            && candy.getPosY() == snakeCollection.get(i).getPosY()) {
                        candy.generateNewPos();
                        i = 0;
                    }
                }

                Snake newSnake = new Snake(20, 20,
                        snakeCollection.get(snakeCollection.size() - 1).getPrevX(),
                        snakeCollection.get(snakeCollection.size() - 1).getPrevY());

                snakeCollection.add(newSnake);
            }

            for (int i = 0; i < snakeCollection.size(); i++) {
                if (i != 0) {
                    if (snakeCollection.get(0).getPosX() == snakeCollection.get(i).getPosX() &&
                            snakeCollection.get(0).getPosY() == snakeCollection.get(i).getPosY()) {
                        gameState = State.GAME_OVER;
                    }
                }
            }
        }

        if (gameState == State.GAME_OVER) {
            score = snakeCollection.size();
            System.out.println("Game Over! Score: " + score);
            System.exit(0);
        }

        for (int i = 0; i < snakeCollection.size(); i++) {
            if (i == 0) {
                g2.setColor(Color.BLUE);
            } else {
                g2.setColor(Color.CYAN);
            }

            g2.fillRect(snakeCollection.get(i).getPosX(), snakeCollection.get(i).getPosY(),
                    snakeCollection.get(i).getSizeX(), snakeCollection.get(i).getSizeY());
        }

        g2.setColor(Color.red);
        g2.fillRect(candy.getPosX(), candy.getPosY(), candy.getSizeX(), candy.getSizeY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Keyboard.isKeyPressed(KeyEvent.VK_W) && snakeDir != Dir.DOWN) {
            snakeDir = Dir.UP;
        } else if (Keyboard.isKeyPressed(KeyEvent.VK_A) && snakeDir != Dir.RIGHT) {
            snakeDir = Dir.LEFT;
        } else if (Keyboard.isKeyPressed(KeyEvent.VK_S) && snakeDir != Dir.UP) {
            snakeDir = Dir.DOWN;
        } else if (Keyboard.isKeyPressed(KeyEvent.VK_D) && snakeDir != Dir.LEFT) {
            snakeDir = Dir.RIGHT;
        }

        repaint();
    }
}
