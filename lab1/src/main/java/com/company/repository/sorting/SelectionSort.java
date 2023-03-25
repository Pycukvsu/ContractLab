package com.company.repository.sorting;

import com.company.repository.Storage;
import com.company.�onracts.Contract;

import java.util.Comparator;

/**
 * ���������� ���������� �������.
 * @autor �������� ������
 */
public class SelectionSort implements ISorted {

    /**
     * ����� ���������, ���� �� ��� � ��������� �������� � ����� �� ����
     *
     * @param storage - ���������
     * @param comparator �����-��������������
     */
    @Override
    public void sort(Storage storage, Comparator<Contract> comparator) {
        for (int i = 0; i < storage.getStorage().length; i++) {
            int pos = i;
            Contract min = storage.getStorage()[i];
            //���� ������ ����������� ��������
            for (int j = i + 1; j < storage.getStorage().length; j++) {
                if (storage.getStorage()[j] != null) {
                    if (comparator.compare(storage.getStorage()[j], min) < 0) {
                        //pos - ������ ����������� ��������
                        pos = j;
                        min = storage.getStorage()[j];
                    }
                }
            }
            storage.getStorage()[pos] = storage.getStorage()[i];
            //������ ������� ���������� � sortArr[i]
            storage.getStorage()[i] = min;
        }
    }
}
