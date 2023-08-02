package greene.jpademo.spring.data.jpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import greene.jpademo.spring.data.jpademo.entity.Course;
import greene.jpademo.spring.data.jpademo.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder().title("DBA").credit(4).build();
        Course courseDBMS = Course.builder().title("DBMS").credit(6).build();
        Teacher teacher = Teacher.builder().firstName("John").lastName("Smith")
            .courses(List.of(courseDBA,courseDBMS)).build();
        teacherRepository.save(teacher);
    }

}
