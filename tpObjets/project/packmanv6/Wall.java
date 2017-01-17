import java.awt.*;

///////////////////////////////////
///////////////////////////////////
// CLASS WALL
///////////////////////////////////
///////////////////////////////////
public class Wall extends PackManObject
{
 	//Constructor
    public Wall()
    {   
        super(PackManObject.OBSTACLE_TYPE);
    }
 
    //draw the wall with green on the game world
    public void draw( Graphics g, int x, int y) {
        g.setColor ( Color.green);
        g.fillRect( x+1, y+1, 12, 12);        
    }
    
}