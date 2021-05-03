import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            int[] newArray = metod1(new int[]{1, 4, 4, 3, 5, 6});
            System.out.println(Arrays.toString(newArray));
        } catch (RuntimeException e) {
        }



        System.out.println(metod2(new int[] {1,2,3,3,5,6,4}));
        System.out.println(metod2(new int[] {1,4,4}));
        System.out.println(metod2(new int[] {1,1,4}));
        System.out.println(metod2(new int[] {1,1,4,4}));
        System.out.println(metod2(new int[] {}));
    }

    public static int[] metod1 (int[] array) throws RuntimeException {
        int index4 = -10;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4 ) {
                index4 = i;
            }
        }
        if (index4 == -10) {
            throw new RuntimeException();
        }
        int[] newArray = new int[array.length - index4 - 1];

        int newIndex = 0;
        for (int i = index4 + 1; i < array.length; i++) {
            newArray[newIndex] = array[i];
            newIndex++;
        }
        return newArray;
    }

    public static boolean metod2(int[] array) {
        boolean one = false;
        boolean four = false;
        boolean another = false;
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case (1):
                    one = true;
                    break;
                case (4):
                    four = true;
                    break;
                default:
                    another = true;
                    break;
            }
            if (another) {
                return false;
            }
        }
        return one && four;
    }
}
