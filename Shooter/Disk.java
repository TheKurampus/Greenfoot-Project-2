import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Disk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disk  extends Enemy
{
    private static GreenfootImage images[];
    /**
     * Create a Disk enemy with one health
     */
    public Disk()
    {
        super(images.length);
        super.images = this.images;
        setImage("Enemy/disk0.png");
        health = 1;
    }
    /**
     * Act - do whatever the Disk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }  

    public static void loadImages()
    {
        images = new GreenfootImage[6];
        
        for(int i = 0; i < images.length; i++)
            images[i] = new GreenfootImage("Enemy/disk" + i + ".png");
    }
}
