
class Bubble {
    
   /** The sketch that the bubble is inside */
   private Sketch s;
   /** the radius of the bubble */
   private float radius;
   private float x;
   private float y;
   /** The number of pixels the bubble moves right per frame */
   private float xSpeed;
   /** The number of pixels the bubble moves down per frame */
   private float ySpeed;
   /** The color of the inside of the bubble */
   private int fillColor;
   /** The color of the outside of the bubble */
   private int borderColor;
   /** Checks if the bubble has been popped */
   private boolean popped; 
   /** Saves inital coordinates to reset bubble */
   private float xinitial;
   private float yinitial;

    /* Default constructor that initializes bubble and sets it to sketch */
    public Bubble(Sketch sketch) {
        s = sketch;
        radius = 20;
        x = 100;
        y = 100;
        xSpeed = 2;
        ySpeed = -1;
        fillColor = s.color(255, 100, 100);
        borderColor = s.color(0, 0, 0);
        popped = false;
        xinitial = 100;
        yinitial = 100;
    }

    /* Constructor allows for the editing of the bubble's properties */
    public Bubble(Sketch sketch, float radius, float x, float y, float xspeed, float yspeed) {
        this.s = sketch;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.xSpeed = xspeed;
        this.ySpeed = yspeed;
        this.popped = false;
        this.xinitial = x;
        this.yinitial = y;
    }

    // accessors for the radius, diameter, x, and y values 
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

    /* "Pops" the bubble, making it disappear */
    public void pop() {
        popped = true;
        respawn();
    }

    /* Checks if mouse clicks are on the bubble 
     * s.dist is the distance between the coordinates 
     * of the mouse and the coordinates of the bubble
     */
    public boolean contains(float mx, float my) {
        float distance = s.dist(mx, my, x, y);
        return distance < radius;
    }

    /* Draws bubble if not popped */
    public void draw() {
        if(!popped){
            s.stroke(borderColor);
            s.fill(fillColor);
            s.circle(x, y, radius*2);
        } 
    }

    /* Sets border and fill color */
    public void setColors(int fill, int border){
        borderColor = border;
        fillColor = fill; 
    }

    /* Moves circle if bubble is not popped */
    public void move() {
        if(!popped){
            x = x + xSpeed;
            y = y + ySpeed;
            if (x > s.width - radius) {
                x = radius;
            } 
            if (x < radius) {
                x = s.width - radius;
            } 
            if (y > s.height - radius) {
                y = radius;
            } 
            if (y < radius) {
            y = s.height - radius;
            }
        }
    }
    
    /* Resets bubbles to initial coordinates
     * As if bubble had not been popped
     */
    public void respawn(){
        x = xinitial; 
        y = yinitial; 
        popped = false;            
    }
}
