package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class PrintFrequencyOfElements extends HashingParentClass {

    public static void main(String[] args) {

        int[] array = getArray();

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            hashMap.put(array[i], hashMap.getOrDefault(array[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> hashData : hashMap.entrySet()) {

            System.out.println(hashData.getKey() + "  " + hashData.getValue());
        }
    }
}
