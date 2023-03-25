package com.company.repository.comparators;

import com.company.сonracts.Contract;

import java.util.Comparator;

/**
 * Компаратор для сравнения StartDate.
 * @autor Хачетлов Руслан
 */
public class MaxStartDateComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        if (o2.getStartDate().isAfter(o1.getStartDate())) {
            return 1;
        }else if (!o2.getStartDate().isAfter(o1.getStartDate())){
            return -1;
        }else
            return 0;
    }
}