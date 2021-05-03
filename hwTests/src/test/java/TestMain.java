import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class TestMain {
    private static Main main;

    @BeforeAll
    public static void before() {
        main = new Main();
    }

    public static Stream<Arguments> data() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1,7}, new int[] {1,2,4,4,2,3,4,1,7}));
        out.add(Arguments.arguments(new int[] {}, new int[] {1,2,4,3,4}));
        out.add(Arguments.arguments(new int[] {1,5}, new int[] {1,2,4,4,2,3,4,1,5}));
        return out.stream();
    }


    @ParameterizedTest
    @MethodSource("data")
    public void testMetod1(int[] newArray, int[] array) {
        Assertions.assertArrayEquals(newArray, main.metod1(array));
    }


    public static Stream<Arguments> data2() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(false, new int[] {1,2,3,3,5,6,4}));
        out.add(Arguments.arguments(true, new int[] {1,4,4}));
        out.add(Arguments.arguments(true, new int[] {1,1,4}));
        out.add(Arguments.arguments(true, new int[] {1,1,4,4}));
        out.add(Arguments.arguments(false, new int[] {}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("data2")
    public void testMetod2(boolean result , int[] array) {
        Assertions.assertEquals(result, main.metod2(array));
    }
}
