package br.com.api.animecontrol.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.animecontrol.dto.AnimeDto;
import br.com.api.animecontrol.interfaces.AnimeService;
import br.com.api.animecontrol.model.AnimeModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/anime")
public class AnimeController {
	private static final String MESSAGE_ANIME_NOT_FOUND = " : Anime not found"; 
	private static final String MESSAGE_ANIME_DELETE_SUCCESS = "Anime deleted successfully"; 
	private static final String MESSAGE_ANIME_UPDATE_SUCCESS = "Anime updated successfully"; 
	
	
	@Autowired
	private AnimeService animeService;
	
	
	@ApiOperation(value = "Cria um novo anime")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna o novo recurso criado")
	})
	@PostMapping
	public ResponseEntity<Object> saveAnime(@RequestBody @Valid AnimeDto animeDto){			
		AnimeModel animeModel = new AnimeModel();
		
		animeModel.setAnoPublicacao(LocalDate.parse(animeDto.getAnoPublicacao()));
		animeModel.setGenero(animeDto.getGenero());
		animeModel.setNomeAnime(animeDto.getNomeAnime());
		animeModel.setNomeAutor(animeDto.getNomeAutor());
		animeModel.setNumeroEpisodios(animeDto.getNumeroEpisodios());
		animeModel.setSinopse(animeDto.getSinopse());
		
		return ResponseEntity.status(HttpStatus.OK).body(animeService.saveAnime(animeModel));
	}
	
	@ApiOperation(value = "Retorna uma lista de animes")
	@ApiResponses(value = { 
	    @ApiResponse(code = 200, message = "Retorna a lista de recursos"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@GetMapping 
	public ResponseEntity<List<AnimeModel>> getAllAnimes(){
		return ResponseEntity.status(HttpStatus.OK).body( animeService.findAllAnime());
	}

	@ApiOperation(value = "Retorna um anime, pelo seu id")
	@ApiResponses(value = { 
	    @ApiResponse(code = 200, message = "Retorna o recurso pesquisado"),
	    @ApiResponse(code = 404, message = "Retorna a mensagem de anime não encontrado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Object> getAnimeById(@PathVariable(value ="id") UUID id){
		Optional<AnimeModel> animeModelOptional = animeService.findById(id);
		return animeModelOptional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(animeModelOptional.get()) :
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(MESSAGE_ANIME_NOT_FOUND);
	}
	
	@ApiOperation(value = "Deleta um anime pelo id")
	@ApiResponses(value = { 
	    @ApiResponse(code = 201, message = "Retorna a mensagem de deleção bem sucedida"),
	    @ApiResponse(code = 404, message = "Retorna a mensagem de anime não encontrado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAnime(@PathVariable(value ="id") UUID id){
		Optional<AnimeModel> animeModelOptional = animeService.findById(id);
		if(animeModelOptional.isPresent()) {
			animeService.deleteAnime(animeModelOptional.get());
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MESSAGE_ANIME_DELETE_SUCCESS);
		}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MESSAGE_ANIME_NOT_FOUND);
	}
	
	@ApiOperation(value = "Atualiza um anime pelo id e demais dados recebidos")
	@ApiResponses(value = { 
	    @ApiResponse(code = 201, message = "Retorna a mensagem de atualização bem sucedida"),
	    @ApiResponse(code = 404, message = "Retorna a mensagem de anime não encontrado"),
	    @ApiResponse(code = 500, message = "Foi gerada uma exceção")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAnime(@PathVariable(value ="id") UUID id, @RequestBody @Valid AnimeDto animeDto){	
		Optional<AnimeModel> animeModelOptional = animeService.findById(id);
		
		if(animeModelOptional.isPresent()) {
			AnimeModel animeModel = animeModelOptional.get();	
			animeModel.setId(id);
			animeModel.setAnoPublicacao(LocalDate.parse(animeDto.getAnoPublicacao()));
			animeModel.setGenero(animeDto.getGenero());
			animeModel.setNomeAnime(animeDto.getNomeAnime());
			animeModel.setNomeAutor(animeDto.getNomeAutor());
			animeModel.setNumeroEpisodios(animeDto.getNumeroEpisodios());
			animeModel.setSinopse(animeDto.getSinopse());
			animeService.saveAnime(animeModel);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MESSAGE_ANIME_UPDATE_SUCCESS);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MESSAGE_ANIME_NOT_FOUND);
	}
}
