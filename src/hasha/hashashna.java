package hasha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class hashashna {
	static Integer rowsMax, columnsMax, numberOfDrones, deadlineTime, maxLoad;
	static ArrayList<Drone> drones;
	static Integer numberOrders;
	static ArrayList<Order> orders;

	static Integer Max;
	static HashMap<Integer, ProductType> prods;
	static ArrayList<Warehouse> warehouses;
	static HashMap<ProductType, Integer> items;
	static int nbProds;

	public static void parseHeader(String line) {
		String[] splitline;
		splitline = line.split(" ");
		rowsMax = Integer.parseInt(splitline[0]);
		columnsMax = Integer.parseInt(splitline[1]);
		numberOfDrones = Integer.parseInt(splitline[2]);
		deadlineTime = Integer.parseInt(splitline[3]);
		maxLoad = Integer.parseInt(splitline[4]);

		drones = new ArrayList<Drone>();
		for (int i = 0; i < numberOfDrones; i++) {
			drones.add(new Drone(maxLoad, i));
		}

	}

	public static void parseOrder(BufferedReader br) throws IOException {
		String line = br.readLine();
		String[] splitted;
		Integer r, c, L;
		numberOrders = Integer.parseInt(line.split("\\s+")[0]);
		orders = new ArrayList<Order>();
		for (int i = 0; i < numberOrders; i++) {
			line = br.readLine();
			splitted = line.split("\\s+");
			r = Integer.parseInt(splitted[0]);
			c = Integer.parseInt(splitted[1]);
			line = br.readLine();
			L = Integer.parseInt(line.split("\\s+")[0]);
			Order order = new Order(new Point(r, c), i);

			line = br.readLine();

			splitted = line.split("\\s+");
			order.nbItems = L;
			for (int j = 0; j < L; j++) {
				order.addItem(prods.get(Integer.parseInt(splitted[j])), 1);
			}
			orders.add(order);
		}
	}

	public static void readProductTypes(BufferedReader br) {
		nbProds = 0;

		String prodWeights;
		String[] weights;
		try {
			nbProds = Integer.parseInt(br.readLine().split("\\s+")[0]);
			prodWeights = br.readLine();
			weights = prodWeights.split("\\s+");

			prods = new HashMap<>();
			for (int i = 0; i < nbProds; i++) {
				prods.put(i, new ProductType(i, Integer.parseInt(weights[i])));
			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public static void readWareHouses(BufferedReader br) {
		int r, c;
		String[] ll;
		try {

			int nbwarehouse = Integer.parseInt(br.readLine().split("\\s+")[0]);
			for (int i = 0; i < nbwarehouse; i++) {
				String loca = br.readLine();
				ll = loca.split("\\s+");
				r = Integer.parseInt(ll[0]);
				c = Integer.parseInt(ll[1]);
				HashMap<ProductType, Integer> curitems = new HashMap<ProductType, Integer>();

				String items = br.readLine();
				String[] ss = items.split("\\s+");
				for (int j = 0; j < nbProds; j++) {
					if (!ss[j].equals("0")) {
						// there are items of this prodtype
						curitems.put(prods.get(j), Integer.parseInt(ss[j]));
					}
				}
				warehouses = new ArrayList<>();
				warehouses.add(new Warehouse(new Point(r, c), curitems, i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void parseFile() {
		BufferedReader br;
		try {

//			br = new BufferedReader(
//					new FileReader("C:\\Users\\Dandachi\\workspace\\hashcode_google\\src\\busy_day.in"));
//			 br = new BufferedReader(new FileReader(
//			 "C:\\Users\\Dandachi\\workspace\\hashcode_google\\src\\mother_of_all_warehouses.in"));
			br = new BufferedReader(
					new FileReader("C:\\Users\\Dandachi\\workspace\\hashcode_google\\src\\redundancy.in"));
			String line = br.readLine();
			// init header
			parseHeader(line);
			readProductTypes(br);
			readWareHouses(br);
			parseOrder(br);


			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		parseFile();
		Queue<String> printables = new LinkedList<>();
		Boolean finished = false;
		while (!finished) {
			Double zedna=0.0;
			for (Order o : orders) {
				Warehouse min = new Warehouse(new Point(1, 1), new HashMap<ProductType, Integer>(), -1);
				Double distMin = Double.MAX_VALUE, percOrder = 0.0, dist = 0.0;
				Integer eddon = 0;
				HashMap<ProductType, Integer> lifinane5domin = new HashMap<ProductType, Integer>();
				
				for (Warehouse wh : warehouses) {
					eddon = 0;
					dist = 0.0;
					percOrder = 0.0;
					HashMap<ProductType, Integer> lifinane5do = new HashMap<ProductType, Integer>();
					dist = Point.Distance(wh.location, o.location);
					for (ProductType pt : o.items.keySet()) {
						Integer badna = o.items.get(pt);
						if (!wh.items.containsKey(pt))
							continue;
						Integer whB2albo = wh.items.get(pt);
						if (badna - whB2albo <= 0) {
							eddon += badna;
							lifinane5do.put(pt, badna);
						} else {
							eddon += whB2albo;
							lifinane5do.put(pt, whB2albo);
						}
					}
					percOrder = eddon.doubleValue() / o.nbItems.doubleValue();
					zedna+=percOrder;
					if (percOrder > 0.0)
						dist = dist / percOrder;
					else
						dist = Double.MAX_VALUE;
					if (dist <= distMin) {
						distMin = dist;
						min = wh;
						lifinane5domin = lifinane5do;
					}

				}
				if(zedna==0.0)
					break;
				Double distDronMin = Double.MAX_VALUE;
				Drone droneMin = new Drone();
				for (Drone drone : drones) {
					Double distDron = Point.Distance(drone.location, min.location) + drone.currentTurn;
					if (distDron <= distDronMin && drone.currentTurn + 2 * distDron < deadlineTime) {
						distDronMin = distDron;
						droneMin = drone;
					}

				}
				// System.out.println(droneMin.currentTurn);
				droneMin.LoadItems(lifinane5domin, min, printables);
				droneMin.Deliver(o, printables);

			}
			if(zedna==0.0)
				break;

			finished = true;
			for (Order o : orders)
				finished = finished && o.isFinished();

		}
		System.out.println(printables.size());
		while (!printables.isEmpty())
			System.out.println(printables.remove());
	}

}
