package com.learning.springdataredis;

import com.learning.springdataredis.entity.Product;
import com.learning.springdataredis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringdataredisApplication {
	@Autowired
	private ProductDao dao;

	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}

	public List<Product> getAll() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Product find(@PathVariable int id) {
		return dao.find(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdataredisApplication.class, args);
	}

}
