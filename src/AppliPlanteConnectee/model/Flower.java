/**
 * 
 */
package AppliPlanteConnectee.model;

/**
 * @author sebbo
 *
 */
public class Flower {

	private int id;

	private String flowerName;

	private int actualTemperature;
	
	private int actualLuminosity;
	
	private boolean actualHumidity;
	
	private String time;
	
	private int idFlowerSpecies;
	
	public Flower(String flowerName) {
		this.id = 0;
		this.flowerName = flowerName;
		this.actualTemperature = 20;
		this.actualLuminosity = 30;
		this.actualHumidity = true;
		this.time = "now";
		this.idFlowerSpecies = 1;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the flowerName
	 */
	public String getFlowerName() {
		return flowerName;
	}

	/**
	 * @param flowerName the flowerName to set
	 */
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	/**
	 * @return the actualTemperature
	 */
	public int getActualTemperature() {
		return actualTemperature;
	}

	/**
	 * @param actualTemperature the actualTemperature to set
	 */
	public void setActualTemperature(int actualTemperature) {
		this.actualTemperature = actualTemperature;
	}

	/**
	 * @return the actualLuminosity
	 */
	public int getActualLuminosity() {
		return actualLuminosity;
	}

	/**
	 * @param actualLuminosity the actualLuminosity to set
	 */
	public void setActualLuminosity(int actualLuminosity) {
		this.actualLuminosity = actualLuminosity;
	}

	/**
	 * @return the actualHumidity
	 */
	public boolean isActualHumidity() {
		return actualHumidity;
	}

	/**
	 * @param actualHumidity the actualHumidity to set
	 */
	public void setActualHumidity(boolean actualHumidity) {
		this.actualHumidity = actualHumidity;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the idFlowerSpecies
	 */
	public int getIdFlowerSpecies() {
		return idFlowerSpecies;
	}

	/**
	 * @param idFlowerSpecies the idFlowerSpecies to set
	 */
	public void setIdFlowerSpecies(int idFlowerSpecies) {
		this.idFlowerSpecies = idFlowerSpecies;
	}
}