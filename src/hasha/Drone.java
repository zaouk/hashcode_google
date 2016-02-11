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
	
	public void LoadItem(ProductType type,int nb)
	{
		if(type.weight*nb>maxPayLoad)
		{
			//can't load 
		}
		else
		{	currentPayLoad+=type.weight*nb;
			items.put(type, nb);
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
