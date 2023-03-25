package com.company.repository.comparators;

import com.company.�onracts.Contract;

import java.util.Comparator;

/**
 * ���������� ��� ��������� � ContractOwner ���� id.
 * @autor �������� ������
 */
public class HumanIdComparator implements Comparator<Contract> {
    @Override
    public int compare(Contract o1, Contract o2) {
        return o2.getContractOwner().getId() - o1.getContractOwner().getId();
    }
}
