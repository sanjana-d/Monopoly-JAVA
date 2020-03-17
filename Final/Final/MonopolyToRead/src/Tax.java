/** This class models Tax which is a type of location
	 *  Class: ICS 4U1
	 *  @author Sanjana Dasadia, Sweni Shah
	*/
import java.util.*;
public class Tax extends Locations {
	private int deduct;
	
	/** Creates Tax object given buyable, x position, y position, deduct
	 * 
	 * @param buyable - if its buyable
	 * @param xPos - x coordinate of Property
	 * @param yPos - y coordinate of Property
	 * @param deduct - amount of money to be subtracted
	 */
	public Tax(boolean buyable, int xPos, int yPos, int deduct) {
		super(buyable, xPos, yPos);
		this.deduct = deduct;
	}
	
	/** getDeduct - returns amount of tax to be deducted
	 * @return deduct
	 */
	public int getDeduct() {
		return deduct;
	}

}
