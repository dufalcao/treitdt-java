package br.com.efalcao.mvc.treitdt.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.efalcao.mvc.treitdt.domain.Localizacao;
import br.com.efalcao.mvc.treitdt.geojson.FeatureCollection;
import br.com.efalcao.mvc.treitdt.geojson.FeatureFactory;
import br.com.efalcao.mvc.treitdt.model.Area;
import br.com.efalcao.mvc.treitdt.repository.AreaRepository;


@RestController
@RequestMapping(value = "/localizacoes")
public class AreaResource {
	
	@Autowired
	AreaRepository areaRepository;

	@RequestMapping(method = RequestMethod.GET)
	public FeatureCollection listar() throws IOException {
		return geraFeature();
	}
	
	private FeatureCollection geraFeature() throws IOException {
		
		/*
		 * Gera FeatureCollection com inserção manual de Feature
		 * 
		 */
//		List<Double> points = geraListLocalizacoes().get(0).getPoints();
//		FeatureCollection fc = FeatureFactory.featureMaker(geraListLocalizacoes().get(0), points);
		
		/**
		 * Gera FeatureCollection com base numa lista
		 */
//		FeatureCollection fc = new FeatureCollection();
//		
//		for (Localizacao local : geraListLocalizacoes()) {
//			List<Double> points = local.getPoints();
//			Geometry geometry = new Geometry(points);
//			Feature feature = new Feature(local, geometry);
//			fc.addFeature(feature);
//		}
		
		/*
		 * Gera FeatureColection com base em um Map<Localizacao, List<Double>>
		 * 
		 */
		FeatureCollection fc = FeatureFactory.featureCollectionMaker(geraMapLocalizacoes());
		
		/*
		 * 
		 * Gera arquivo JSON no projeto
		 */
//		String path = "/home/rafael/Documents/workspace-spring-tool-suite/starterspringexemplo-json/src/main/resources/static/fc.json";
//		String path = "/Users/eduardofalcao/Downloads/treitdt/src/main/resources/static/js/area_geojsonNovo";

//		FeatureFactory.featureCollectionFileMaker(fc, path);
		
		return fc;
	}
	
	private List<Localizacao> geraListLocalizacoes() {
		List<Localizacao> localizacoes = new ArrayList<>();
		
		List<Double> points1 = new ArrayList<Double>();
		points1.add(-48.043212890625);
		points1.add(-22.41102852155869);
		Localizacao local1 = new Localizacao(
				1, "Café Java", "Rua 66, n 100", "11 9 8888 8888", "contato@cafejava.com.br", points1);
		
		List<Double> points2 = new ArrayList<Double>();
		points2.add(-54.594647);
		points2.add(-25.430194);
		Localizacao local2 = new Localizacao(
				1, "Café Java", "Rua 66, n 100", "11 9 8888 8888", "contato@cafejava.com.br", points2);
		
		List<Double> points3 = new ArrayList<Double>();
		points3.add(-48.043212890625);
		points3.add(-22.41102852155869);
		Localizacao local3 = new Localizacao(
				1, "Café Java", "Rua 66, n 100", "11 9 8888 8888", "contato@cafejava.com.br", points3);
		
		localizacoes.add(local1);
		localizacoes.add(local2);
		localizacoes.add(local3);
		
		return localizacoes;
	}
	
	private Map<Object, List<Double>> geraMapLocalizacoes() {
		Map<Object, List<Double>> localizacoes = new HashMap<>();
		
		List<Area> areas = areaRepository.findAll();
		String popupContent = "";
		
		for(Area area : areas) {
			area.setPopupContent("Nome: <b>" + area.getNome()+"</b>" + "<br>Tel:" + area.getTelefone());
			List<Double> point = new ArrayList<>();
			point.add(area.getLatitude());
			point.add(area.getLongitude());
			localizacoes.put(area, point);
		}
		
		
		
		
//		List<Double> points1 = new ArrayList<Double>();
//		points1.add(-54.594647);
//		points1.add(-25.430194);
//		Localizacao local1 = new Localizacao(
//				1, "Café Java", "Rua 66, n 100", "11 9 8888 8888", "contato@cafejava.com.br", points1);
//		
//		List<Double> points2 = new ArrayList<Double>();
//		points2.add(-48.043212890625);
//		points2.add(-22.41102852155869);
//		Localizacao local2 = new Localizacao(
//				1, "Café Java", "Rua 66, n 100", "11 9 8888 8888", "contato@cafejava.com.br", points2);
//		
//		List<Double> points3 = new ArrayList<Double>();
//		points3.add(-48.043212890625);
//		points3.add(-22.41102852155869);
//		Localizacao local3 = new Localizacao(
//				1, "Café Java", "Rua 66, n 100", "11 9 8888 8888", "contato@cafejava.com.br", points3);
//		
//		localizacoes.put(local1, points1);
//		localizacoes.put(local2, points2);
//		localizacoes.put(local3, points3);
		
		return localizacoes;
	}
	
}
