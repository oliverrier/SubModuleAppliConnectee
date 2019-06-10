package AppliPlanteConnectee.model;

import java.util.Date;

public class FlowerSummary {

		private int id;
		private int athmosphericTemperature;
		private int luminosity;
		private boolean humidity;
		private Date dateHour;
		private int idConnectedFlower;
		
		public FlowerSummary() {
			this.id = 1;
			this.athmosphericTemperature = 30;
			this.luminosity = 30;
			this.humidity = true;
			this.dateHour = new Date ();
			this.idConnectedFlower = 1;
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
		 * @return the athmosphericTemperature
		 */
		public int getAthmosphericTemperature() {
			return athmosphericTemperature;
		}
		/**
		 * @param athmosphericTemperature the athmosphericTemperature to set
		 */
		public void setAthmosphericTemperature(int athmosphericTemperature) {
			this.athmosphericTemperature = athmosphericTemperature;
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
		 * @return the dateHour
		 */
		public Date getDateHour() {
			return dateHour;
		}
		/**
		 * @param dateHour the dateHour to set
		 */
		public void setDateHour(Date dateHour) {
			this.dateHour = dateHour;
		}
		/**
		 * @return the idConnectedFlower
		 */
		public int getIdConnectedFlower() {
			return idConnectedFlower;
		}
		/**
		 * @param idConnectedFlower the idConnectedFlower to set
		 */
		public void setIdConnectedFlower(int idConnectedFlower) {
			this.idConnectedFlower = idConnectedFlower;
		}
}
