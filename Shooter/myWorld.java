import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author Bretton Murphy
 */
public class myWorld  extends World
{
    //The worlds diminsions 
    private static final int WORLD_WIDTH = 550;
    private static final int WORLD_HEIGHT = 400;
    private static final int CELL_SIZE = 1;

    /**
     * Constructor for objects of class myWorld.
     * 
     */
    public myWorld()
    {    
        super(WORLD_WIDTH, WORLD_HEIGHT, CELL_SIZE, false); 
        levelSwitch(1);  //Start up level one

        prepare();
    }

    /**
     * Returns the width of the world.
     * 
     * @return The width of the world.
     */
    public static int getWorldWidth()
    {
        return WORLD_WIDTH;
    }

    /**
     * Returns the height of the world
     * 
     * @return The height of the world.
     */
    public static int getWorldHeight()
    {
        return WORLD_HEIGHT;
    }
    //Cleans up theWorld by grabbing all objects and deleting them
    private void cleanWorld()
    {
        removeObjects(getObjects(null));
    }
    //Controls which level get loaded into the world.  Levels are actors that get added as an object.
    private void levelSwitch(int whichLvl)
    {
        cleanWorld();  //Clear everything within our world first.

        switch(whichLvl)
        {
            case 1: //Level one
            addObject(new Level1(), 0, 0); 
            break;   
            default: 
            System.err.println("Error switching to level " + whichLvl);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Disk disk = new Disk();
        addObject(disk, 395, 133);
    }
}
