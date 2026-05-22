package lv.venta.service;

import lv.venta.model.Course;
import lv.venta.model.Enums.Degree;
import lv.venta.model.Grade;

import java.util.ArrayList;

public interface IFilterService {
    public abstract ArrayList<Grade> filterGradesByStudentId(long studentId) throws Exception;

    public abstract ArrayList<Grade> filterGradesByCourseTitle(String title) throws Exception;

    public abstract ArrayList<Course> filterCoursesByProfessorDegree(Degree degree) throws Exception;
}
