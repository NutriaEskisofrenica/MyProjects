package com.udg.SIIAU.Repositories;

import com.udg.SIIAU.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {

    public Optional<ArrayList<StudentModel>> findDoctorModelByCode(String code);

    public Optional<ArrayList<StudentModel>> findDoctorModelByName(String name);
}
