/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.Course;

/**
 *
 * @author nhatt
 */
public interface CourseDao {
    public List<Course> findAll();
    public void addCourse(Course newCourse);
    public void deleteCourse(int courseId);
    public void updateCourse(Course course);
}
