package calc;

public class Calc {
    /**
     *
     * @param first слагаемое
     * @param second слагаемое
     * @return  возврат -> сумму двух чисел
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double sum(F first, S second) {
        return first.doubleValue() + second.doubleValue();
    }

    /**
     *
     * @param first множитель
     * @param second множитель
     * @return  возврат -> произведение
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double multiply(F first, S second) {
        return first.doubleValue() * second.doubleValue();
    }

    /**
     *
     * @param first делимое
     * @param second делитель
     * @return возврат -> частное
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double divide(F first, S second) {
        return first.doubleValue() / second.doubleValue();
    }

    /**
     *
     * @param first Уменьшаемое
     * @param second Вычитаемое
     * @return возврат -> разность
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double subtract(F first, S second) {
        return first.doubleValue() - second.doubleValue();
    }
}
