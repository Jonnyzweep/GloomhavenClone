package main.entity;

import java.util.List;

public class EntityManager {
	
	private List<Entity> entities;
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public List<Entity> getAllEntities(){
		return this.entities;
	}

}
