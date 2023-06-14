import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("hello");
        System.out.println(SimpleMathLibrary.add(1,5));

        TestRunner testRunner = new TestRunner();

        testRunner.runTestClassByName("SimpleMathLibraryTest");
        testRunner.runTestClassByClass(SimpleMathLibraryTest.class);
        testRunner.runTestClassesByNames("SimpleMathLibraryTest","SimpleMathLibraryTest");
        testRunner.runTestClassByClasses(SimpleMathLibraryTest.class, SimpleMathLibraryTest.class);
        testRunner.runTestClassByDirectory("C:/Job/Hillel/unitTests/src/SimpleMathLibraryTest");

        TestResultParser.parseByName("14062023_test.txt");

        int[] inputArray = {1, 2, 4, 4, 2, 3, 4, 1, 7};

        try {
            int[] resultArray = getElementAfterFour(inputArray);
            System.out.println(Arrays.toString(resultArray));
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: " + e.getMessage());
        }

        int[] arr1 = {1, 1, 1, 4, 4, 1, 4, 4};
        int[] arr2 = {1, 1, 1, 1, 1, 1};
        int[] arr3 = {4, 4, 4, 4};
        int[] arr4 = {1, 4, 4, 1, 1, 4, 3};

        System.out.println(checkArrayOneAndFour(arr1));
        System.out.println(checkArrayOneAndFour(arr2));
        System.out.println(checkArrayOneAndFour(arr3));
        System.out.println(checkArrayOneAndFour(arr4));
    }

    public static int[] getElementAfterFour(int[] array) {
        int lastFourIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                lastFourIndex = i;
            }
        }
        if (lastFourIndex == -1) {
            throw new RuntimeException("Array doesn`t have 4");
        }
        int[] resultArray = new int[array.length - lastFourIndex - 1];
        for (int i = lastFourIndex + 1, j = 0; i < array.length; i++, j++) {
            resultArray[j] = array[i];
        }
        return resultArray;
    }


    public static boolean checkArrayOneAndFour(int[] array) {
        boolean isOne = false;
        boolean isFour = false;

        for (int num : array) {
            if (num == 1) {
                isOne = true;
            } else if (num == 4) {
                isFour = true;
            }
        }
        return isOne && isFour;
    }
}
