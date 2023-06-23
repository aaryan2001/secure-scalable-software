/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.sfsb;

import dto.CartItem;
import java.util.ArrayList;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author aarya
 */
@Stateful
public class ShopCartBean implements ShopCartBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private ArrayList<CartItem> cart;

    public ShopCartBean() {
        cart = new ArrayList<CartItem>();
    }


    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    @Remove
    public void remove() {
        cart = null;
    }

    @Override
    public boolean addCartItem(CartItem cartItem) {
        boolean itemInCart = false;
        for (CartItem item : cart) {
            if (item.getItemId().equalsIgnoreCase(cartItem.getItemId())) {
                itemInCart = true;
                item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                return true;
            }
        }
        
        if (!itemInCart && !cartItem.getItemId().equalsIgnoreCase("")) {
            try{
                cart.add(cartItem);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        
        return false;
    }

    @Override
    public boolean deleteCartItem(String itemId) {
        boolean itemInCart = false;
        CartItem itemToRemove = null;
        for (CartItem item : cart) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                itemInCart = true;
                itemToRemove = item;
            }
        }
        
        if (itemInCart) {
            try {
                cart.remove(itemToRemove);
                return true;
            } catch (Exception ex) {
                return false;
            }
            
        } 
        return false;
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {
        boolean itemInCart = false;
        CartItem itemToUpdate = null;
        for (CartItem item : cart) {
            if (item.getItemId().equalsIgnoreCase(cartItem.getItemId())) {
                itemInCart = true;
                itemToUpdate = item;
            }
        }
        
        if (itemInCart) {
            try {
                cart.remove(itemToUpdate);
                cart.add(cartItem);
                return true;
            } catch (Exception ex) {
                return false;
            }
        } 
        
        return false;
    }

    
}
