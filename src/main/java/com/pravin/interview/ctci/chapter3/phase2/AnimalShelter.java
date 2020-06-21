package com.pravin.interview.ctci.chapter3.phase2;

import java.util.LinkedList;

public class AnimalShelter {

    private static class Animal {
        int order;
        String type;

        public Animal(String type) {
            this.type = type;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }
    }

    private class Cat extends Animal {
        public Cat(String cat) {
            super(cat);
        }
    }

    private class Dog extends Animal {
        public Dog(String dog) {
            super(dog);
        }
    }

    private LinkedList<Animal> dogs = new LinkedList<>();
    private LinkedList<Animal> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal animal) {
        order++;
        animal.setOrder(order);
        if (animal instanceof Dog) {
            dogs.add(animal);
        } else {
            cats.add(animal);
        }

    }

    public Dog dequeueDog() {
        if (dogs.isEmpty()) {
            return null;
        }
        order--;
        Animal animal = dogs.remove();

        return (Dog) animal;

    }

    public Cat dequeueCat() {
        if (cats.isEmpty()) {
            return null;
        }
        order--;
        Animal animal = cats.remove();
        return (Cat) animal;
    }

    public Animal dequeueAny() {

        if (dogs.isEmpty() && cats.isEmpty()) {
            return null;
        }

        if (dogs.isEmpty()) {
            return cats.remove();
        } else if (cats.isEmpty()) {
            return dogs.remove();
        }

        Animal dog = dogs.peek();
        Animal cat = cats.peek();

        if (dog.getOrder() > cat.getOrder()) {
            return dog;
        }else {
            return cat;
        }
    }
}
