package com.kzvo.csvreader.dao.impl;

import com.kzvo.csvreader.dao.ProductDao;
import com.kzvo.csvreader.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JdbcProductDao implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void saveProduct(Product product) {
        String sql = "INSERT INTO products (name, price, type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getType());
    }
}
