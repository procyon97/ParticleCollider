import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Klasa abstrakcyjna rigidBody (bryly sztywnej)
 */
public abstract class RigidBody {
    protected double x, y;
    protected double xVelocity, yVelocity, velocity;
    protected int radius;
    protected int ID;
    /** Licznik kolizji */
    protected int collisionCounter = 0;
    /** Maksymalny promien przeszkod */
    public int maxObstacleRadius = 100;

    /**
     * Rysowanie RigidBody
     * Wlaczane jest wygladzanie krawedzi, wybierany kolor wnetrza czasteczki, kolor ramki oraz wypisywane na niej wlasnego ID
     */
     public void draw(Graphics g,  Color color){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
        g.setColor(Color.black);
        g.drawOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
        String ID = Integer.toString(this.ID);
        g.drawString(ID, (int) x - 5, (int) y + 5);
    }

    /**
     * Zmiana rozmiaru RigidBody
     */
    public abstract void changeSize();

    /**
     * Poruszanie sie RigidBody
     */
    public abstract void move();

    /**
     * Warunek zabicia RigidBody
     */
    public abstract boolean kill();


    public void setXPosition(double newX) {
        this.x = newX;
    }

    public void setYPosition(double newY) {
        this.y = newY;
    }

    public void setXVelocity(double newXVelocity) {
        this.xVelocity = newXVelocity;
    }

    public void setYVelocity(double newYVelocity) {
        this.yVelocity = newYVelocity;
    }

    public double getXPosition() {
        return x;
    }

    public double getYPosition() {
        return y;
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public int getRadius() { return radius; }

    public int getMaxObstacleRadius() {return maxObstacleRadius; }
}


