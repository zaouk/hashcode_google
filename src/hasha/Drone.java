package hasha;

import java.util.HashMap;

public class Drone {

	int maxPayLoad=0;
	HashMap<ProductType, Integer> items;
	Point location=new Point(1, 1);
	int currentPayLoad;
	Integer currentTurn;
	

	public Drone(int maxPayLoad)
	{
		location=new Point(1, 1);
		this.maxPayLoad=maxPayLoad;
	}
	public Drone()
	{
		
	}
	
	public void LoadItems(HashMap<ProductType,Integer> itemsToLoad)
	{
		for(ProductType pt:itemsToLoad.keySet())
		{
			
		}
	}
	public void Deliver(Order order, HashMap<ProductType,Integer> items)
	{
		currentTurn+=Point.Distance(location, order.location).intValue()+1;
		for(ProductType pt:items.keySet())
				order.removeItems(pt,items.get(pt));
		
		
		
		
	}
	public static void main(String args[])
	{
		System.out.println("hi");
	}
}
