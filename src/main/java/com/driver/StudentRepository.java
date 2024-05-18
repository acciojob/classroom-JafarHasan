package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }


    public void saveStudent(Student student){

        // your code goes here
        String name=student.getName();
        studentMap.put(name,student);
    }


    public void saveTeacher(Teacher teacher){

        // your code goes here
        String name=teacher.getName();
        teacherMap.put(name,teacher);
    }


    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){

            // your code goes here
            if(teacherStudentMapping.containsKey(teacher)){

                //get the student List
                List<String> studentList=teacherStudentMapping.get(teacher);

                //add new Student
                studentList.add(student);

                //putting updated studentlist back to map
                teacherStudentMapping.put(teacher,studentList);

            }

            else{
                //create new StudentList
                List<String> newStudentList=new ArrayList<>();

                //add student to list
                newStudentList.add(student);

                //putting in the map as new entry
                teacherStudentMapping.put(teacher,newStudentList);
            }

        }
    }


    public Student findStudent(String student){

        // your code goes here
        Student ansStudent=null;
        for(String name:studentMap.keySet()){
            if(name.equals(student)){ //student found
                ansStudent=studentMap.get(name);
                break;
            }
        }
        return ansStudent;
    }


    public Teacher findTeacher(String teacher){

        // your code goes here
        Teacher ansTeacher=null;
        for(String name:teacherMap.keySet()){
            if(name.equals(teacher)){ //student found
                ansTeacher=teacherMap.get(name);
                break;
            }
        }
        return ansTeacher;
    }


    public List<String> findStudentsFromTeacher(String teacher){

        // your code goes here

        // find student list corresponding to a teacher
        List<String> studentList=new ArrayList<>();

        if(teacherStudentMapping.containsKey(teacher)){
            studentList=teacherStudentMapping.get(teacher);
        }
        return studentList;

    }


    public List<String> findAllStudents(){

        // your code goes here
        List<String> studentList=new ArrayList<>();
        for(String s:studentMap.keySet()){
            studentList.add(s);
        }
        return studentList;
    }

    public void deleteTeacher(String teacher){

        // your code goes here
        teacherMap.remove(teacher);
        List<String> studentList=teacherStudentMapping.get(teacher);
        //removing teacher from map
        teacherStudentMapping.remove(teacher);

        //removing students from studentMap also corresponding the teacher
        for(String name:studentList){
            if(studentMap.containsKey(name)){
                studentMap.remove(name);
            }
        }


    }

    public void deleteAllTeachers(){

        // your code goes here
        teacherMap.clear();
        //studentMap.clear();
        teacherStudentMapping.clear();
    }
}