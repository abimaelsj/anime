package br.com.api.animecontrol.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AnimeDto {	
	
	@NotBlank
	private String nomeAnime; 
	
	@NotBlank
	private String nomeAutor;
	
	@NotBlank
	private String anoPublicacao; 
	
	@NotNull
	private Long numeroEpisodios;
	
	@NotBlank
	private String genero;
	
	@NotBlank
	private String sinopse;

	public String getNomeAnime() {
		return nomeAnime;
	}

	public void setNomeAnime(String nomeAnime) {
		this.nomeAnime = nomeAnime;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public @NotBlank String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(@NotBlank String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Long getNumeroEpisodios() {
		return numeroEpisodios;
	}

	public void setNumeroEpisodios(Long numeroEpisodios) {
		this.numeroEpisodios = numeroEpisodios;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String snopse) {
		this.sinopse = snopse;
	}
}