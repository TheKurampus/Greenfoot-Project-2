import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Default here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Single  extends Weapon
{
    /**
     * Create a single laser weapon with the specified location and speed.
     * 
     * @param s The speed that single travels.
     * @param x The x location within the world.
     * @param y The y location within the world.
     */
    public Single(int s, int x, int y, double d, Actor actor)
    {
        super(s, x, y, d, actor);
        setImage("Weapons/single.png");
        damage = 1;  
        Greenfoot.playSound("Laser.wav");
    }
    
    /**
     * Act - do whatever the Level1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveWeapon();
        checkCollisions();
    }
}
