package lt.baltictalents.stoteliutinklas.data.beans;

public class Station {
	String name;
	String longtitute;
	String latitude;
	String[] routes;

	public Station(String name, String lon, String lat, String[] routes) {
		super();
		this.name = name;
		this.longtitute = lon;
		this.latitude = lat;
		this.routes = routes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongtitute() {
		return longtitute;
	}

	public void setLongtitute(String longtitute) {
		this.longtitute = longtitute;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String[] getRoutes() {
		return routes;
	}

	public void setRoutes(String[] routes) {
		this.routes = routes;
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder(getName());
	    sb.append("    longit.: ").append(getLongtitute()).append(";  latit.: ").append(getLatitude());
	    return sb.toString();
	}
	
	public String toLongString() {
	    StringBuilder sb = new StringBuilder(this.toString());
	    for(String s: getRoutes()) {sb.append("\n   -   ").append(s);}
	    return sb.toString();
	}
	
	public double getDistanceDeg(Coordinates coordinates) {
	    double stationLongitude = Double.parseDouble(this.getLongtitute());
	    double deltaLongitude = coordinates.getLongitude() - stationLongitude;
	    double stationLatitude = Double.parseDouble(this.getLatitude());
	    double deltaLatitude = coordinates.getLatitude() - stationLatitude;
	    deltaLongitude = deltaLongitude * Math.cos(stationLatitude * 2 * Math.PI /360);//correction for latitude
	    
	    double distance = deltaLongitude * deltaLongitude + deltaLatitude * deltaLatitude;
	    distance = Math.sqrt(distance);
	    return distance;
	    }

}