/*
 * Submarine.java	
 * Version 1.0 (2013-05-30)
 */

package battleships.game;

import java.util.TreeSet;

/**
 * 
 * @author Åsa Waldhe
 *
 */
public class Submarine extends Ship {
	
	private static int instances_s =0;
	
	/**
	 * 
	 * @param c
	 */
	public Submarine(Coordinate c) {			
		CompareHorizontal compH = new CompareHorizontal();
		coords = new TreeSet<Coordinate>(compH);
		hits = new TreeSet<Coordinate>(compH);
		coords.add(c);
		
		++instances_s;
	}

	public Submarine() {	
		
		CompareHorizontal compH = new CompareHorizontal();
		coords = new TreeSet<Coordinate>(compH);
		hits = new TreeSet<Coordinate>(compH);
		
		++instances_s;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getInstances(){
		return instances_s;
	}

	@Override
	protected void setName() {
		NAME = "SUBMARINE";
	}
	@Override
	protected void setLength() {
		LENGTH = 1;
	}

	public int getLength() {
		return LENGTH;
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
