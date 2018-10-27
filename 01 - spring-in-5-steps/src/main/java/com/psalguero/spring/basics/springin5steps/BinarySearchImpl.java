package com.psalguero.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    private  SortAlgorith sortAlgorith;

    public void setSortAlgorith(SortAlgorith sortAlgorith) {
        this.sortAlgorith = sortAlgorith;
    }

    public int binarySearch(int numbers[], int numberToSearchFor) {
        int[] sortedNumbers = sortAlgorith.sort(numbers);
        System.out.println(sortAlgorith);
        return 3;
    }
}
