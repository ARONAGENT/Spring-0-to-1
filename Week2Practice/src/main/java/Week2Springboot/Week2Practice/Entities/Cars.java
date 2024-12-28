package Week2Springboot.Week2Practice.Entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;

@Entity
@Table(name="cars")

public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carId;

    private String carName;

    private String company;

    private float price;

    public Cars(int carId, String carName, String company, float price) {
        this.carId = carId;
        this.carName = carName;
        this.company = company;
        this.price = price;
    }
    public Cars(){

    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
