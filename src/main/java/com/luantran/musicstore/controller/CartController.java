package com.luantran.musicstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luantran.musicstore.model.Album;
import com.luantran.musicstore.model.Cart;
import com.luantran.musicstore.model.CartItem;
import com.luantran.musicstore.model.Genre;
import com.luantran.musicstore.repository.AlbumRepository;
import com.luantran.musicstore.repository.CartRepository;
import com.luantran.musicstore.repository.GenreRepository;
import com.luantran.musicstore.validator.CheckoutValidator;

@Controller
@RequestMapping("/viewcart")
public class CartController extends GeneralController {

	public static final String PARAM_LATESTPHOTO = "LATEST_PHOTO_PARAM";
	public static final String PARAM_BASE_URL = "baseURL";
	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private CartRepository cartRepository;;

	@Autowired
	private CheckoutValidator checkoutValidator;
	@Autowired
	private GenreRepository genreRepository;
	@SuppressWarnings("unchecked")
	@GetMapping("")
	public ModelAndView viewCart(Model model, HttpSession session, @ModelAttribute(value = "cart") Cart cart) {
		double grandTotal = total(session);
		if (session.getAttribute("cart") == null) {
			List<Genre> genres = genreRepository.findAll();
			model.addAttribute("genres", genres);
			model.addAttribute("genre", "Rock");

			return new ModelAndView("emptycart");
			

		}
		cart.setGrandTotal(total(session));
		if(cart.getGrandTotal()==0) {
			List<Genre> genres = genreRepository.findAll();
			model.addAttribute("genres", genres);
			return new ModelAndView("emptycart");
		}
		List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
		session.setAttribute("cart", cartItem);

		model.addAttribute("cartItem", cartItem);
		model.addAttribute("genre", cartItem.get(cartItem.size() - 1).getAlbum().getGenre().getName());
		model.addAttribute("grandTotal", grandTotal);

		return new ModelAndView("viewcart");
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/buy/{id}")
	public String addCart(@PathVariable("id") Long id, Model model, HttpSession session) {
		Album album = albumRepository.findOne(id);
		if (session.getAttribute("cart") == null) {
			List<CartItem> cart = new ArrayList<>();
			cart.add(new CartItem(album));
			session.setAttribute("cart", cart);
			List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
			model.addAttribute("cartItem", cartItem);
		} else {
			List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
			int index = isExists(id, cartItem);
			if (index == -1) {
				cartItem.add(new CartItem(album));
			} else {
				int quantity = cartItem.get(index).getQuantity() + 1;
				cartItem.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cartItem);
			model.addAttribute("cartItem", cartItem);

		}
		return "redirect:/viewcart";

	}

	private int isExists(long id, List<CartItem> cartItem) {
		for (int i = 0; i < cartItem.size(); i++) {
			if (cartItem.get(i).getAlbum().getId() == id) {
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/removeall")
	public ModelAndView remove(HttpSession session, Model model) {
	

		List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
		for (int i = 0; i < cartItem.size(); i++) {
			cartItem.remove(i);
		}
		List<Genre> genres = genreRepository.findAll();
		model.addAttribute("genres", genres);
		return new ModelAndView("emptycart");

	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/removeitem/{id}")
	public ModelAndView removeitem(@PathVariable("id") Long id,@ModelAttribute(value = "cart") Cart cart ,HttpSession session, Model model) {
		

		if (session.getAttribute("cart") == null) {

			model.addAttribute("genre", "Rock");
			return new ModelAndView("emptycart");

		}
	
		List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
		int index = isExists(id, cartItem);
		int quantity = cartItem.get(index).getQuantity() - 1;
		cartItem.get(index).setQuantity(quantity);
		if (quantity <= 0) {
			cartItem.remove(index);
		}
		cart.setGrandTotal(total(session));
		if(cart.getGrandTotal()==0) {
			List<Genre> genres = genreRepository.findAll();
			model.addAttribute("genres", genres);
			return new ModelAndView("emptycart");
		}

		session.setAttribute("cart", cartItem);
		model.addAttribute("cartItem", cartItem);


		return new ModelAndView("viewcart");

	}

	@SuppressWarnings("unchecked")
	private double total(HttpSession session) {
		double grandTotal = 0.0;
		if (session.getAttribute("cart") == null) {
			return grandTotal;
		}
		List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
		for (CartItem item : cartItem) {
			item.setTotalPrice(item.getQuantity() * item.getAlbum().getPrice());
			grandTotal += (item.getQuantity() * item.getAlbum().getPrice());
		}
		session.setAttribute("cart", cartItem);
		return grandTotal;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/checkout")
	public String checkout(HttpSession session, Model model,@ModelAttribute(value="cart") Cart cart) {
		if (session.getAttribute("cart") == null) {
			List<Genre> genres = genreRepository.findAll();
			model.addAttribute("genres", genres);
			return "emptycart";

		}
	
		cart.setGrandTotal(total(session));
		if(cart.getGrandTotal()==0) {
			return "viewcart";
		}

		List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
		model.addAttribute("cartItem", cartItem);
		model.addAttribute("cart", cart);
		return "checkout";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/checkout/submit")
	public String submitCart( @ModelAttribute(value = "cart") Cart cart, HttpSession session, Model model,
			BindingResult bindingResult) {
	
		cart.setGrandTotal(total(session));
		cartRepository.save(cart);

		List<Cart> lstTemp = cartRepository.findAll();
		Cart cartSubmit = lstTemp.get(lstTemp.size() - 1);

		List<CartItem> cartItem = (List<CartItem>) session.getAttribute("cart");
		for (CartItem element : cartItem) {
			element.setCart(cartSubmit);
		}
		checkoutValidator.validate(cart,bindingResult );
		if(bindingResult.hasErrors()) {
			return "checkout";

		}
		session.setAttribute("cart", cartItem);
		cartSubmit.setCartItems(cartItem);

		session.removeAttribute("cart");
		
		return "complete";
	}
}
