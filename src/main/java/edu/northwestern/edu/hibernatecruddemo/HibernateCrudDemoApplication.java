package edu.northwestern.edu.hibernatecruddemo;

import edu.northwestern.edu.hibernatecruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HibernateCrudDemoApplication {

    public static void main(String[] args) {

        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try{

            //Create an Employee object
            Employee newEmployee1 = new Employee("Petyr", "Baelish", "Chain Co.");
            Employee newEmployee2 = new Employee("Jon", "Snow", "North Wall Co.");
            Employee newEmployee3 = new Employee("Sansa", "Stark", "North Queen Co.");
            Employee newEmployee4 = new Employee("Aarya", "Stark", "No Face Co.");
            Employee newEmployee5 = new Employee("Samwell", "Tarley", "North Wall Co.");
            Employee newEmployee6 = new Employee("Daenarys", "Targaryan", "Dragon Mother Co.");

            //Start a transaction
            session.beginTransaction();

            //Save the Employee object
            session.save(newEmployee1);
            session.save(newEmployee2);
            session.save(newEmployee3);
            session.save(newEmployee4);
            session.save(newEmployee5);
            session.save(newEmployee6);

            //Commit the transaction
            session.getTransaction().commit();

            //Create session
            session = factory.getCurrentSession();

            //Start a transaction
            session.beginTransaction();

            //Read an object from the database
            Employee retrievedEmployee = session.get(Employee.class, 1);
            System.out.println("Retrieved Employee: " + retrievedEmployee);

            //Commit the transaction
            session.getTransaction().commit();

            //Create session
            session = factory.getCurrentSession();

            //Start a transaction
            session.beginTransaction();

            List<Employee> employeesToRead = session
                    .createQuery("from Employee where lastName LIKE '%Stark%'")
                    .getResultList();

            System.out.println("Employees with last name Stark: ");

            for(Employee el: employeesToRead){
                System.out.println(el);
            }

            //Commit the transaction
            session.getTransaction().commit();

            //Create session
            session = factory.getCurrentSession();

            //Start a transaction
            session.beginTransaction();

            //Update employee with ID 2
            Employee employeeToUpdate = session.get(Employee.class, 2);
            employeeToUpdate.setFirstName("Rhaegar");
            employeeToUpdate.setLastName("Targaryan");

            //Commit the transaction
            session.getTransaction().commit();

            //Create session
            session = factory.getCurrentSession();

            //Start a transaction
            session.beginTransaction();

            //Delete employee
            Employee employeeToDelete = session.get(Employee.class, 1);
            session.delete(employeeToDelete);

            //Commit the transaction
            session.getTransaction().commit();

        }finally {

            factory.close();

        }

    }

}
