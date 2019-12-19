package com.lab5.util;

import com.lab5.data.Student;
import com.lab5.data.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api")
public class OperationController {
    private StudentRep studentRepository;
    private Counting count;

    @Autowired
    OperationController(Counting count, StudentRep studentRepository) {
        this.count = count;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/count")
    public @ResponseBody
    HashMap count(@RequestParam("str") String str) {
        HashMap<String, String> result = new HashMap<>();
        result.put("value", count.count(str));
        return result;
    }

    @GetMapping("/students")
    public @ResponseBody
    Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Map addStudent(@RequestBody Student student) {
        return Collections.singletonMap("id", studentRepository.save(student).getId());
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        Student selectedStudent = studentRepository.findById(id).get();
        selectedStudent.setFio(student.getFio());
        selectedStudent.setGroup(student.getGroup());
        selectedStudent.setUnName(student.getUnName());
        studentRepository.save(selectedStudent);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }
}