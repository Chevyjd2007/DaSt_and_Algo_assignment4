package com.Chevy;
/**
 * The class LinkedList implements a singly linked list of strings.
 * The list uses a header (dummy) node.
 *
 * @author Josias
 */
public class LinkedList
{
    /**
     * Implements the node of a singly linked list of string type.
     */
    private class Node
    {
        private String info;
        private Node next;

        public Node()
        {
            info = "<empty>";
            next = null;
        }

        public String getInfo()
        {
            return info;
        }

        public Node getNext()
        {
            return next;
        }

        public void setInfo(String info)
        {
            this.info = info;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }
    }

    private final Node first; //dummy header node

    /**
     * Default constructor. Sets this object as an empty list.
     */
    public LinkedList()
    {
        first = new Node();
    }

    /**
     * Adds given string as the first element of the list.
     *
     * @param str given string
     */
    /* from slide 5, we make a new node and populated with the parameter given.
    Then we set it into the list.
     */
    public void add(String str)
    {
        Node q = new Node();

        q.setInfo(str);
        q.setNext(first.getNext());

        first.setNext(q);

    }

    /**
     * Determines if linked list is empty.
     *
     * @return true if list contains no elements, false otherwise.
     */
    //Referenced from slide 5. We check if there are nodes after the first.
    public boolean isEmpty()
    {
        return (first.getNext() == null);
    }

    /**
     * Removes given string from the list.
     *
     * @param str string to be removed
     */
    /*
    we traverse through the linked list in the while loop looking for the parameter.
    If found we return true which will then remove the location of the node and
    add it to the node after. Thus, successfully removing the link of the older
    node.
     */
    public void remove(String str)
    {
        Node o = first.getNext(), p = first;

        boolean found = false;
        while (o != null && !found){
            if (o.getInfo() == str)
                found = true;
            else{
                p = o;
                o = p.getNext();
            }
        }
        if (found)
            p.setNext(o.getNext());
    }

    /**
     * Determines if given string is in the list.
     *
     * @param str given string
     * @return true if str is in the list, false otherwise
     */
    /*Referenced from slide 5. We create a node and set it to the first node's (dummy)
    next node (where are list starts). We keep checking if that node equals the specified string
    if not  set the node to the node after. If we do find it we return True, if not then the loop
    breaks and return false instead.
     */
    public boolean search(String str)
    {
        Node current = first.getNext();

        while (current != null){
            if (current.getInfo() == str)
                return true;

            current = current.getNext();
        }

        return false;
    }

    /**
     * Constructs a String description of the list.
     *
     * @return String containing the list elements.
     */
    public String toString()
    {
        Node current = first.getNext();


        String str = "";
        while (current != null)
        {
            str += "[" + current.getInfo() + "]";
            current = current.getNext();

            if (current != null)
                str += " -> ";
        }

        return str;
    }
}
