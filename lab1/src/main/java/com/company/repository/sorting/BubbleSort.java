package com.company.repository.sorting;

import com.company.repository.Storage;
import com.company.сonracts.Contract;

import java.util.Comparator;

/**
 * Реализация сортировки пузырьком.
 * @autor Хачетлов Руслан
 */
public class BubbleSort implements ISorted {

    /**
     * Метод проверяет, есть ли уже в хранилище контракт с таким же айди
     *
     * @param storage - хранилище
     * @param comparator класс-«сравниватель»
     */
    @Override
    public void sort(Storage storage, Comparator<Contract> comparator) {
        for (int i = 0; i < storage.getStorage().length - 1; i++) {
            for (int j = 0; j < storage.getStorage().length - i - 1; j++) {
                if (storage.getStorage()[j + 1] != null) {
                    if (comparator.compare(storage.getStorage()[j + 1], storage.getStorage()[j]) < 0) {
                        Contract temp = storage.getStorage()[j + 1];
                        storage.getStorage()[j + 1] = storage.getStorage()[j];
                        storage.getStorage()[j] = temp;

                    }
                }
            }
        }
    }
}
