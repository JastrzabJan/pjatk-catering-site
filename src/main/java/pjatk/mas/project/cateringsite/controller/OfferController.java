package pjatk.mas.project.cateringsite.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pjatk.mas.project.cateringsite.model.offer.Diet;
import pjatk.mas.project.cateringsite.model.offer.OneTimeOffer;
import pjatk.mas.project.cateringsite.service.offer.OfferService;

@RestController
public class OfferController {

    private final OfferService<Diet> dietService;
    private final OfferService<OneTimeOffer> oneTimeOfferOfferService;

    public OfferController(OfferService<Diet> dietService, OfferService<OneTimeOffer> oneTimeOfferOfferService) {
        this.dietService = dietService;
        this.oneTimeOfferOfferService = oneTimeOfferOfferService;
    }

    @GetMapping(path = "/diets")
    public ModelAndView diets() {
        ModelAndView mav = new ModelAndView("diets");
        mav.addObject("diets", dietService.getAllOffers());
        return mav;
    }

    @GetMapping(path = "/onetimeoffers")
    public ModelAndView onetimeoffers() {
        ModelAndView mav = new ModelAndView("onetimeoffers");
        mav.addObject("onetimeoffers", oneTimeOfferOfferService.getAllOffers());
        return mav;
    }
}
