package com.pravin.interview.ctci.chapter3;

import java.util.Stack;

/*
Sort stack with temp stack.
 */
public class SortedStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tmp = new Stack<>();

    @Override
    public String toString() {
        return "SortedStack{" +
                "stack=" + stack +
                ", tmp=" + tmp +
                '}';
    }

    public void push(int data){

          if (stack.isEmpty()) {
              stack.push(data);

          }  else {

              while(!stack.isEmpty() && data > stack.peek()){
                  tmp.push(stack.pop());
              }
              stack.push(data);
              while (!tmp.isEmpty()){
                  stack.push(tmp.pop());
              }

          }
    }

    public int pop(){
        return stack.pop();
    }

    public int peek(){
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(1);
        sortedStack.push(2);
        sortedStack.push(4);
        sortedStack.push(1);
        sortedStack.push(2);
        sortedStack.push(3);
        System.out.println(sortedStack);
        //SortedStack{stack=[4, 3, 2, 2, 1, 1], tmp=[]}

        System.out.println( sortedStack.pop());
        // o/p : 1
    }

}
