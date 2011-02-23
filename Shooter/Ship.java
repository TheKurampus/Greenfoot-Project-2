import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class that represents a players ship.  The ship can fire weapons and move about the screen.  Should a collision occur between the ship and 
 * an enemy the ship will destroy itself.
 * 
 * @author Bretton Murphy  
 */
public class Ship  extends Actor
{   
    //Ships x and y location
    private static int xPose; 
    private static int yPose;
    
    //The edges of the world.  Used to keep the ship from partially going off screen
    private int bottomBounds;
    private int topBounds;
    private int rightBounds;
    private int leftBounds;
    //The ship's speed
    private int speed = 3;
    //Slow down factor for ships fire rate
    private int shootSlow = 7;

    //Which weapon is equiped right now
    private String weapon = "twin";
    //Key checkers
    private Greenfoot horizontal, vertical, shoot;
    //Our world that was created
    private myWorld theWorld;
    
    private Experience exp;
    private Health health;

    /**
     * Create a ship
     */
    public Ship()
    {
        //Get and store the edges of the world
        bottomBounds = theWorld.getWorldHeight() - (getImage().getHeight() / 2);
        topBounds = getImage().getHeight() / 2;
        rightBounds = theWorld.getWorldWidth() - (getImage().getWidth() / 2);
        leftBounds = getImage().getWidth() / 2;
        loadWeapons();
        exp = new Experience();
        health = new Health();
    }

    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkCollision();
    }
    
    public static int xPose()
    {
        return xPose;
    }
    
    public static int yPose()
    {
        return yPose;
    }

    /**
     * Set's the xPose of the ship in the world.
     * 
     * @param x The x position in the world.
     */
    public void setXPose(int x)
    {
        xPose = x;
    }

    /**
     * Set's the yPose of the ship in the world.
     * 
     * @param y The y position in the world.
     */
    public void setYPose(int y)
    {
        yPose = y;
    }

    /**
     * Set's the speed of the ship.
     * 
     * @param s The speed the ship will fly at.
     */
    public void setSpeed(int s)
    {
        speed = s;
    }

    /**
     * This method is called by the Greenfoot system when the object has been inserted into the world.
     * 
     * @param world The world this object was added to.
     */
    public void addedToWorld(World world)
    {
        theWorld = (myWorld) world;    
        theWorld.addObject(exp, 150, 20);
        theWorld.addObject(health, 150, 10);
    }
    
    public void takeDamage(int amount)
    {
        health.recieveDamage(amount);
    }

    //Removes "this" from the world
    private void removeSelf()
    {
        theWorld.addObject(new ShipD(), getX(), getY());
        theWorld.removeObject(this);
    }

    //Check for key presses that control the ship
    private void checkKeys()
    {
        //Move ship right or left if right or left arrows are held down
        if(horizontal.isKeyDown("d") && xPose <= rightBounds)
            setLocation(xPose += speed, yPose);
        else if(horizontal.isKeyDown("a") && xPose >= leftBounds)
            setLocation(xPose -= speed, yPose);

        //Move ship up or down if up or down arrows are held down
        if(vertical.isKeyDown("w") && yPose >= topBounds)
            setLocation(xPose, yPose -= speed);
        else if(vertical.isKeyDown("s") && yPose <= bottomBounds)
            setLocation(xPose, yPose += speed);

        //Shoot ship's gun if z is held down
        if(shoot.isKeyDown("j") && shootSlow == 7)
            fire(weapon);

        //Decrement shoot factor to slow down shooting 
        shootSlow--;
        if(shootSlow <=0)
            shootSlow = 7;
    }
    //Fires the ships weapon.  Which weapon depends on what is passed to String parameter whichWeapon
    private void fire(String whichWeapon)
    {
        //Fire appropriate weapon based on string.  Add the object just in front of the ship by 20 pixels
        if(whichWeapon == "bullet")
            theWorld.addObject(new Bullet(10, xPose+20, yPose, 0, this) , xPose+20, yPose);
        else if(whichWeapon == "single")
            theWorld.addObject(new Single(10, xPose+20, yPose, 0, this) , xPose+20, yPose); 
        else if(whichWeapon == "twin")
            theWorld.addObject(new Twin(10, xPose+20, yPose, 0, this) , xPose+20, yPose); 
        else if(whichWeapon == "wave")
            theWorld.addObject(new Wave(10, xPose+20, yPose, 0, this) , xPose+20, yPose); 
    }

    private void loadWeapons()
    {
        Wave.loadImages();
        ShipD.loadImages();
        Special.loadImages();
        Exp.loadImages();
    }
    
    
    /**
     * Checks for a collision between the ship and other stuff in the world.
     */
    protected void checkCollision()
    {
        
        Actor actor = getOneIntersectingObject(null);

        if(actor !=  null)
        {
            if(Enemy.class.isInstance(actor))
            {
                ((Enemy)actor).decreaseHealth(1);
                health.recieveDamage(2);
                
                if(health.depleted())
                    removeSelf();
            }
            else if(Exp.class.isInstance(actor))
                exp.recieveExp((Exp)actor);   
        }
    }
    
}
