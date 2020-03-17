/** This class models Properties which is a type of location
	 *  Class: ICS 4U1
	 *  @author Sanjana Dasadia, Sweni Shah
	*/
import java.util.*;
public class Properties extends Locations{
	
	private int price;
	private int rent; 
	
	/** Creates Properties object given buyable, x position, y position, price and rent.
	 * 
	 * @param buyable - if its buyable
	 * @param xPos - x coordinate of Property
	 * @param yPos - y coordinate of Property
	 * @param price - price of property
	 * @param rent - rent of property
	 */
	public Properties(boolean buyable, int xPos, int yPos, int price, int rent) {
		super(buyable, xPos, yPos);
		this.price = price;
		this.rent = rent;
	} 
	
	/** getPrice - returns price of Property 
	 * @return price
	 */
	public int getPrice() {
		return this.price;
	}
	
	/** getRent - returns rent of Property
	 * @return rent
	 */
	public int getRent() {
		return this.rent; 
	}
}


