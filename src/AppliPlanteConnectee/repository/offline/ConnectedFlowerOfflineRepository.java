package AppliPlanteConnectee.repository.offline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import AppliPlanteConnectee.model.ConnectedFlower;
import AppliPlanteConnectee.repository.Repository;

/**
 * @author sebbo
 *
 */
public class ConnectedFlowerOfflineRepository implements Repository<ConnectedFlower> {

	private List<ConnectedFlower> connectedFlowers = new ArrayList<>();

	public ConnectedFlowerOfflineRepository() {
		addOrUpdate(new ConnectedFlower("Rose"));
		addOrUpdate(new ConnectedFlower("Pissenlit"));
	}

	@Override
	public void addOrUpdate(ConnectedFlower item) {
		if (item.getId() > 0) {
			connectedFlowers.remove(item);
		} else {
			int id = 0;
			if (!connectedFlowers.isEmpty()) {
				id = connectedFlowers.stream().max(Comparator.comparingInt(ConnectedFlower::getId)).get().getId();
			}
			item.setId(id + 1);
		}
		connectedFlowers.add(item);
	}

	@Override
	public List<ConnectedFlower> getAll() {
		return connectedFlowers;
	}

	@Override
	public ConnectedFlower get(int id) {
		return connectedFlowers.stream().filter(flowers -> flowers.getId() == id).findFirst().get();
	}

	@Override
	public void remove(ConnectedFlower item) {
		connectedFlowers.remove(item);
	}

}
