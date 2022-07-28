package br.com.api.animecontrol.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.animecontrol.interfaces.AnimeService;
import br.com.api.animecontrol.model.AnimeModel;
import br.com.api.animecontrol.repository.AnimeRepository;

@Service
public class AnimeServiceImpl implements AnimeService {
	
	@Autowired
	private AnimeRepository animeRepository;

	@Transactional
	@Override
	public AnimeModel saveAnime(AnimeModel animeModel) {
		return animeRepository.save(animeModel);
	}

	@Override
	public List<AnimeModel> findAllAnime() {
		return animeRepository.findAll();
	}

	@Override
	public Optional<AnimeModel> findById(UUID id) {
		return animeRepository.findById(id);	
	}

	@Transactional
	@Override
	public void deleteAnime(AnimeModel animeModel) {
		animeRepository.delete(animeModel);
	}
}