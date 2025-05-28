package day0430.advanced.ch15.sec05.exam04;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {

    @Override
    public int compare(Fruit o1, Fruit o2) {
        if (o1.price > o2.price) return 1;
        else return o1.price - o2.price;
    }
}
