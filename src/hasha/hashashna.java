package hasha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class hashashna {
	Integer rowsMax,columnsMax,numberOfDrones,deadlineTime,maxLoad;
	ArrayList<Drone> drones;
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
			drones.add(new Drone());
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
