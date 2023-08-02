package greene.jpademo.spring.data.jpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import greene.jpademo.spring.data.jpademo.entity.Course;
import greene.jpademo.spring.data.jpademo.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder().title("DSA").credit(4).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }
}
