import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends Actor
{
    /**
     * GreenfootImage to hold the background image used for the level.
     */
    protected GreenfootImage background;
    /**
     * GreenfootImage to hold the redrawn background each time we scroll.  
     */
    protected GreenfootImage bg;
    
    //The current scrolling position in game
    private int scrollPos;
    
    public Level()
    {
       scrollPos = myWorld.getWorldWidth();
    }
    
    //Redraws the background image onto bg to give us the scrolling effect.  Takes one int or the scrollPosition
    protected void scrollBackground()
    {
        scrollPos -= 1;
        
        bg.drawImage(background, scrollPos - myWorld.getWorldWidth(), 0);  //Redraw background onto bg.  Makes the new addition move from right to left
        bg.drawImage(background, scrollPos, 0);
        getWorld().setBackground(bg);  //set the worlds background to new background
        //Redraw what was already on bg plus the new addition to bg to get the whole image scrolling 
        if(scrollPos <= 0) 
            scrollPos = myWorld.getWorldWidth();
    }
}
