import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OurFirstTest {

    private Integer sum(Integer a, Integer b) {
        return a + b;
    }
    private final Logger LOGGER = LogManager.getLogger(OurFirstTest.class);

    @Test  //аннотация
    public void showSum() {
        LOGGER.info("We are starting our test");
        Integer c;
        Integer d;
        LOGGER.info("Now we are summing two digits");

        c = sum(15, 5);

        LOGGER.info("And again");
        d = sum(25, 15);

        LOGGER.info("C is: " + c + " \nand D is: " + d);
        LOGGER.info("Asserting");
        Assertions.assertEquals(20, c, "Shit!!!");
        LOGGER.info("Assertions finished");
    }
}
