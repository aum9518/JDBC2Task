package org.example.dao.daoImpl;

import org.example.configuration.Config;
import org.example.dao.ServiceDaoJob;
import org.example.model.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoJobImpl implements ServiceDaoJob {
    @Override
    public void createJobTable() {
        String sql = "create table jobs (" +
                "id serial primary key," +
                "position varchar," +
                "profession varchar," +
                "description varchar," +
                "experience int );";
        try(Connection connection = Config.connectionToDataBase();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully created!");
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addJob(Job job) {
        String sql = "insert into jobs (position,profession, description,experience)" +
                "values(?,?,?,?);";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, job.getPosition());
            statement.setString(2,job.getProfession());
            statement.setString (3,job.getDescription());
            statement.setInt(4,job.getExperiences());
            statement.executeUpdate();
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Job getJobById(Long jobId) {
        Job job = null;
        String sql = " select * from jobs where id = ?;";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,jobId);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                job =  new Job(result.getLong("id"),
                        result.getString("position"),
                        result.getString("profession"),
                        result.getString("description"),
                        result.getInt("experience"));
            }

        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }
        return job;
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        List<Job> jobs = new ArrayList<>();
        String sql = " select * from jobs order by experience "+ascOrDesc ;
        try (Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
//            statement.setString(1,ascOrDesc);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                jobs.add(new Job(result.getLong("id"),
                        result.getString("position"),
                        result.getString("profession"),
                        result.getString("description"),
                        result.getInt("experience")));
            }
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }
        return jobs;
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        Job job = null;
        String sql = "select * from jobs join employees e on jobs.id = e.job_id where e.job_id = ?;";
        try(Connection connection = Config.connectionToDataBase();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,employeeId);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                job = new Job(
                        result.getLong("id"),
                        result.getString("position"),
                        result.getString("profession"),
                        result.getString("description"),
                        result.getInt("experience")
                );
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return job;
    }

    @Override
    public void deleteDescriptionColumn() {
        String sql = "alter table jobs drop column description;";
        try(Connection connection = Config.connectionToDataBase();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Successfully deleted...");
        }catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }
}
