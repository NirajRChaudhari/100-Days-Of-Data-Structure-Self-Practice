package Arrays;

public class StockBuyAndSellToMaximizeProfit extends ArrayParentClass {
    public static void main(String[] args) {

        int array[] = getArray();
        int size = array.length;

        approachOne(array, size);

        // Better approach focuses on consecutive pair's contribution to totalProfit
        // approachTwo(array, size);
    }

    static void approachOne(int[] array, int size) {

        int i = 0;

        // Direction -1 is Loss and 1 is profit
        int direction = 1, totalProfit = 0;

        int stockBuyAmount = array[0];
        for (i = 0; i < size; i++) {

            while (direction == 1 && i < size) {

                if (i + 1 == size) {
                    totalProfit += array[i] - stockBuyAmount;

                } else if (array[i] > array[i + 1]) {
                    // Right time to sell as stock price is highest now and going to decrease
                    totalProfit += array[i] - stockBuyAmount;
                    direction = -1;
                }
                i++;
            }

            while (direction == -1 && i + 1 < size) {

                // Right time to buy when stock price is lowest now and going to increase
                if (array[i] < array[i + 1]) {
                    stockBuyAmount = array[i];
                    direction = 1;
                }
                i++;
            }
        }

        System.out.println("\nMaximum Profit earned is : " + totalProfit + "\n");
    }// approachOne

    static void approachTwo(int[] array, int size) {

        int totalProfit = 0;

        for (int i = 1; i < size; i++) {

            if (array[i] > array[i - 1]) {
                totalProfit = totalProfit + (array[i] - array[i - 1]);
            }
        }

        System.out.println("\nMaximum Profit earned is : " + totalProfit + "\n");
    }
}
