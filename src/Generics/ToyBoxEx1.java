package Generics;

import java.util.ArrayList;

class Thing {
    @Override
    public String toString() {
        return "Thing";
    }
}

class Toy extends Thing {
    @Override
    public String toString() {
        return "Toy";
    }
}

class Book extends Thing {
    @Override
    public String toString() {
        return "Book";
    }
}

// 지네릭 클래스
class Box<T> {
    ArrayList<T> arr = new ArrayList<T>();
    void addItem(T item) { arr.add(item); }
    T getItem(int i) { return arr.get(i); }
    int size() { return arr.size(); }

    @Override
    public String toString() {
        return arr.toString();
    }
}
public class ToyBoxEx1 {
    public static void main(String[] args) {
        Box<Thing> box = new Box<>(); // 뒤에 생성자 타입 생략 가능(JDK1.7부터)
        Box<Toy> toyBox = new Box<>();
        Box<Book> bookBox = new Box<>();

        box.addItem(new Thing());
        box.addItem(new Toy()); // 자손타입까지 추가로 넣을 수 있기 때문에 물건 안에 장난감, 책 다 넣을 수 있게 됨

        toyBox.addItem(new Toy()); // book 불가

        System.out.println(box);
        System.out.println("toyBox = " + toyBox);
        System.out.println("bookBox = " + bookBox);
    }
}
