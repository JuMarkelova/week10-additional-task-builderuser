package cy.markelova.builderuser.util;

import java.util.Random;

public class DataGenerator {

    public static StringBuilder generateRandomString() {
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int stringLength = 5 + (int) (Math.random() * 16);
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(stringLength);

        for (int i = 0; i < stringLength; i++) {
            int index = random.nextInt(validCharacters.length());
            randomString.append(validCharacters.charAt(index));
        }
        return randomString;
    }
}