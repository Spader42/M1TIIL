/*
	PackManGame - A basic extension of the java.applet.Applet class

	Original Java 1.0 implementation
	Author: Cemal Yilmaz & David Davenport
	Date: March 1998

	Java 1.3.1 implementation, 	version 6
	Updated by : Rabia Nuray
	Date: March 2002
 */

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.applet.*;

public class PackManGame extends Applet implements ActionListener,KeyListener{
    
    static int WINDOW_WIDTH;
    static int WINDOW_HEIGHT;
    
    GameWorld world;
    Ani a;
    Image offScreen;
    Graphics offGraph;
    static boolean play; // enables/disables packman controls
    AudioClip eatenSound, eatingSound, bumpingSound;
    
    public void stop() {
	    if (a != null) {
	        a.go = false;
	     }
        a = null;
	    play = false;	      
    }
    
    public void destroy() {
    	stop();
    }
    
    // SETUP
    void setup() {
        
        play = false;

        eatenSound = getAudioClip( getCodeBase(), "thathurts.au"); 
        eatingSound = getAudioClip( getCodeBase(), "eating.au"); 
        bumpingSound = getAudioClip( getCodeBase(), "bumping.au"); 

		// create GameWorld
		world = new GameWorld( eatenSound, eatingSound, bumpingSound );
		// and fill it with things...
		loadWorld( createGameWorld() );

        // setup double buffering
        WINDOW_WIDTH = GameWorld.WORLD_WIDTH * (GameWorld.CELL_WIDTH + GameWorld.CELL_HGAP) - 5;
        WINDOW_HEIGHT = GameWorld.WORLD_HEIGHT * (GameWorld.CELL_HEIGHT + GameWorld.CELL_VGAP) - 5;
		offScreen = createImage( WINDOW_WIDTH, WINDOW_HEIGHT);
		offGraph = offScreen.getGraphics();
    }

	//INIT
	public void init()
	{
        setup();  // setup gameworld, etc.

 	 //{{INIT_CONTROLS
		setLayout(null);
		addNotify();
		resize(487,525);
		UpButton = new java.awt.Button("Up");
		UpButton.reshape(216,456,50,26);
		UpButton.setBackground(new Color(12632256));
  	    UpButton.addActionListener(this);
		add(UpButton);
		
		DownButton = new java.awt.Button("Down");
		DownButton.reshape(216,492,50,26);
		DownButton.setBackground(new Color(12632256));
  	    DownButton.addActionListener(this);
	 	add(DownButton);
	
		
		RightButton = new java.awt.Button("Right");
		RightButton.reshape(276,468,50,26);
		RightButton.setBackground(new Color(12632256));
  	    RightButton.addActionListener(this);
		add(RightButton);
		
		LeftButton = new java.awt.Button("Left");
		LeftButton.reshape(156,468,50,26);
		LeftButton.setBackground(new Color(12632256));
  	    LeftButton.addActionListener(this);
		add(LeftButton);
		
		QuitButton = new java.awt.Button("Quit");
		QuitButton.reshape(372,468,58,26);
		QuitButton.setForeground(new Color(16777215));
		QuitButton.setBackground(new Color(16711680));
  	    QuitButton.addActionListener(this);
		add(QuitButton);
		
		startButton = new java.awt.Button("Start");
		startButton.reshape(60,468,58,26);
		startButton.setBackground(new Color(65280));
  	    startButton.addActionListener(this);
		add(startButton);
		
		label1 = new java.awt.Label("");
		label1.hide();
		label1.reshape(24,504,180,27);
		add(label1);
		
		label2 = new java.awt.Label("Packman - (c) 2002 Bilkent CS102 (v6)",Label.CENTER);
		label2.reshape(60,12,366,21);
		label2.setFont(new Font("Dialog", Font.BOLD, 12));
		label2.setBackground(new Color(65535));
		add(label2);
		
		this.addKeyListener(this);	
	//}}
		requestFocus();
	}
	
    //UPDATE
    public void update(Graphics g)
    {
        paint(g);
    }
    
    ///PAINT
	public void paint(Graphics g)
	{
	    //clear the off-screen buffer
	    offGraph.setColor(Color.white);
        offGraph.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        //Draw the world on the buffer
        world.draw(offGraph, 0, 0);
        //Draw the buffer on the screen
        g.drawImage(offScreen, 45, 50, this);
	}

	//{{DECLARE_CONTROLS
	java.awt.Button UpButton;
	java.awt.Button DownButton;
	java.awt.Button RightButton;
	java.awt.Button LeftButton;
	java.awt.Button QuitButton;
    java.awt.Button startButton;
	java.awt.Label label1;
	java.awt.Label label2;
	java.awt.Panel displayPanel;
	//}}


    public void actionPerformed(ActionEvent event)
    {

       Object object = event.getSource();
			
			if (object.equals(UpButton) && play == true)
				UpButton_Action(event);
			else if (object.equals(DownButton) && play == true)
				DownButton_Action(event);
			else if (object.equals(RightButton) && play == true)
				RightButton_Action(event);
			else if (object.equals(LeftButton) && play == true)
				LeftButton_Action(event);
			else if (object.equals(QuitButton))
				QuitButton_Action(event);
			else if (object.equals(startButton)) 
				startButton_Action(event);
    
    }

	void UpButton_Action(ActionEvent event)
	{
        world.packMan.goUp();
	    requestFocus();
        repaint();
	}

	void DownButton_Action(ActionEvent event)
	{
        world.packMan.goDown();
  	  	requestFocus();
        repaint();
	}

	void RightButton_Action(ActionEvent event)
	{
        world.packMan.goRight();
  		requestFocus();
        repaint();
	}

	void LeftButton_Action(ActionEvent event)
	{
        world.packMan.goLeft();
  		requestFocus();
        repaint();
	}

	void QuitButton_Action(ActionEvent event)
	{
	    stop();
	}

	void startButton_Action(ActionEvent event)
	{
  		requestFocus();
  		if (world.packMan == null) 
            setup();  // gameover, set it up again
        play = true;
		if (a != null) 
			a.go = false;
		a = null;
		a = new Ani(this, world);
		a.start();
	}
	
    public void keyTyped(KeyEvent e){
		//System.out.println("KEY TYPED");
	}
	
	public void keyPressed(KeyEvent e){
		if ( play)
			PackManGame_KeyPress(e);
	}
	
	public void keyReleased(KeyEvent e){
		//System.out.println("KEY RELEASED");
	}
	
	void PackManGame_KeyPress(KeyEvent event)
	{
//		System.out.println("KEY PRESSED");
		int code;
		
		code = event.getKeyCode();

		if ( code == KeyEvent.VK_UP){//UP AROOW IS PRESSED
    			label1.setText("test - key pressed UP");
            	world.packMan.goUp();
	            repaint();
	    }
    	else if (code == KeyEvent.VK_DOWN) {//DOWN ARROW IS PRESSED
    			label1.setText("test - key pressed DOWN");
	      	    world.packMan.goDown();
      	    	repaint();
	    }
    	else if (code == KeyEvent.VK_LEFT) {//LEFT ARROW
    		    label1.setText("test - key pressed LEFT");
                world.packMan.goLeft();
                repaint();
        }
 	    else if (code == KeyEvent.VK_RIGHT) {//RIGHT ARROW
    	   	    label1.setText("test - key pressed RIGHT");
                world.packMan.goRight();
                repaint();
        }
        else {
    	  	    label1.setText("test - key pressed" + code );
    	}
	}

////////////////////////////////////////////////////////////////////////////////////////
   
    //CREATEGAMEWORLD
	public StringBuffer[] createGameWorld()
	{
        // This has to be at least as big as world is...!
	    StringBuffer[] worldMap = new StringBuffer[20];

        //map is created
        worldMap[ 0]=new StringBuffer("WWWWWWWWWWWWWWWWWWWW"); 
        worldMap[ 1]=new StringBuffer("W000M0W000M000000F0W"); 
        worldMap[ 2]=new StringBuffer("W0F00MW000000000000W"); 
        worldMap[ 3]=new StringBuffer("W000000000M0000F000W"); 
        worldMap[ 4]=new StringBuffer("W000000000000F00000W"); 
        worldMap[ 5]=new StringBuffer("W000MM0000M00000000W"); 
        worldMap[ 6]=new StringBuffer("W000000M00000000000W"); 
        worldMap[ 7]=new StringBuffer("W00M00000F0000000WWW"); 
        worldMap[ 8]=new StringBuffer("W0000000000000WWW00W"); 
        worldMap[ 9]=new StringBuffer("W000000000000000000W"); 
        worldMap[10]=new StringBuffer("W0000WW0WWW00000000W"); 
        worldMap[11]=new StringBuffer("W0000W00F0W00000000W"); 
        worldMap[12]=new StringBuffer("W0P00W0M00W00000000W"); 
        worldMap[13]=new StringBuffer("W0000WWWWWW00000F00W"); 
        worldMap[14]=new StringBuffer("W000000000000000000W"); 
        worldMap[15]=new StringBuffer("W000000000000000000W"); 
        worldMap[16]=new StringBuffer("W0F0000000000F00000W"); 
        worldMap[17]=new StringBuffer("W0WWWW0000000000000W"); 
        worldMap[18]=new StringBuffer("W00F00WWWW000000WWWW"); 
        worldMap[19]=new StringBuffer("WWWWWWWWWWWWWWWWWWWW"); 
        
        return worldMap;
	}

    //LOADMAP
    public void loadWorld(StringBuffer m[])
    {
        int y;
        int x;
        char type;
        
        //read the map into the cells
        for(y=0; y< world.WORLD_HEIGHT; y++)
        {
            for(x=0; x< world.WORLD_WIDTH; x++)
            {
                type = m[y].charAt(x);
               	//if there is a wall
                if (type == 'W')
                    world.addGuestAt( x, y, new Wall() );
                //else if there is a packman 
                else if (type == 'P')
                    world.setPackMan( x, y, new PackMan(x, y) );
                //else if there is a Food
			    else if(type == 'F')
			    	world.addGuestAt( x, y, new Food() );
			    //else there is a Monster
   		        else if(type == 'M')
   		        	world.addGuestAt(x,y,new Monster(x,y));
            }
        }
    }

}
