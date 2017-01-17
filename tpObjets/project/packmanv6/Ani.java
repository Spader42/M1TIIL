// Revised for Java 1.3 Threads
// David, March 2002

import java.awt.*;


public class Ani extends Thread {
    
    public static final int GAME_SPEED = 250;    
    
    GameWorld world;
    Panel p;
    boolean go;
    
    public Ani( Panel p, GameWorld world ) {
        this.world = world;
        this.p = p;
        go = true;
    }
	
	public void run()
	{
	    // This Loop continuously updates the positions of all the 
	    // Animatable Objects, redraws them and sleeps a bit...
	    while( go)
	    {	        
            world.updateWorld();
            p.repaint();	
	        try{
	            Thread.sleep(GAME_SPEED);
	        }catch(Exception e){
	        	go = false;
	        }
	    }
	}
}	
