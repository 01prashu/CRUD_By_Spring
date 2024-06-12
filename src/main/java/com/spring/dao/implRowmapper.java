package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.model.Product;

public class implRowmapper implements RowMapper {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product proud  = new Product();
		proud.setId(rs.getInt(1));
		proud.setProductName(rs.getString(2));
		proud.setProductDescription(rs.getString(3));
		proud.setProductPrice(rs.getFloat(4));
		return proud;
	}

}
