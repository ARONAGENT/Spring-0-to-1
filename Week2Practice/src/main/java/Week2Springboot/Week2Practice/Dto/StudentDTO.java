package Week2Springboot.Week2Practice.Dto;

import Week2Springboot.Week2Practice.annotations.primeNoRohan;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int studId;
    @NotBlank(message = "Name should not be Empty ")
    private String name;

    @NotNull
    private long mobileNo;

    @Email(message = "Email should be Valid ")
    private String email;

    @NotNull(message = " Role cannot bee Null Value")
    @Size(max = 5 ,message = "Max Size Of Role Must Be Length Exactly 5")
    @Pattern(regexp = "^(ADMIN|GUEST)$",message = "The Role Should be Always ADMIN or GUEST ")
    private String role;

    @Positive(message = "marks Should Be Positive")
    private Float avgMarks;

    @PastOrPresent(message = "date Should Be Past or Present ")
    private Date registerAt ;

    @JsonProperty("isActive")
    @AssertTrue(message = "Value Must be True")
    private boolean isActive;

    @primeNoRohan
    private Integer isPrime;

}
