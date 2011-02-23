import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy  extends Actor
{
    //Array of greenfootImage's for enemy's animation
    protected GreenfootImage[] images;

    //This enemy's health 
    protected int health;
    
    //Index for move array and slowDown factors so animation doesn't move so fast
    private int index = 0;
    private int delay;
    private int timer;
    
    private int sDelay = 100;
    private int sTimer;
    
    public Enemy(int theDelay)
    {
        delay = timer = theDelay;
        sTimer = sDelay;
    }
    
    /**
     * Creates an Enemy with images for animation.
     * 
     * @param baseName  The base name of the image files to be loaded.
     * @param numOfImages  The number of images to be loaded.
     * @param suffix  The image type.  I.e. ".png" 
     */
    public Enemy(String baseName, int numOfImages, String suffix, int theDelay)
    {
        loadImages(baseName, numOfImages, suffix);
        delay = timer = theDelay;
        sTimer = sDelay;
    }  
    
    public void act()
    {
        animate();
        
        if(sTimer <= 0)
        {
            shoot();
            sTimer = sDelay;
        }
        else
            sTimer--;
    }

    //Loads the animation images for this enemy into move array.  
    //baseName - Base name of image files.  numOfImages - Number of images.  suffix - ".png", ".jpg" etc
    private void loadImages(String baseName, int numOfImages, String suffix)
    {
        //Instantiate move 
        images = new GreenfootImage[numOfImages];
        //Loop through move and store all the greenfootImages needed for animation
        for(int i = 0; i < numOfImages; i++)
        { 
            images[i] = new GreenfootImage("Enemy/" + baseName + i + suffix);
        }     
    }
    
    /**
     * Decreases this enemy's health equal to amount.
     * 
     * @param amount The amount of health subtracted from this enemy
     */
    public void decreaseHealth(int amount)
    {
        health -= amount;
        if(health <= 0)
            destruct();
    }
    /**
     * Removes this from the world.
     */
    private void removeSelf()
    {
        getWorld().removeObject(this);
    }
    /**
     * Determines whether or not to destroy this based on health.  If health is less than one this will be removed.
     */
    protected void destruct()
    {
        //Add a destruction cloud object where the enemy dies
        getWorld().addObject(new Cloud(), getX(), getY());
        Greenfoot.playSound("Destruct.wav");
        removeSelf();
    }
    /**
     * Animates this enemy 
     */
    protected void animate()
    {
        //Slows down the animation so it's not too fast
        if(timer == 0)
        {
            index = (index + 1) % images.length;  
            setImage(images[index]);  
        }
        //Check the moveSlowDown factor and either decrement it or reset it
        timer = (timer + 1) % delay;
    }
    
    protected void shoot()
    {
        int x = getX();
        int y = getY();
        
        getWorld().addObject(new Bullet(10, x, y, Math.atan2((Ship.yPose()-y) , (Ship.xPose()-x)), this), x, y);
    }
}
