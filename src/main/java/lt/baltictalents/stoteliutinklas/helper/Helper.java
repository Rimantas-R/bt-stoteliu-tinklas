package lt.baltictalents.stoteliutinklas.helper;

public class Helper {
	
	//https://en.wikipedia.org/wiki/Haversine_formula
	public static double getDistanceBetweenTwoPointsInMeters(double lat1,double lon1,double lat2,double lon2)
	{
		double R = 6378.137; // Radius of earth in KM
		double dLat = lat2 * Math.PI / 180 - lat1 * Math.PI / 180;
		double dLon = lon2 * Math.PI / 180 - lon1 * Math.PI / 180;
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	    Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
	    Math.sin(dLon/2) * Math.sin(dLon/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
	    return d * 1000; // meters
	}
}
