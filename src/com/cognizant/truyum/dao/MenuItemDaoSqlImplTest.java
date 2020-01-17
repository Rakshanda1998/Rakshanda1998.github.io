package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	public static void main(String[] args) throws SQLException {
		try {
			System.out.println("***Admin List Details***");
			testGetMenuItemListAdmin();

			System.out.println("\n***Customer List Details***");
			testGetMenuItemListCustomer();
			testModifyMenuItem();

			System.out.println("\n***Modified Coustomer List***");
			testGetMenuItemListAdmin();
		} catch (ParseException e) {
			System.out.println(e);
		}	
	}

	public static void testGetMenuItemListAdmin() throws ParseException, SQLException {

		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}

	public static void testGetMenuItemListCustomer() throws ParseException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();

		for (MenuItem x : menuItemList) {
			System.out.println(x);
		}
	}
	
	private static void testModifyMenuItem() throws ParseException, SQLException {
		MenuItem m = new MenuItem(1, "Hakka-Noodles", 199.0f, true, DateUtil.convertToDate("26/01/2020"), "Course",
				true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(m);

	}
}