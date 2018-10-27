package com.psalguero.spring.basics.springin5steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements SortAlgorith{

    public int[] sort(int[] numbers){
        //Logica para ordenar
        return  numbers;
    }
}
