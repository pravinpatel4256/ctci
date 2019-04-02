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

    public boolean isEmpty(){
        return first == null;
    }


    public T peek(){
        if (first == null) {
            throw new RuntimeException();
        }
        return first.data;
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
//        myQueue.push(10);
  //      myQueue.push(10);
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.isEmpty());
        myQueue.remove();
        System.out.println(myQueue);

        int[] a = new int[2];

        a[0] = 1;
        a[1] = 3;

        int [] ar = new int[20];

        System.arraycopy(a,0, ar, 0, a.length );

        for (int d: ar) {
            System.out.println(d);
        }

        a = ar;

        ar[4] = 9;

        for (int d: a) {
            System.out.println(d);
        }
    }
}
