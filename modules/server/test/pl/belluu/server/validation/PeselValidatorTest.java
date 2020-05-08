package pl.belluu.server.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeselValidatorTest {

    @Test
    void shouldHave11Digits() {
        PeselValidator peselValidator = new PeselValidator("73071141895");
        assertTrue(peselValidator.PeselHave11Digitals());
    }

    @Test
    void shouldHaveCorrectSumControl() {
        PeselValidator peselValidator = new PeselValidator("73071141895");
        assertTrue(peselValidator.peselHaveValidSumControl());
    }

    @Test
    void shouldThrowBecauseOfInvalidNumberOfDigits() {
        PeselValidator peselValidator = new PeselValidator("950210002121");
        assertThrows(IllegalArgumentException.class, peselValidator::PeselHave11Digitals);
    }

    @Test
    void shouldThrowBecauseOfInvalidSumOfControl() {
        PeselValidator peselValidator = new PeselValidator("95021000211");
        assertThrows(IllegalArgumentException.class, peselValidator::peselHaveValidSumControl);
    }

    @Test
    void shouldBelongToMan() {
        PeselValidator peselValidator = new PeselValidator("85092334251");
        assertTrue(peselValidator.isPeselOwnerMale());
    }

    @Test
    void shouldBelongToWomen() {
        PeselValidator peselValidator = new PeselValidator("99091788928");
        assertFalse(peselValidator.isPeselOwnerMale());
    }
}
