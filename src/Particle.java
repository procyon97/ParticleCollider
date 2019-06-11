import java.awt.*;

/**
 * Klasa cząstki
 */

public class Particle extends RigidBody {

    //Konstruktor Particle z niezbędnymi parametrami
    public Particle(double x, double y, int radius, double velocity, double angle, int ID) {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.xVelocity = velocity * Math.cos((angle * Math.PI) / 180);
        this.yVelocity = velocity * Math.sin((angle * Math.PI) / 180);
        this.radius = radius;
        this.ID = ID;
    }

    //Metoda rysująca Particle
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.RED);
        g.fillOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
        g.setColor(Color.black);
        g.drawOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
        String ID = Integer.toString(this.ID);
        g.drawString(ID, (int) x - 5, (int) y + 5);
    }

    //Metoda od ruchu Particle
    public void move() {

        x += xVelocity;
        y += yVelocity;


        //Zachowanie przy zderzeniu ze ścianą
        if (x + radius + 2 > 1000) {
            xVelocity = -xVelocity;
            x = 1000 - radius - 2 - 1;

        } else if (x - radius < 0) {
            xVelocity = -xVelocity;
            x = radius + 2;
        }
        if (y + radius > 1000) {
            yVelocity = -yVelocity;
            y = 1000 - radius - 2 - 1;

        } else if (y - radius < 0) {
            yVelocity = -yVelocity;
            y = radius + 2;
        }

    }

    //Metoda od zmiany rozmiaru
    public void changeSize(){
        radius--;
    }

    //Metoda sprawdzająca czy Particle może zostać zabity
    public boolean kill(){
        if (radius <= 2){
            return true;
        }
        return false;
    }


}