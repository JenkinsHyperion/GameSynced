package physics;

import java.awt.Rectangle;

import entities.EntityDynamic;
import entities.EntityStatic;

public class CollisionGenericTest extends Collision {
	
	public CollisionGenericTest(EntityDynamic entity1, EntityStatic entity2){
		
		super(entity1, entity2);
		
		//GENERIC COLLISION
		
		initCollision();
		
	}
	
	//INITAL COLLISION COMMANDS - Run once, the first time collision occurs
	@Override
	public void initCollision(){
		

		
	}
	
	//CONTINUOUS COLLISION COMMANDS - Ongoing commands during collision like particle effects, sound, etc.
	@Override
	public void updateCollision(){ 
		
		//There might be a better pure mathematical way to do this
		
		Rectangle box1 = entityPrimary.getBoundingBox();
		Rectangle box2 = entitySecondary.getBoundingBox();
		
		//if (sideIsAllignedX(box1, box2)){
		
			if (box1.getCenterY() < box2.getCenterY() ) { 
				
				if (box1.getMaxY() == box2.getMinY() + 1 ) {
							
					entityPrimary.setAccY(0);
					entityPrimary.setDY(0);
					entityPrimary.setDampeningX();
					
				}
				else {				
					entityPrimary.setDY(-1);		
				}
			
			}
			else { 
				
				if (box1.getMinY() == box2.getMaxY()  ) {
					entityPrimary.setDY(0.5f);
				}
				else {				
					entityPrimary.setDY(0.5f);		
				}
			
			}
			
		//}
		
		
		if (!sideIsAllignedY(box1, box2)){
			
			if (box1.getCenterX() < box2.getCenterX() ) { 
				
				if (box1.getMaxX() == box2.getMinX() ) {
							
					entityPrimary.setAccX(0);
					entityPrimary.setDX(0);
					
				}
				else {				
					entityPrimary.setDX(-5);		
				}
			
			}
			else { 
				
				if (box1.getMinY() == box2.getMaxY()  ) {
					entityPrimary.setDX(0);
				}
				else {				
					entityPrimary.setDX(5);		
				}
			
			}
			
		}
		
		
	}
	
	//FINAL COLLISION COMMANDS - Last commands before this collision object self destructs
	@Override
	public void completeCollision(){
		entityPrimary.setColliding(false); // unset entity collision flag. 
		entityPrimary.setAccY(0.1f); //turn gravity back on
		entityPrimary.setAccX(0); //remove friction
	}
	
		
	public boolean sideIsAllignedX(Rectangle box1, Rectangle box2){
		if ( box1.getMinX() > box2.getMaxX() || box1.getMaxX() < box2.getMinX() ){
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean sideIsAllignedY(Rectangle box1, Rectangle box2){
		if ( box1.getMinY() > box2.getMaxY() || box1.getMaxY() < box2.getMinY() ){
			return false;
		}
		else {
			return true;
		}
	}

}
