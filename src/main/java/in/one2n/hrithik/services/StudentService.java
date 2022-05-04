package in.one2n.hrithik.services;

import in.one2n.hrithik.entities.Student;
import in.one2n.hrithik.errors.StudentNotFoundException;
import in.one2n.hrithik.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student fetchStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> student =
                studentRepository.findById(studentId);

        if (!student.isPresent()) {
            throw new StudentNotFoundException("ID: " + studentId + " Not Found");
        }

        return student.get();
    }

    public Student saveStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    public List<Student> fetchAllStudents() {
        return studentRepository.findAllByOrderByNameAsc();
    }

    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student updateStudent(Long studentId, Student student) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent() && (studentByEmail.get().getId() != studentId)) {
            throw new IllegalStateException("Email taken");
        }

        Student studentDB = studentRepository.findById(studentId).get();

        if (Objects.nonNull(student.getEmail()) &&
                !"".equalsIgnoreCase(student.getEmail())) {
            studentDB.setEmail(student.getEmail());
        }

        if (Objects.nonNull(student.getName()) &&
                !"".equalsIgnoreCase(student.getName())) {
            studentDB.setName(student.getName());
        }

        if (Objects.nonNull(student.getAddress()) &&
                !"".equalsIgnoreCase(student.getAddress())) {
            studentDB.setAddress(student.getAddress());
        }

        if (Objects.nonNull(student.getGender()) &&
                !"".equalsIgnoreCase(String.valueOf(student.getGender()))) {
            studentDB.setGender(student.getGender());
        }

        if (Objects.nonNull(student.getDob()) &&
                !"".equalsIgnoreCase(String.valueOf(student.getDob()))) {
            studentDB.setDob(student.getDob());
        }

        studentDB.setUpdatedAt(LocalDateTime.now());
        return studentRepository.save(studentDB);
    }


}
