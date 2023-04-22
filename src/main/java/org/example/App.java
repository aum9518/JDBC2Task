package org.example;

import org.example.configuration.Config;
import org.example.model.Employee;
import org.example.model.Job;
import org.example.service.serviceImpl.ServiceEmployeeImpl;
import org.example.service.serviceImpl.ServiceJobImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ServiceEmployeeImpl service = new ServiceEmployeeImpl();
        ServiceJobImpl job = new ServiceJobImpl();
       // job.createJobTable();
      //  job.addJob(new Job("Mentor","Java","Backend developer",2));
//          job.addJob(new Job("Management","JavaScript","Fronted developer",1));
//        System.out.println(job.getJobById(1L));
//        System.out.println(job.sortByExperience("desc"));
//        System.out.println(job.getJobByEmployeeId(1L));
//            job.deleteDescriptionColumn();


//         service.createEmployee();
//        service.addEmployee(new Employee("Manas","Abdugani uulu",27,"manas@gmail.com",1));
//        service.dropTable();
//        service.cleanTable();
//        service.updateEmployee(2L , new Employee("Ulan","Kubanychbekov",28,"ulan@gmail.com",1L));
//        System.out.println(service.getAllEmployees());
//        System.out.println(service.findByEmail("ulan@gmail.com"));
//        System.out.println(service.getEmployeeById(2L));
//        System.out.println(service.getEmployeeByPosition("Mentor"));


    }
}
