package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.StudentDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.StudentDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Student;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
import marcos.filho.compassRESTfulAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student save(StudentDtoRequest studentDtoRequest) {
        Student student = new Student(
                null,
                studentDtoRequest.getName(),
                studentDtoRequest.getLastname(),
                studentDtoRequest.getEmail()
        );
        if (studentDtoRequest.getName() != null && studentDtoRequest.getLastname() != null && studentDtoRequest.getEmail() != null) {
            studentRepository.save(student);
            return student;
        } else {
            throw new ApiRequestException("Null not allowed");
        }
    }
    public StudentDtoResponse getStudentById(Long id){
        Student student = studentRepository
                .findById(id)
                .orElseThrow(()-> new ApiRequestException("student cannot be found"));
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
        throw new ApiRequestException(" Student cannot be found ");
    }

    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }else{
            throw new ApiRequestException("student cannot be found");
        }
    }
}


