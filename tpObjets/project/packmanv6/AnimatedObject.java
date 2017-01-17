import java.awt.*;

///////////////////////////////////
///////////////////////////////////
// CLASS ANIMTEDOBJECT
///////////////////////////////////
///////////////////////////////////
public abstract class AnimatedObject extends PackManObject
{
    protected int currXPos, currYPos;

    //ANIMATEDOBJECT
    public AnimatedObject(int objType, int x, int y)
    {
        super(objType);
        animateAbility = true;
        currXPos = x;
        currYPos = y;
    }

    //GOUP
    // Moves object up and returns null if place is empty, 
    // else returns contents of cell or
    // returns null and doesn't move if cell is outside gameworld.
    public PackManObject goUp()
    {
        PackManObject result;
        Cell tc,cc;
        
        result = null;
        tc = gw.getCell(currXPos, currYPos-1); 
        cc = gw.getCell(currXPos, currYPos);
        
        if (tc == null)
            return null;
        else if (tc.getGuest() == null)
        {
            tc.setGuest(cc.removeGuest());
            currYPos =  currYPos - 1;
        }
        else 
        {
            result = tc.getGuest();
        }
        return result;
    }

    //GODOWN
    public PackManObject goDown()
    {
        PackManObject result;
        Cell tc,cc;
        
        result = null;
        tc = gw.getCell(currXPos, currYPos+1); 
        cc = gw.getCell(currXPos, currYPos);
        
        if (tc == null)
            return null;
        else if (tc.getGuest() == null)
        {
            tc.setGuest(cc.removeGuest());
            currYPos =  currYPos + 1;
        }
        else 
        {
            result = tc.getGuest();
        }
        return result;
    }

    //GOLEFT
    public PackManObject goLeft()
    {
        PackManObject result;
        Cell tc,cc;
        
        result = null;
        tc = gw.getCell(currXPos-1, currYPos); 
        cc = gw.getCell(currXPos, currYPos);
        
        if (tc == null)
            return null;
        else if (tc.getGuest() == null)
        {
            tc.setGuest(cc.removeGuest());
            currXPos =  currXPos - 1;
        }
        else 
        {
            result = tc.getGuest();
        }
        return result;
    }
    

    //GORIGHT
    public PackManObject goRight()
    {
        PackManObject result;
        Cell tc,cc;
        
        result = null;
        tc = gw.getCell(currXPos+1, currYPos); 
        cc = gw.getCell(currXPos, currYPos);
        
        if (tc == null)
            return null;
        else if (tc.getGuest() == null)
        {
            tc.setGuest(cc.removeGuest());
            currXPos =  currXPos + 1;
        }
        else 
        {
            result = tc.getGuest();
        }
        return result;
    }
    
    // ANIMATE
    public abstract void animate (PackMan packman);
        
 
}