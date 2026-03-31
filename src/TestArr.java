import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestArr {

    // The Consumer<int[]> allows us to pass a sorting method as an argument
    public void runTests(Consumer<int[]> sortingMethod) {
        Random random = new Random();
        int numberOfTests = 10;
        boolean allPassed = true;

        List<int[]> failedArrays = new ArrayList<>();

        for (int i = 0; i < numberOfTests; i++) {
            // Generate random size between 5 and 50
            int size = random.nextInt(46) + 5;
            int[] originalArray = new int[size];

            // Fill with random numbers between 0 and 99
            for (int j = 0; j < size; j++) {
                originalArray[j] = random.nextInt(100);
            }

            int[] expectedArray = Arrays.copyOf(originalArray, size);
            int[] userArray = Arrays.copyOf(originalArray, size);

            // 1. Source of truth (Java's built-in sort)
            Arrays.sort(expectedArray);

            // 2. Call whichever sorting method was passed in
            sortingMethod.accept(userArray);

            // 3. Compare
            if (!Arrays.equals(expectedArray, userArray)) {
                allPassed = false;
                failedArrays.add(originalArray); // Store the original unsorted array to print later
            }
        }

        // Print results
        if (allPassed) {
            System.out.println("true");
        } else {
            System.out.println("Failed! Here are the original arrays that did not sort correctly:");
            for (int[] arr : failedArrays) {
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}