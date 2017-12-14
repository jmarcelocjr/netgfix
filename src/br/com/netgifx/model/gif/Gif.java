package br.com.netgifx.model.gif;

import java.time.LocalDate;

import br.com.netgifx.model.Usuario;

public class Gif {

	private int id;
	
	private String titulo;
	
	private String descricao;
	
	private LocalDate dataCadastro;
	
	private Categoria categoria;
	
	private Usuario usuariosQueFavoritaram;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuariosQueFavoritaram() {
		return usuariosQueFavoritaram;
	}

	public void setUsuariosQueFavoritaram(Usuario usuariosQueFavoritaram) {
		this.usuariosQueFavoritaram = usuariosQueFavoritaram;
	}
	
	
}
