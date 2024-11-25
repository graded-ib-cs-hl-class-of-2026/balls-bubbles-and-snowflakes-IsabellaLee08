class Ball {

    /*
     * In Processing, the Sketch works a lot like the World in the turtles. You
     * can't
     * draw a ball without knowing which sketch to draw it on, so you always need to
     * specify the sketch for a Ball object.
     */

    /** The sketch that the ball is inside */
    private Sketch s;
    /** the radius of the ball */
    private float radius;
    private float x;
    private float y;
    /** The number of pixels the ball moves right per frame */
    private float xSpeed;
    /** The number of pixels the ball moves down per frame */
    private float ySpeed;
    /** The color of the inside of the ball */
    private int fillColor;
    /** The color of the outside of the ball */
    private int borderColor;

    /** Empty constructor to keep the defaults. Only sets up our link. */
    public Ball(Sketch sketch) {
        s = sketch;
        radius = 20;
        x = 100;
        y = 100;
        xSpeed = 2;
        ySpeed = -1;
        fillColor = s.color(255, 100, 100);
        borderColor = s.color(0, 0, 0);
    }

    /** Fully specified constructor to allow changes to size, position, speed */
    /** Does NOT allow changing color! Need to use setColors() for that. */
    public Ball(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
    }

    // Accessors (getters) go here

    public float getRadius() {
        return radius;
    }

    public float getDiameter() {
        return radius * 2;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /* Randomizes colors with Math.random(),
    * setting a random value for r,g, and b 
    * Randomization from: https://www.w3schools.com/java/java_howto_random_number.asp 
    */
    public int randomColor() {
        int r = (int) (Math.random() * 255);
        int g = (int) (Math.random() * 255);
        int b = (int) (Math.random() * 255);
        return s.color(r, g, b);  
    }

    // Setters that you need go here - by default, only colors
    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }

    /**
     * Draws the ball on the given sketch
     */
    public void draw() {
        s.stroke(borderColor);
        s.fill(fillColor);
        s.circle(x, y, radius * 2);
    }

    /* Tracks if the ball is frozen */
    boolean isFrozen = false; 

    /**
     *  Sets frozen state of the ball, if frozen = true,
     * it will not move */
    public void frozen(boolean state) {
        isFrozen = state;
    }

     /**
     * Moves the ball so that the next time it draws it will be in a different place, 
     * unless it is frozen
     */
    public void move() {
        if (!isFrozen) {
            x = x + xSpeed;
            y = y + ySpeed;
            
            if (x > s.width - radius || x < radius) {
                xSpeed = -xSpeed;
            }
            if (y > s.height - radius || y < radius) {
                ySpeed = -ySpeed;
            }
        }

        /**
        * Checks if mouse is within ball radius so that if it is,
        * it freeses and changes colors randomly.
        * Unfreezes when mouse is away from ball area.
        */
        if (Sketch.dist(s.mouseX, s.mouseY, x, y) < radius) {
            frozen(true);
            setColors(randomColor(), randomColor());
        } else {
            frozen(false);
        }
    }

    /* 
     * sets that when mouse is pressed inside the ball's area
     * the balls freezes and randomizes its colors 
     * From: https://processing.org/reference/mousePressed_.html
     */
    public void mousePressed() {
        if (Sketch.dist(s.mouseX, s.mouseY, x, y) < radius) {
            frozen(true); 
            setColors(randomColor(), randomColor());
        }
    }

    /* 
     * sets that when mouse is released, it does not freeze. 
     * From: https://processing.org/reference/mouseReleased_.html
     */
    public void mouseReleased() {
        frozen(false); 
    }
}