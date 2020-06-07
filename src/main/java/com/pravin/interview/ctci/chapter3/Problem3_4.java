package com.pravin.interview.ctci.chapter3;


import java.util.Stack;

public class Problem3_4 {

    private Stack<Integer> ns = new Stack<>();
    private Stack<Integer> os = new Stack<>();


    @Override
    public String toString() {
        return "Problem3_4{" +
                "ns=" + ns +
                ", os=" + os +
                '}';
    }

    public void add(int data) {
        ns.push(data);
    }

    public int remove() {
        if (os.isEmpty()) {
            while (!ns.isEmpty()) {
                os.push(ns.pop());
            }
        }

       if (os.isEmpty()) {
           throw new RuntimeException();
       }
       return os.pop();
    }


    public int peek() {

        if (os.isEmpty()) {
            while (!ns.isEmpty()) {
                os.push(ns.pop());
            }
        }
        if (os.isEmpty()) {
            throw new RuntimeException();
        }
        return os.peek();

    }


    public static void main(String[] args) {

        Problem3_4 queue = new Problem3_4();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue);

        queue.peek();
        queue.add(20);
        System.out.println(queue);
    }

}
