package tw.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tw.loja.data.Permissao;

@Repository
public interface PermissaoRepository extends CrudRepository<Permissao, String> {

}