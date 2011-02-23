import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Experience here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Experience extends Actor
{
    private static GreenfootImage xpFrame = new GreenfootImage("xpFrame.png"); 
    private static GreenfootImage xpBar = new GreenfootImage("xpBar.png");
    private GreenfootImage temp;
    
    private int xpCap = 100;
    private int currentXp = 0;
    
    private int frameWidth;
    
    public Experience()
    {
        temp = new GreenfootImage("xpFrame.png");
        setImage(temp);
        
        frameWidth = xpFrame.getWidth();
    }
    
    public boolean levelUp()
    {
        if(currentXp >= xpCap)
            return true;
        return false;
    }
    
    public void recieveExp(Exp exp)
    {  
        drawBar(exp.expAmount());
        exp.contact();
    }
    
    private void drawBar(int amount)
    {
        currentXp += amount;
        
        if(currentXp >= xpCap)
        {
            getImage().clear();
            getImage().drawImage(xpFrame, 0, 0);
            xpCap += amount;
            currentXp = 0;
        }
        else
        {
            temp.clear();
            temp.drawImage(xpBar, (frameWidth/(xpCap/amount))*(currentXp/amount)-frameWidth, 0);
            temp.drawImage(xpFrame, 0, 0);
        }
    }
}
