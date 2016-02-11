package hasha;

import java.util.HashMap;

public class Drone {

	int maxPayLoad = 0;
	HashMap<ProductType, Integer> items=new HashMap<>();
	Point location = new Point(1, 1);
	int currentPayLoad = 0;
	Integer currentTurn=0;
	Integer id;

	public Drone(int maxPayLoad, Integer id) {
		location = new Point(1, 1);
		this.id = id;
		this.maxPayLoad = maxPayLoad;
	}

	public Drone() {

	}

	public void LoadItems(HashMap<ProductType, Integer> itemsToLoad, Warehouse wh) {
		String toPrint = "";
		currentTurn = Point.Distance(wh.location, location).intValue() + 1;
		location = wh.location;
		for (ProductType pt : itemsToLoad.keySet()) {
			if(pt.id==null)
				continue;
			Integer itemsLoad = (maxPayLoad - currentPayLoad) / pt.weight;
			Integer lifinane5do = itemsLoad > itemsToLoad.get(pt) ? itemsToLoad.get(pt) : itemsLoad;
			if (items.containsKey(pt))
				items.put(pt, items.get(pt) + lifinane5do);
			else
				items.put(pt, +lifinane5do);
			if (lifinane5do > 0) {
				toPrint = id + " L " + wh.id + " " + pt.id + " " + lifinane5do;
				wh.takeItem(pt, +lifinane5do);
				System.out.println(toPrint);

			}

		}
	}

	public void Deliver(Order order) {
		currentTurn += Point.Distance(location, order.location).intValue() + 1;
		if(items.keySet()==null||items==null)
			return;
		for (ProductType pt : items.keySet()) {
			if(pt.id==null)
				continue;
			order.removeItems(pt, items.get(pt));

			System.out.println(id + " D " + order.id + " " + pt.id + " " + items.get(pt));
		}
		items=new HashMap<ProductType,Integer>();

	}

}
