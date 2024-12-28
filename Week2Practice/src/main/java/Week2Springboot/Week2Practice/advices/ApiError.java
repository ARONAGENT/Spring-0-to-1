package Week2Springboot.Week2Practice.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;
    private Map<String, String> Errors;
}
