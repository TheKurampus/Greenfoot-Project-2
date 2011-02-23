import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health  extends Actor
{
    private static GreenfootImage healthFrame = new GreenfootImage("healthFrame.png");
    private static GreenfootImage healthBar = new GreenfootImage("healthBar.png");
    private GreenfootImage temp;
    
    private int healthCap = 4;
    private int currentHealth = 4;
    
    private int frameWidth;
    
    public Health()
    {
        temp = new GreenfootImage("healthBar.png");
        temp.drawImage(healthFrame, 0, 0);
        
        setImage(temp);
        
        frameWidth = healthFrame.getWidth();
    }
    
    public boolean depleted()
    {
        if(currentHealth <= 0)
            return true;
        return false;
    }
    
    public void recieveDamage(int amount)
    {
        drawBar(-amount);
    }
    
    public void recieveHealth(int amount)
    {
        drawBar(amount);
    }
    
    private void drawBar(int amount)
    {
        if(currentHealth+amount <= healthCap && currentHealth+amount >= 0)
            currentHealth += amount;
        else if(currentHealth+amount < 0)
            currentHealth = 0;
        else 
            currentHealth = healthCap;
            
        temp.clear();
        temp.drawImage(healthBar, (frameWidth/healthCap)*currentHealth-frameWidth, 0);
        temp.drawImage(healthFrame, 0, 0);
    }
}
