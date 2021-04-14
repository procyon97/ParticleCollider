import java.awt.*;

/**
 * Class responsible for drawing background.
 */
public class Environment {
    private int xStart, xEnd, yStart, yEnd;
    private Color fill, frame;

    /**
     * Construct for drawing background.
     */
    public Environment(int x, int y, int width, int height, Color fill, Color frame) {
        xStart = x;
        yStart = y;
        xEnd = x + width - 1;
        yEnd = y + height - 1;
        this.fill = fill;
        this.frame = frame;
    }
    /**
     * Method that draws background.
     */
    public void draw(Graphics g) {
        g.setColor(fill);
        g.fillRect(xStart, yStart, xEnd - xStart - 1, yEnd - yStart - 1);
        g.setColor(frame);
        g.drawRect(xStart, yStart, xEnd - xStart - 1, yEnd - yStart - 1);
    }
}
