package edu.miu.lelafoods.delivery.Controller;

import edu.miu.lelafoods.delivery.domain.Cart;
import edu.miu.lelafoods.delivery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(CartController.BASE_URL)
public class CartController {
    public static final String BASE_URL = "/carts";

    @Autowired
    CartService cartService;

    @GetMapping("")
    public List<Cart> getAllinCart() {
        List<Cart> foodsList = cartService.findall();
        return foodsList;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createCart(@RequestBody Cart cart) {

        cartService.save(cart);
        System.out.println("status " + cart.getOrderStatus());


    }



    @GetMapping("{id}")
    public Cart getByCartId(@PathVariable("id") Long id) {
        return cartService.findById(id);
    }

}

