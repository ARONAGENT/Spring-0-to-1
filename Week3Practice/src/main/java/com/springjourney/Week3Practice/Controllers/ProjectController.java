package com.springjourney.Week3Practice.Controllers;

import com.springjourney.Week3Practice.Entities.ProjectEntity;
import com.springjourney.Week3Practice.Services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {


    @Autowired
    private ProjectServices projectServices;

    @PostMapping("/add")
    public ProjectEntity addProject(@RequestBody ProjectEntity obj){
        return projectServices.addProject(obj);
    }

    @GetMapping("/all")
    public List<ProjectEntity> allProject(){
        return projectServices.allProject();
    }
    @PutMapping("/{projectId}/assign/{empId}")
    public ProjectEntity assignProjectToEmployee(@PathVariable int projectId,
                                                 @PathVariable int empId){
        return projectServices.assignProjectToEmployee(projectId,empId);
    }

}
