package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
		testGetAllCartItems();
	}

	static void testAddCartItem() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		CartDao cartDao = cartDaoSqlImpl;
		cartDao.addCartItems(1, 4);
		cartDao.addCartItems(1, 3);
	}

	static void testGetAllCartItems() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		CartDao cartDao = cartDaoSqlImpl;
		List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	static void testRemoveCartItem() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		CartDao cartDao = cartDaoSqlImpl;
		
		try {
			cartDao.removeCartItems(1, 4);
		} catch (Exception e) {
			throw new CartEmptyException("The Cart is Empty");

		}

	}

}
