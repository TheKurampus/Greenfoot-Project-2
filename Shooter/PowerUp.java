import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp  extends Actor
{
    protected GreenfootImage images[];
    
    private int timer;
    private int delay;
    
    private int index = 0;
    
    public PowerUp(int delayAmount)
    {
        timer = delay = delayAmount;
    }
    
    /**
     * Act - do whatever the PowerUps wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void powerShip(Ship ship)
    {
    }
    
    protected void removeSelf()
    {
        getWorld().removeObject(this);
    }

    protected void animate()
    {
        //Slows down animation so it doesn't execute too fast
        if(timer == 0)
        {
            index = (index + 1) % images.length;
            setImage(images[index]);
        }

        timer = (timer + 1) % delay;
    }
}
