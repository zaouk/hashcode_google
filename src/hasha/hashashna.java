package hasha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class hashashna {
	static Integer rowsMax,columnsMax,numberOfDrones,deadlineTime,maxLoad;
	static ArrayList<Drone> drones;
	static Integer numberOrders;
	static ArrayList<Order> orders;
	
	static Integer Max;
	static HashMap<Integer,ProductType> prods;
	static ArrayList<Warehouse> warehouses;
	static HashMap<ProductType,Integer> items;
	static int nbProds;

	
	public static void parseHeader(String line)
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
	public static void parseOrder(BufferedReader br) throws IOException
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
	public static void readProductTypes(BufferedReader br)
	{
		nbProds=0;
		
		String prodWeights;
		String[] weights;
		try {
			nbProds=Integer.parseInt(br.readLine());
			prodWeights=br.readLine();
			weights=prodWeights.split("\\s+");
			
			for(int i=0;i<nbProds;i++)
			{
				prods.put(i, new ProductType(i,Integer.parseInt(weights[i])));
			}
			
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void readWareHouses(BufferedReader br)
	{
		int r,c;
		String[] ll;
		try {
			
			int nbwarehouse=Integer.parseInt(br.readLine());
			for(int i=0;i<nbwarehouse;i++)
			{
			String loca=br.readLine();
			ll=loca.split("\\s+");
			r=Integer.parseInt(ll[0]);
			c=Integer.parseInt(ll[1]);
			HashMap<ProductType,Integer> curitems=new HashMap<>();
			
			String items=br.readLine();
			String[] ss=items.split("\\s+");
			for(int j=0;j<nbProds;j++)
			{
				if(!ss[j].equals("0"))
				{
					//there are items of this prodtype
					curitems.put(prods.get(j), Integer.parseInt(ss[j]));
				}
			}
			warehouses.add(new Warehouse(new Point(r,c),curitems));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void parseFile()
	{	
		BufferedReader br;
		try {
			
			br = new BufferedReader(new FileReader("samplein.in"));

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
		parseFile();

	}

}
