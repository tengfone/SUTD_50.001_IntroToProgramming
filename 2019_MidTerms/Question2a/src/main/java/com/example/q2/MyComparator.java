package com.example.q2;

//***[QUESTION 2a]*********
import java.util.Comparator;

public class MyComparator  implements Comparator<Animal>{
    @Override
    public int compare(Animal animal, Animal t1) {
        return Integer.compare(animal.getWeight(),t1.getWeight());
    }
    //TODO: implement MyComparator class

}
