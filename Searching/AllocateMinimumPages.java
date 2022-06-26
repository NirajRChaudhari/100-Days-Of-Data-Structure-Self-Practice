package Searching;

//Divide all books pages among given number of students and find the combination of distribution where maximum number of pages read by student is minimum as compared to other combinations
public class AllocateMinimumPages extends SearchingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        System.out.println("\nEnter the Total number of Students : ");
        int noOfStudents = sc.nextInt();

        // Call the function with params as student 1 has already taken book 0 as it is
        // compulsory for student 1 to take 0th index book in any combination
        int pages = findMaximumPagesByAStudent(array, noOfStudents, 0, 0, 0);
        System.out.println("Minimum Number of Pages " + pages);
    }

    static int findMaximumPagesByAStudent(int[] array, int noOfStudents, int currentBook, int currentStudentPagesSum,
            int largestPagesSum) {

        if (noOfStudents == 1 && currentBook == array.length - 1) {
            return Math.max(largestPagesSum, currentStudentPagesSum + array[currentBook]);
        }

        if (noOfStudents == 0 || currentBook == array.length) {
            return Integer.MAX_VALUE;
        }

        int value1 = findMaximumPagesByAStudent(array, noOfStudents, currentBook + 1,
                currentStudentPagesSum + array[currentBook],
                Math.max(largestPagesSum, currentStudentPagesSum + array[currentBook]));

        int value2 = findMaximumPagesByAStudent(array, noOfStudents - 1, currentBook, 0, largestPagesSum);

        return Math.min(value1, value2);
    }
}
