package com.company.repository.sorting;

import com.company.repository.Storage;
import com.company.�onracts.Contract;

import java.util.Comparator;

public interface ISorted {

    void sort(Storage storage, Comparator<Contract> comparator);

}
