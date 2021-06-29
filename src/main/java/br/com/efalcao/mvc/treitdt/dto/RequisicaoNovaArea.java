package br.com.efalcao.mvc.treitdt.dto;

import javax.validation.constraints.NotBlank;

import org.postgis.PGgeography;


//import com.vividsolutions.jts.geom.Point;

import br.com.efalcao.mvc.treitdt.model.Area;

public class RequisicaoNovaArea {
	
	@NotBlank
	private String sigla;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String desc_referenciada;
	
	@NotBlank
	private String desc_especialidades;
	
	@NotBlank
	private String telefone;
	
	
	private Double latitude;
	
	
	private Double longitude;
//	private PGgeography geom;
	
	
	public String getSigla() {
		return sigla;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	//	public PGgeography getGeom() {
//		return geom;
//	}
//	public void setGeom(PGgeography geom) {
//		this.geom = geom;
//	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesc_referenciada() {
		return desc_referenciada;
	}
	public void setDesc_referenciada(String desc_referenciada) {
		this.desc_referenciada = desc_referenciada;
	}
	public String getDesc_especialidades() {
		return desc_especialidades;
	}
	public void setDesc_especialidades(String desc_especialidades) {
		this.desc_especialidades = desc_especialidades;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Area toArea() {
		Area area = new Area();
		area.setSigla(sigla);
		area.setNome(nome);
		area.setTelefone(telefone);
		area.setDesc_referenciada(desc_referenciada);
		area.setDesc_especialidades(desc_especialidades);
//		area.setLatitude(-54.594647);
//		area.setLongitude(-25.430194);
		area.setLatitude(latitude);
		area.setLongitude(longitude);
		area.setPopupContent("Nome: <b>" + area.getNome()+"</b>");
//		area.setGeom(geom);
		return area;
	}
}

