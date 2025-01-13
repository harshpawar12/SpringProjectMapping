package com.project.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.IdnotFoundException;
import com.project.model.CategoryDTO;
import com.project.model.CategoryModel;
import com.project.repo.CategoryRepo;

@Service
public class CategoryImplemented implements CategoryService {

    @Autowired
    private CategoryRepo cateRepo;


    /*
     this is the i make pegination that use to 
     large dataSet are divide into smaller pages.
     */
    @Override
    public List<CategoryDTO> getAllCategoriesDto(int page, int size) {
        Pageable pag = PageRequest.of(page, size);
        return cateRepo.findAll(pag)
                       .getContent()
                       .stream()
                       .map(category -> new CategoryDTO(category.getId(), category.getName()))
                       .collect(Collectors.toList());
    }

	
	/*
    All the category are Adding in the Database
    */
   @Override
   public String iscreateCategory(CategoryModel category) {
       if (category.getProducts() != null) 
       {
           category.getProducts().forEach(product -> product.setCategory(category));
       }
       if(cateRepo!=null)
       {
       	cateRepo.save(category);
           return "Category Added Succesfully..";
       }else {
       	return "Category failed to Add";
       }
        
   }
	
	
	/*
	 	Category Data fetching by the categoryid
	 */
	@Override
	public CategoryModel isGettingById(long id) throws IdnotFoundException {
		
		if(!cateRepo.existsById(id))
		{
			throw new IdnotFoundException("Please Enter Valid_id...");
		}
		CategoryModel ob=cateRepo.findById(id).orElse(null);
		return ob;
			
	}
	
    /*
          if category id are not found then its first give
          Exceprion,
          and id presnet then it update the given data.
     */
   
	@Override
	public CategoryModel isUpdatingCategory(long id, CategoryModel ob) throws IdnotFoundException{
		
		
		if(!cateRepo.existsById(id))
		{
			throw new IdnotFoundException("There is No id found...");
		}else {
			CategoryModel ob1 = cateRepo.findById(id).get();
		
			if(ob1!=null)
			{
				if(ob1.getName()!=null){
					ob1.setName(ob.getName());
				}
				return cateRepo.save(ob1);
			}else {
			return cateRepo.save(ob);
			}
		}
		
	}
	/*
	 In the Category delete by there id
	 */
	@Override
	public String isdeletebycategory(long id) throws IdnotFoundException {
		if(!cateRepo.existsById(id))
		{
			throw new IdnotFoundException("Sorry...Given idNotFound..");
		}
		cateRepo.deleteById(id);
		return "Record Deleted Succesfully...";
	}

   
}
