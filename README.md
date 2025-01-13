## Category CRUD Operations

### 1. Create a Category
- **Endpoint:** `POST http://localhost:8080/api/categories`
- **Input Example:**
  ```json
  {
      "name": "category_name"
  }
  ```

### 2. Get All Categories
- **Endpoint:** `GET http://localhost:8080/api/categories?page={pageNumber}`
- **Input:** No body required. Just specify the page number as a query parameter.

### 3. Get Category by ID
- **Endpoint:** `GET http://localhost:8080/api/categories/{id}`
- **Input:** No body required. Replace `{id}` with the actual category ID you want to retrieve.

### 4. Update Category by ID
- **Endpoint:** `PUT http://localhost:8080/api/categories/{id}`
- **Input Example:**
  ```json
  {
      "name": "updated_category_name"
  }
  ```
  Replace `{id}` with the actual category ID you want to update.

### 5. Delete Category by ID
- **Endpoint:** `DELETE http://localhost:8080/api/categories/{id}`
- **Input:** No body required. Replace `{id}` with the actual category ID you want to delete.

---

## Product CRUD Operations

### 1. Create a Product
- **Endpoint:** `POST http://localhost:8080/api/products`
- **Input Example:**
  ```json
  {
      "name": "product_name",
      "price": 123.45,
      "category": {
          "id": 1 // Reference an existing category ID
      }
  }
  ```

### 2. Get All Products
- **Endpoint:** `GET http://localhost:8080/api/products?page={pageNumber}`
- **Input:** No body required. Just specify the page number as a query parameter.

### 3. Get Product by ID
- **Endpoint:** `GET http://localhost:8080/api/products/{id}`
- **Input:** No body required. Replace `{id}` with the actual product ID you want to retrieve.

### 4. Update Product by ID
- **Endpoint:** `PUT http://localhost:8080/api/products/{id}`
- **Input Example:**
  ```json
  {
      "name": "updated_product_name",
      "price": 150.00,
      "category": {
          "id": 2 // Reference an existing category ID
      }
  }
  ```
  Replace `{id}` with the actual product ID you want to update.

### 5. Delete Product by ID
- **Endpoint:** `DELETE http://localhost:8080/api/products/{id}`
- **Input:** No body required. Replace `{id}` with the actual product ID you want to delete.

---
