/**
 * 
 */
package laboCrudJavaFx.model;

/**
 * @author sebbo
 *
 */
public class Flower extends FlowerSpecies {

	private int id;

	private String flowerName;

	private int actualTemperature;
	
	private int actualLuminosity;
	
	private boolean actualHumidity;
	
	private Date time;
	
	public Flower(String flowerName) {
		this.super();
		this.flowerName = flowerName;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFlowerName(){
		return this.flowerName}
	
	public void setFlowerName(String flowerName) {
		this.flowerName;
	}
	
	public int getActualTemperature(){
		return this.actualTemperature;
	}
	
	public void setActualTemperature(int actualTemperature) {
		this.actualTemperature = actualTemperature;
	}
	
	public int getAcualLuminosity(){
		return this.actualLuminosity;
	}
	
	public void setActualLuminosity(int actualLuminosity) {
		this.actualLuminosity = actualLuminosity;
	}
	
	public boolean getActualHumidity){
		return this.actualHumidity;
	}
	
	public void setActualHumidity(int actualHumidity) {
		this.actualHumidity = actualHumidity;
	}
	
	public Date getTime(){
		return this.time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
}