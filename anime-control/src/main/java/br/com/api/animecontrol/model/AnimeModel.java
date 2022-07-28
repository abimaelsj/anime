package br.com.api.animecontrol.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_ANIME")
public class AnimeModel implements Serializable{
	private static final long serialVersionUID = 4901154546060396392L;
	
	@ApiModelProperty(value = "ID do anime")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID Id;
	
	@ApiModelProperty(value = "Nome do Anime")
	@Column(nullable = false, length = 30)
	private String nomeAnime;     
	
	@ApiModelProperty(value = "Nome do Autor do anime")
	@Column(nullable = false, length = 30)
	private String nomeAutor;
	
	@ApiModelProperty(value = "Ano de publicação do Anime")
	@Column(nullable = false)
	private LocalDate anoPublicacao; 
	
	@ApiModelProperty(value = "Numero de episódios do Anime")
	@Column(nullable = false)
	private Long numeroEpisodios;
	
	@ApiModelProperty(value = "Gênero do Anime")
	@Column(nullable = false, length = 20)
	private String genero;
	
	@ApiModelProperty(value = "Sinopse do Anime")
	@Column(nullable = false, length = 60)
	private String sinopse;

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

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

	public LocalDate getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(LocalDate anoPublicacao) {
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

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

}
