package entities;

import java.awt.Rectangle;

import animation.Animation;
import sprites.SpriteAnimated;
import sprites.SpriteStill;
import sprites.Sprite;

/*
 * Static Entity class, for unmoving sprites. Has graphic that can be either still image or animation.
 */
public class EntityStatic extends Entity{

	public String name;
	private Sprite graphic; //might want to put into super class unless Entity without image is useful
	protected Rectangle boundingBox = new Rectangle(0,0); //Should be moved to intermediate class for only collidables
	
    public EntityStatic(int x, int y) {
    	super(x,y);
        //this.x = x;
        //this.y = y;
        //visibility = true;
    }
    
    protected void loadSprite(String path){ // needs handling if failed. Also needs to be moved out of object class into sprites
    	graphic = new SpriteStill(System.getProperty("user.dir").replace( "\\", "//" ) + "//Assets//" +path + ".png");
    }
    
    /*protected void loadAnimatedSprite(String path){ // needs handling if failed. 
    	graphic = new SpriteAnimatedTest(System.getProperty("user.dir").replace( "\\", "//" ) + "//Assets//" +path + ".png");
    }*/
    
    protected void loadAnimatedSprite(Animation a){ // needs handling if failed. 
    	graphic = new SpriteAnimated(a); 
    }
    
    public Sprite getObjectGraphic(){ // gets the Object's sprite, still image or animation
    	return graphic;
    }
    
    public void setBoundingBox(int x_offset, int y_offset , int width , int height) {
    	
        boundingBox = new Rectangle(x_offset, y_offset, width , height);
    }
	
	public Rectangle getBoundingBox(){ 
		return new Rectangle (getX() + boundingBox.x , getY() + boundingBox.y , boundingBox.width , boundingBox.height);
	}

	@Override
	public void selfDestruct(){
		setBoundingBox(0,0,0,0); // This is almost exclusively so the Collision Detector closes collisions with dead entities
		alive = false;
	}
	
	public String toString()
	{
		return String.format("%s", this);
	}
	
	
}
