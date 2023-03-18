package yandex.stellarburgers;


import java.util.Random;

public class StringGenerator {

    public StringGenerator(){

    }
    public String getRandomString() {
        String chars = "abcdefghijklmnopqrstuvwxyz123456789";
        StringBuilder randomString = new StringBuilder();
        Random rnd = new Random();
        while (randomString.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            randomString.append(chars.charAt(index));
        }
        String rndString = randomString.toString();
        return rndString + "@yandex.ru";
    }
}
