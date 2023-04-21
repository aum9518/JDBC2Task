package org.example.service.serviceImpl;

import org.example.dao.daoImpl.ServiceDaoJobImpl;
import org.example.model.Job;
import org.example.service.ServiceJob;

import java.util.List;

public class ServiceJobImpl implements ServiceJob {
    ServiceDaoJobImpl job1 = new ServiceDaoJobImpl();
    @Override
    public void createJobTable() {
        job1.createJobTable();
    }

    @Override
    public void addJob(Job job) {
        job1.addJob(job);
    }

    @Override
    public Job getJobById(Long jobId) {
        return job1.getJobById(jobId);
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        return job1.sortByExperience(ascOrDesc);
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        return job1.getJobByEmployeeId(employeeId);
    }

    @Override
    public void deleteDescriptionColumn() {
        job1.deleteDescriptionColumn();
    }
}
