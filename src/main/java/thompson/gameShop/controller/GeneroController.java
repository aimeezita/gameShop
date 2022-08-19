package thompson.gameShop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thompson.gameShop.model.Genero;
import thompson.gameShop.repository.GeneroRepository;

@RestController	
@RequestMapping("/genero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GeneroController {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping
	private ResponseEntity<List<Genero>> getAll(){
		
		return ResponseEntity.ok(generoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero> getById(@PathVariable Long id){
		
		return generoRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Genero>> getByGenero(@PathVariable String genero){
		
		return ResponseEntity.ok(generoRepository.findAllByGeneroContainingIgnoreCase(genero));	
	}
	
	@PostMapping
	public ResponseEntity<Genero> postGenero(@Valid @RequestBody Genero genero){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generoRepository.save(genero));
	}
	
	@PutMapping
	public ResponseEntity<Genero> putGenero(@Valid @RequestBody Genero genero) {
					
		return generoRepository.findById(genero.getId())
				.map(resposta -> ResponseEntity.ok().body(generoRepository.save(genero)))
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
		
		return generoRepository.findById(id)
				.map(resposta -> {
					generoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
