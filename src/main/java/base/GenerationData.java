package base;

import java.util.Random;

/**
 * Класс для генерации уникальных данных
 */
public class GenerationData {

    public static String getRandomString(int size) {
        StringBuilder result = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            result.append((char) (r.nextInt(26) + 'a'));
        }
        return result.toString();
    }
}
