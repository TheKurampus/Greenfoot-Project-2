import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Twin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Twin  extends Weapon
{
    /**
     * Create a Twin laser weapon with the specified location and speed.
     * 
     * @param s The speed that Twin travels.
     * @param x The x location within the world.
     * @param y The y location within the world.
     */
    public Twin(int s, int x, int y, double d, Actor actor)
    {
        super(s, x, y, d, actor);
        setImage("Weapons/twin.png");
        damage = 2;  
        Greenfoot.playSound("Laser.wav");
    }
    /**
     * Act - do whatever the Twin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveWeapon();
        checkCollisions();
    }    
}
