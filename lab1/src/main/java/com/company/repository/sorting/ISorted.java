package com.company.repository.sorting;

import com.company.�onracts.Contract;

import java.util.Comparator;

public interface ISorted {

    <T> void sort(Contract[] storage, Comparator<Contract> comparator);

}
