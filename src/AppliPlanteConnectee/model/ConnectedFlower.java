/**
 * 
 */
package AppliPlanteConnectee.model;

/**
 * @author sebbo
 *
 */
public class ConnectedFlower {

	private int id;

	private String name;
	
	private int idFlowerSpecies;
	
	public ConnectedFlower(String name) {
		this.id = 0;
		this.name = name;
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