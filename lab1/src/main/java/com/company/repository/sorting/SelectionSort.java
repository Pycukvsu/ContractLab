package com.company.repository.sorting;

import com.company.repository.Storage;
import com.company.сonracts.Contract;

import java.util.Comparator;

/**
 * Реализация сортировки выбором.
 * @autor Хачетлов Руслан
 */
public class SelectionSort implements ISorted {

    /**
     * Метод проверяет, есть ли уже в хранилище контракт с таким же айди
     *
     * @param storage - хранилище
     * @param comparator класс-«сравниватель»
     */
    @Override
    public void sort(Storage storage, Comparator<Contract> comparator) {
        for (int i = 0; i < storage.getStorage().length; i++) {
            int pos = i;
            Contract min = storage.getStorage()[i];
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < storage.getStorage().length; j++) {
                if (storage.getStorage()[j] != null) {
                    if (comparator.compare(storage.getStorage()[j], min) < 0) {
                        //pos - индекс наименьшего элемента
                        pos = j;
                        min = storage.getStorage()[j];
                    }
                }
            }
            storage.getStorage()[pos] = storage.getStorage()[i];
            //меняем местами наименьший с sortArr[i]
            storage.getStorage()[i] = min;
        }
    }
}
