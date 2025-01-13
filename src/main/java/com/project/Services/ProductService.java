package com.project.Services;

import java.util.List;

import com.project.Exception.IdnotFoundException;
import com.project.model.ProductModel;

public interface ProductService {

    public List<ProductModel> isGetAllProducts(int page,int size);
    public ProductModel createProduct(ProductModel product);
    public ProductModel isGettingByid(long id) throws IdnotFoundException;
    public ProductModel isUpdatingProduct(long id,ProductModel ob)throws IdnotFoundException;
    public String isdeletedbyId(long id)throws IdnotFoundException;
    

}
