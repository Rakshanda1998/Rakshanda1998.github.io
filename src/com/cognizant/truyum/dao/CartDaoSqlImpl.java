package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItems(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "insert into cart(ct_us_id, ct_pr_id) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			int result=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement ps;
		ResultSet resultSet;
		boolean activeFlag, freeDeliveryFlag;
		MenuItem menuItem = null;
		try {
			Cart cart = new Cart();
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append("SELECT me_id,me_name  , me_price ,me_active,me_date_of_launch,me_category, me_free_delivery FROM menu_item ")
			.append("INNER JOIN cart ON me_id = ct_pr_id WHERE ct_us_id = ?");
			ps = con.prepareStatement(sqlBuffer.toString());
			ps.setLong(1, userId);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				int menuItemId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				String active = resultSet.getString(4);
				Date date_of_launch = resultSet.getDate(5);
				String category = resultSet.getString(6);
				String freeDelivery = resultSet.getString(7);
				if (active != null && active.equals("Yes"))
					activeFlag = true;
				else
				activeFlag = false;
				if (freeDelivery != null && freeDelivery.equals("Yes"))
					freeDeliveryFlag = true;
				else
					freeDeliveryFlag = false;
				menuItem = new MenuItem(menuItemId, name, price,
						activeFlag, date_of_launch, category,
						freeDeliveryFlag);
				menuItemList.add(menuItem);
			}
	     	cart.setMenuItemList(menuItemList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (menuItemList.size() == 0) {
			throw new CartEmptyException("Cart is Empty");
		}

		return menuItemList;

	}

	@Override
	public void removeCartItems(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "delete from cart where ct_us_id=? and  ct_pr_id=? limit 1";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			int result =ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
