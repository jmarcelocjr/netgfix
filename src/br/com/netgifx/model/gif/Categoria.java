package br.com.netgifx.model.gif;

import java.util.List;

public class Categoria {
	
	private String descricao;
	
	private List<Gif> gifs;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Gif> getGifs() {
		return gifs;
	}

	public void setGifs(List<Gif> gifs) {
		this.gifs = gifs;
	}
}
