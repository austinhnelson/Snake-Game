public class Snake {

    private int sizeX;
    private int sizeY;
    private int posX;
    private int posY;
    private int prevX;
    private int prevY;

    public Snake(int sizeX, int sizeY, int posX, int posY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.posX = posX;
        this.posY = posY;
        prevX = this.posX;
        prevY = this.posY;
    }

    public void updatePrev(int posX, int posY) {
        prevX = this.posX;
        prevY = this.posY;
    }

    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPrevX() {
        return prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void incrementPosX() {
        prevX = posX;
        prevY = posY;
        this.posX += sizeX + 1;
    }

    public void decrementPosX() {
        prevX = posX;
        prevY = posY;
        this.posX -= sizeX + 1;
    }

    public void incrementPosY() {
        prevX = posX;
        prevY = posY;
        this.posY += sizeY + 1;
    }

    public void decrementPosY() {
        prevX = posX;
        prevY = posY;
        this.posY -= sizeY + 1;
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

}
