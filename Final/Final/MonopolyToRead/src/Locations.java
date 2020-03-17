/** This class models Locations
	 *  Class: ICS 4U1
	 *  @author Sanjana Dasadia, Sweni Shah
	*/
import java.util.*; 

public class Locations {	
	private int xPos;
	private int yPos;
	private boolean buyable;
	
	/** Creates Location object given buyable, x position, y position.
	 * 
	 * @param buyable - if its buyable
	 * @param xPos - x coordinate of Location
	 * @param yPos - y coordinate of Location
	 */
	public Locations(boolean buyable, int xPos, int yPos) {
		this.buyable = buyable;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/** getXpos - returns x coordinate of Location
	 * @return xPos
	 */
	public int getXpos() {
		return xPos;
	}
	
	/** getYpos - returns y coordinate of Location
	 * @return yPos
	 */
	public int getYpos() {
		return yPos;
	}
	
	/** getBuyable - returns if true or false
	 * @return buyable
	 */
	public boolean getBuyable() {
		return buyable; 
	}
	
	/** Sets if the location is owned or unowned by the player
	 * @param owned
	 */
	public void setBuyable(boolean owned) {
		this.buyable = owned;
	}
	
	/** getPrice - returns price of Location 
	 * @return getPrice()
	 */
	public int getPrice() {
		return this.getPrice();
	}
	
	/** getDeduct - returns amount of tax to be deducted
	 * @return getDeduct()
	 */
	public int getDeduct() {
		return this.getDeduct();
	}
	
	/** getRent - returns rent of Location
	 * @return getRent()
	 */
	public int getRent() {
		return this.getRent();
	}

}










