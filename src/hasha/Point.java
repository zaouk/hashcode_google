package hasha;

public class Point {
	public Integer r,c;
	public Point(Integer r,Integer c)
	{
		this.r=r;
		this.c=c;
	}
	public static Double Distance(Point p1,Point p2){
		return Math.sqrt((p1.r - p2.r) * (p1.r - p2.r)
				+ (p1.c - p2.c) * (p1.c - p2.c));
	}
}
