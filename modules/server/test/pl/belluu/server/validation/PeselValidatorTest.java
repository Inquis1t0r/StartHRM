package pl.belluu.server.validation;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PeselValidatorTest {


    @Test
    public void shouldHave11Digits(){
        PeselValidator peselValidator = new PeselValidator("95021000212");
        assertTrue(peselValidator.peselHave11Digitals());
    }

    @Test
    public void shouldHaveCorrectSumControl(){
        PeselValidator peselValidator = new PeselValidator("95021000212");
        assertTrue(peselValidator.peselHaveValidSumControl());
    }

    @Test
    public void shouldThrowBecauseOfInvalidNumberOfDigits(){
        PeselValidator peselValidator = new PeselValidator("950210002121");
        assertThrows(IllegalArgumentException.class, peselValidator::peselHave11Digitals);
    }

    @Test
    public void shouldThrowBecauseOfInvalidSumOfControl(){
        PeselValidator peselValidator = new PeselValidator("95021000211");
        assertThrows(IllegalArgumentException.class, peselValidator::peselHaveValidSumControl);
    }
}
