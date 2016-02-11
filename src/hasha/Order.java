package hasha;

import java.util.HashMap;
import java.util.TreeMap;

public class Order {
	public HashMap<ProductType, Integer> items;
	public Point location;
	public Integer nbItems;

	public Order(Point p) {
		location = p;
	}

	public void addItem(ProductType type, Integer nbitems) {
		if (!items.containsKey(type))
			items.put(type, nbitems);
		else {
			items.put(type, items.get(type)+nbitems);
		}
	}

	public Boolean removeItems(ProductType type, Integer nbItems) {
		Integer currentCount = items.get(type);
		if (currentCount > nbItems) {
			items.put(type, currentCount - nbItems);
			return true;
		} else {
			if (currentCount == nbItems) {
				items.remove(type);
				return true;
			} else
				return false;
		}
	}

	public Integer getCount(ProductType type) {
		if (items.containsKey(type))
			return items.get(type);
		return 0;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
