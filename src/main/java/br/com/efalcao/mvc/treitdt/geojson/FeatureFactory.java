package br.com.efalcao.mvc.treitdt.geojson;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class FeatureFactory {
	
	private FeatureFactory() {
	}
	
	public static FeatureCollection featureMaker(Object object, List<Double> coords) {
		FeatureCollection featureCollection = new FeatureCollection();
		
		Geometry geometry = new Geometry(coords);
		Feature feature = new Feature(object, geometry);
		
		
		featureCollection.addFeature(feature);
		
		return featureCollection;
	}
	
	public static FeatureCollection featureCollectionMaker(Map<Object, List<Double>> objects) {
		FeatureCollection featureCollection = new FeatureCollection();
		
		for (Map.Entry<Object, List<Double>> obj : objects.entrySet()) {
			Geometry geometry = new Geometry(obj.getValue());
			Feature feature = new Feature(obj.getKey(), geometry);
			featureCollection.addFeature(feature);
		}
		
		return featureCollection;
	} 
	
	public static void featureCollectionFileMaker(FeatureCollection featureCollection, String path) throws IOException {
		
		Gson gson = new Gson();
		String featureJSON = gson.toJson(featureCollection);
		
		FileWriter fw = new FileWriter(path);
		PrintWriter p = new PrintWriter(fw);
		
		p.print(featureJSON);
		p.close();
	}
}