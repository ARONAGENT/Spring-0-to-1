package Week2Springboot.Week2Practice.Services;

import Week2Springboot.Week2Practice.Dto.StudentDTO;
import Week2Springboot.Week2Practice.Entities.StudentEntity;
import Week2Springboot.Week2Practice.Repositories.StudentRepository;
import Week2Springboot.Week2Practice.exceptions.InvalidPayloadException;
import Week2Springboot.Week2Practice.exceptions.ResourceNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studRepo;
    private final ModelMapper modelMapper;
    private final Validator validator;

    public StudentService(ModelMapper modelMapper, StudentRepository studRepo,Validator validator) {
        this.modelMapper = modelMapper;
        this.studRepo = studRepo;
        this.validator=validator;
    }
    public void isExistById(int studId){
        boolean studentEntity1=studRepo.existsById(studId);
        if(!studentEntity1) throw new NoSuchElementException();
    }
    public StudentDTO addStud(StudentDTO obj){

        StudentEntity toSaveEntity=modelMapper.map(obj,StudentEntity.class);
        StudentEntity studentEntity=studRepo.save(toSaveEntity);
        return modelMapper.map(studentEntity,StudentDTO.class);
    }

    public List<StudentDTO> allStudents(){
        List<StudentEntity> studEntity =studRepo.findAll();
        return studEntity
                .stream()
                .map(studentEntity -> modelMapper.map(studentEntity,StudentDTO.class))
                .collect(Collectors.toList());
    }

    public StudentDTO updateStudent(StudentDTO obj,int studId){
       StudentEntity studentEntity=modelMapper.map(obj,StudentEntity.class);
       isExistById(studId);
       studentEntity.setStudId(studId);
       studRepo.save(studentEntity);
       return modelMapper.map(studentEntity,StudentDTO.class);
    }
    public boolean deleteStudent(int studId){
        modelMapper.map(StudentDTO.class,StudentEntity.class);
        isExistById(studId);
        studRepo.deleteById(studId);
        modelMapper.map(StudentEntity.class,StudentDTO.class);
        return true;
    }

    public Optional<StudentDTO> getElementById(int studId){
        Optional<StudentEntity> studentEntity=studRepo.findById(studId);
        return studentEntity
                .map(studentEntity1 -> modelMapper.map(studentEntity1,StudentDTO.class));
    }


    public StudentDTO partialUpdateStud(int studId, Map<String, Object> updates) {
        isExistById(studId);
        Optional<StudentEntity> studentEntity = studRepo.findById(studId);
        return studentEntity.map(sd -> {
            updates.forEach((field, value) -> {
                Field fieldUp = ReflectionUtils.findRequiredField(StudentEntity.class, field);
                fieldUp.setAccessible(true);
                ReflectionUtils.setField(fieldUp, sd, value);
            });

            // Validate the entity
            Set<ConstraintViolation<StudentDTO>> violations = validator.validate(modelMapper.map(sd, StudentDTO.class));
            if (!violations.isEmpty()) {
                Map<String, String> errors = violations.stream()
                        .collect(Collectors.toMap(
                                v -> v.getPropertyPath().toString(),
                                ConstraintViolation::getMessage
                        ));
                throw new InvalidPayloadException("Invalid payload found. Please note the following errors",errors);}

            return modelMapper.map(studRepo.save(sd), StudentDTO.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studId));
    }
}


