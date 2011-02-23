 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An effect object that animates itself so that a puff of smoke appears when added to the world.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cloud  extends Affect
{
    private static GreenfootImage images[];
    
    /**
     * Creates a Cloud object
     */
    public Cloud()
    {
        super(images.length);
        super.images = this.images;
        setImage("Affects/cloud0.png");
    }
    /**
     * Act - do whatever the Cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateOnce();
    }    
    
    public static void loadImages()
    {
        images = new GreenfootImage[3];
        
        for(int i = 0; i < images.length; i++)
            images[i] = new GreenfootImage("Affects/cloud" + i + ".png");
    }
}
