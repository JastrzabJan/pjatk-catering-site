package pjatk.mas.project.cateringsite;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pjatk.mas.project.cateringsite.model.offer.Diet;
import pjatk.mas.project.cateringsite.model.offer.OfferStatus;
import pjatk.mas.project.cateringsite.service.offer.DietService;
import pjatk.mas.project.cateringsite.service.offer.OneTimeOfferService;
import pjatk.mas.project.cateringsite.service.order.OrderOfferService;
import pjatk.mas.project.cateringsite.service.order.OrderService;
import pjatk.mas.project.cateringsite.service.user.ClientService;
import pjatk.mas.project.cateringsite.service.user.ConsultantService;
import pjatk.mas.project.cateringsite.service.user.RoleService;

import java.math.BigDecimal;

@SpringBootApplication

public class CateringSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CateringSiteApplication.class, args);

	}

	@Autowired
	ClientService clientService;
	@Autowired
	DietService dietService;
	@Autowired
	OneTimeOfferService oneTimeOfferService;
	@Autowired
	ConsultantService consultantService;
	@Autowired
	RoleService roleService;
	@Autowired
	OrderService orderService;
	@Autowired
	OrderOfferService orderOfferService;

	@Bean
	InitializingBean sendData(){
		return () -> {


			//INITIAL LOAD************************************************
//
//			Role clientRole = new Role("ROLE_Client");
//			Role consultantRole = new Role("ROLE_Consultant");
//			Role managerRole = new Role("Role_Manager");
//			Role administratorRole = new Role("ROLE_Administrator");
//
//			roleService.save(clientRole);
//			roleService.save(consultantRole);
//			roleService.save(managerRole);
//			roleService.save(administratorRole);
//
//			Client client1 = new Client("Test Name Client", "Test Surname Client", new Date(), Gender.Male, AccountStatus.ACTIVE, "testusername", "testpassword");
//			Consultant consultant1 = new Consultant("Test Name Consultant", "Test Surname Consultant", new Date(), Gender.Male, AccountStatus.ACTIVE, "testconsultant", "testpassword");
//
//			List<Role> client1List = new ArrayList<>();
//			client1List.add(clientRole);
//			client1.setRoles(client1List);
//
//			List<Role> consultant1List = new ArrayList<>();
//			consultant1List.add(consultantRole);
//			consultant1.setRoles(client1List);
//
			Diet diet1 = new Diet(OfferStatus.ACTIVE, "Test Diet 1", "Description for Test Diet 1", BigDecimal.valueOf(6), BigDecimal.valueOf(6));
			Diet diet2 = new Diet(OfferStatus.ACTIVE, "Test Diet 2", "Description for Test Diet 2", BigDecimal.valueOf(12), BigDecimal.valueOf(6));
			Diet diet3 = new Diet(OfferStatus.ACTIVE, "Test Diet 3", "Description for Test Diet 3", BigDecimal.valueOf(6), BigDecimal.valueOf(6));
//
//			OneTimeOffer oneTimeOffer1 = new OneTimeOffer(OfferStatus.ACTIVE, "Test One Time Offer 1", "Description for One Time Offer 1", BigDecimal.valueOf(6));
//			OneTimeOffer oneTimeOffer2 = new OneTimeOffer(OfferStatus.ACTIVE, "Test One Time Offer 2", "Description for One Time Offer 2", BigDecimal.valueOf(6));
//			OneTimeOffer oneTimeOffer3 = new OneTimeOffer(OfferStatus.ACTIVE, "Test One Time Offer 3", "Description for One Time Offer 3", BigDecimal.valueOf(6));
//
//			clientService.save(client1);
//			consultantService.save(consultant1);
			dietService.save(diet1);
			dietService.save(diet2);
			dietService.save(diet3);
//
//			oneTimeOfferService.save(oneTimeOffer1);
//			oneTimeOfferService.save(oneTimeOffer2);
//			oneTimeOfferService.save(oneTimeOffer3);

//			Address addres1 = new Address("Warsaw","Koszykowa", "05054", 5);
//			DeliveryForm deliveryForm = new DeliveryForm("Andrzej","Nowak", "Comment", addres1);
//			Order order1 = new Order(new Date(), OrderStatus.NEW, clientService.getUserById(1), deliveryForm);
//			orderService.save(order1);
//			BigDecimal bigDecimal = BigDecimal.valueOf(2);
//			orderOfferService.create(new OrderOffer(order1, dietService.getOffer(1), bigDecimal));
			
			//INITIAL LOAD************************************************




//			orderService.delete(orderService.getOrder(1));
//			clientService.save(new Client("TestName", "TestSurname", new Date(), Gender.Male, AccountStatus.ACTIVE, "testusername", "testpassword"));
//			dietService.save(new Diet(OfferStatus.ACTIVE, "test", "http://placehold.it/200x100", 100, 200));
		};
	}
}
