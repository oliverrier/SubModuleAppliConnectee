package AppliPlanteConnectee.repository.offline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import AppliPlanteConnectee.model.FlowerSummary;
import AppliPlanteConnectee.repository.Repository;

public class FlowerSummaryOfflineRepository implements Repository<FlowerSummary>{

	
	private List<FlowerSummary> flowerSummaries = new ArrayList<>();

	public FlowerSummaryOfflineRepository() {
		addOrUpdate(new FlowerSummary());
		addOrUpdate(new FlowerSummary());
	}

	@Override
	public void addOrUpdate(FlowerSummary item) {
		if (item.getId() > 0) {
			flowerSummaries.remove(item);
		} else {
			int id = 0;
			if (!flowerSummaries.isEmpty()) {
				id = flowerSummaries.stream().max(Comparator.comparingInt(FlowerSummary::getId)).get().getId();
			}
			item.setId(id + 1);
		}
		flowerSummaries.add(item);
	}

	@Override
	public List<FlowerSummary> getAll() {
		return flowerSummaries;
	}

	@Override
	public FlowerSummary get(int id) {
		return flowerSummaries.stream().filter(flowerSummaries -> flowerSummaries.getId() == id).findFirst().get();
	}

	@Override
	public void remove(FlowerSummary item) {
		flowerSummaries.remove(item);
	}
}
