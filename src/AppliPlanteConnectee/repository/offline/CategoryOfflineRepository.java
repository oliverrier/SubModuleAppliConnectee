package AppliPlanteConnectee.repository.offline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import AppliPlanteConnectee.model.Category;
import AppliPlanteConnectee.repository.Repository;

public class CategoryOfflineRepository implements Repository<Category>{
	
	private List<Category> categories = new ArrayList<>();

	public CategoryOfflineRepository() {
		addOrUpdate(new Category());
		addOrUpdate(new Category());
	}

	@Override
	public void addOrUpdate(Category item) {
		if (item.getId() > 0) {
			categories.remove(item);
		} else {
			int id = 0;
			if (!categories.isEmpty()) {
				id = categories.stream().max(Comparator.comparingInt(Category::getId)).get().getId();
			}
			item.setId(id + 1);
		}
		categories.add(item);
	}

	@Override
	public List<Category> getAll() {
		return categories;
	}

	@Override
	public Category get(int id) {
		return categories.stream().filter(categories -> categories.getId() == id).findFirst().get();
	}

	@Override
	public void remove(Category item) {
		categories.remove(item);
	}

}
