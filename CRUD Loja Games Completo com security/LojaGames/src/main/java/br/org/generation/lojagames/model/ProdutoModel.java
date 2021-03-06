package br.org.generation.lojagames.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table (name = "Tb_produto")
public class ProdutoModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nome; //Nome do jogo
	
	
	@Temporal(TemporalType.TIMESTAMP) //data de lançamento do jogo
	private Date data_lancamento = new java.sql.Date(System.currentTimeMillis());
	
	
	//Relacionamento está sendo feito abaixo
	@ManyToOne //many to one porque vários produtos só podem ter uma categoria cada.
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;//coloco uma categoria para este produto que foi criado, ou seja, estou criando uma característica para o produto não é criado como list pois só vai ter uma categoria para o produto.
	
	@NotNull
	private BigDecimal preco; //preço do jogo
	
	@NotNull
	private int faixa_etaria; // faixa etária do jogo

	public long getId() {
		return id;
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

	public Date getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getFaixa_etaria() {
		return faixa_etaria;
	}

	public void setFaixa_etaria(int faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	
	

}
