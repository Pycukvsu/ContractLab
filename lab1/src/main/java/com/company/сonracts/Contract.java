package com.company.�onracts;

import com.company.entities.Human;
import java.time.LocalDate;


/**
 * ����� �������� � ������ <b>id</b>, <b>startDate</b>, <b>endDate</b>, <b>numberContract</b> � <b>contractOwner</b>.
 * @autor �������� ������
 */
public class Contract {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int numberContract;
    private Human contractOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public Human getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(Human contractOwner) {
        this.contractOwner = contractOwner;
    }

    public Contract(int id) {
        this.id = id;
    }

    public Contract(int id, LocalDate startDate, LocalDate endDate, int numberContract, Human contractOwner) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberContract = numberContract;
        this.contractOwner = contractOwner;
    }

    public Contract() {
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", numberContract='" + numberContract + '\'' +
                ", contractOwner='" + contractOwner + '\'' +
                '}';
    }
}
