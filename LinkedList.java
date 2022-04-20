package com.javax;

import java.util.Scanner;

class LinkedList {
    Node head;
    class Node {
        int data;
        Node next;

//constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }
//new node next = prev node next
    /*
    Method for Insert at the beginning
     */
    public void insertAtBeginning(int new_data)
    {
        // insert the data
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    /*
     Method for Insert after a node
     */
    public void insertAfter(Node prev_node, int new_data)
    {
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    /*
    Method for  Insert at the end
     */
    public void insertAtEnd(int new_data)
    {
        Node new_node = new Node(new_data);

        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    /*
    Method for deleting a node from the linkedlist
     */
    void deleteNode(int position)
    {
        if (head == null)
            return;

        Node temp = head;

        if (position == 0)
        {
            head = temp.next;
            return;
        }
        // Find the key to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        // If the key is not present
        if (temp == null || temp.next == null)
            return;

        // Remove the node
        Node next = temp.next.next;

        temp.next = next;
    }


    /*
    Method for displaying the linked list
     */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }

    }
/*
MAIN method
 */
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter th elements to be added");
        int new_data = sc.nextInt();


        llist.insertAtEnd(new_data);
        llist.insertAtBeginning(2);
        llist.insertAtBeginning(3);
        llist.insertAtEnd(4);
        llist.insertAfter(llist.head.next, 5);

        System.out.println("Linked list: ");
        llist.printList();

        System.out.println("\nAfter deleting an element: ");
        llist.deleteNode(3);
        llist.printList();

        System.out.println();




    }
}