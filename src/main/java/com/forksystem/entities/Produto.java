package com.forksystem.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="produto")
public class Produto {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=true)
	private String descricao;
	
	@Column(name="preco_compra",nullable=false)
	private BigDecimal precoCompra;
	
	@Column(name="preco_venda",nullable=false)
	private BigDecimal precoVenda;
	@Column(name="estoque")
	private Integer qtdEstoque;
	
	@Column(name="estoqueMinimo",nullable=false)
	private Integer estoqueCritico;
	@Column(name="barcode")
	private String codigo;
	
	@Column(name="imagem")
	private String img;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable=false)
	private Categoria categoria;
	
	@ManyToOne
	private Marca marca;
	
	@ManyToOne
	private Unidade unidade;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCOmpra(BigDecimal precoCompr) {
		this.precoCompra = precoCompr;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVend) {
		this.precoVenda = precoVend;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getestoqueCritico() {
		return estoqueCritico;
	}

	public void setestoqueCritico(Integer minimoInventario) {
		this.estoqueCritico = minimoInventario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estoqueCritico == null) ? 0 : estoqueCritico.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((precoCompra == null) ? 0 : precoCompra.hashCode());
		result = prime * result + ((precoVenda == null) ? 0 : precoVenda.hashCode());
		result = prime * result + ((qtdEstoque == null) ? 0 : qtdEstoque.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estoqueCritico == null) {
			if (other.estoqueCritico != null)
				return false;
		} else if (!estoqueCritico.equals(other.estoqueCritico))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (precoCompra == null) {
			if (other.precoCompra != null)
				return false;
		} else if (!precoCompra.equals(other.precoCompra))
			return false;
		if (precoVenda == null) {
			if (other.precoVenda != null)
				return false;
		} else if (!precoVenda.equals(other.precoVenda))
			return false;
		if (qtdEstoque == null) {
			if (other.qtdEstoque != null)
				return false;
		} else if (!qtdEstoque.equals(other.qtdEstoque))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		return true;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoCompra=" + precoCompra
				+ ", precoVenda=" + precoVenda + ", qtdEstoque=" + qtdEstoque + ", estoqueCritico=" + estoqueCritico
				+ ", codigo=" + codigo + ", img=" + img + ", fornecedor=" + fornecedor + ", categoria=" + categoria
				+ ", marca=" + marca + ", unidade=" + unidade + "]";
	}

	
   	

	
	
}
