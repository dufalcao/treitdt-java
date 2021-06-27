package br.com.efalcao.mvc.treitdt.geojson;

import java.util.ArrayList;
import java.util.List;

public class FeatureCollection {

	private final String type = "FeatureCollection";
	private List<Feature> features = new ArrayList<>();
	
	public FeatureCollection() {
	}
	
	public void addFeatures (List<Feature> features) {
		this.features = features;
	}
	
	public void addFeature (Feature feature) {
		this.features.add(feature);
	}

	public String getType() {
		return type;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}	
}