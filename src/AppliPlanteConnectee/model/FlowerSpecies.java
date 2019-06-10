package AppliPlanteConnectee.model;


/**
 * 
 */

/**
 * @author Irohn
 *
 */
public class FlowerSpecies {

	private int id;

	private String flowerSpeciesName;

	private int idealTemperature;
	
	private int idealLuminosity;
	
	private boolean idealHumidity;
	
	private String startBlossoming;

	private String endBlossoming;
	
	public FlowerSpecies() {
		this.id = 0;
		this.flowerSpeciesName = "rosacées";
		this.idealTemperature = 18;
		this.idealLuminosity = 30;
		this.idealHumidity = true;
		this.startBlossoming = "Janvier";
		this.endBlossoming = "Janvier";
	}
	
	public FlowerSpecies(int id, String flowerSpeciesName, int idealTemperature, int idealLuminosity, boolean idealHumidity, String startBlossoming, String endBlossoming) {
		this.id = id;
		this.flowerSpeciesName = flowerSpeciesName;
		this.idealTemperature = idealTemperature;
		this.idealLuminosity = idealLuminosity;
		this.idealHumidity = idealHumidity;
		this.startBlossoming = startBlossoming;
		this.endBlossoming = endBlossoming;
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
	 * @return the flowerSpeciesName
	 */
	public String getFlowerSpeciesName() {
		return flowerSpeciesName;
	}

	/**
	 * @param flowerSpeciesName the flowerSpeciesName to set
	 */
	public void setFlowerSpeciesName(String flowerSpeciesName) {
		this.flowerSpeciesName = flowerSpeciesName;
	}

	/**
	 * @return the idealTemperature
	 */
	public int getIdealTemperature() {
		return idealTemperature;
	}

	/**
	 * @param idealTemperature the idealTemperature to set
	 */
	public void setIdealTemperature(int idealTemperature) {
		this.idealTemperature = idealTemperature;
	}

	/**
	 * @return the idealLuminosity
	 */
	public int getIdealLuminosity() {
		return idealLuminosity;
	}

	/**
	 * @param idealLuminosity the idealLuminosity to set
	 */
	public void setIdealLuminosity(int idealLuminosity) {
		this.idealLuminosity = idealLuminosity;
	}

	/**
	 * @return the idealHumidity
	 */
	public boolean isIdealHumidity() {
		return idealHumidity;
	}

	/**
	 * @param idealHumidity the idealHumidity to set
	 */
	public void setIdealHumidity(boolean idealHumidity) {
		this.idealHumidity = idealHumidity;
	}

	/**
	 * @return the startBlossoming
	 */
	public String getStartBlossoming() {
		return startBlossoming;
	}

	/**
	 * @param startBlossoming the startBlossoming to set
	 */
	public void setStartBlossoming(String startBlossoming) {
		this.startBlossoming = startBlossoming;
	}

	/**
	 * @return the endBlossoming
	 */
	public String getEndBlossoming() {
		return endBlossoming;
	}

	/**
	 * @param endBlossoming the endBlossoming to set
	 */
	public void setEndBlossoming(String endBlossoming) {
		this.endBlossoming = endBlossoming;
	}
	

	
	
	
}
