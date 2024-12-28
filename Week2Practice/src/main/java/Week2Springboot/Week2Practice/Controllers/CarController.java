package Week2Springboot.Week2Practice.Controllers;

import Week2Springboot.Week2Practice.Entities.Cars;
import Week2Springboot.Week2Practice.Repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @GetMapping
    public String getData(){
        return "All Data Get Successfully";
    }

   private final CarRepository carRepo;

    public CarController(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    @PostMapping("/addCar")
    public Cars addCars(@RequestBody Cars obj){
        return carRepo.save(obj);
    }

    @GetMapping("/all")
    public List<Cars> getAllCars(){
        return carRepo.findAll();
    }

}
