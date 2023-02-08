package Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
와일드 카드
지네릭 타입은 컴파일 타임 이후에는 제거되기 때문에
메서드를 오버로딩할 시 "메서드 중복정의"로 판정되어 컴파일 에러 발생한다.
이를 막기위해 "매개변수 지네릭 타입 지정 변수"를 만들었다.

이제 매개변수 타입을 상한과 하한을 정하지 않을 시 모든 타입이 가능하게 된다.

특히 Comparator<T>의 선언부를 보면 다음과 같다
static <T> void sort(List<T> list, Comparator<? super T> c)
여기서 <? super T>를 붙인 이유는 중복 코드의 제거 및 반복 생성 제거를 하기 위함이다.
밑에 코드 구현부를 보고 이해하자.
 */

class Cloth {
    String name;
    int length;

    public Cloth(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public String toString() {
        return name + " (" + length + ")";
    }
}

class WidePants extends Cloth {
    public WidePants(String name, int length) {
        super(name, length);
    }
}

class StraightPants extends Cloth {
    public StraightPants(String name, int length) {
        super(name, length);
    }
}

class WidePantsComp implements Comparator<WidePants> {
    public int compare(WidePants w1, WidePants w2) {
        return w2.length - w1.length;
    }
}

class StraightPantsComp implements Comparator<StraightPants> {
    @Override
    public int compare(StraightPants o1, StraightPants o2) {
        return o2.length - o1.length;
    }
}

// 와일드 카드의 중복 제거
class PantsComp implements Comparator<Cloth> {
    public int compare(Cloth c1, Cloth c2) {
        return c2.length - c1.length;
    }
}

class ClothBox<T> {
    ArrayList<T> list = new ArrayList<T>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    ArrayList<T> getList() {
        return list;
    }

    int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

class ClothPantsBox<T extends Cloth> extends ClothBox<T> {};

public class WildCardEx {

    public static void main(String[] args) {
        ClothPantsBox<WidePants> widePantsClothBox = new ClothPantsBox<WidePants>();
        ClothPantsBox<StraightPants> straightPantsClothPantsBox = new ClothPantsBox<StraightPants>();

        widePantsClothBox.add(new WidePants("Suare", 100));
        widePantsClothBox.add(new WidePants("musinsa standard", 95));

        Collections.sort(widePantsClothBox.getList(), new WidePantsComp());
        // static <T> void sort(List<T> list, Comparator<? super T> c)
        System.out.println("widePantsClothBox = " + widePantsClothBox);

        Collections.sort(widePantsClothBox.getList(), new PantsComp());
        // 이렇게 하면 PantsBox들의 다른 것들도 PantsComp()로 정렬이 가능해진다. 모두 정렬 가능
    }

}
