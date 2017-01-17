import java.awt.*;
import java.awt.image.*;
import java.net.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.*;

///////////////////////////////////
///////////////////////////////////
// CLASS GameWorld
///////////////////////////////////
///////////////////////////////////
public class GameWorld
{
    public final static int CELL_WIDTH = 14;
    public final static int CELL_HEIGHT = 14;
    public final static int CELL_HGAP = 6;
    public final static int CELL_VGAP = 6;
    public final static int WORLD_WIDTH = 20;
    public final static int WORLD_HEIGHT = 20;

    private Cell[][] map;
    public PackMan packMan;
    
    AudioClip eatenSound, eatingSound, bumpingSound;

    //GAMEWORLD
    public GameWorld( AudioClip eatenSound, AudioClip eatingSound, AudioClip bumpingSound)
    {
        map = new Cell[WORLD_HEIGHT][WORLD_WIDTH];
        for(int y=0; y<WORLD_HEIGHT; y++)
        {
            for(int x=0; x<WORLD_WIDTH; x++)
            {
               map[y][x] = new Cell(CELL_WIDTH, CELL_HEIGHT);
            }
        }
        packMan = null;
        this.eatenSound = eatenSound;
        this.eatingSound = eatingSound;
        this.bumpingSound = bumpingSound;
    }

    //GETCELL
    public Cell getCell(int x, int y)
    {
        if((x>=0) && (y>=0) && (x<WORLD_WIDTH) && (y<WORLD_HEIGHT))
            return map[y][x];
        else
            return null;
    }
    
    // GETCELLTYPE
    public int getCellType( int x, int y) {
        if((x>=0) && (y>=0) && (x<WORLD_WIDTH) && (y<WORLD_HEIGHT))
            return map[x][y].getType();
        else
            return -1;
    }
    
    //GETWORLDWIDTH
    public static int getWorldWidth()
    {
        return WORLD_WIDTH;
    }
    
    //GETWORLDHEIGHT
    public static int getWorldHeight()
    {
        return WORLD_HEIGHT;
    }

    //ADDGUESTAT
    public void addGuestAt( int x, int y, PackManObject guest) {
        guest.setWorld(this);
        map[y][x].setGuest(guest);
    }

    //SETPACKMAN
    public void setPackMan( int x, int y, PackMan theMan) {
        theMan.setWorld(this);
        map[y][x].setGuest(theMan);
        packMan = theMan;        
    }
    
    //DRAW
    public void draw(Graphics g, int xp, int yp)
    {
        int x, y;
        int xPos, yPos;
        
        xPos = 0;
        yPos = 0;
        for(y=0; y<WORLD_HEIGHT; y++)
        {
            for(x=0; x<WORLD_WIDTH; x++)
            {
                map[y][x].draw(g, xp+xPos, yp+yPos);
                xPos = xPos + CELL_HGAP + CELL_WIDTH;// WORLD_WIDTH;
            }
            xPos = 0;       
            yPos = yPos + CELL_VGAP + CELL_HEIGHT; // WORLD_HEIGHT;
        }
            
    }
        
    // UPDATEWORLD
    public void updateWorld() {
	    PackManObject obj;
	    Vector v = new Vector(50);

        for(int y=0;y<WORLD_HEIGHT; y++)
        {
            for(int x=0;x<WORLD_WIDTH;x++)
            {
                obj = getCell(x,y).getGuest();
                if ((obj != null) && (obj.getAnimateAbility()))
                {
                  v.addElement( obj);
                  // ((AnimatedObject)obj).animate(this, this.packMan);
                }
            }
        }
        
        for (int i=0; i < v.size(); i++) {
            obj = (PackManObject) v.elementAt(i);
            ((AnimatedObject)obj).animate(this.packMan);
        }
        
    }
    
}