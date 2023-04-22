package org.example.dao.daoImpl;

import org.example.configuration.Config;
import org.example.dao.ServiceDaoEmployee;
import org.example.model.Employee;
import org.example.model.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceDaoEmployeeImpl implements ServiceDaoEmployee {
    @Override
    public void createEmployee() {
        String sql = "create table employees(" +
                "id serial primary key," +
                "first_name varchar," +
                "last_name varchar," +
                "age int ," +
                "email varchar," +
                "job_id int references jobs(id));";
        try(Connection connection = Config.connectionToDataBase();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully created!");
        } catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = " insert into employees (first_name,last_name,age,email,job_id)" +
                "values (?,?,?,?,?);";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,employee.getFirstName());
            statement.setString(2,employee.getLastName());
            statement.setInt(3,employee.getAge());
            statement.setString(4,employee.getEmail());
            statement.setLong(5,employee.getJobId());
            statement.executeUpdate();
            System.out.println(" Successfully added!");
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dropTable() {
        String sql = "drop table employees;";
        try(Connection connection = Config.connectionToDataBase();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully dropped!");
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void cleanTable() {
        String sql = "delete from employees;";
        try(Connection connection = Config.connectionToDataBase();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully cleaned!");
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
            String sql = " update employees set first_name = ?, last_name = ?," +
                    "age = ?, email = ?, job_id = ? where id = ?;";
            try(Connection connection = Config.connectionToDataBase();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString (1,employee.getFirstName());
                statement.setString(2,employee.getLastName());
                statement.setInt(3,employee.getAge());
                statement.setString (4,employee.getEmail());
                statement.setLong(5,employee.getJobId());
                statement.setLong(6,id);
                statement.executeUpdate();
                System.out.println("Successfully updated...");
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee>employees = new ArrayList<>();
        String sql = " select * from employees ;";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet result = statement.executeQuery();
            while(result.next()){
                employees.add(new Employee(
                        result.getLong("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getInt("age"),
                        result.getString("email"),
                        result.getLong("job_id")
                ));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }

    @Override
    public Employee findByEmail(String email) {
        Employee employee = null;
        String sql = "select * from employees where email in (?);";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,email);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                employee = new Employee(
                        result.getLong("id"),
                        result.getString ("first_name"),
                        result.getString("last_name"),
                        result.getInt("age"),
                        result.getString("email"),
                        result.getLong("job_id")
                );
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }
        return employee;
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        Map<Employee,Job> employeeJobMap = new HashMap<>();
        String sql = "select * from employees  join jobs j on employees.job_id = j.id where employees.id = ?;";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,employeeId);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                employeeJobMap.put(new Employee( result.getLong("id"),
                                result.getString ("first_name"),
                                result.getString("last_name"),
                                result.getInt("age"),
                                result.getString("email"),
                                result.getLong("job_id")),
                        new Job(result.getLong("id"),
                                result.getString("position"),
                                result.getString("profession"),
                                result.getString("description"),
                                result.getInt("experience"))
                        );
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return employeeJobMap;
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        List<Employee>employees = new ArrayList<>();
        String sql = "select * from employees join jobs j on employees.job_id = j.id where j.position in (?);";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString( 1,position);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                employees.add(new Employee(
                        result.getLong("id"),
                        result.getString ("first_name"),
                        result.getString("last_name"),
                        result.getInt("age"),
                        result.getString("email"),
                        result.getLong("job_id")
                ));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }
}
