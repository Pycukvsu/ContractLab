package com.company.repository.comparators;

import com.company.сonracts.Contract;

import java.util.Comparator;

/**
 * Компаратор для сравнения у ContractOwner поля id.
 * @autor Хачетлов Руслан
 */
public class HumanIdComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract o1, Contract o2) {
        return o2.getContractOwner().getId() - o1.getContractOwner().getId();
    }
}
