package task1;

import com.github.sidimekov.task1.CosSeries;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CosSeriesTest {
    private static final double DELTA = 1e-9;
    private static final double COS_DELTA = 1e-6;

    @ParameterizedTest
    @CsvFileSource(resources = "/task1/csv/partial_sums.csv")
    void calculate_partialSums(double x, int n, double expected) {
        double result = CosSeries.calculate(x, n);
        assertEquals(expected, result, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task1/csv/approximate_math_cos.csv")
    void calculate_approximateMathCos(double x, int n) {
        double result = CosSeries.calculate(x, n);
        assertEquals(Math.cos(x), result, COS_DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task1/csv/even_functions.csv")
    void calculate_evenFunction(double x, int n) {
        double positive = CosSeries.calculate(x, n);
        double negative = CosSeries.calculate(-x, n);
        assertEquals(positive, negative, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task1/csv/periodicity.csv")
    void calculate_periodicityApproximation(double x, int n) {
        double shifted_x = x + 2 * Math.PI;
        double base = CosSeries.calculate(x, n);
        double shifted = CosSeries.calculate(shifted_x, n);

        assertAll(
                () -> assertEquals(Math.cos(x), base, COS_DELTA),
                () -> assertEquals(Math.cos(shifted_x), shifted, COS_DELTA),
                () -> assertEquals(base, shifted, COS_DELTA)
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task1/csv/small_large_values.csv")
    void calculate_smallAndLargeValues(double x, int n) {
        double result = CosSeries.calculate(x, n);
        assertFalse(Double.isNaN(result));
        assertFalse(Double.isInfinite(result));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.MAX_VALUE, -Double.MAX_VALUE})
    void calculate_maxValue_returnsNonFiniteResult(double x) {
        int n = 10;
        double result = CosSeries.calculate(x, n);

        assertTrue(Double.isInfinite(result) || Double.isNaN(result));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.MIN_VALUE, -Double.MIN_VALUE})
    void calculate_minValue_isCloseToOne(double x) {
        int n = 10;
        double result = CosSeries.calculate(x, n);

        assertEquals(1.0, result, DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 1.0, -1.0, 3.14})
    void calculate_zeroN_throwsException(double x) {
        int n = 0;
        assertThrows(IllegalArgumentException.class, () -> CosSeries.calculate(x, n));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task1/csv/negative_n.csv")
    void calculate_negativeN_throwsException(double x, int n) {
        assertThrows(IllegalArgumentException.class, () -> CosSeries.calculate(x, n));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void calculate_specialDoubleValues_returnsNaN(double x) {
        int n = 10;
        double result = CosSeries.calculate(x, n);
        assertTrue(Double.isNaN(result));
    }
}