package tw.loja.repository;

import org.springframework.data.repository.CrudRepository;
import tw.loja.data.Permissao;
import tw.loja.data.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {
}
