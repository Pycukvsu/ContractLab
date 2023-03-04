package com.company.ñonracts;

import com.company.entities.Human;
import java.time.LocalDate;

public class ContractDigitalTV extends Contract {

    private ChannelPackage channelPackage;

    public ChannelPackage getChannelPackage() {
        return channelPackage;
    }

    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

    public ContractDigitalTV(int id, LocalDate startDate, LocalDate endDate, int numberContract, Human contractOwner, ChannelPackage channelPackage) {
        super(id, startDate, endDate, numberContract, contractOwner);
        this.channelPackage = channelPackage;
    }

    public ContractDigitalTV(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return  "ContractDigitalTV{" +
                "id=" + getId() +
                ", startDate='" + getStartDate() + '\'' +
                ", endDate='" + getEndDate() + '\'' +
                ", numberContract='" + getNumberContract() + '\'' +
                ", contractOwner='" + getContractOwner() + '\'' +
                "channelPackage=" + channelPackage +
                '}';
    }
}
