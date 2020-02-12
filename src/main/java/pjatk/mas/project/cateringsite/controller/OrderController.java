package pjatk.mas.project.cateringsite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pjatk.mas.project.cateringsite.model.order.*;
import pjatk.mas.project.cateringsite.service.offer.DietService;
import pjatk.mas.project.cateringsite.service.offer.OneTimeOfferService;
import pjatk.mas.project.cateringsite.service.order.CartService;
import pjatk.mas.project.cateringsite.service.order.OrderOfferService;
import pjatk.mas.project.cateringsite.service.order.OrderService;
import pjatk.mas.project.cateringsite.service.user.ClientService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderOfferService orderOfferService;
    private final CartService cartService;
    private final DietService dietService;
    private final OneTimeOfferService oneTimeOfferService;
    private final ClientService clientService;

    @Autowired
    public OrderController(OrderService orderService, OrderOfferService orderOfferService, CartService cartService, DietService dietService, OneTimeOfferService oneTimeOfferService, ClientService clientService) {
        this.orderService = orderService;
        this.orderOfferService = orderOfferService;
        this.cartService = cartService;
        this.dietService = dietService;
        this.oneTimeOfferService = oneTimeOfferService;
        this.clientService = clientService;
    }

    @GetMapping(path = "/orderform")
    public ModelAndView orderform(){
        ModelAndView mav = new ModelAndView();
        DeliveryForm deliveryForm = new DeliveryForm();
        mav.addObject("orderform", deliveryForm);
        mav.setViewName("/orderform");
        return mav;
    }

//    @PostMapping(path = "/orderform")
//    public ModelAndView saveOrder(@Valid DeliveryForm deliveryForm){
//        ModelAndView mav = new ModelAndView();
//        return saveOrder(deliveryForm);
//    }
//
//
//    @GetMapping(path = "/orderform")
//    public ModelAndView saveOrder(DeliveryForm deliveryForm){
//        (Date orderDate, OrderStatus orderStatus, Client client, DeliveryForm deliveryForm)
//        Order order = new Order(new Date(), OrderStatus.NEW, clientService.)
//        OrderOffer orderOffer = new OrderOffer()
//        List<Diet> diets = cartService.getDietsInCart();
//        return new ModelAndView();
//    }


}
