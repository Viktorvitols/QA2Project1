import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OurFirstTest {

    private Integer sum(Integer a, Integer b) {
        return a + b;
    }

    @Test  //аннотация
    public void showSum() {
        Integer c;
        Integer d;

        c = sum(15, 5);
        d = sum(25, 15);

//        System.out.println("C is: " + c + " \nand D is: " + d);
        Assertions.assertEquals(20, c, "Shit!!!");
    }
}
