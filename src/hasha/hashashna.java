package hasha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class hashashna {
	Integer rowsMax,columnsMax,numberOfDrones,deadlineTime,maxLoad;
	ArrayList<Drone> drones;
	Integer numberOrders;
	ArrayList<Order> orders;
	
	HashMap<Integer,ProductType> prods;
	
	public void parseHeader(String line)
	{
		String[] splitline;
		splitline=line.split(" ");
		rowsMax=Integer.parseInt(splitline[0]);
		columnsMax=Integer.parseInt(splitline[1]);
		numberOfDrones=Integer.parseInt(splitline[2]);
		deadlineTime=Integer.parseInt(splitline[3]);
		maxLoad=Integer.parseInt(splitline[4]);
		
		drones=new ArrayList<Drone>();
		for(int i=0;i<numberOfDrones;i++)
		{
			drones.add(new Drone(maxLoad));
		}
		
	}
	public void parseOrder(BufferedReader br) throws IOException
	{
		String line=br.readLine();
		String[] splitted;
		Integer r,c,L;
		numberOrders=Integer.parseInt(line);
		orders=new ArrayList<Order>();
		for(int i=0;i<numberOrders;i++)
		{
			line=br.readLine();
			splitted=line.split("");
			r=Integer.parseInt(splitted[0]);
			c=Integer.parseInt(splitted[1]);
			line=br.readLine();
			L=Integer.parseInt(line);
			Order order=new Order(new Point(r, c));
			
			
			line=br.readLine();
			splitted=line.split("");
			
			for(int j=0;j<L;j++)
			{
				order.addItem(prods.get(j), 1);
			}
			orders.add(order);
		}
	}
	public void parseFile()
	{	
		BufferedReader br;
		try {
			
			br = new BufferedReader(new FileReader("/home/dandachi/workspace/hash/src/dc.in"));

			String line = br.readLine();
			String[] splitline;
			// init header
			parseHeader(line);
			// init u
			line = br.readLine();
			int countu = 0;
			
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("nothing");

	}

}
