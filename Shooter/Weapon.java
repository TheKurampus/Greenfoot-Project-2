import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class that represents a ships weapons.  A weapon can move foward, animate as well as check for a collision with an enemy.  Weapons will also
 * clean up after themselves so there is no need to manually remove the weapon from the game after a collision of any kind.
 * 
 * @author Bretton Murphy
 */
public class Weapon  extends Actor
{   
    /**
     * Array of greenfootImages for weapons animation
     */
    protected GreenfootImage[] images;

    /**
     * Weapons x position in the world
     */
    protected int xPose;

    /**
     * Weapons y position in the world
     */
    protected int yPose;

    /**
     * Weapons travel speed
     */
    protected int speed;
    
    protected Actor fired;

    protected double direction;
    
    /**
     * Weapons damage factor
     */
    protected int damage;  
    //Index for the images array.
    private int index = 0;
    //Slow down factor for weapon animation
    private int timer;
    //Temp slow down factor for weapon animation
    private int delay;
    /**
     * Create a weapon with specified position, speed, and images used for animation of the weapon.
     * Note that images used for animation must be in the form "nameOfImage0.png", "nameOfImage1.png" where the first image
     * must start with a 0 after the base name and continue in sequential order.
     * 
     * @param s Speed at which weapon travels.
     * @param x The x position of the weapon within the world.
     * @param y The y position of the weapon within the world.
     * @param weaponDelay The delay amount of a weapons animation.  A 0 will result in no delay.
     * @param baseName The base image name for the weapons animation.
     * @param numOfImages The number of images that are required for the animation.
     * @param suffix The images suffix in the form of ".png" 
     */
    public Weapon(int s, int x, int y, int weaponDelay, String baseName, int numOfImages, String suffix, Actor actor)
    {
        speed = s;
        xPose = x;
        yPose = y;
        delay = timer = weaponDelay;
        loadImages(baseName, numOfImages, suffix);
        fired = actor;
    }

    /**
     * Create a weapon with specified position and speed.  
     * 
     * @param s Speed at which weapon travels.
     * @param x The x position of weapon within the world.
     * @param y The y position of weapon within the world.
     */
    public Weapon(int s, int x, int y, double d, Actor actor)
    {
        speed = s;
        xPose = x;
        yPose = y;
        direction = d;
    }

    /**
     * Create a weapon with specified position, speed, slow down factor, and images for animation.  
     * 
     * @param s Speed at which weapon travels.
     * @param x The x position of weapon within the world.
     * @param y The y position of weapon within the world.
     * @param slow The slow down factor for weapon or how slow the animation will execute.
     */
    public Weapon(int s, int x, int y, double d, int slow, Actor actor)
    {
        speed = s;
        xPose = x;
        yPose = y;
        direction = d;
        delay = timer = slow;
        fired = actor;
    }
    //Load animation images for weapon into weapon array.  baseName - base name of image files. numOfImages - number of images 
    //suffix - image file extensions
    private void loadImages(String baseName, int numOfImages, String suffix)
    {
        //Initialize weapon array
        images = new GreenfootImage[numOfImages];
        //Store aniamtion images into wave array
        for(int i = 0; i < numOfImages; i++)
            images[i] = new GreenfootImage("Weapons/" + baseName + i + suffix);
    }
    //Removes this weapon from the world
    private void removeSelf()
    {
        getWorld().removeObject(this);
    }

    /**
     * Checks for a collision between this weapon and an enemy or the edge of screen.  If so, this weapon will remove itself from the world.
     */
    protected void checkCollisions()
    {
        //Check if this wave intersects an enemy in the world.  Must cast as an Enemy since the return is of type Actor.
        //Doing it this way also allows for me to manipulate enemy's data by calling function on it.  
        Actor actor = getOneIntersectingObject(null);

        if(actor != null)
        {
            if(Enemy.class.isInstance(actor) && Ship.class.isInstance(fired))
            {
                ((Enemy)actor).decreaseHealth(damage);
                removeSelf();
            }
            else if(Ship.class.isInstance(actor) && Enemy.class.isInstance(fired))
            {
                ((Ship)actor).takeDamage(damage);
                removeSelf();
            }
        }
        //Check to see if weapon has reached edge of screen
        else if(xPose >= getWorld().getWidth() || xPose <= 0 || yPose >= getWorld().getHeight() || yPose <= 0)
            removeSelf();
    }

    /**
     * Moves weapon forward.
     */
    protected void moveWeapon()
    {
        double dx = speed*Math.cos(direction);//+0.5 * Math.PI);
        double dy = speed*Math.sin(direction);//+0.5 * Math.PI);
        
        xPose += Math.round(dx);
        yPose += Math.round(dy);
        
        setLocation(xPose, yPose);
    }

    /**
     * Animates weapon using images from images array.
     */
    protected void animate()
    {
        //Slows down weapon animation so it doesn't execute too fast
        if(timer == 0)
        {
            index = (index + 1) % images.length;
            setImage(images[index]);
        }

        timer = (timer + 1) % delay;
    }
}
