package pjatk.mas.project.cateringsite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pjatk.mas.project.cateringsite.service.order.OrderService;
import pjatk.mas.project.cateringsite.service.user.ClientService;


@RestController
public class UserController {

    private final OrderService orderService;
    private final ClientService clientService;

    public UserController(OrderService orderService, ClientService clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @GetMapping(path = "/userorders")
    public ModelAndView userOders(@RequestParam(value="username", required = true) String username) {
        ModelAndView mav = new ModelAndView("userorders");
        mav.addObject("userorders", clientService.getUserByUsername(username).getOrders());
        return mav;
    }

    @GetMapping(path = "/userdetails")
    public ModelAndView userDetails(@RequestParam(value="username", required = true) String username) {
        ModelAndView mav = new ModelAndView("userdetails");
        mav.addObject("userdetails", clientService.getUserByUsername(username));
        return mav;
    }
}
