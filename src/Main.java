import Sorting.Selection_Sort;

public class Main {
    public static void main(String[] args) {

        // 1. Create the testing object
        TestArr tester = new TestArr();
        Selection_Sort Sel = new Selection_Sort();

        System.out.print("Testing Bubble Sort: ");

        // 2. Run the tests by passing your sorting algorithm
        // The 'arr ->' syntax just tells Java: "Take the array and pass it to my BubbleSort"
        tester.runTests(arr -> Sel.sort(arr));

        /* * Once you write more algorithms, you can test them instantly like this:
         * * System.out.print("Testing Selection Sort: ");
         * tester.runTests(arr -> Sorting.SelectionSort.sort(arr));
         */
    }
}