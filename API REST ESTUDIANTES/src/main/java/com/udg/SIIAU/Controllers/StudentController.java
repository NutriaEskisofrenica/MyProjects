package com.udg.SIIAU.Controllers;

import com.udg.SIIAU.Models.StudentModel;
import com.udg.SIIAU.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return service.saveDoctor(student);
    }

    @PutMapping()
    public StudentModel editStudent(@RequestBody StudentModel student){
        return service.editDoctor(student);
    }

    @GetMapping()
    public ArrayList<StudentModel> getAllStudents(){
        return service.getAllDoctors();
    }


    @GetMapping("/findDoctorById/{id}")
    public Optional<StudentModel> findStudentById(@PathVariable Long id){
        return service.findDoctorById(id);
    }

    @GetMapping("/findDoctorByCode/{code}")
    public Optional<ArrayList<StudentModel>> finStudentByCode(@PathVariable String code){
        return service.findDoctorByCode(code);
    }


    @GetMapping("/findDoctorByName/{name}")
    public Optional<ArrayList<StudentModel>> finStudentByName(@PathVariable String name){
        return service.findDoctorByName(name);
    }
    @DeleteMapping("/delete-doctor-by-id")
    public String deleteStudentById(@RequestParam("id") Long id){
        return service.deleteDoctorById(id);
    }
}