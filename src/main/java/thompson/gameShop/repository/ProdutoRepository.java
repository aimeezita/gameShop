package thompson.gameShop.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import thompson.gameShop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByJogoContainingIgnoreCase(@Param("jogo") String jogo);
	
	
	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
	
	
	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);
}
