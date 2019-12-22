package homework.ls_09_Exceptions.task2_MyException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MethodsTest {

    Methods methods;

    @BeforeEach
    void init() {
        methods = new Methods();
    }

    @Nested
    @DisplayName("Addition method")
    class AddTest {

        @Test
        @DisplayName("IllegalArgumentException")
        void add_TooLowValues_ExceptionThrown() {
            assertThrows(IllegalArgumentException.class, () -> methods.add(Integer.MIN_VALUE, Integer.MIN_VALUE));
        }

        @Test
        @DisplayName("MyException")
        void add_TooLargeValues_ExceptionThrown() {
            assertThrows(MyException.class, () -> methods.add(Double.MAX_VALUE, Double.MAX_VALUE));
        }

        @Test
        @DisplayName("without exception")
        void add_AddingZeros_Success() {

            try {

                double expected = 0;
                double actual = methods.add(0, 0);

                assertEquals(expected, actual);


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    }

    @Nested
    @DisplayName("Subtraction method")
    class SubTest {

        @Test
        @DisplayName("ArithmeticException")
        void sub_ZeroSubtractSomeValue_ExceptionThrown() {
            assertThrows(ArithmeticException.class, () -> methods.sub(0, Double.MAX_VALUE));
        }

        @Test
        @DisplayName("without exception")
        void sub_SomeValueSubtractZero_Success() {
            double expected = Double.MAX_VALUE;
            double actual = methods.sub(Double.MAX_VALUE, 0);

            assertEquals(expected, actual);
        }

    }

    @Nested
    @DisplayName("Multiplication method")
    class MultTest {

        @Test
        @DisplayName("ArithmeticException")
        void mult_SomeValueMultiplyZero_ExceptionThrown() {
            assertThrows(ArithmeticException.class, () -> methods.mult(Double.MAX_VALUE, 0));
        }

        @Test
        @DisplayName("without exception")
        void mult_TwoMultiplyTwo_Success() {
            double expected = 4;
            double actual = methods.mult(2, 2);

            assertEquals(expected, actual);
        }

    }

    @Nested
    @DisplayName("Division method")
    class DivTest {

        @Test
        @DisplayName("IllegalAccessException")
        void div_ZeroDivideByZero_ExceptionThrown() {
            assertThrows(IllegalAccessException.class, () -> methods.div(0, 0));
        }

        @Test
        @DisplayName("division by zero")
        void div_SomeValueDivideByZero_ExceptionThrown() {
            assertThrows(IllegalArgumentException.class, () -> methods.div(Double.MAX_VALUE, 0));
        }

        @Test
        @DisplayName("without exception")
        void div_FourDivideTwo_Success() {

            try {

                double expected = 2;
                double actual = methods.div(4, 2);

                assertEquals(expected, actual);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    }

}