/*
 * Destroyer.java	
 * Version 1.0 (2013-05-30)
 */

package battleships.game;

import java.util.TreeSet;

public class Destroyer extends Ship {

	private static int instances_d=0;

	public Destroyer(Coordinate c1, Coordinate c2, Coordinate c3){
		
		++instances_d;
		
		super.shipsDirection(c1, c2);
		
		if(direction == HORIZONTAL){
			CompareHorizontal compH = new CompareHorizontal();
			hits = new TreeSet<Coordinate>(compH);
			coords = new TreeSet<Coordinate>(compH);
			}
			else if(direction == VERTICAL){
				CompareVertical compV = new CompareVertical();
				hits = new TreeSet<Coordinate>(compV);
				coords = new TreeSet<Coordinate>(compV);
			}                                                           // No more else? exception?
		
		coords.add(c1);
		coords.add(c2);
		coords.add(c3);		
	}
	
	public Destroyer(){
		
		++instances_d;

		if(direction == HORIZONTAL){
			CompareHorizontal compH = new CompareHorizontal();
			hits = new TreeSet<Coordinate>(compH);
			coords = new TreeSet<Coordinate>(compH);
			}
			else if(direction == VERTICAL){
				CompareVertical compV = new CompareVertical();
				hits = new TreeSet<Coordinate>(compV);
				coords = new TreeSet<Coordinate>(compV);
			}                                                           // No more else? exception?
		
		
	}
	
	public int getInstances(){
		return instances_d;
	}

	@Override
	protected void setName() {
		NAME = "DESTROYER";
	}
	@Override
	protected void setLength() {
		LENGTH = 3;
	}

	@Override
	protected void initializeSunk() {
		sunk = false;
	}
	@Override
	public void initialize() {
		setName();
		setLength();
		initializeSunk();
	}
	
	
}
