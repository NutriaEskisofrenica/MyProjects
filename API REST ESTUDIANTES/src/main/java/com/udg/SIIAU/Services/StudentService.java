package com.udg.SIIAU.Services;

import com.udg.SIIAU.Models.StudentModel;
import com.udg.SIIAU.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    //CRUD

    public StudentModel saveDoctor(StudentModel student){
        if(repository.findDoctorModelByCode(student.getCode()).toString().equals("Optional[[]]")){
            return repository.save(student);
        }else{
            //retornar un error de repetido
            StudentModel studentError = new StudentModel();
            studentError.setId(-1L);
            return studentError;
        }



    }

    public ArrayList<StudentModel> getAllDoctors(){
        return (ArrayList<StudentModel>) repository.findAll();
    }

    public Optional<StudentModel> findDoctorById(Long id){
        return repository.findById(id);
    }



    public StudentModel editDoctor(StudentModel student){
        return repository.save(student);
    }

    public String deleteDoctorById(Long id){

        if(findDoctorById(id).isPresent()){
            repository.deleteById(id);
            return "student deleted successfully";
        }else {
            return "student with id="+ id+ " not foud";
        }
    }

    public Optional<ArrayList<StudentModel>> findDoctorByCode(String code){
        return repository.findDoctorModelByCode(code);
    }
    public Optional<ArrayList<StudentModel>> findDoctorByName(String name){
        return repository.findDoctorModelByName(name);
    }
}
