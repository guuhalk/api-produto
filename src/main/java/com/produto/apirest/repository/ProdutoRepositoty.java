package com.produto.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.apirest.model.Produto;

public interface ProdutoRepositoty extends JpaRepository<Produto, Long> {
	
	
	Produto findById(long id);
	
	

}
