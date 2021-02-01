package tw.loja.repository;

import jdk.jshell.execution.Util;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tw.loja.data.Utilizador;

@Repository
public interface UtilizadorRepository extends CrudRepository<Utilizador, String> {
    Utilizador findByUsername(String username);

    Utilizador findByUsernameAndPassword(String username, String password);
}

