package com.company.repository.sorting;

import com.company.repository.Storage;
import com.company.сonracts.Contract;

import java.util.Comparator;

/**
 * Реализация сортировки шелла.
 * @autor Хачетлов Руслан
 */

public class ShellSort implements ISorted {

    /**
     * Метод проверяет, есть ли уже в хранилище контракт с таким же айди
     *
     * @param storage - хранилище
     * @param comparator класс-«сравниватель»
     */
    @Override
    public void sort(Storage storage, Comparator<Contract> comparator) {
        int gap = storage.getStorage().length / 2;
        while (gap >= 1) {
            for (int right = 0; right < storage.getStorage().length; right++) {
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (storage.getStorage()[c] != null && storage.getStorage()[c + gap] != null) {
                        if (comparator.compare(storage.getStorage()[c], storage.getStorage()[c + gap]) > 0) {
                            Contract temp = storage.getStorage()[c + gap];
                            storage.getStorage()[c + gap] = storage.getStorage()[c];
                            storage.getStorage()[c] = temp;
                        }
                    }
                }
            }
            gap = gap / 2;
        }
    }
}
