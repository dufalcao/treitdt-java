package br.com.efalcao.mvc.treitdt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.efalcao.mvc.treitdt.dto.RequisicaoNovaArea;
import br.com.efalcao.mvc.treitdt.model.Area;
import br.com.efalcao.mvc.treitdt.repository.AreaRepository;

@Controller
@RequestMapping("area")
public class AreaController {
	
//	@Autowired
//	private AreaRepository areaRepository;
//	
//	@GetMapping("/area")
//	public String area(Model model) {
//		List<Area> areas = areaRepository.findAll();		
//		model.addAttribute("areas", areas);
//		return "area";
//	}
	

	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("novo")
	public String novo(RequisicaoNovaArea requisicao) {
		return "area_nova";
	}
	
	@PostMapping("incluir")
	public String incluir(@Valid RequisicaoNovaArea requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "area_nova";
		}
		
		Area area = requisicao.toArea();
		areaRepository.save(area);
		return "area_nova";
	}
	
}

