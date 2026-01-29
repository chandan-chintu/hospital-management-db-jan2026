package com.jpahibernate.example.hospital_management_db.service;

import com.jpahibernate.example.hospital_management_db.model.Doctor;
import com.jpahibernate.example.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service // it contains business logic
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully!!";
    }

    public Doctor findByDoctorId(int id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        } else {
            return null;
        }
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    public String countDoctors(){
        long totalCount = doctorRepository.count();
        return "Total doctors present are : "+totalCount;
    }

    public String deleteDoctorById(int id){
        doctorRepository.deleteById(id);
        return "Doctor with id : "+id+" is deleted successfully!!";
    }

    //update using put operation - updates complete object
    public String updateDoctorUsingPut(int doctorId, Doctor newDoctorRequest){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = findByDoctorId(doctorId);
        if(existingDoctor!=null){
            // proceed to update
            doctorRepository.save(newDoctorRequest);
            return "doctor updated successfully!";
        } else {
            // cannot update
            return "Doctor with id : "+doctorId+" is not present, hence cannot update";
        }
    }


    //update using patch operation - single specific fields
    public String updateDoctorUsingPatch(int doctorId, String newEmail, String newMobile){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = findByDoctorId(doctorId);
        if(existingDoctor!=null){
            // proceed to update
            existingDoctor.setMobile(newMobile);
            existingDoctor.setEmail(newEmail);
            doctorRepository.save(existingDoctor);
            return "doctor updated successfully!";
        } else {
            // cannot update
            return "Doctor with id : "+doctorId+" is not present, hence cannot update";
        }
    }
}
