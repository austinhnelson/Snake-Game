import java.util.Random;

public class Candy {

    private int sizeX;
    private int sizeY;
    private int posX;
    private int posY;

    public Candy(int sizeX, int sizeY) {
        generateNewPos();
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void generateNewPos() {
        Random rand = new Random();

        int xUpperBound = SnakeGame.WINDOW_X - (2 * sizeX);
        int yUpperBound = SnakeGame.WINDOW_Y - (2 * sizeY);

        int newPosX;
        int newPosY;

        newPosX = rand.nextInt(xUpperBound - 20) + 1;
        newPosY = rand.nextInt(yUpperBound - 20) + 1;

        while (newPosX % 21 != 1 && newPosX != 400) {
            newPosX = rand.nextInt(xUpperBound);
        }
        while (newPosY % 21 != 1 && newPosY != 400) {
            newPosY = rand.nextInt(yUpperBound);
        }

        posX = newPosX;
        posY = newPosY;

    }
}
