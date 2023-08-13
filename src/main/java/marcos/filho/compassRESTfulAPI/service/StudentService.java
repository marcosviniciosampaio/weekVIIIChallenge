package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.StudentDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.StudentDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Student;
import marcos.filho.compassRESTfulAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student save(StudentDtoRequest studentDtoRequest){
        Student student = new Student(
                null,
                studentDtoRequest.getName(),
                studentDtoRequest.getLastname(),
                studentDtoRequest.getEmail()
        );
        studentRepository.save(student);
        return student;
    }

    public StudentDtoResponse getStudentById(Long id){
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("student cannot be found"));
        StudentDtoResponse studentDtoResponse = new StudentDtoResponse(
                student.getId(),
                student.getName(),
                student.getLastname(),
                student.getEmail());
        return studentDtoResponse;
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }else{
            throw new RuntimeException("student cannot be found");
        }
    }
}


