package tw.loja.data;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "preco")
    private float preco;
    @Column(name = "cor")
    private String cor;
    @Column(name = "marca")
    private String marca;
    @Column(name = "fuel")
    private String fuel;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descricao")
    private String descricao;
    private File image;

    public Produto(long id, String nome, float preco, String cor, String marca, String fuel, String tipo, String descricao, File image) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.cor = cor;
        this.marca = marca;
        this.fuel = fuel;
        this.tipo = tipo;
        this.descricao = descricao;
        this.image = image;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public Produto() {

    }

    public long getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
