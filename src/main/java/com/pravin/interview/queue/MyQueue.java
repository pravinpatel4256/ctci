package com.pravin.interview.queue;

public class MyQueue<T> {


    private static class QueueNode<T> {

        private T data;
        private QueueNode<T>  next;


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


    private QueueNode<T> first;
    private QueueNode<T> last;


    public void add(T data){

        QueueNode<T> t = new QueueNode<>(data);

        if (last != null) {
            last.next = t;
        }

        last = t;

        if (first == null) {
            first = last;

        }

    }


    public T remove() {

        if (first == null) {
            throw new RuntimeException();
        }

        T data = first.data;

        first = first.next;

        if (first == null) {
            last = null;
        }

        return data;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }

    public static void main(String[] args) {
        MyQueue<Integer>  myQueue = new MyQueue<>();
        myQueue.add(10);
//        myQueue.add(10);
  //      myQueue.add(10);
        System.out.println(myQueue);
        myQueue.remove();
        System.out.println(myQueue);
    }
}
