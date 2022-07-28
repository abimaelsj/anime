package br.com.api.animecontrol.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.api.animecontrol.model.AnimeModel;

public interface AnimeService {	
	public AnimeModel saveAnime(AnimeModel animeModel);
	public List<AnimeModel> findAllAnime();
	public Optional<AnimeModel> findById(UUID id);
	public void deleteAnime(AnimeModel animeModel);
}