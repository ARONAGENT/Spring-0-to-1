package com.springjourney.Week3Practice;

import com.springjourney.Week3Practice.Entities.Product;
import com.springjourney.Week3Practice.Entities.User;
import com.springjourney.Week3Practice.Repositories.ProductRepository;
import com.springjourney.Week3Practice.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@Transactional  // This is crucial for test database operations
@SpringBootTest(classes = Week3PracticeApplication.class)
class Week3PracticeApplicationTests {


	@Test
	void contextLoads() {
	}
	@Autowired
	ProductRepository prodRepo;

	@Test
	void addData(){
		Product product=Product.builder()
				.productName("Samsung s23")
				.quantity(1)
				.price(76566).build();
		Product pr=prodRepo.save(product);
		System.out.println(pr);
	}


	@Test
	void findById(){
		Optional<Product> pd=prodRepo.findById(1);
		System.out.println(pd);
	}

	@Test
	void findByProductName(){
		List<Product> pnameList=
				prodRepo.findByProductName("Kinder Joy");
		System.out.println(pnameList);
	}
	@Test
	void findByProductNameLike(){
		List<Product> pNameListLike=
				prodRepo.findByProductNameLike("%S%");
		System.out.println(pNameListLike);
	}

    @Test
    void findByProductNameNotLike(){
        List<Product> obj=
                prodRepo.findByProductNameNotLike("%S%");
        for (Product product : obj) {
            System.out.println(product);
        }
    }

	@Test
	void allProductList(){
		List<Product> plist=prodRepo.findAll();
		for (Product product : plist) {
			System.out.println(product);
			// plist.forEach(System.out::println);
		}
	}

	@Test
	void findByProductNameStartsWith(){
		List<Product> findProductStartsWith=
				prodRepo.findByProductNameStartsWith("P");
		System.out.println(findProductStartsWith);
	}

	@Test
	void findByProductNameEndsWith(){
		List<Product> findProductEndsWith=
				prodRepo.findByProductNameEndsWith("e");
		for (Product product : findProductEndsWith) {
			System.out.println(product);
		}
	}

	@Test
	void findByPriceGreaterThan(){
		List<Product> findByPriceGreaterThan=
				prodRepo.findByPriceGreaterThan(1000);
		for (Product product : findByPriceGreaterThan) {
			System.out.println(product);
		}
	}

	@Test
	void findByPriceLessThan(){
		List<Product> findByPriceLessThan=
				prodRepo.findByPriceLessThan(50);
		for (Product product : findByPriceLessThan) {
			System.out.println(product);
		}
	}

	@Test
	void findByPriceGreaterThanEqual(){
		List<Product> findByPriceGreaterThanEqual=
				prodRepo.findByPriceGreaterThanEqual(1299);
		for (Product product : findByPriceGreaterThanEqual) {
			System.out.println(product);
		}
	}

	@Test
	void findByPriceLessThanEqual(){
		List<Product> findByPriceLessThanEqual=
				prodRepo.findByPriceLessThanEqual(50);
		for (Product product : findByPriceLessThanEqual) {
			System.out.println(product);
		}
	}

	@Test
	void findByPriceIsBetween(){
		List<Product> betweenPrice=
				prodRepo.findByPriceIsBetween(800,1200);
		for (Product product : betweenPrice) {
			System.out.println(product);
		}
	}

	@Test
	void findByProductNameContaining(){
		List<Product> betweenPrice=
				prodRepo.findByProductNameContaining("Joy");
		for (Product product : betweenPrice) {
			System.out.println(product);
		}
	}

    @Test
    void findFirst5ByProductName(){
        List<Product> obj=
                prodRepo.findFirst5ByProductNameLike("%Smart%");
        for (Product product : obj) {
            System.out.println(product);
        }
    }

    @Test void orderByPrice(){
        List<Product> obj= prodRepo.findByOrderByPriceDesc();
        for (Product product : obj) {
            System.out.println(product);
        }
    }




    @Autowired
	UserRepository userRepo;
	@Test
	void findAll(){
		List<User> allUsers=
				userRepo.findAll();
		for (User user : allUsers) {
			System.out.println(user);
		}
	}

	@Test
	void addUserData(){
		User user=User.builder()
				.userName("piyush")
				.location("bbbb")
				.password("ayu@123")
				.registerAt(LocalDate.of(2024, 1, 27))
				.isActive(false)
				.build();
		User ur =userRepo.save(user);
		System.out.println(ur);
		Optional<User> foundUser = userRepo.findById(ur.getUserId());
		assertTrue(foundUser.isPresent());
		System.out.println("Saved user verified: " + foundUser.get());
	}

	@Test  void existsById(){
		boolean exists=userRepo.existsById(6);
		System.out.println("Status :"+exists);
	}

	@Test
	void findByRegisterAtAfter(){
		List<User>
				findByRegisterAtAfter=userRepo.findByRegisterAtAfter
				(LocalDate.of(2024,01,01));
		for (User user : findByRegisterAtAfter) {
			System.out.println(user);
		}
	}
	@Test
	void findByRegisterAtBefore(){
		List<User>
				findByRegisterAtBefore=userRepo.findByRegisterAtBefore
				(LocalDate.of(2024,01,03));
		for (User user : findByRegisterAtBefore) {
			System.out.println(user);
		}
	}

	@Test
	void findByUserNameAndLocation(){
		List<User> obj= userRepo.findByUserNameAndLocation
				("Rohan","Goa");
		for (User user : obj) {
			System.out.println(user);
		}
	}

	@Test
	void findByUserNameOrIsActive(){
		List<User> obj= userRepo.findByUserNameOrIsActive
				("JaneSmith",true);
		for (User ii : obj) {
			System.out.println(ii);
		}
	}

	@Test
	void findByIsActiveFalse(){
		List<User> obj= userRepo.findByIsActiveFalse();
		for (User user : obj) {
			System.out.println(user);
		}
	}

	@Test
	void findByIsActiveTrue(){
		List<User> obj= userRepo.findByIsActiveTrue();
		for (User user : obj) {
			System.out.println(user);
		}
	}

	@Test
	void findByUserIdIn(){
		List<Integer> ids = Arrays.asList(1, 2, 3);
		List<User> obj = userRepo.findByUserIdIn(ids);
		for (User user : obj) {
			System.out.println(user);
		}
	}
	@Test
	void findByUserIdNotIn(){
		List<Integer> ids = Arrays.asList(1, 2, 3,4);
		List<User> obj = userRepo.findByUserIdNotIn(ids);
		for (User user : obj) {
			System.out.println(user);
		}
	}

	@Test
	void findByLocationEquals(){
		List<User> obj=userRepo.findByLocationEquals("Los Angeles");
        for (User user : obj) {
            System.out.println(user);
        }
	}

    @Test
    void findByLocationISNull(){
        List<User> obj=userRepo.findByLocationIsNull();
        for (User user : obj) {
            System.out.println(user);
        }
    }

    @Test
    void findByLocationIsNotNull(){
        List<User> obj=userRepo.findByLocationIsNotNull();
        for (User user : obj) {
            System.out.println(user);
        }
    }

//    @Test
//    void findDistinctByUserName(){
//        List<User> obj=userRepo.findDistinctByLocation();
//        for (User user : obj) {
//            System.out.println(user);
//        }
//    }
    @Test void findByUserNameAllIgnoreCase(){
        List<User> obj=
                userRepo.findByUserNameAllIgnoreCase("JANESMITH");
        for (User user : obj) {
           System.out.println(user);
        }
    }

}
