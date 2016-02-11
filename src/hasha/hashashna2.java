package hasha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class hashashna2 {
	Integer Max;
	HashMap<Integer,ProductType> prods;
	ArrayList<Warehouse> warehouses;
	HashMap<ProductType,Integer> items;
	int nbProds;

	public void parseHeader(String line)
	{
		
	}
	
	public void readProductTypes(BufferedReader br)
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
	
	public void readWareHouses(BufferedReader br)
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
			for(int i=0i<nbProds;i++)
			{
				if(!ss[i].equals("0"))
				{
					//there are items of this prodtype
					curitems.put(prods.get(i), Integer.parseInt(ss[i]));
				}
			}
			warehouses.add(new Warehouse(new Point(r,c),curitems));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
			while (line != null) {
				splitline = line.split(" ");
				if (countu < Max) {
					countu++;

				} else {
				}
				line = br.readLine();

			}
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
