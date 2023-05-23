package de.tectronic.lf10_customermanagement_gui.interfaces;

import de.oszimt.lf10aContractMgmt.model.Employee;

public interface IEmployeeCallback {
    void onChange(Employee employee);
}
