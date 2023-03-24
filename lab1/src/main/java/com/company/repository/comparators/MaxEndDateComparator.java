package com.company.repository.comparators;

import com.company.ñonracts.Contract;

import java.util.Comparator;

public class MaxEndDateComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract o1, Contract o2) {
        if (o2.getEndDate().isAfter(o1.getEndDate())) {
            return 1;
        }else if (!o2.getEndDate().isAfter(o1.getEndDate())){
            return -1;
        }else
            return 0;
    }
}
