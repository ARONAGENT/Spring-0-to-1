package com.springjourney.Week3Practice.Services;

import com.springjourney.Week3Practice.Entities.EmployeeEntity;
import com.springjourney.Week3Practice.Entities.ProjectEntity;
import com.springjourney.Week3Practice.Repositories.EmployeeRepository;
import com.springjourney.Week3Practice.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository empRepo;

    public ProjectEntity addProject(ProjectEntity obj) {
        return projectRepository.save(obj);
    }


    public List<ProjectEntity> allProject() {
        return projectRepository.findAll();
    }

    public ProjectEntity assignProjectToEmployee(int projectId, int empId) {
        Optional<ProjectEntity> projectEntity=projectRepository.findById(projectId);
        Optional<EmployeeEntity> employeeEntity=empRepo.findById(empId);
        return employeeEntity.flatMap(employee ->
                projectEntity.map(project -> {
                    employee.getProjectSet().add(project);
                    empRepo.save(employee);
                    project.getMembers().add(employee);
                    return project;
                })).orElse(null);
    }
}
