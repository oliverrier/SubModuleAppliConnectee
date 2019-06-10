package AppliPlanteConnectee.repository.offline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import AppliPlanteConnectee.model.Pictures;
import AppliPlanteConnectee.repository.Repository;

public class PicturesOfflineRepository implements Repository<Pictures>{

	private List<Pictures> pictures = new ArrayList<>();

	public PicturesOfflineRepository() {
		addOrUpdate(new Pictures());
		addOrUpdate(new Pictures());
	}

	@Override
	public void addOrUpdate(Pictures item) {
		if (item.getId() > 0) {
			pictures.remove(item);
		} else {
			int id = 0;
			if (!pictures.isEmpty()) {
				id = pictures.stream().max(Comparator.comparingInt(Pictures::getId)).get().getId();
			}
			item.setId(id + 1);
		}
		pictures.add(item);
	}

	@Override
	public List<Pictures> getAll() {
		return pictures;
	}

	@Override
	public Pictures get(int id) {
		return pictures.stream().filter(pictures -> pictures.getId() == id).findFirst().get();
	}

	@Override
	public void remove(Pictures item) {
		pictures.remove(item);
	}
}
