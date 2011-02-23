import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fight  extends Enemy
{
    private static GreenfootImage images[];
    /**
     * Create a Fight enemy with one health.
     */
    public Fight()
    {
        super(images.length);
        super.images = this.images;
        setImage("Enemy/fight0.png");
        health = 1;
    }

    /**
     * Act - do whatever the Fight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
    }    

    public static void loadImages()
    {
        images = new GreenfootImage[6];
        
        for(int i = 0; i < images.length; i++)
            images[i] = new GreenfootImage("Enemy/fight" + i + ".png");
    }
}
