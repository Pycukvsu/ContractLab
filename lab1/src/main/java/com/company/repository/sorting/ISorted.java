package com.company.repository.sorting;

import com.company.�onracts.Contract;

import java.util.Comparator;

public interface ISorted {

    void sort(Contract[] storage, Comparator<Contract> comparator);

}
