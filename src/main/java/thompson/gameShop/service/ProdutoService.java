package thompson.gameShop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thompson.gameShop.model.Produto;
import thompson.gameShop.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
    private ProdutoRepository produtoRepository;

   /**
	 * Método Curtir -> Soma 1 ao atributo curtir
	 */
    public Optional<Produto> curtir(Long id) {

		if(produtoRepository.existsById(id)) {
            
            Produto produto = produtoRepository.findById(id).get();
            
                        
            return Optional.of(produtoRepository.save(produto));
            
        }

        return Optional.empty();

	}
    

}
