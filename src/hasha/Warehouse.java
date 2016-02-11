package hasha;

public class Warehouse {

	Point location;
	HashMap<ProductType,Integer> items;
	public Warehouse(Point p,Map<ProductType,Integer> initItems) {
		items=inititems;
		location=p;
	}
	public bool takeItem(ProductType type,Integer count)
	{
		Integer currentCount=items.get(type);
		if(currentCount>=count)
		{
			items.set(type,currentCount-count)
			return true;
		}
		else return false;
	}
	public Integer getCount(ProductType type)
	{
		return items.get(type);
	}

}
