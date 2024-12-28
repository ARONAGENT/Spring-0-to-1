package Week2Springboot.Week2Practice.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name="students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studId;

    private String name;

    private String mobileNo;

    private String email;

    private String role;

    private float avgMarks;

    private Date registerAt;

    @JsonProperty("isActive")
    private boolean isActive;

    private Integer isPrime;


}
