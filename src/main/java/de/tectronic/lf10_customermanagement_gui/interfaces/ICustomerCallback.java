package de.tectronic.lf10_customermanagement_gui.interfaces;

import de.oszimt.lf10aContractMgmt.model.Customer;

public interface ICustomerCallback {
    void onChange(Customer customer);
}
