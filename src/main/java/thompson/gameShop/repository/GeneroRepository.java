package thompson.gameShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import thompson.gameShop.model.Genero;


public interface GeneroRepository extends JpaRepository<Genero, Long> {
	
	public List<Genero> findAllByGeneroContainingIgnoreCase(@Param("genero") String genero);

}
