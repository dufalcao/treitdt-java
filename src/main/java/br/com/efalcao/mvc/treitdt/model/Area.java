package br.com.efalcao.mvc.treitdt.model;

//import com.vividsolutions.jts.geom.Geometry;
//import com.vividsolutions.jts.geom.Point;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.postgis.Geometry;

@Entity // anotação para representar uma Entidade no BD
@Table(name = "area_area1") // anotação para referenciar o nome da tabela no BD
public class Area implements Serializable {
	@Id // anotação para representar a PK
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // anotação para o BD gerar automaticamente a PK
	//@GeneratedValue(strategy = GenerationType.Auto)
	private Long id;
	private String sigla;
	private String nome;
	private String desc_referenciada;
	private String desc_especialidades;
	private String telefone;
	private Double latitude;
	private Double longitude;
	private String popupContent;
	
	
//	@Column(columnDefinition = "Geometry(Point,4326)")
//	@Column(columnDefinition = "Geometry")
//	private Geometry geom; 
//   private Point geom;
	
//	@Column(columnDefinition = "GEOGRAPHY(POINT,4326)")
//	private PGgeography geom;
////	
//	public PGgeography getGeom() {
//		return geom;
//	}
//
//	public void setGeom(PGgeography geom) {
//		this.geom = geom;
//	}

	public String getPopupContent() {
		return popupContent;
	}

	public void setPopupContent(String popupContent) {
		this.popupContent = popupContent;
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

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
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
	
}
