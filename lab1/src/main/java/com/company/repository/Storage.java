package com.company.repository;

import com.company.сonracts.Contract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс хранилище
 *
 * @autor Хачетлов Руслан
 */

public class Storage {
    private Contract[] storage = new Contract[10];
    private int numberOfContracts = 0;


    /**
     * Метод расширение хранилища
     * Данный метод создаёт новый массив в который переносятся все контракты, кроме null-ов.
     * Хранилище расширяется в 4 раза (Чтобы избежать частого пересоздавания массива)
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
     * Метод проверяет, есть ли уже в хранилище контракт с таким же айди
     *
     * @param id - айди контракта
     * @return flag - возвращает true если такого элемента нет в хранилище | false - если есть
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
     * Метод по добавлению контракта в хранилище.
     * Метод вызывает проверку на нахождении контракта с таким айди в хранилище.
     * Если количество элементов в массиве равно длине массива, то вызываем метод по расширению хранилища.
     *
     * @param contract - контракт
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
        } else System.out.println("Контракт с таким id уже есть в хранилище");
    }

    /**
     * Метод удаления контракта по айди.
     *
     * @param id - афди контракта
     */
    public void deleteContractById(int id) {
        boolean flag = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getId() == id) {
                    storage[i] = null;
                    System.out.println("Контракт успешно удалён");
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Контракта с таким id нету в хранилище");
        }
    }

    /**
     * Метод получения контракта по айди.
     *
     * @param id - айди контракта
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
            System.out.println("Контракта с таким id нет в хранилище");
        }
    }

    /**
     * Вывод всех элементов хранилища.
     */
    public void viewAllContracts() {
        System.out.println("Хранилище: ");
        System.out.println();
        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println((i + 1) + ". " + storage[i]);
        }
        System.out.println();
        System.out.println("Размер хранилища: " + storage.length);
        System.out.println();
    }

    public <T> List<Contract> find(Predicate<T> condition) {
        List<Contract> contracts = new ArrayList<>();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && condition.test((T) storage[i])) {
                contracts.add(storage[i]);
            }
        }

        System.out.println("Результаты поиска: ");

        if (contracts.isEmpty()) {
            System.out.println("Неудалось ничего найти");
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
