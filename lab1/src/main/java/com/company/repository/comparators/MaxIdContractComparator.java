package com.company.repository.comparators;

import com.company.сonracts.Contract;

import java.util.Comparator;

/**
 * Компаратор для сравнения Id.
 * @autor Хачетлов Руслан
 */
public class MaxIdContractComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        return o2.getId() - o1.getId();
    }
}
