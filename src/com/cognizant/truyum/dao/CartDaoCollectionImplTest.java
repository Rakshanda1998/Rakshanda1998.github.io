package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItems(1, 5L);
		cartDao.addCartItems(1, 3L);
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
		System.out.println("Cart List to Check-Out");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}
	}

	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1L);
		System.out.println("\nUser Cart Items");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);

		}
	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("\nItem List Removed from Customer");
		try {
			// cartDao.removeCartItems(1, 2L);
			cartDao.removeCartItems(1, 5L);
			cartDao.removeCartItems(1, 3L);
			List<MenuItem> menuItemListCustomer = cartDao.getAllCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}
}
