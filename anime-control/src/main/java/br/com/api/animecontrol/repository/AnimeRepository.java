package br.com.api.animecontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.animecontrol.model.AnimeModel;

public interface AnimeRepository extends JpaRepository<AnimeModel, UUID>{
	
}
