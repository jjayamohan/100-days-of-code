package com.jay.datastructure;

public class LinkedList<A> {

    private int size;
    private Node<A> first;
    private Node<A> last;

    public void addFirst (A a) {

        final Node<A> f = first;
        Node newNode = new Node(a, null, first);
        first = newNode;

        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }

        size++;
    }

    public void addLast (A a) {

        final Node<A> l = last;
        Node<A> newNode = new Node<>(a, last, null);
        last = newNode;

        if (l.prev == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        size++;
    }

    public void removeFirst () {
        Node<A> newFirst = first.next;
        first = newFirst;

        if(newFirst == null)
            last = null;
        else {
            newFirst.prev = null;
        }

        size--;
    }

    public void removeLast () {
        Node<A> newLast = last.prev;
        last = newLast;

        if (newLast == null)
            first = null;
        else {
            newLast.next = null;
        }

        size--;
    }



}

class Node<A> {
    A a;
    Node<A> prev;
    Node<A> next;

    Node (A a, Node<A> prev, Node<A> next) {
       this.a = a;
       this.prev = prev;
       this.next = next;
    }
}

