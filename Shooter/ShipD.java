import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shipD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShipD  extends Affect
{
    private static GreenfootImage images[];    

    public ShipD()
    {
        super(images.length);
        super.images = this.images;
        setImage("Affects/shipD0.png");
        Greenfoot.playSound("sounds/shipD.wav");
    }
    /**
     * Act - do whatever the shipD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateOnce();
    }    
    
    public static void loadImages()
    {
        images = new GreenfootImage[10];
        
        for(int i = 0; i < images.length; i++)
            images[i] = new GreenfootImage("Affects/shipD" + i + ".png");
    }
}
