package Week2Springboot.Week2Practice.Controllers;

import Week2Springboot.Week2Practice.Dto.StudentDTO;
import Week2Springboot.Week2Practice.Services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path="/students")
public class StudentController {

    private final StudentService studServ;

    public StudentController(StudentService studServ) {
        this.studServ = studServ;
    }

    @GetMapping
    public String getStudents(){
        return "All Students Retrieve Successfully";
    }

    @PostMapping(path="/add")
    public ResponseEntity<StudentDTO> addStudents(@RequestBody @Valid StudentDTO studentDTO){
        StudentDTO sd= studServ.addStud(studentDTO);
        return new ResponseEntity<>(sd, HttpStatus.CREATED);
    }
    @GetMapping(path="/id/{studId}")
    public ResponseEntity<StudentDTO> getElementBYId(@PathVariable int studId){
        Optional<StudentDTO> std=studServ.getElementById(studId);
        return std
                .map(std1 ->ResponseEntity.ok(std1))
                .orElseThrow(() -> new NoSuchElementException("Student Id Not Found"));
    }



    @GetMapping(path="/all")
    public ResponseEntity<List<StudentDTO>> allStudents(){
        return ResponseEntity.ok(studServ.allStudents()) ;
    }
    @PutMapping(path="/updateStudent/{studId}")
    public ResponseEntity<StudentDTO> updateStud(@RequestBody @Valid StudentDTO obj, @PathVariable int studId){
       return ResponseEntity.ok(studServ.updateStudent(obj,studId));
    }

    @DeleteMapping(path="/delete/{studId}")
    public ResponseEntity<Boolean> delStud(@PathVariable int studId){
            boolean deleted=studServ.deleteStudent(studId);
            if(deleted) return ResponseEntity.ok(true);
            return ResponseEntity.notFound().build();
    }

    @PatchMapping(path="/partialUpdate/{studId}")
    public ResponseEntity<StudentDTO> partialUpdateStud(@PathVariable int studId,
                                                        @RequestBody Map<String,Object> updates)
    {
        StudentDTO studentDTO= studServ.partialUpdateStud(studId,updates);
        if(studentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentDTO);
    }
}
