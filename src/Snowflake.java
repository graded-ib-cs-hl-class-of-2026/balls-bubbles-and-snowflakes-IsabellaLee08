
class Snowflake {
    /** Sketch that snowflake is inside*/
    private Sketch s;
    /** Radius of snowflake*/
    private float radius;
    private float x;
    private float y;
    /** Number of pixels snowflake moves right per frame*/
    private float xSpeed;
    /** Number of pixels snowflake moves down per frame */
    private float ySpeed; 
    /** Inside color of Snowflake  */
    private float fillColor;
    /** Outside color of Snowflake  */
    private float borderColor; 

 
    /** Constructor for creating a Snowflake object.*/
    public Snowflake(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
    }
    // Accessor methods (getters) 
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

    // Setters that you need go here - by default, only colors

    public void setColors(int fill, int border) {
        borderColor = border;
        fillColor = fill;
    }
    
    /* Moves the snowflake */
    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;
        if (x > s.width - radius) {
            x=0;
        }
        if (y > s.height - radius) {
            y=0;
        }
    }

    /* Draws the snowflake */ 
    public void draw() {
        s.line(x+radius,y,x-radius,y);
        s.line(x,y+radius,x,y-radius);
        s.line(x+radius*.707f,y+radius*.707f,x-radius*.707f,y-radius*.707f);
        s.line(x+radius*.707f,y-radius*.707f,x-radius*.707f,y+radius*.707f);
    }
}
