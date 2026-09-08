import com.june.config.JavaConfig;
import com.june.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void  test() {
        calculator.add(1, 2);
    }
}
