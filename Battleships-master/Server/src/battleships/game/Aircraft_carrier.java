/*
 * Aircraft_carrier.java	
 * Version 1.0 (2013-05-30)
 */

package battleships.game;

import java.util.TreeSet;

/**
 * This class extends the abstract class Ship for the game Battleships.
 * 
 * @author Åsa Waldhe
 *
 */
public class Aircraft_carrier extends Ship {
	
	private static int instances_ac=0;
	
	/**
	 * 
	 * @param c1
	 * @param c2
	 * @param c3
	 * @param c4
	 * @param c5
	 */
	public Aircraft_carrier(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4, Coordinate c5){
		
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
		coords.add(c4);
		coords.add(c5);
		
		
		++instances_ac;
	}

	public Aircraft_carrier(){
		
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
		
		++instances_ac;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getInstances(){
		return instances_ac;
	}
	@Override
	protected void setName() {
		NAME = "AIRCRAFT_CARRIER";
	}
	@Override
	protected void setLength() {
		LENGTH = 5;
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
