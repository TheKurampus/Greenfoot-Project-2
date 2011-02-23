import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Special here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Special  extends PowerUp
{
    private static GreenfootImage images[];
    
    public Special()
    {
        super(images.length * 2);
        super.images = this.images;
        setImage("PowerUps/special0.png");
    }
    
    /**
     * Act - do whatever the Special wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
    }    
    
    public static void loadImages()
    {
        images = new GreenfootImage[4];
        
        for(int i = 0; i < images.length; i++)
            images[i] = new GreenfootImage("PowerUps/special" + i + ".png");
    }
    
    public void powerShip(Ship ship)
    {
        removeSelf();
    }
}
