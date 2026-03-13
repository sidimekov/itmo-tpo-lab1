package task1;

import com.github.sidimekov.task1.CosSeries;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CosSeriesTest {
    private static final double DELTA = 1e-9;
    private static final double COS_DELTA = 1e-6;

    @ParameterizedTest
    @CsvSource({
            // x = 0.0
            "0.0, 1, 1.0",
            "0.0, 2, 1.0",
            "0.0, 3, 1.0",
            "0.0, 5, 1.0",

            // x = 1.0
            "1.0, 1, 1.0",
            "1.0, 2, 0.5",
            "1.0, 3, 0.541666666",
            "1.0, 5, 0.540302579",

            // x = 1.57
            "1.57, 1, 1.0",
            "1.57, 2, -0.23245",
            "1.57, 3, 0.0207055",
            "1.57, 5, 0.000820939",

            // x = 2.0
            "2.0, 1, 1.0",
            "2.0, 2, -1.0",
            "2.0, 3, -0.333333333",
            "2.0, 5, -0.415873015",

            // x = 3.14
            "3.14, 1, 1.0",
            "3.14, 2, -3.9298",
            "3.14, 3, 0.120688006",
            "3.14, 5, -0.976140477",

            // x = 4.0
            "4.0, 1, 1.0",
            "4.0, 2, -7.0",
            "4.0, 3, 3.666666666",
            "4.0, 5, -0.396825396",

            // x = 4.71
            "4.71, 1, 1.0",
            "4.71, 2, -10.09205",
            "4.71, 3, 10.413545533",
            "4.71, 5, 1.257122064",

            // x = 5.0
            "5.0, 1, 1.0",
            "5.0, 2, -11.5",
            "5.0, 3, 14.541666666",
            "5.0, 5, 2.528397817",

            // x = 6.28
            "6.28, 1, 1.0",
            "6.28, 2, -18.7192",
            "6.28, 3, 46.088608106",
            "6.28, 5, 20.892142202",

            // x = 7.0
            "7.0, 1, 1.0",
            "7.0, 2, -23.5",
            "7.0, 3, 76.541666666",
            "7.0, 5, 56.116493055"
    })
    void calculate_partialSums(double x, int n, double expected) {
        double result = CosSeries.calculate(x, n);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 10",
            "0.0, 20",
            "1.0, 10",
            "1.0, 20",
            "-1.0, 10",
            "-1.0, 20",
            "3.14, 10",
            "3.14, 20",
            "-3.14, 10",
            "-3.14, 20",
            "1.57, 10",
            "1.57, 20",
            "-1.57, 10",
            "-1.57, 20"
    })
    void calculate_approximateMathCos(double x, int n) {
        double result = CosSeries.calculate(x, n);
        assertEquals(Math.cos(x), result, COS_DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 5",
            "0.0, 10",
            "0.0, 20",

            "1.0, 5",
            "1.0, 10",
            "1.0, 20",

            "2.5, 5",
            "2.5, 10",
            "2.5, 20",

            "3.14, 5",
            "3.14, 10",
            "3.14, 20",

            "1.57, 5",
            "1.57, 10",
            "1.57, 20"
    })
    void calculate_evenFunction(double x, int n) {
        double positive = CosSeries.calculate(x, n);
        double negative = CosSeries.calculate(-x, n);
        assertEquals(positive, negative, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 30",
            "-1.0, 30",
            "1.570796326, 30",
            "-1.570796326, 30",
            "3.141592653, 30",
            "-3.141592653, 30"
    })
    void calculate_periodicityApproximation(double x, int n) {
        double shifted_x = x + 2 * Math.PI;
        double base = CosSeries.calculate(x, n);
        double shifted = CosSeries.calculate(shifted_x, n);

        assertEquals(Math.cos(x), base, COS_DELTA);
        assertEquals(Math.cos(shifted_x), shifted, COS_DELTA);
        assertEquals(base, shifted, COS_DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "1e-12, 10",
            "-1e-12, 10",
            "1e-8, 10",
            "-1e-8, 10",
            "100.0, 20",
            "-100.0, 20"
    })
    void calculate_smallAndLargeValues(double x, int n) {
        double result = CosSeries.calculate(x, n);
        assertFalse(Double.isNaN(result));
        assertFalse(Double.isInfinite(result));
    }

    @ParameterizedTest
    @CsvSource({
            "1.7976931348623157E308, 2",
            "-1.7976931348623157E308, 2"
    })
    void calculate_maxValue_returnsNonFiniteResult(double x, int n) {
        double result = CosSeries.calculate(x, n);

        assertTrue(Double.isInfinite(result) || Double.isNaN(result));
    }

    @ParameterizedTest
    @CsvSource({
            "4.9E-324, 10",
            "-4.9E-324, 10"
    })
    void calculate_minValue_isCloseToOne(double x, int n) {
        double result = CosSeries.calculate(x, n);

        assertEquals(1.0, result, DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, 0",
            "1.0, 0",
            "-1.0, 0",
            "3.14, 0"
    })
    void calculate_zeroN_throwsException(double x, int n) {
        assertThrows(IllegalArgumentException.class, () -> CosSeries.calculate(x, n));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, -1",
            "1.0, -1",
            "-1.0, -5",
            "3.14, -10"
    })
    void calculate_negativeN_throwsException(double x, int n) {
        assertThrows(IllegalArgumentException.class, () -> CosSeries.calculate(x, n));
    }
}