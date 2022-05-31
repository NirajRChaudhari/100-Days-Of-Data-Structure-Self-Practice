package Hashing;

public class HashWithOpenAddressing {

    int hashTable[];
    int capacity, size;

    HashWithOpenAddressing(int capacity, int size) {

        this.capacity = capacity;
        this.size = size;
        this.hashTable = new int[capacity];

        /*
         * -1 = Empty Element
         * -2 = Deleted Element
         */
        for (int i = 0; i < capacity; i++) {
            this.hashTable[i] = -1;
        }
    }

    int hashFunction1(int num) {

        return num % capacity;
    }

    void insertInHash(int num) {

        if (size >= capacity) {
            System.out.println("Insertion Failed as Hash Table is Full..");
            return;
        }

        int hashKey = hashFunction1(num);
        int index = hashKey, offset = 0;

        // If the position is occupied
        while (hashTable[index] != -1 || hashTable[index] != -2) {

            if (hashTable[index] == num) {
                System.out.println("\nGiven Element already exists in the Hash Table..");
                return;
            }

            offset++;
            index = (hashKey + offset) % capacity;

            if (hashKey == index) {
                System.out.println("\nNo Empty Place found");
                return;
            }
        }

        hashTable[index] = num;
    }

    boolean searchInHash(int key) {

        int hashKey = hashFunction1(key);
        int index = hashKey, offset = 0;

        // If the position is not Empty
        while (hashTable[index] != -1) {

            if (hashTable[index] == key) {
                return true;
            }

            offset++;
            index = (hashKey + offset) % capacity;

            if (index == hashKey) {
                return false;
            }
        }

        return false;
    }

    boolean deleteFromHash(int key) {

        int hashKey = hashFunction1(key);
        int index = hashKey, i = 0;

        while (hashTable[index] != -1) {

            if (hashTable[index] == key) {
                hashTable[index] = -2;
                return true;
            }

            i++;
            index = (hashKey + i) % capacity;

            if (index == hashKey) {
                return false;
            }
        }

        return false;
    }
}
