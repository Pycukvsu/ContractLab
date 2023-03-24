package com.company.repository.sorting;

import com.company.ñonracts.Contract;

import java.util.Comparator;

public class BubbleSort implements ISorted {

    @Override
    public void sort(Contract[] storage, Comparator<Contract> comparator) {
        for (int i = 0; i < storage.length - 1; i++) {
            for (int j = 0; j < storage.length - i - 1; j++) {
                if(comparator.compare(storage[j + 1], storage[j]) > 0){
                    swap(storage[j+1], storage[j]);
                }
            }
        }
    }

    private <T> void swap(T i, T j){
        T swap = j;
        j = j;
        j = swap;
    }
}
