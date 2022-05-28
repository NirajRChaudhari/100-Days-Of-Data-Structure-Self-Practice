package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashWithChaining {

    int size;
    ArrayList<LinkedList<Integer>> hashTable = new ArrayList<>();

    HashWithChaining(int size) {
        this.size = size;

        for (int i = 0; i < size; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    int hashFunction(int num) {

        return num % size;
    }

    void insertInHash(int num) {

        hashTable.get(hashFunction(num)).add(num);
    }

    boolean searchInHash(int key) {

        return hashTable.get(hashFunction(key)).contains(key);
    }

    boolean deleteFromHash(int key) {
        /*
         * Very Imp : There are 2 remove functions :
         * 1. remove(int index) - removes element at given index
         * 2. remove(Object obj) - removes object obj from list
         * 
         * So, In remove function I had to type-cast the integer to Integer object so
         * that it should be not be treated as index but value to be deleted
         */

        return hashTable.get(hashFunction(key)).remove((Integer) key);
    }
}
