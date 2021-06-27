package br.com.efalcao.mvc.treitdt.geojson;

import br.com.efalcao.mvc.treitdt.domain.Localizacao;

public class Feature {

	private final String type = "Feature";
	private Object properties;
	private Geometry geometry;
	
	public Feature(Object properties, Geometry geometry) {
		super();
		this.properties = properties;
		this.geometry = geometry;
	}

	public Object getProperties() {
		return properties;
	}

	public void setProperties(Localizacao properties) {
		this.properties = properties;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getType() {
		return type;
	}
}