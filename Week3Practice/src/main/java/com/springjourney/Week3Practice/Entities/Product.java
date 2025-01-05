package com.springjourney.Week3Practice.Entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int prodId;

    String productName;

    int quantity;

    float price;
}
