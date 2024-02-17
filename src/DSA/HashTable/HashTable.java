package DSA.HashTable;


import java.util.LinkedList;
import java.util.NoSuchElementException;

class HashNode<Key, Value> {

    public Key key;

    public Value value;

    public HashNode(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

}

public class HashTable<Key, Value> {
    private LinkedList<HashNode<Key, Value>>[] table;
    public Integer numberOfBuckets;

    public Integer size;

    public HashTable(Integer capacity) {
        this.numberOfBuckets = capacity;
        this.size = 0;
        this.table = new LinkedList[capacity];
    }

    public HashTable() {
        this.numberOfBuckets = 5;
        this.size = 0;
        this.table = new LinkedList[5];
    }

    private int hashFunction(Key key) {
        int hash = 0;
        if (key instanceof String str) {
            for (int j = 0; j < str.length(); j++) {
                hash += str.charAt(j);
            }
            return hash % numberOfBuckets;
        } else {
            return (int) key % numberOfBuckets;
        }
    }

    public synchronized void put(Key key, Value value) {

        if ((double) size / table.length > 0.85) {
            resize();
        }

        int index = hashFunction(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        } else {
            LinkedList<HashNode<Key, Value>> bucket = table[index];
            for (HashNode<Key, Value> node : bucket) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }
        }

        table[index].add(new HashNode<>(key, value));
        size++;

    }

    public void remove(Key key) {

        int index = hashFunction(key);
        LinkedList<HashNode<Key, Value>> buckets = table[index];

        if (buckets != null) {
            buckets.removeIf(bucket -> bucket.key.equals(key));
            size--;
        } else {
            throw new NoSuchElementException("There is no key like this ");
        }
    }

    public void resize() {

        LinkedList<HashNode<Key, Value>>[] oldTable = table;
        int newCapacity = numberOfBuckets + 10;
        table = new LinkedList[newCapacity];
        numberOfBuckets = newCapacity;
        size = 0;

        for (LinkedList<HashNode<Key, Value>> buckets : oldTable) {
            if (buckets != null) {
                for (HashNode<Key, Value> bucket : buckets) {
                    put(bucket.key, bucket.value);
                }
            }
        }
    }

    public Value getValue(Key key) {

        for (LinkedList<HashNode<Key, Value>> buckets : table) {
            if (buckets != null) {
                for(HashNode<Key,Value> bucket : buckets){
                    if(bucket.key.equals(key)){
                        return bucket.value;
                    }
                }
            }
        }

        throw new NoSuchElementException("There is no key like this");
    }

    public void print() {
        for (int i = 0; i < numberOfBuckets; i++) {
            System.out.print("Bucket " + (i + 1) + ": ");

            LinkedList<HashNode<Key, Value>> bucket = table[i];

            if (bucket != null) {
                for (HashNode<Key, Value> node : bucket) {
                    System.out.print("(" + node.key + ", " + node.value + ") ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.put(1, "User1");
        hashTable.put(2, "User2");
        hashTable.put(3, "User3");
        hashTable.put(5, "User5");


        hashTable.put(12, "User4");
        hashTable.put(22, "User5");
        hashTable.put(33, "User7");
        hashTable.put(15, "User6");
        hashTable.put(25, "User6");


        hashTable.remove(1);
        hashTable.remove(12);
        hashTable.remove(25);
        hashTable.remove(33);

        System.out.println(hashTable.getValue(5));


        hashTable.print();
    }

}