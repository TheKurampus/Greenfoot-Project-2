import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet  extends Weapon
{
    public Bullet(int s, int x, int y, double d, Actor actor)
    {
        super(s, x, y, d, actor);
        setImage("Weapons/bullet.png");
        damage = 1;  
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveWeapon();
        checkCollisions();
    }
    
}
