package org.example.service.serviceImpl;

import org.example.dao.daoImpl.ServiceDaoEmployeeImpl;
import org.example.model.Employee;
import org.example.model.Job;
import org.example.service.ServiceEmployee;

import java.util.List;
import java.util.Map;

public class ServiceEmployeeImpl implements ServiceEmployee {
    ServiceDaoEmployeeImpl employee1 = new ServiceDaoEmployeeImpl();
    @Override
    public void createEmployee() {
        employee1.createEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        employee1.addEmployee(employee);
    }

    @Override
    public void dropTable() {
        employee1.dropTable();
    }

    @Override
    public void cleanTable() {
        employee1.cleanTable();
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employee1.updateEmployee(id,employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employee1.getAllEmployees();
    }

    @Override
    public Employee findByEmail(String email) {
        return employee1.findByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return employee1.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return employee1.getEmployeeByPosition(position);
    }
}
