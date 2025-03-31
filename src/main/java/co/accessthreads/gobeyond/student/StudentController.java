package co.accessthreads.gobeyond.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @QueryMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @MutationMapping
    public Student storeStudent(@Argument Student student) {
        return studentRepository.save(student);
    }
}
