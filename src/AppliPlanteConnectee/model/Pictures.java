package AppliPlanteConnectee.model;

public class Pictures {

		private int id;
		
		private String picture;
		
		private int idFlowerSpecies;
		
		public Pictures() {
			this.id = 1;
			this.picture = "Lien vers l'image";
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
		 * @return the picture
		 */
		public String getPicture() {
			return picture;
		}

		/**
		 * @param picture the picture to set
		 */
		public void setPicture(String picture) {
			this.picture = picture;
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
