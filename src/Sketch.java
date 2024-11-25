import processing.core.PApplet;

public class Sketch extends PApplet {

    /** Represents balls */
    private Ball ball1;
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;

    /** Represents bubbles */
    private Bubble b1;
    private Bubble b2;
    private Bubble b3;
    private Bubble b4; 

    /** Represents snowflakes */
    private Snowflake s1;
    private Snowflake s2; 
    private Snowflake s3; 
    private Snowflake s4;

    /**
     * This method can only be used to change the window size. It runs before the
     * window is created.
     */
    public void settings() {
        size(500, 500);
    }

    /* Generates random colors by choosing random RGB values */
    public int randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return color(r, g, b);  
    }

    /**
     * Runs once at the beginning of the program, after the window is created. Use
     * this to initialize the sketch.
     */
    public void setup() {

        /* Initializes the ball objects, with randomized colors*/
        ball1 = new Ball(this, 40, 400, 40, 1, 8);
        ball1.setColors(randomColor(),randomColor());
        ball2 = new Ball(this,20, 300, 20, 1, 5);
        ball2.setColors(randomColor(),randomColor());
        ball3 = new Ball(this,12,200,10,30,6);
        ball3.setColors(randomColor(),randomColor());
        ball4 = new Ball(this, 15,100,30,1,3);
        ball4.setColors(randomColor(),randomColor());

        /* Initializes bubble objects */
        b1 = new Bubble(this, 20, 100, 10, 0.006f, -2);
        b1.setColors(256,0);
        b2 = new Bubble(this, 50, 300, 5, 0.008f, -3);
        b2.setColors(256,0);
        b3 = new Bubble(this,10,400,50,0.008f,-5 );
        b3.setColors(256,0);
        b4 = new Bubble(this, 30,250 ,30,0.006f,-1);
        b4.setColors(256, 0);

        /* Initializes snowflake objects */ 
        s1 = new Snowflake(this, 20, 30, 10, 0.895f, 4);
        s2 = new Snowflake(this, 10, 20, 10, 0.800f, 3 );
        s3 = new Snowflake(this, 6, 20, 40, 0.800f,3 );
        s4 = new Snowflake(this, 30, 40, 20, 0.600f, 1);
    }

    /**
     * This method runs over and over and over, approximately 60 times per second!
     * By moving objects a tiny bit each frame, you can get the appearance of
     * movement.
     */
    public void draw() {
        background(255, 230, 255);

        /* Draw and move balls */
        ball1.draw();
        ball1.move();
        ball2.move();
        ball2.draw();
        ball3.draw();
        ball3.move();
        ball4.move();
        ball4.draw();

        /* Draw and move bubbles */
        b1.move();
        b1.draw();
        b2.move();
        b2.draw();
        b3.draw();
        b3.move();
        b4.draw();
        b4.move();

        /* Draw and move snowflakes */   
        s1.move();
        s1.draw();
        s2.draw();
        s2.move();
        s3.move();
        s3.draw(); 
        s4.move();
        s4.draw();
    }

    /* Detects mouse clicks and checks if it clicks the bubble.
     * if the mouse coordinates are within a bubble, the pop
     * method will pop the bubble
     * Learned from https://processing.org/reference/mousePressed_.html
     */
     public void mousePressed() {
        if (b1.contains(mouseX, mouseY)) {
            b1.pop();
        }
        if (b2.contains(mouseX, mouseY)) {
            b2.pop();
        }
        if (b3.contains(mouseX, mouseY)) {
            b3.pop();
        }
        if (b4.contains(mouseX, mouseY)) {
            b4.pop();
        }
    }

    /** All processing sketches have to use this main method. Don't touch this! */
    public static void main(String[] args) {
        PApplet.main("Sketch");
    }
}
