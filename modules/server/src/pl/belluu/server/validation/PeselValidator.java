package pl.belluu.server.validation;

public class PeselValidator {

    private byte PESEL[] = new byte[11];
    private final String peselNumber;

    public PeselValidator(String peselNumber) throws IllegalArgumentException {

        this.peselNumber = peselNumber;
    }

    public boolean peselHaveValidSumControl() {

        for (int i = 0; i < 11; i++) {
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

    public boolean peselHave11Digitals() {

        if (peselNumber.length() != 11) {
            throw new IllegalArgumentException("The PESEL number should have 11 digits");
        }
        return true;
    }
}