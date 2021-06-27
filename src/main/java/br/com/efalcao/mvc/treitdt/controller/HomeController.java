package br.com.efalcao.mvc.treitdt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import br.com.efalcao.mvc.treitdt.domain.Localizacao;
import br.com.efalcao.mvc.treitdt.geojson.FeatureCollection;
import br.com.efalcao.mvc.treitdt.geojson.FeatureFactory;
import br.com.efalcao.mvc.treitdt.model.Area;
import br.com.efalcao.mvc.treitdt.repository.AreaRepository;


@Controller
public class HomeController {
	
	@GetMapping("/index")
	public String home() throws IOException {
		
//		listar();
		
		
//		JSONObject featureCollection = new JSONObject();
//		featureCollection.put("type", "FeatureCollection");
//		JSONObject properties = new JSONObject();
//		properties.put("name", "ESPG:4326");
//		JSONObject crs = new JSONObject();
//		crs.put("type", "name");
//		crs.put("properties", properties);
//		featureCollection.put("crs", crs);
//
//		JSONArray features = new JSONArray();
//		JSONObject feature = new JSONObject();
//		feature.put("type", "Feature");
//		JSONObject geometry = new JSONObject();
//
//		JSONArray JSONArrayCoord = new JSONArray();
//
//		JSONArrayCoord.add(0, 55);
//		JSONArrayCoord.add(1, 55);
//		geometry.put("type", "Point");
//		geometry.put("coordinates", JSONArrayCoord);
//		feature.put("geometry", geometry);
//
//		features.add(feature);
//		featureCollection.put("features", features);
		
		
//		Point point = new Point();
//		GeometryJSON g = new GeometryJSON();
//		Geometry geometry = ...;
//		g.write(geometry, new File("geometry.json"));
//				
		return "index";
	}
	
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/area")
	public String area(Model model) {
		List<Area> areas = areaRepository.findAll();		
		model.addAttribute("areas", areas);
		return "area";
	}
	
	
	

}
