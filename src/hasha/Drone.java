package hasha;

import java.util.HashMap;

public class Drone {

	int maxPayLoad;
	HashMap<ProductType, Integer> items;
	Point location;
	int currentPayLoad;
	

	public Drone(int maxPayLoad)
	{
		location=new Point(1, 1);
		this.maxPayLoad=maxPayLoad;
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
		
	}
	public static void main(String args[])
	{
		System.out.println("hi");
	}
}
