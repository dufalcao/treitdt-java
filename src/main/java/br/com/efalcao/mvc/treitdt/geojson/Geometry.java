package br.com.efalcao.mvc.treitdt.geojson;

import java.util.List;

public class Geometry {

	private final String type = "Point";
	private List<Double> coordinates;
	
	public Geometry(List<Double> coordinates) {
		super();
		this.coordinates = coordinates;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}
}