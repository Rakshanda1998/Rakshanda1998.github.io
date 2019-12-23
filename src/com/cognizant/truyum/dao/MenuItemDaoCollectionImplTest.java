package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
	public static void main(String[] args) {
		try {
			System.out.println("***Admin List Details***\n");
			testGetMenuItemListAdmin();
			System.out.println("\n***Customer List Details***");
			testGetMenuItemListCustomer();
			System.out.println("\n***Modified Coustomer List***");
			testModifyMenuItem();
			testGetMenuItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);
		}
	}

	private static void testModifyMenuItem() throws ParseException {
		// TODO Auto-generated method stub
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem m = new MenuItem(1, "Veg-Sandwich", 199.0f, true, DateUtil.convertToDate("26/01/2020"), "Course",
				true);
		menuItemDao.modifyMenuItem(m);

	}

	public static void testGetMenuItemListAdmin() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		menuItemDao.getMenuItemListAdmin();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();

		menuItemDao.getMenuItemListCustomer();
		List<MenuItem> customerList = menuItemDao.getMenuItemListCustomer();

		for (MenuItem x : customerList) {
			System.out.println(x);
		}
	}
}
