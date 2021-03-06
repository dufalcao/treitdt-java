package br.com.efalcao.mvc.treitdt.domain;

import java.util.List;

public class Localizacao {
	
	private Integer id;
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private List<Double> points;
	
	public Localizacao(Integer id, String nome, String endereco, String telefone, String email, List<Double> points) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.points = points;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Double> getPoints() {
		return points;
	}

	public void setPoints(List<Double> points) {
		this.points = points;
	}

}
