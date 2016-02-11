package hasha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class hashashna2 {
	Integer Max;
	HashMap<Integer,ProductType> prods;

	public void parseHeader(String line)
	{
		
	}
	
	public void readProductTypes(BufferedReader br)
	{
		int nbProds;
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
	
	public void 

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
