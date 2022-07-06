package Recursion;

// There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

public class JosephusProblem extends RecursionParentClass {

    public static void main(String[] args) {

        System.out.println("\nEnter total number of persons : ");
        int noOfPeople = sc.nextInt();

        System.out.println("\nEnter frequency of Elimination : ");
        int frequency = sc.nextInt();

        // If position starts from 1 instead of 0 just add +1 here to final output
        int safePosition = findSafePosition(noOfPeople, frequency);

        System.out.println("\nSafe Position is : " + safePosition + "\n");
    }

    static int findSafePosition(int noOfPeople, int frequency) {

        if (noOfPeople == 1) {
            return 0;
        }

        int pos = findSafePosition(noOfPeople - 1, frequency);
        System.out.println(pos + " " + frequency + " " + noOfPeople + " " + (pos + frequency) % noOfPeople);
        return (pos + frequency) % noOfPeople;
    }
}
