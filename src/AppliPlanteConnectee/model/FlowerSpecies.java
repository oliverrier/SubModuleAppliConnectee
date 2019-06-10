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

	private String name;
	
	private String description;

	private int temperature;
	
	private int luminosity;
	
	private boolean humidity;
	
	private String blossomingPeriodStart;

	private String blossomingPeriodEnd;
	
	private int idCategory;
	
	public FlowerSpecies() {
		this.id = 0;
		this.name = "rosacées";
		this.temperature = 18;
		this.luminosity = 30;
		this.humidity = true;
		this.blossomingPeriodStart = "Janvier";
		this.blossomingPeriodEnd = "Janvier";
		this.idCategory = 1;
	}
	
	public FlowerSpecies(int id, String name, int temperature, int luminosity, boolean humidity, String blossomingPeriodStart, String blossomingPeriodEnd, int idCategory) {
		this.id = id;
		this.name = name;
		this.temperature = temperature;
		this.luminosity = luminosity;
		this.humidity = humidity;
		this.blossomingPeriodStart = blossomingPeriodStart;
		this.blossomingPeriodEnd = blossomingPeriodEnd;
		this.idCategory = idCategory;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the temperature
	 */
	public int getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the luminosity
	 */
	public int getLuminosity() {
		return luminosity;
	}

	/**
	 * @param luminosity the luminosity to set
	 */
	public void setLuminosity(int luminosity) {
		this.luminosity = luminosity;
	}

	/**
	 * @return the humidity
	 */
	public boolean isHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(boolean humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the blossomingPeriodStart
	 */
	public String getBlossomingPeriodStart() {
		return blossomingPeriodStart;
	}

	/**
	 * @param blossomingPeriodStart the blossomingPeriodStart to set
	 */
	public void setBlossomingPeriodStart(String blossomingPeriodStart) {
		this.blossomingPeriodStart = blossomingPeriodStart;
	}

	/**
	 * @return the blossomingPeriodEnd
	 */
	public String getBlossomingPeriodEnd() {
		return blossomingPeriodEnd;
	}

	/**
	 * @param blossomingPeriodEnd the blossomingPeriodEnd to set
	 */
	public void setBlossomingPeriodEnd(String blossomingPeriodEnd) {
		this.blossomingPeriodEnd = blossomingPeriodEnd;
	}

	/**
	 * @return the idCategory
	 */
	public int getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	
}
