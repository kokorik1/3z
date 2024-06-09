import javax.swing.*;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        // Запрашиваем у пользователя размер массива
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(null, "Введите размер массива (целое число):");
            if (input == null) {
                return; // Пользователь нажал "Cancel"
            }
            try {
                n = Integer.parseInt(input);
                if (n <= 0) {
                    JOptionPane.showMessageDialog(null, "Размер массива должен быть положительным целым числом.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Некорректный ввод: введите целое число.");
            }
        }

        // Создаем массив случайных чисел
        int[] array = new Random().ints(n, 0, 101).toArray();
        int[] reversedArray = new int[n];

        // Обращаем порядок следования элементов
        for (int i = 0; i < n; i++) {
            reversedArray[i] = array[n - 1 - i];
        }

        // Формируем строку для вывода
        StringBuilder originalArrayStr = new StringBuilder("Исходный массив:\n");
        for (int num : array) {
            originalArrayStr.append(num).append("\n");
        }

        StringBuilder reversedArrayStr = new StringBuilder("Обращенный массив:\n");
        for (int num : reversedArray) {
            reversedArrayStr.append(num).append("\n");
        }

        // Выводим оба массива в диалоговом окне
        JOptionPane.showMessageDialog(null, originalArrayStr.toString() + "\n" + reversedArrayStr.toString());
    }
}