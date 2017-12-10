package com.niit.shoppingback.dao;

import java.util.List;

import com.niit.shoppingback.model.Cart;
import com.niit.shoppingback.model.CartLine;


public interface CartLineDao {
	
	// the common methods from previously coded one
	
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	
	// other business methods related to cart lines
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	
	// update a cart
	boolean updateCart(Cart cart);
	
	
}
