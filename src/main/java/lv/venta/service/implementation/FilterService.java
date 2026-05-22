package lv.venta.service.implementation;

import lv.venta.model.Enums.Degree;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

import lv.venta.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilterService implements IFilterService{

    @Autowired
    private IGradeRepo iGradeRepo;
    private IStudentRepo iStudentRepo;

    @Override
    public ArrayList<Grade> filterGradesByStudentId(long studentId) throws Exception {
        if(studentId < 1){
            throw new Exception("Student ID cannot be negative...");
        }

        if(!iStudentRepo.existsById(studentId)){
            throw new Exception("No student with the given ID was found...");
        }

        if(iGradeRepo.count() == 0){
            throw new Exception("There are no grades in the Database...");
        }

        ArrayList<Grade> result_grades = iGradeRepo.findByStudentStudentId(studentId);

        if(result_grades.isEmpty()){
            throw new Exception("Could not find any grades with the given student ID...");
        }
        return result_grades;
    }

    @Override
    public ArrayList<Grade> filterGradesByCourseTitle(String title) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Course> filterCoursesByProfessorDegree(Degree degree) throws Exception {
        return null;
    }


}
