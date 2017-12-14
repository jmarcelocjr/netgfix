package br.com.netgifx.model;

import java.util.List;

import br.com.netgifx.model.gif.Gif;

public class Usuario {
	
	private int id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private Role role;
	
	private List<Gif> gifsFavoritos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Gif> getGifsFavoritos() {
		return gifsFavoritos;
	}

	public void setGifsFavoritos(List<Gif> gifsFavoritos) {
		this.gifsFavoritos = gifsFavoritos;
	}
}
