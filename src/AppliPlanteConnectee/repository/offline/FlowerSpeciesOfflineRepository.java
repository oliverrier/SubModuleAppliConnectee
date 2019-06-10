package AppliPlanteConnectee.repository.offline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import AppliPlanteConnectee.model.FlowerSpecies;
import AppliPlanteConnectee.repository.Repository;

public class FlowerSpeciesOfflineRepository implements Repository<FlowerSpecies> {
	
	private List<FlowerSpecies> flowerSpecies = new ArrayList<>();

	public FlowerSpeciesOfflineRepository() {
		addOrUpdate(new FlowerSpecies());
		addOrUpdate(new FlowerSpecies());
	}

	@Override
	public void addOrUpdate(FlowerSpecies item) {
		if (item.getId() > 0) {
			flowerSpecies.remove(item);
		} else {
			int id = 0;
			if (!flowerSpecies.isEmpty()) {
				id = flowerSpecies.stream().max(Comparator.comparingInt(FlowerSpecies::getId)).get().getId();
			}
			item.setId(id + 1);
		}
		flowerSpecies.add(item);
	}

	@Override
	public List<FlowerSpecies> getAll() {
		return flowerSpecies;
	}

	@Override
	public FlowerSpecies get(int id) {
		return flowerSpecies.stream().filter(flowerSpecies -> flowerSpecies.getId() == id).findFirst().get();
	}

	@Override
	public void remove(FlowerSpecies item) {
		flowerSpecies.remove(item);
	}

}
