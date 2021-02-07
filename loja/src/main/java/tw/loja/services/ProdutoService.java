package tw.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.loja.data.Permissao;
import tw.loja.data.Utilizador;
import tw.loja.data.Produto;
import tw.loja.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public boolean createProduto(long id, String nome, float preco, String cor, String marca, String fuel, String tipo) {
        if(this.produtoRepository.findById(id) != null)
            return false;

        Produto novo = new Produto();
        novo.setId(id);
        novo.setNome(nome);
        novo.setPreco(preco);
        novo.setCor(cor);
        novo.setMarca(marca);
        novo.setFuel(fuel);
        novo.setTipo(tipo);
        this.produtoRepository.save(novo);
        return true;
    }

    public List<Produto> findProduto(String cor, String marca, String fuel) {
        System.out.println(cor);
        System.out.println(fuel);
        System.out.println(marca);
        System.out.println(produtoRepository.find(cor, fuel, marca));
    return produtoRepository.find(cor, fuel, marca);
    }

    public List<Produto> listAll(String keyword) {
        if (keyword != null) {
            return produtoRepository.search(keyword);
        }
        return produtoRepository.findAll();
    }



    public List<Produto> findByIdProduto(long id) {
        return produtoRepository.findById(id);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
