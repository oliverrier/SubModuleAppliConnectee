package laboCrudJavaFx.repository.offline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import laboCrudJavaFx.model.Poney;
import laboCrudJavaFx.repository.Repository;

/**
 * @author sebbo
 *
 */
public class PoneyOfflineRepository implements Repository<Poney> {

	private List<Poney> poneys = new ArrayList<>();

	public PoneyOfflineRepository() {
		addOrUpdate(new Poney("Bob"));
		addOrUpdate(new Poney("George"));
	}

	@Override
	public void addOrUpdate(Poney item) {
		if (item.getId() > 0) {
			poneys.remove(item);
		} else {
			int id = 0;
			if (!poneys.isEmpty()) {
				id = poneys.stream().max(Comparator.comparingInt(Poney::getId)).get().getId();
			}
			item.setId(id + 1);
		}
		poneys.add(item);
	}

	@Override
	public List<Poney> getAll() {
		return poneys;
	}

	@Override
	public Poney get(int id) {
		return poneys.stream().filter(poney -> poney.getId() == id).findFirst().get();
	}

	@Override
	public void remove(Poney item) {
		poneys.remove(item);
	}

}
