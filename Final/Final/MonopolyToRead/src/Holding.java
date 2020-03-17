/** This class models Holding which is a type of location 
	 *  Class: ICS 4U1
	 *  @author Sanjana Dasadia, Sweni Shah
	 */
import java.util.*;
public class Holding extends Locations{
	
	/** Creates Holding object given buyable, x position, y position.
	 * 
	 * @param buyable - if its buyable
	 * @param xPos - x coordinate of holding
	 * @param yPos - y coordinate of holding
	 */
	public Holding (boolean buyable, int xPos, int yPos) {
		super(buyable, xPos, yPos);
	}

}
