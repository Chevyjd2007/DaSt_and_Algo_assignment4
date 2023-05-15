package com.Chevy;



/**
 * Implements the symbol table.
 *
 * @author Josias
 */
public class HashTable
{
    private final LinkedList[] table;    //hash table
    private final int tableSize;         //hash table size
    private final int hashConstant = 31; //hash constant used in hash function

    /**
     * Parameterized constructor.Sets this hash table as an empty one. Size of
     * the table is set to given size.
     *
     * @param size size of array defined by user
     */
    //Setting up the hashtable using the linkedlist per entry on the table. The size is provided by the implementation in main.
    public HashTable(int size)
    {
        tableSize = size;

        table = new LinkedList[tableSize];

        for(int i = 0;i < table.length;i++){
            table[i] = new LinkedList();
        }
    }

    /**
     * Adds a string to this hash table.
     *
     * @param str given string
     */
    //We hash the value and then add it to the table's linked list.
    public void add(String str)
    {
        int hashValue = hash(str);

        table[hashValue].add(str);
    }

    /**
     * Determines the hash value of a given string of characters.
     *
     * @param key string
     * @return hash value of key
     */
    private int hash(String key)
    {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++)
        {
            hashVal = hashConstant * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize;

        return hashVal;
    }

    /**
     * Removes from this hash table the given string, if found.
     *
     * @param str given string
     */
    //hash the value then we use the linked list remove method to delete the value if found.
    public void remove(String str)
    {
        int hashValue = hash(str);

        table[hashValue].remove(str);
    }

    /**
     * Determines if given string is in this hash table.
     *
     * @param str given string
     * @return true if search is successful, false otherwise
     */
    //hash the value and then return the value given by the search method in the linked list for the specified value.
    public boolean search(String str)
    {
        int hashValue = hash(str);

        return table[hashValue].search(str);
    }

    /**
     * Constructs a String description of this hash table.
     *
     * @return String containing the hash table elements.
     */
    public String toString()
    {
        String str = "";

        for (int i = 0; i < table.length; i++)
        {
            str = String.format(str + "%2d: ", i);

            str += table[i] + "\n";
        }

        return str;
    }
}
