package com.project.model;

public class ProductDTO {
	
	 private Long id;
	    private String name;
	    private Double price;
	    private Long quantity;
	    private Long categoryId;
	    private String categoryName;
	   

	 
	    public ProductDTO(ProductModel product) {
	        this.id = product.getId();
	        this.name = product.getName();
	        this.price = product.getPrice();
	        this.quantity = product.getQuantity();
	        this.categoryId=product.getCategory()!= null ? product.getCategory().getId() : null;
	        this.categoryName = product.getCategory() != null ? product.getCategory().getName() : null;
	    }


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


		public Double getPrice() {
			return price;
		}


		public void setPrice(Double price) {
			this.price = price;
		}


		public Long getQuantity() {
			return quantity;
		}


		public void setQuantity(Long quantity) {
			this.quantity = quantity;
		}


		public String getCategoryName() {
			return categoryName;
		}


		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}


		public Long getCategoryId() {
			return categoryId;
		}


		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}


		


		

	    


}
