package com.spingjourney.Week2Homework.Controllers;

import com.spingjourney.Week2Homework.Services.DepartmentServices;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/department")
public class DepartmentController {

    private final DepartmentServices deptServ;

    public DepartmentController(DepartmentServices deptServ) {
        this.deptServ = deptServ;
    }
}
