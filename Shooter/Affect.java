import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class that represents in game effects.  Effects such as smoke or explosions. 
 * 
 * @author Bretton Murphy 
 */
public class Affect  extends Actor
{
    protected GreenfootImage[] images;    

    private int delay;
    private int timer;
    private int index = 0;
    
    /**
     * Creates an affect.
     * 
     * @param delayAmount The delay amount of an affect animation.  A 0 will result in no delay.
     */
    public Affect(int delayAmount)
    {
        timer = delay = delayAmount;
    }
    
    /**
     * Creates an affect that uses a series of images in order to animate itself and an amount by which to delay the animations by.  If the delay is set to 0
     * then there is no delay.
     * 
     * @param baseName The base image name for the weapons animation.
     * @param numOfImages The number of images that are required for the animation.
     * @param suffix The images suffix in the form of ".png" 
     * @param delayAmount The delay amount of an affect animation.  A 0 will result in no delay.
     */
    public Affect(String baseName, int numOfImages, String suffix, int delayAmount)
    {
        timer = delay = delayAmount;
        loadImages(baseName, numOfImages, suffix);    
    }

    /**
     * Animates an affect by cycling through it's images.
     */
    protected void animate()
    {
        if(timer == 0)
        {
            index = (index + 1) % images.length;
            setImage(images[index]);
        }
        
        timer = (timer + 1) % delay;
    }
    /**
     * Animates an affect by cycling through it's images only one time.  Once the animation completes the affect removes itself from the world.
     */
    protected void animateOnce()
    {
        if(timer == 0)
        {
            setImage(images[index]);
            
            if(index >= images.length-1)
                removeSelf();
                
            index = (index + 1) % images.length;
        }
        
        timer = (timer + 1) % delay;
    }
    
    //Load the required images for animation purposes.
    private void loadImages(String baseName, int numOfImages, String suffix)
    {
        images = new GreenfootImage[numOfImages];
        
        for(int i = 0; i < numOfImages; i++)
            images[i] = new GreenfootImage("Affects/" + baseName + i + suffix);
    }
    //Remove this affect from the world.
    private void removeSelf()
    {
        getWorld().removeObject(this);
    }
}
