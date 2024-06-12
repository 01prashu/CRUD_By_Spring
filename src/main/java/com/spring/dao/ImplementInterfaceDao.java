package com.spring.dao;

import java.util.List;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Product;

public class ImplementInterfaceDao implements InterfaceDao {
	
	private JdbcTemplate temp;
	public JdbcTemplate getTemp() {
		return temp;
	}
	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}
	public int Add(Product proud) {
		String query = "insert into products( productName ,productDescription, productPrice) values(?,?,?)";
		int r = temp.update(query,proud.getProductName(),proud.getProductDescription() , proud.getProductPrice());
		return r;
	}

	
	public int Update(Product proud) {
	    String query = "UPDATE products SET productName = ?, productDescription = ?, productPrice = ? WHERE id = ?";
	    int r = temp.update(query, proud.getProductName(), proud.getProductDescription(), proud.getProductPrice(), proud.getId());
	    return r;
	}


	
	public int Remove(int id) {
	    String query = "DELETE FROM products WHERE id = ?";
	    int r = temp.update(query, id);
	    return r;
	}


	
	public List<Product> GetAllProduct() {
		String query = "SELECT * FROM products";
        List<Product> products = temp.query(query, new implRowmapper());
        return products;
	}

}
