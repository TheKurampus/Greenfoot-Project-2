import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exp  extends PowerUp
{
    private static GreenfootImage images[];

    private int expAmount = 25;
    
    public Exp()
    {
        super(images.length * 2);
        super.images = this.images;
        setImage("PowerUps/power0.png");
    }
    
    /**
     * Act - do whatever the Exp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
    }
    
    public void contact()
    {
        removeSelf();
    }
    
    public static void loadImages()
    {
        images = new GreenfootImage[4];
        
        for(int i = 0; i < images.length; i++)
            images[i] = new GreenfootImage("PowerUps/power" + i + ".png");
    }
    
    public int expAmount()
    {
        return expAmount;
    }
}
