package kogan.brains.entities;

import static kogan.brains.api.Tables.*; 

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name = LEVELS)
@Entity
public class Level {
	
	@Id
	int levelNumber;
	
	
	public Level() {
		super();
	}



	public Level(int levelNumber) {
		super();
		this.levelNumber = levelNumber;
	}
	
	

}
