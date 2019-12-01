import model.Student;
import org.junit.jupiter.api.Test;

public class ObjectTest {
    @Test
    public void checkObject() {
        Student student = new Student();

        student.setName("Andrej");
        student.setAge(99);
        student.setPhoneNumber("112");

        System.out.println(student.getName());
    }
}
