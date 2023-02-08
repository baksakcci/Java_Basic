package Generics;

import java.util.ArrayList;

class Fruit implements Eatable {
    public String toString() { return "Fruit"; }
}
class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple";
    }
}

class Grape extends Fruit {
    @Override
    public String toString() {
        return "Grape";
    }
}

class Pen {
    @Override
    public String toString() {
        return "Pen";
    }
}

interface Eatable { }

class FruitBox<T extends Fruit & Eatable> extends Box<T> { }

public class ToyBoxEx2 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
        // Toy는 올 수 없다.

        fruitBox.addItem(new Fruit());
        fruitBox.addItem(new Apple());
        fruitBox.addItem(new Grape());
        appleBox.addItem(new Apple());

        System.out.println("fruitBox = " + fruitBox);
        System.out.println("grapeBox = " + grapeBox);
        System.out.println("appleBox = " + appleBox);    }
}
