import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.CRC32;

public class Main {
    public static void main(String[] args) throws IOException {
        long hash2 = 0x0BA02B6E1L; // хэш CRC32 пароля, который нужно угадать

        CRC32 crc32 = new  CRC32();
        File f = new File("10k-most-common.txt");// Создание объекта File для работы с файлом со списком распространенных паролей
        Scanner sc = new Scanner(f);// Создание объекта Scanner для считывания данных из файла

        while (sc.hasNextLine()) {
            String word = sc.nextLine();// Считывание следующей строки файла


            // Цикл для добавления чисел от 1 до 9999 к строке пароля
            for (int i = 1; i <= 9999; i++) {
                String passwordToCheck = word + i; // Формирование комбинации пароля для проверки на соответствие

                crc32.reset();
                crc32.update(passwordToCheck.getBytes()); // Обновление контрольной суммы на основе байтов пароля
                long calculatedHash = crc32.getValue(); // Получение вычисленного хэша пароля

                // Проверка совпадения вычисленного хэша с искомым хэшем
                if (calculatedHash == hash2) {
                    System.out.println("Найдено соответствие. Искомый пароль: " + passwordToCheck);
                    sc.close();
                    return;
                }
            }
        }

        System.out.println("Искомый пароль не был найден!");
        sc.close();

    }
}