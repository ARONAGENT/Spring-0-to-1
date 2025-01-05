package com.springjourney.Week3Practice.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String userName;

    String password ;

    String location;

    LocalDate registerAt;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    @Builder.Default
    boolean isActive = false;

}
