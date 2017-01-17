import java.awt.*;
import java.awt.image.*;
import java.net.*;

///////////////////////////////////
///////////////////////////////////
// CLASS PackManObject
///////////////////////////////////
///////////////////////////////////
public abstract class PackManObject
{
    static final int OBSTACLE_TYPE = 1;
    static final int MONSTER_TYPE = 2;
    static final int PACKMAN_TYPE = 3;
    static final int FOOD_TYPE = 4;
    

    boolean animateAbility;
    int objectType;
    GameWorld gw;
     
    //PACKMANOBJECT
    public PackManObject(int otype)
    {
        animateAbility = false;
        objectType = otype;
        gw=null;
    }
    
    //GETTYPE
    public int getType()
    {
        return objectType;
    }
    
	//set the game world of the packman object
	public void setWorld(GameWorld gw){
		this.gw = gw;
	}
	
	//get the game world
	public GameWorld getWorld(){
		return gw;
	}
	
	//DRAW
    public abstract void draw(Graphics g, int x, int y);

    //GETANIMATEABILITY
    public boolean getAnimateAbility()
    {
        return animateAbility;
    }

}
