import java.awt.*;

///////////////////////////////////
///////////////////////////////////
// CLASS PACKMAN
///////////////////////////////////
///////////////////////////////////
class PackMan extends AnimatedObject
{
    //PackMan
    public PackMan(int x, int y)
    {
        super(PackManObject.PACKMAN_TYPE, x, y);
    }    

    public void draw ( Graphics g, int x, int y) {
        g.setColor ( Color.red);
        g.fillOval( x, y, GameWorld.CELL_WIDTH-1, GameWorld.CELL_HEIGHT-1);        
    }

    public void animate (PackMan packman) {
        // don't need to do anything here, since controlled by user!
    }
    
    //goUp method  is overriden for PackMan
    public PackManObject goUp( ) {
        PackManObject x = super.goUp();
        if ( x != null) {
            if (x.getType() == PackManObject.OBSTACLE_TYPE)
                gw.bumpingSound.play();
            else if (x.getType() == PackManObject.MONSTER_TYPE)
                getEaten();
            else if ( x.getType() == PackManObject.FOOD_TYPE) {
                gw.getCell(currXPos, currYPos-1).removeGuest(); 
                super.goUp();
                gw.eatingSound.play();
            }
        }
        return x;
    }
    //goDown method  is overriden for PackMan
    public PackManObject goDown( ) {
        PackManObject x = super.goDown();
        if ( x != null) {
            if (x.getType() == PackManObject.OBSTACLE_TYPE)
                gw.bumpingSound.play();
            else if (x.getType() == PackManObject.MONSTER_TYPE)
                getEaten( );
            else if ( x.getType() == PackManObject.FOOD_TYPE) {
                gw.getCell(currXPos, currYPos+1).removeGuest(); 
                super.goDown( );
                gw.eatingSound.play();
            }
        }
        return x;
    }
	//goLeft method  is overriden for PackMan
    public PackManObject goLeft(  ) {
        PackManObject x = super.goLeft( );
        if ( x != null) {
            if (x.getType() == PackManObject.OBSTACLE_TYPE)
                gw.bumpingSound.play();
            else if (x.getType() == PackManObject.MONSTER_TYPE)
                getEaten( );
            else if ( x.getType() == PackManObject.FOOD_TYPE) {
                gw.getCell(currXPos-1, currYPos).removeGuest(); 
                super.goLeft( );
                gw.eatingSound.play();
            }
        }
        return x;
    }
	//goRight method  is overriden for PackMan
    public PackManObject goRight(  ) {
        PackManObject x = super.goRight( );
        if ( x != null) {
            if (x.getType() == PackManObject.OBSTACLE_TYPE)
                gw.bumpingSound.play();
            else if (x.getType() == PackManObject.MONSTER_TYPE)
                getEaten( );
            else if ( x.getType() == PackManObject.FOOD_TYPE) {
                gw.getCell(currXPos+1, currYPos).removeGuest(); 
                super.goRight( );
                gw.eatingSound.play();
            }
        }
        return x;
    }
	
	//If the Packman object is eaten then this method will be  called
    public void getEaten( ) {
        gw.getCell(currXPos, currYPos).removeGuest();
        gw.eatenSound.play();
        PackManGame.play = false;
        gw.packMan = null;
    }
    
}