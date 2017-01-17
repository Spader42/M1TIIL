import java.awt.*;
import java.awt.image.*;
import PackManObject;

///////////////////////////////////
///////////////////////////////////
// CLASS CELL
///////////////////////////////////
///////////////////////////////////
public class Cell
{
    private int width;
    private int height;
    private PackManObject guest;
    
    //CELL
    public Cell(int w, int h)
    {
        width = w;
        height = h;
        guest = null;
    }

    //DRAWCELL
    public void draw(Graphics g, int x, int y )
    {
        // drawthecellitself
        g.setColor(Color.black);
        g.drawRect(x,y,width,height);
        // draw the guest
        if (guest != null)
            guest.draw(g, x, y);
    }

    
    //GETTYPE
    public int getType()
    {
        if(guest!=null)
            return guest.getType();
        else
            return -1;
    }
    
    //SETGUEST
    public void setGuest(PackManObject g)
    {
        guest = g;
    }
    
    //GETGUEST
    public PackManObject getGuest()
    {
        return guest;
    }
    
    //REMOVEGUEST
    public PackManObject removeGuest()
    {
        PackManObject g;
        g = guest;
        guest = null;        
        
        return g;
    }

}
