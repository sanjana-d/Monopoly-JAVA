/** This class models Jail which is a type of location
	 *  Class: ICS 4U1
	 *  @author Sanjana Dasadia, Sweni Shah
	*/
import java.util.*;
public class Jail extends Locations {
	
	private boolean inJail; 
	
	/** Creates Properties object given buyable, x position, y position, inJail
	 * 
	 * @param buyable - if its buyable
	 * @param xPos - x coordinate of Property
	 * @param yPos - y coordinate of Property
	 * @param inJail - if player is in jail or not
	 */
	public Jail (boolean buyable, int xPos, int yPos, boolean inJail) {
		super(buyable, xPos, yPos);
		this.inJail = inJail;
	}
	
	/** getJail - returns if in jail or not
	 * @return inJail
	 */
	public boolean getJail() {
		return inJail; 
	}
	
}
