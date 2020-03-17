/** This class models Player 
	 *  Class: ICS 4U1
	 *  @author Sanjana Dasadia, Sweni Shah
	*/
import java.util.*;
public class Player {
	
	private int money;
	private ArrayList<Locations> ownedProperties = new ArrayList<Locations>();; 
	
	/** Creates Player object given money, ownedProperties
	 * 
	 * @param money - amount of money each player has
	 * @param ownedProperties - list of properties owned by each player
	 */
	public Player(int money, ArrayList<Locations> ownedProperties) {
		this.money = money;
		this.ownedProperties = ownedProperties;
	}
	
	/** getMoney - returns money
	 * @return money
	 */
	public int getMoney() {
		return this.money;
	}
	
	/** getProperties - returns a list of all the owned properties by the player
	 * @return ownedProperties
	 */
	public ArrayList<Locations> getProperties(){
		return this.ownedProperties; 
	}

		
}





