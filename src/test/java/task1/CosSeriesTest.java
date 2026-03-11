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
            // x = 0
            "0.0, 1, 1.0",
            "0.0, 2, 1.0",
            "0.0, 3, 1.0",
            "0.0, 5, 1.0",

            // x = 1
            "1.0, 1, 1.0",
            "1.0, 2, 0.5",
            "1.0, 3, 0.541666666",
            "1.0, 5, 0.540302579",

            // x = -1
            "-1.0, 1, 1.0",
            "-1.0, 2, 0.5",
            "-1.0, 3, 0.541666666",
            "-1.0, 5, 0.540302579",

            // x = pi
            "3.1415926532653, 1, 1.0",
            "3.1415926532653, 2, -3.9348022005",
            "3.1415926532653, 3, 0.12390992587",
            "3.1415926532653, 5, -0.97602221262",

            // x = -pi
            "-3.1415926532653, 1, 1.0",
            "-3.1415926532653, 2, -3.934802200",
            "-3.1415926532653, 3, 0.12390992587",
            "-3.1415926532653, 5, -0.97602221262",

            // x = pi / 2
            "1.5707963267, 1, 1.0",
            "1.5707963267, 2, -0.23370055013",
            "1.5707963267, 3, 0.019968957764",
            "1.5707963267, 5, 0.000024737276364",

            // x = -pi / 2
            "-1.5707963267, 1, 1.0",
            "-1.5707963267, 2, -0.23370055013",
            "-1.5707963267, 3, 0.019968957764",
            "-1.5707963267, 5, 0.000024737276364",

            // x = 3.14
            "3.14,1,1",
            "3.14,3,0.120688006",
            "3.14,5,-0.9761404770"
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

            "3.1415926532653, 10",
            "3.1415926532653, 20",

            "-3.1415926532653, 10",
            "-3.1415926532653, 20",

            "1.5707963267, 10",
            "1.5707963267, 20",

            "-1.5707963267, 10",
            "-1.5707963267, 20"
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

            "3.141592653589793, 5",
            "3.141592653589793, 10",
            "3.141592653589793, 20",

            "1.5707963267948966, 5",
            "1.5707963267948966, 10",
            "1.5707963267948966, 20"
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
            "1.5707963267948966, 30",
            "-1.5707963267948966, 30",
            "3.141592653589793, 30",
            "-3.141592653589793, 30"
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
            "3.141592653589793, 0"
    })
    void calculate_zeroN_throwsException(double x, int n) {
        assertThrows(IllegalArgumentException.class, () -> CosSeries.calculate(x, n));
    }

    @ParameterizedTest
    @CsvSource({
            "0.0, -1",
            "1.0, -1",
            "-1.0, -5",
            "3.141592653589793, -10"
    })
    void calculate_negativeN_throwsException(double x, int n) {
        assertThrows(IllegalArgumentException.class, () -> CosSeries.calculate(x, n));
    }
}