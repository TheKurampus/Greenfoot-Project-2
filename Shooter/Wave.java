import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wave  extends Weapon
{
    private static GreenfootImage[] images;
    
    /**
     * Create a Wave laser weapon with the specified location and speed.
     * 
     * @param s The speed that Wave travels.
     * @param x The x location within the world.
     * @param y The y location within the world.
     */
    public Wave(int s, int x, int y, double d, Actor actor)
    {
        super(s, x, y, d, 3, actor);
        super.images = this.images;
        setImage("Weapons/wave0.png");
        damage = 1;
        Greenfoot.playSound("Wave.wav");
    }
    
    /**
     * Act - do whatever the Wave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveWeapon();
        animate();
        checkCollisions();
    }    
    
    public static void loadImages()
    {
        images = new GreenfootImage[18];
        
        for(int i = 0; i < 18; i++)
            images[i] = new GreenfootImage("Weapons/wave" + i + ".png");
    }
}
