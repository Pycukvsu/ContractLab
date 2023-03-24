package com.company.repository.comparators;

import com.company.ñonracts.Contract;

import java.util.Comparator;

public class MaxNumberContractComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        return o2.getNumberContract() - o1.getNumberContract();
    }
}
