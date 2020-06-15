package com.pravin.interview.ctci.queue.phase2;


public class MyQueue<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "QueueNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private QueueNode<T> head;
    private QueueNode<T> tail;


    public void add(T data) {
        QueueNode<T> node = new QueueNode<>(data);

        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = tail;
        }
    }

    public T remove() {
        if (head == null) throw new RuntimeException();
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public T peek() {
        if (head == null) throw new RuntimeException();
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        myQueue.add(40);
        System.out.println(myQueue);
        System.out.println(myQueue.remove());
        System.out.println(myQueue.peek());
        System.out.println(myQueue);
        System.out.println(myQueue.remove());
        System.out.println(myQueue.peek());
        System.out.println(myQueue);
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue);
        myQueue.add(50);
        System.out.println(myQueue);

    }
}
