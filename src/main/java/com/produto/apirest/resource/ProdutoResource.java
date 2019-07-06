package com.produto.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.apirest.model.Produto;
import com.produto.apirest.repository.ProdutoRepositoty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping(value = "/api")
@Api(value=" API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	@Autowired
	private ProdutoRepositoty produtoRepository;
	
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos.")
	public List<Produto> listaProdutos(){	
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna um produtos unico.")
	public Produto listaProdutosPorId(@PathVariable(value = "id" ) long id ){	
		return produtoRepository.findById(id);
	}
	
	
	@PostMapping(value ="/produto")
	@ApiOperation(value="Salva um produtos.")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
		
	}
	
	@DeleteMapping(value ="/produto") 
	@ApiOperation(value="Deleta um produto.")
	public void deleteProduto(@RequestBody Produto produto) {
			produtoRepository.delete(produto);	
	}
	
	@PutMapping(value ="/produto")
	@ApiOperation(value="Atualiza um produto.")
	public Produto atualizaProduto(@RequestBody Produto produto) {
			return produtoRepository.save(produto);	
	}
}
