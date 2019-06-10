package AppliPlanteConnectee.model;

public class Category {

		private int id;
		
		private String categoryFlower;
		

		public Category(int id, String categoryFlower) {
		super();
		this.id = id;
		this.categoryFlower = categoryFlower;
	}
		
		public Category() {
			this.id = 1;
			this.categoryFlower = "Famille";
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
		 * @return the categoryFlower
		 */
		public String getCategoryFlower() {
			return categoryFlower;
		}

		/**
		 * @param categoryFlower the categoryFlower to set
		 */
		public void setCategoryFlower(String categoryFlower) {
			this.categoryFlower = categoryFlower;
		}
}
