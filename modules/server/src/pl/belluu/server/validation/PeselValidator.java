package pl.belluu.server.validation;

public class PeselValidator {

    private byte[] PESEL = new byte[11];
    private final String peselNumber;
    private static int NUMBER_OF_DIGITS_CORRECT_PESEL = 11;

    public PeselValidator(String peselNumber) throws IllegalArgumentException {

        this.peselNumber = peselNumber;
    }

    public boolean peselHaveValidSumControl() {

        for (int i = 0; i < NUMBER_OF_DIGITS_CORRECT_PESEL; i++) {
            PESEL[i] = Byte.parseByte(peselNumber.substring(i, i + 1));
        }


        int sum = 1 * PESEL[0] +
                3 * PESEL[1] +
                7 * PESEL[2] +
                9 * PESEL[3] +
                1 * PESEL[4] +
                3 * PESEL[5] +
                7 * PESEL[6] +
                9 * PESEL[7] +
                1 * PESEL[8] +
                3 * PESEL[9];
        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        if (sum != PESEL[10]) {
            throw new IllegalArgumentException("The checksum of the PESEL number is incorrect");
        }
        return true;

    }

    public boolean PeselHave11Digitals() {

        if (peselNumber.length() != NUMBER_OF_DIGITS_CORRECT_PESEL) {
            throw new IllegalArgumentException("The PESEL number should have 11 digits");
        }
        return true;
    }

    public boolean isPeselOwnerMale() {

        PESEL[9] = Byte.parseByte(peselNumber.substring(9, 10));

        if (PESEL[9] % 2 == 1) {
            return true;
        }
        return false;
    }
}
