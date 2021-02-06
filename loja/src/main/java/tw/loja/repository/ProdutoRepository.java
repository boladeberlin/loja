package tw.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tw.loja.data.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findById(long id);

    //List<Produto> findProdutoByCorAndFuelAndMarca(String cor, String fuel, String marca);

    //	@Query("SELECT p FROM Produto p WHERE p.name LIKE %?1%"
//			+ " OR p.brand LIKE %?1%"
//			+ " OR p.madein LIKE %?1%"
//			+ " OR CONCAT(p.price, '') LIKE %?1%")
    @Query("SELECT p FROM Produto p WHERE CONCAT(p.nome, ' ', p.marca, ' ', p.tipo, ' ', p.fuel, ' ', p.preco, ' ', p.cor) LIKE %?1%")
    public List<Produto> search(String keyword);


    @Query("SELECT p FROM Produto p WHERE p.cor like %?1 AND p.fuel like %?2 AND p.marca like %?3")
    public List<Produto> find(String cor, String fuel, String marca);
}
