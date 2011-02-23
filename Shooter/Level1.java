import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1  extends Level
{
    //Our world that was created
    private myWorld theWorld;
    //The player's ship
    private Ship ship;
    /**
     * Create level one with space as a background.
     */
    public Level1()
    {
        super();
        loadImages();
        
        background = new GreenfootImage("Backgrounds/space1.jpg");
        bg = new GreenfootImage("Backgrounds/space1.jpg");
        background = getSpaceBG();
        bg = getSpaceBG();
        ship = new Ship();
    }
    
    /**
     * Act - do whatever the Level1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scrollBackground();
    }    
    /**
     * This method is called by the Greenfoot system when this object has been inserted into the world.  Add's the players ship to the world,
     * set's the background, and stores the ships current x and y values.  
     * 
     * @param world The world this object was added to.
     */
    public void addedToWorld(World world)
    {
        theWorld = (myWorld) world;   
        theWorld.addObject(ship, 20, 200);
        theWorld.setBackground(background);
        ship.setXPose(20);
        ship.setYPose(200); 
        getImage().setTransparency(0);
    }
    
    private void loadImages()
    {
        Disk.loadImages();
        Fight.loadImages();
        Cloud.loadImages();
    }
    
    //Returns a greenfootImage that contains the space background for level1
    private GreenfootImage getSpaceBG()
    {
        //Temp variable to draw our background to and return with the worlds dimensions
        GreenfootImage space = new GreenfootImage(theWorld.getWorldWidth(), theWorld.getWorldHeight());
        //Loops by amounts equal to the space1.jpg image dimensions and draws it over greenfootImage space
        for(int i = 0; i <= theWorld.getWorldWidth(); i += background.getWidth())
        {
            for(int j = 0; j <= theWorld.getWorldHeight(); j += background.getHeight())
            {
                space.drawImage(background, i, j);
            }
        }
        //Return space
        return space;
    }
}
