package greene.jpademo.spring.data.jpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import greene.jpademo.spring.data.jpademo.entity.Student;


@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .emailId("john.doe@domain")
                .guardianName("Jane Doe")
                .guardianEmail("jane.doe@domain")
                .guardianMobile("555-555-5555")
                .build();
        studentRepository.save(student);
    }

    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }
}