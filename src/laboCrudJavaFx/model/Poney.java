/**
 * 
 */
package laboCrudJavaFx.model;

/**
 * @author sebbo
 *
 */
public class Poney {

	private int id;

	private String name;

	private String weapon;

	public Poney(String name) {
		super();
		this.name = name;
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

	public String getWeapon() {
		return weapon;
	}

	/**
	 * @param name the name to set
	 */
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

}
