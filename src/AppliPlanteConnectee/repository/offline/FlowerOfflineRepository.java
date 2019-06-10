package AppliPlanteConnectee.repository.offline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import AppliPlanteConnectee.model.Flower;
import AppliPlanteConnectee.repository.Repository;

/**
 * @author sebbo
 *
 */
public class FlowerOfflineRepository implements Repository<Flower> {

	private List<Flower> flowers = new ArrayList<>();

	public FlowerOfflineRepository() {
		addOrUpdate(new Flower("Rose"));
		addOrUpdate(new Flower("Pissenlit"));
	}

	@Override
	public void addOrUpdate(Flower item) {
		if (item.getId() > 0) {
			flowers.remove(item);
		} else {
			int id = 0;
			if (!flowers.isEmpty()) {
				id = flowers.stream().max(Comparator.comparingInt(Flower::getId)).get().getId();
			}
			item.setId(id + 1);
		}
		flowers.add(item);
	}

	@Override
	public List<Flower> getAll() {
		return flowers;
	}

	@Override
	public Flower get(int id) {
		return flowers.stream().filter(flowers -> flowers.getId() == id).findFirst().get();
	}

	@Override
	public void remove(Flower item) {
		flowers.remove(item);
	}

}
