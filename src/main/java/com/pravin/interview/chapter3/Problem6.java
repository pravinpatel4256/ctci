package com.pravin.interview.chapter3;

import java.util.LinkedList;
import java.util.Objects;

public class Problem6 {


    private static class Animal{
        private String type;
        private int order;



        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }


        public Animal(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "type='" + type + '\'' +
                    ", order=" + order +
                    '}';
        }
    }


    private LinkedList<Animal> dogs = new LinkedList<>();
    private LinkedList<Animal> cats = new LinkedList<>();
    int order = 0;

    @Override
    public String toString() {
        return "Problem6{" +
                "dogs=" + dogs +
                ", cats=" + cats +
                ", order=" + order +
                '}';
    }

    public void push(String type){

        Animal animal = new Animal(type);
        animal.setOrder(order);
        order++;

        if("dog".equalsIgnoreCase(type)){
            dogs.addLast(animal);
        }else if ("cat".equalsIgnoreCase(type)){
            cats.addLast(animal);
        }else {
            throw new RuntimeException();
        }
    }


    public Animal pollDog() {

        return dogs.poll();
    }


    public Animal pollCat() {

        return cats.poll();
    }

    public Animal pollAny() {

        if (Objects.requireNonNull(cats.peek()).getOrder() > Objects.requireNonNull(dogs.peek()).getOrder()){
            return dogs.poll();
        }
        return cats.poll();
    }

    public static void main(String[] args) {

        Problem6 problem6 = new Problem6();
        problem6.push("dog");
        problem6.push("dog");
        problem6.push("cat");
        problem6.push("dog");
        problem6.push("dog");
        problem6.push("dog");
        problem6.push("cat");
        problem6.push("cat");
        problem6.push("cat");
        problem6.push("cat");
        problem6.push("cat");
        problem6.push("dog");

        System.out.println(problem6);

        System.out.println(problem6.pollCat());

        System.out.println(problem6.pollAny());

        System.out.println(problem6.pollAny());

        System.out.println(problem6.pollAny());

        System.out.println(problem6);

    }
}
