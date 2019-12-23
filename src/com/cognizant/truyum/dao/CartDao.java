package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItems(long userId, long menuItemId);

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	public void removeCartItems(long userId, long menuItemId);

}
