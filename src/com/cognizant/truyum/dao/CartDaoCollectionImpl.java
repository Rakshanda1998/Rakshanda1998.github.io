package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> UserCarts;

	public CartDaoCollectionImpl() {
		super();
		if (UserCarts == null) {
			UserCarts = new HashMap<>();
			UserCarts.put(1l, new Cart());
		}
	}

	@Override
	public void addCartItems(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		try {
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

			if (UserCarts.containsKey(userId)) {
				Cart cart = UserCarts.get(userId);
				cart.getMenuItemList().add(menuItem);
			} else {
				Cart cart = new Cart();
				cart.getMenuItemList().add(menuItem);
				UserCarts.put(userId, cart);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList = UserCarts.get(userId).getMenuItemList();
		Cart cart = UserCarts.get(userId);
		double total = 0.0;
		if (cart == null || menuItemList.isEmpty()) {
			throw new CartEmptyException();
		} else {
			for (MenuItem menuItem : menuItemList) {
				total += menuItem.getPrice();
			}
		}
		cart.setTotal(total);
		return menuItemList;
	}

	@Override
	public void removeCartItems(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		List<MenuItem> menuItemList = UserCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);
				break;
			}
		}
	}
}
