package com.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.IdnotFoundException;
import com.project.model.CategoryModel;
import com.project.model.ProductModel;
import com.project.repo.CategoryRepo;
import com.project.repo.ProductRepo;

@Service
public class ProductImplemented implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    
    /*
      getAll prodcuts that time multiple product retrive
      from the database that time i ussing the pegination 
      to large dataset are converted in smaller pages
     */
	@Override
	public List<ProductModel> isGetAllProducts(int page, int size) {
		
		try {
			Pageable paging = PageRequest.of(page, size);
			return productRepo.findAll(paging).getContent();
		} catch (Exception e) {
			return List.of();
		}
	}
	
	/*
    its use to Add the data To the database 
    and that time in product set the categoryId
    then its make Relation to Both tables
    */
	@Override
	   public ProductModel createProduct(ProductModel pro) {
	       if (pro.getCategory() == null || pro.getCategory().getId() == null) {
	           CategoryModel deCate = categoryRepo.findById(1L)
	                   .orElseThrow(() -> new RuntimeException("Default category not found"));

	           pro.setCategory(deCate);
	       } else {
	           
	           Long categoryId = pro.getCategory().getId();
	           CategoryModel category = categoryRepo.findById(categoryId).orElse(null);
	           pro.setCategory(category);
	       }
	       return productRepo.save(pro);
	   }

	/*
	 we retrive the product by that id if id not 
	 present this throw exception and found id 
	 that time its retrive the record
	 */
	@Override
	public ProductModel isGettingByid(long id) throws IdnotFoundException {
		if(!productRepo.existsById(id))
		{
			throw new IdnotFoundException("Product_id Not Founded...");
		}
		ProductModel ob1 = productRepo.findById(id).get();
		return ob1;
	}
	/*
	  if product id are not found then its first give
          Exceprion,
          and id presnet then it update the given data.
	 */
	@Override
	public ProductModel isUpdatingProduct(long id, ProductModel ob) throws IdnotFoundException {
		
		if(!productRepo.existsById(id))
		{
			throw new IdnotFoundException("Id not Founded...");
		}else {
		
	    ProductModel ob1 = productRepo.findById(id).orElse(null);
	    
	    if (ob1 != null) {
	      if (ob.getName() != null) {
	            ob1.setName(ob.getName());
	        }
	        if (ob.getQuantity() != null) {
	            ob1.setQuantity(ob.getQuantity());
	        }
	        if (ob.getPrice() != null) {
	            ob1.setPrice(ob.getPrice());
	        }
	         return productRepo.save(ob1);
	    } else {
	        return productRepo.save(ob);
	    }
	}
		
	}
	/*
	 Product deleting by there id.
	 */
	@Override
	public String isdeletedbyId(long id)throws IdnotFoundException {
		if(!productRepo.existsById(id))
		{
			throw new IdnotFoundException("The Given IdNotFound...");
		}
			productRepo.deleteById(id);
			return "Product deleted Succesfully...";
		
		
	}

   
}
