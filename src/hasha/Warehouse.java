package hasha;

import java.util.HashMap;

public class Warehouse {

	Integer id;
	Point location;
	HashMap<ProductType,Integer> items;
	public Warehouse(Point p,HashMap<ProductType,Integer> initItems) {
		items=initItems;
		location=p;
	}
	public boolean takeItem(ProductType type,Integer count)
	{
		Integer currentCount=items.get(type);
		if(currentCount>=count)
		{
			items.put(type,currentCount-count);
			return true;
		}
		else return false;
	}
	public Integer getCount(ProductType type)
	{
		return items.get(type);
	}

}
