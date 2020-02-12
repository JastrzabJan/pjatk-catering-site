package pjatk.mas.project.cateringsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pjatk.mas.project.cateringsite.model.offer.Offer;
import pjatk.mas.project.cateringsite.service.offer.DietService;
import pjatk.mas.project.cateringsite.service.offer.OneTimeOfferService;
import pjatk.mas.project.cateringsite.service.order.CartService;

@Controller
public class CartController<T extends Offer> {

    private final CartService cartService;
    private final DietService dietService;
    private final OneTimeOfferService oneTimeOfferService;

    public CartController(CartService cartService, DietService dietService, OneTimeOfferService oneTimeOfferService) {
        this.cartService = cartService;
        this.dietService = dietService;
        this.oneTimeOfferService = oneTimeOfferService;
    }

    @GetMapping(path = "/cart")
    public ModelAndView cart() {
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("cart", cartService);
        return mav;
    }

    @GetMapping(path = "/removeDietFromCart")
    public ModelAndView removeDietFromCart(@RequestParam(value = "dietId") Long dietId){
        cartService.removeDiet(dietService.getOffer(dietId));
        return cart();
    }

    @GetMapping(path = "/removeOneTimeOfferFromCart")
    public ModelAndView removeOneTimeOfferFromCart(@RequestParam(value = "oneTimeOfferId") Long oneTimeOfferId){
        cartService.removeOneTimeOffer(oneTimeOfferService.getOffer(oneTimeOfferId));
        return cart();
    }

    @GetMapping(path ="/addDietToCart")
    public String addDietToCart(@RequestParam(value = "dietId") Long dietId){
        cartService.addDiet(dietService.getOffer(dietId));
        return "redirect:/diets";
    }

    @GetMapping(path ="/addOneTimeOfferToCart")
    public String addOneTimeOfferToCart(@RequestParam(value = "oneTimeOfferId") Long oneTimeOfferId){
        cartService.addOneTimeOffer(oneTimeOfferService.getOffer(oneTimeOfferId));
        return "redirect:/onetimeoffers";
    }

}
