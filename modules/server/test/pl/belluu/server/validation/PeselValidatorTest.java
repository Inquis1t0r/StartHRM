package pl.belluu.server.validation;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PeselValidatorTest {
    String peselNumber = "95021000212";

    @Test
    public void shouldHave11Digs(){
        PeselValidator peselValidator = new PeselValidator(peselNumber);
        assertThat(peselValidator.peselHave11Digitals(peselNumber));
    }
}
