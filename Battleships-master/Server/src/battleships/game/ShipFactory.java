/*
 * ShipFactory.java	
 * Version 1.0 (2013-05-31)
 */

package battleships.game;

public class ShipFactory {
	
	public Ship getShipType(String type){
        if(type == null) {
            return null;
        } else if(type.equalsIgnoreCase("AIRCRAFT_CARRIER")) {
            return new Aircraft_carrier();
        } else if(type.equalsIgnoreCase("DESTROYER")) {
            return new Destroyer();
        } else if(type.equalsIgnoreCase("SUBMARINE")) {
            return new Submarine();
        } else {
            return null;
        }
    }

}
