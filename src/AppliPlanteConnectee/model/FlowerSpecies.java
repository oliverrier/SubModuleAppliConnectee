/**
 * 
 */

/**
 * @author Irohn
 *
 */
public abstract class FlowerSpecies {

	private int id;

	private String flowerSpeciesName;

	private int idealTemperature;
	
	private int idealLuminosity;
	
	private boolean idealHumidity;
	
	private Date startBlossoming;

	private Date endBlossoming;
	
	public Flower(int id, String flowerSpeciesName, int idealTemperature, int idealLuminosity, boolean idealHumidity, Date startBlossoming, Date endBlossoming) {
		this.id = id;
		this.flowerSpeciesName = flowerSpeciesName;
		this.idealTemperature = idealTemperature;
		this.idealLuminosity = idealLuminosity;
		this.idealHumidity = idealHumidity;
		this.startBlossoming = startBlossoming;
		this.endBlossoming = endBlossoming;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getFlowerSpeciesName(){
		return this.flowerSpeciesName;
	}
	
	public void setFlowerSpeciesName(int flowerSpeciesName) {
		this.flowerSpeciesName = flowerSpeciesName;
	}
	
	public int getIdealTemperature(){
		return this.idealTemperature;
	}
	
	public void setIdealTemperature(int idealTemperature) {
		this.idealTemperature = idealTemperature;
	}
	
	public int getIdealLuminosity(){
		return this.idealLuminosity;
	}
	
	public void setIdealLuminosity(int idealLuminosity) {
		this.idealLuminosity = idealLuminosity;
	}
	
	public boolean getIdealHumidity(){
		return this.idealHumidity;
	}
	
	public void setIdealHumidity(int idealHumidity) {
		this.idealHumidity = idealHumidity;
	}
	
	public Date getStartBlossoming(){
		return this.startBlossoming;
	}
	
	public void setStartBlossoming(Date startBlossoming) {
		this.startBlossoming = startBlossoming;
	}
	
	public Date getEndBlossoming(){
		return this.endBlossoming;
	}
	
	public void setEndBlossoming(int endBlossoming) {
		this.endBlossoming = endBlossoming;
	}
	
	
}
