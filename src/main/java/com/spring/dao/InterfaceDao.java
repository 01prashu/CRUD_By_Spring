package com.spring.dao;

import java.util.List;

import com.spring.model.Product;

public interface InterfaceDao {
	public int  Add(Product proud);
	public int Update(Product proud);
	public int Remove(Product proud);
	public List<Product> GetAllProduct();
}
