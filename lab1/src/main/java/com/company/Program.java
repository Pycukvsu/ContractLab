package com.company;

import com.company.entities.Gender;
import com.company.entities.Human;
import com.company.repository.Storage;
import com.company.repository.comparators.MaxIdContractComparator;
import com.company.repository.sorting.BubbleSort;
import com.company.repository.sorting.ISorted;
import com.company.сonracts.*;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Program {

    public static void main(String[] args) {
        // write your code here
    }

    /**
     * Тест для проверки расширения хранилища
     */
    @Test
    public void storageExpansionTest(){
        Storage storage = new Storage();
        for (int i = 0; i < 15; i++) {
            storage.addContract(new Contract());
        }
        storage.viewAllContracts();
    }

    /**
     * Тест для удаления контрактов по айди
     */
    @Test
    public void deletionTest(){
        Storage storage = new Storage();

        storage.addContract(new ContractDigitalTV(123));
        storage.addContract(new ContractMobileCom(111));
        storage.addContract(new ContractWiredInternet(101));
        storage.addContract(new ContractWiredInternet(200));
        storage.addContract(new ContractDigitalTV(300));
        storage.addContract(new ContractDigitalTV(401));
        storage.addContract(new ContractMobileCom(56));
        storage.addContract(new ContractWiredInternet(700));

        storage.viewAllContracts();

        storage.deleteContractById(111);
        storage.deleteContractById(401);
        storage.deleteContractById(200);
        storage.deleteContractById(1000);

        storage.viewAllContracts();

        storage.addContract(new ContractWiredInternet(107));
        storage.addContract(new ContractDigitalTV(30));
        storage.addContract(new ContractWiredInternet(108));
        storage.viewAllContracts();
    }

    /**
     * Тест получения контрактов по айди
     */
    @Test
    public void gettingByIdTest(){
        Storage storage = new Storage();

        storage.addContract(new ContractDigitalTV(123));
        storage.addContract(new ContractMobileCom(111));
        storage.addContract(new ContractWiredInternet(101));
        storage.addContract(new ContractWiredInternet(200));
        storage.addContract(new ContractDigitalTV(300));
        storage.addContract(new ContractDigitalTV(401));
        storage.addContract(new ContractMobileCom(56));
        storage.addContract(new ContractWiredInternet(700));

        storage.viewAllContracts();

        storage.getContractById(111);
        storage.getContractById(200);
        storage.getContractById(300);
        storage.getContractById(1000);

        System.out.println();

        ISorted bubble = new BubbleSort();
        bubble.sort(storage.getStorage(), new MaxIdContractComparator());

        storage.viewAllContracts();

    }

    /**
     * Тест всего функционала
     */
    @Test
    public void testAllFunctionality(){
        Storage storage = new Storage();

        Human human = new Human(69,
                "Иванов Иван Иванович",
                LocalDate.of(1980, 10,10),
                Gender.MALE,
                "1414 555555",
                32);

        storage.addContract(new ContractWiredInternet(155,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2024, 10, 10),
                1,
                human,
                15
        ));

        storage.addContract(new ContractMobileCom(100,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2023, 10, 10),
                2,
                human,
                1000,
                400,
                50
        ));

        storage.addContract(new ContractDigitalTV(112,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2025, 10, 10),
                3,
                human,
                ChannelPackage.PLUS
        ));

        storage.viewAllContracts();

        Human human2 = new Human(30,
                "Иванова Илона Ивановна",
                LocalDate.of(2000, 10,10),
                Gender.FEMALE,
                "1416 777777",
                22);

        storage.addContract(new ContractWiredInternet(200,
                LocalDate.of(2022, 10, 15),
                LocalDate.of(2024, 10, 10),
                4,
                human2,
                10
        ));

        storage.addContract(new ContractDigitalTV(205,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2026, 10, 10),
                5,
                human2,
                ChannelPackage.PREMIUM
        ));

        storage.addContract(new ContractMobileCom(210,
                LocalDate.of(2019, 9, 15),
                LocalDate.of(2023, 9, 10),
                6,
                human2,
                800,
                300,
                40
        ));

        storage.viewAllContracts();

        storage.getContractById(205);

        storage.deleteContractById(205);

        storage.viewAllContracts();
    }

    @Test
    public void  TestFindMethod(){
        Storage storage = new Storage();

        Human human = new Human(69,
                "Иванов Иван Иванович",
                LocalDate.of(1980, 10,10),
                Gender.MALE,
                "1414 555555",
                32);

        storage.addContract(new ContractWiredInternet(155,
                LocalDate.of(2020, 1, 15),
                LocalDate.of(2024, 10, 10),
                1,
                human,
                15
        ));

        storage.addContract(new ContractMobileCom(100,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2023, 10, 10),
                2,
                human,
                1000,
                400,
                50
        ));

        storage.addContract(new ContractDigitalTV(112,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2025, 10, 10),
                3,
                human,
                ChannelPackage.PLUS
        ));

        Human human2 = new Human(30,
                "Иванова Илона Ивановна",
                LocalDate.of(2000, 10,10),
                Gender.FEMALE,
                "1416 777777",
                22);

        storage.addContract(new ContractWiredInternet(200,
                LocalDate.of(2022, 10, 15),
                LocalDate.of(2024, 10, 10),
                4,
                human2,
                10
        ));

        storage.addContract(new ContractDigitalTV(205,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2026, 10, 10),
                5,
                human2,
                ChannelPackage.PREMIUM
        ));

        storage.addContract(new ContractMobileCom(210,
                LocalDate.of(2019, 9, 15),
                LocalDate.of(2023, 9, 10),
                6,
                human2,
                800,
                300,
                40
        ));

        // Поиск контракта по дате окончания (EndDate)
        System.out.println(1);
        Predicate<Contract> condition = field -> field.getEndDate().equals(LocalDate.of(2023, 9, 10));
        List<Contract> contracts = storage.find(condition);

        // Поиск контрактов после заданной даты (EndDate)
        System.out.println(2);
        Predicate<Contract> condition2 = field -> field.getEndDate().isAfter(LocalDate.of(2023, 9, 10));
        List<Contract> contracts2 = storage.find(condition2);

        // Поиск контракта по айди
        System.out.println(3);
        Predicate<Contract> condition3 = field -> field.getId() == 205;
        List<Contract> contracts3 = storage.find(condition3);

        // Поиск контракта по айди
        System.out.println(4);
        Predicate<Contract> condition4 = field -> field.getId() >= 200;
        List<Contract> contracts4 = storage.find(condition4);

        // Поиск контрактов по человеку
        System.out.println(5);
        Predicate<Contract> condition5 = field -> field.getContractOwner().equals(human);
        List<Contract> contracts5 = storage.find(condition5);
    }
}
