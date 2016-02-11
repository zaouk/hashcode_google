package hasha;

import java.util.ArrayList;

public class Order {
	ArrayList<ProductType> items;
	Point location;
	
	public Order()
	{
		
	}
	
	public ArrayList<ProductType> getItems() {
		return items;
	}
	public void setItems(ArrayList<ProductType> items) {
		this.items = items;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	

}
