package org.example.dao.daoImpl;

import org.example.dao.ServiceDaoEmployee;
import org.example.model.Employee;
import org.example.model.Job;

import java.util.List;
import java.util.Map;

public class ServiceDaoEmployeeImpl implements ServiceDaoEmployee {
    @Override
    public void createEmployee() {

    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void dropTable() {

    }

    @Override
    public void cleanTable() {

    }

    @Override
    public void updateEmployee(Long id, Employee employee) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee findByEmail(String email) {
        return null;
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return null;
    }
}
