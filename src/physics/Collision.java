package physics;

import entities.EntityDynamic;
import entities.EntityStatic;

public class Collision {
	
	protected EntityDynamic entityPrimary;
	protected EntityStatic entitySecondary;
	
	public Collision(EntityDynamic entity1, EntityStatic entity2){
		
		entityPrimary = entity1;
		entitySecondary = entity2;
		
		//THIS TEST COLLISION IS A NORMAL SURFACE SUCH AS A FLAT PLATFORM
		
		initCollision();
		
	}
	
	//INITAL COLLISION COMMANDS - Run once, the first time collision occurs
	public void initCollision(){
		
	}
	
	//CONTINUOUS COLLISION COMMANDS - Ongoing commands during collision like particle effects, sound, etc.
	public void updateCollision(){ 
		   
	}
	
	//FINAL COLLISION COMMANDS - Last commands before this collision object self destructs
	public void completeCollision(){
		
	}
	
	
	//INTERNAL METHODS - DON'T ALTER BELOW THIS
	public boolean isComplete(){ // Check if entities are no longer colliding
		
		if (entityPrimary.getBoundingBox().intersects(entitySecondary.getBoundingBox()) ){
			return false;
		}
		else { // entities are no longer colliding
			completeCollision(); // run final commands
			return true; // return true for scanning loop in Board to delete this collision
		}
	}
	
	//When Board detects collision, check to see if it's already in the list of active collisions
	public boolean isActive(EntityStatic entity1, EntityStatic entity2){
		if (entity1 == entityPrimary){
			if (entity2 == entitySecondary){
				return true;
			}
			else {
				return false;
			}
			
		}
		else if (entity1 == entitySecondary){
			if (entity2 == entityPrimary){
				return true;
			}
			else {
				return false;
			}
		}
		

		else{
			return false;
		}
	}
}
