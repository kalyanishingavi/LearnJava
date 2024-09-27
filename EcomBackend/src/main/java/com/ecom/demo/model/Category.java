package com.ecom.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Integer sequence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	
}
/*
 @RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public List<Category> getAllCategories() {
		return categoryRepository.findAll().stream()
					.sorted(Comparator.comparing(Category :: getSequence))
					.collect(Collectors.toList());
	}
	
	@PostMapping("/category")
	public Category postCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
}
 
 */
