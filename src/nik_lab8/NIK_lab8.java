
package nik_lab8;

import static java.lang.Math.*; // Импорт всех математических функций
import java.util.Arrays;

/**
 *
 * @author Никита
 */
public class NIK_lab8 {

    int[] InMass; // Переменная для входного массива целых чисел
    double[] OutMass; // Переменная для выходного массива вещественных чисел
    int length_OrigMass; // Переменная для длины исходного массива

    public void SetMass(int OrigMass[]) { // МЕТОД ДЛЯ ЗАДАНИЯ ИСХОДНЫХ ДАННЫХ
        length_OrigMass = OrigMass.length; // Определяем длину исходного массива
        // Копируем значения из исходного массива во входной
        InMass = Arrays.copyOf(OrigMass, length_OrigMass);
        OutMass = new double[length_OrigMass]; // Создаем выходной массив
    }

    public double[] GetMass() { // МЕТОД ВЫЧИСЛЕНИЯ ЗНАЧЕНИЯ
        int ki; //ki1;
        double pr = 1, fk = 1,s=0.33;
        for (int i = 0; i < length_OrigMass; i++) { // Цикл по элементам входного массива
            try {
                fk *= (i + 1); // Расчет факториала
                ki = InMass[i]; // Текущее значение элемента входного массива
                pr *= ki; // Расчет произведения элементов входного массива
               // sum += ki; // Расчет суммы элементов входного массива
               //ki1 = InMass[i - 1]; // Предыдущее значение элемента входного массива
                // Вычисление элемента для выходного массива по заданному алгоритму
                OutMass[i] = Math.pow((sqrt(pow(sin(ki*ki), 3)
                        / (fk + 5))) 
                        /(tan(cos (cos(ki)*cos(ki)))*(cos (cos(ki)*cos(ki)))),s);
            } catch (Exception ex) {
                OutMass[i] = Double.NaN; // Присваиваем значение элементу "нет решения"
            }
        }
        return OutMass; // Возвращаем результирующий массив в программу
    }
}


