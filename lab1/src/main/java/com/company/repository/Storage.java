package com.company.repository;

import com.company.�onracts.Contract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * ����� ���������
 *
 * @autor �������� ������
 */

public class Storage {
    private Contract[] storage = new Contract[10];
    private int numberOfContracts = 0;


    /**
     * ����� ���������� ���������
     * ������ ����� ������ ����� ������ � ������� ����������� ��� ���������, ����� null-��.
     * ��������� ����������� � 4 ���� (����� �������� ������� �������������� �������)
     */
    private void expandStorage() {
        Contract[] newStorage = new Contract[storage.length];
        int j = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                newStorage[j] = storage[i];
                j++;
            } else numberOfContracts--;
        }

        storage = new Contract[storage.length * 4];
        System.arraycopy(newStorage, 0, storage, 0, newStorage.length);
    }


    /**
     * ����� ���������, ���� �� ��� � ��������� �������� � ����� �� ����
     *
     * @param id - ���� ���������
     * @return flag - ���������� true ���� ������ �������� ��� � ��������� | false - ���� ����
     */
    private boolean isContractIdInStorage(int id) {
        boolean flag = true;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getId() == id) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * ����� �� ���������� ��������� � ���������.
     * ����� �������� �������� �� ���������� ��������� � ����� ���� � ���������.
     * ���� ���������� ��������� � ������� ����� ����� �������, �� �������� ����� �� ���������� ���������.
     *
     * @param contract - ��������
     */
    public void addContract(Contract contract) {
        if (isContractIdInStorage(contract.getId())) {
            if (numberOfContracts == storage.length) {
                expandStorage();
                storage[numberOfContracts] = contract;
            } else {
                storage[numberOfContracts] = contract;
            }
            numberOfContracts++;
        } else System.out.println("�������� � ����� id ��� ���� � ���������");
    }

    /**
     * ����� �������� ��������� �� ����.
     *
     * @param id - ���� ���������
     */
    public void deleteContractById(int id) {
        boolean flag = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getId() == id) {
                    storage[i] = null;
                    System.out.println("�������� ������� �����");
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("��������� � ����� id ���� � ���������");
        }
    }

    /**
     * ����� ��������� ��������� �� ����.
     *
     * @param id - ���� ���������
     */
    public void getContractById(int id) {
        boolean flag = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getId() == id) {
                    System.out.println(storage[i]);
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("��������� � ����� id ��� � ���������");
        }
    }

    /**
     * ����� ���� ��������� ���������.
     */
    public void viewAllContracts() {
        System.out.println("���������: ");
        System.out.println();
        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println((i + 1) + ". " + storage[i]);
        }
        System.out.println();
        System.out.println("������ ���������: " + storage.length);
        System.out.println();
    }

    public <T> List<Contract> find(Predicate<T> condition) {
        List<Contract> contracts = new ArrayList<>();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && condition.test((T) storage[i])) {
                contracts.add(storage[i]);
            }
        }

        System.out.println("���������� ������: ");

        if (contracts.isEmpty()) {
            System.out.println("��������� ������ �����");
        }else {
            Iterator<Contract> it = contracts.listIterator();
            Contract contract;
            while (it.hasNext()) {
                contract = it.next();
                System.out.println(contract);
            }
        }
        System.out.println();
        return contracts;
    }

    public Contract[] getStorage() {
        return storage;
    }

    public void removeNull(){
        for (int i = 0; i < numberOfContracts; i++) {
            if (storage[i] == null){
                storage[i] = storage[numberOfContracts-1];
            }
        }
    }
}
