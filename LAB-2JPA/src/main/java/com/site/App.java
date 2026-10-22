package com.site;

import jakarta.persistence.*;

public class App {

    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("studentPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void createStudent(Student student) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }
    public static Student getStudentById(int id) {
        EntityManager em = getEntityManager();
        Student s = em.find(Student.class, id);
        em.close();
        return s;
    }
    public static void updateStudentName(String newName, int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student s = em.find(Student.class, id);
        s.setName(newName);
        em.getTransaction().commit();
        em.close();
    }
    public static void updateStudentNameAndTech(String newName, String newTech, int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student s = em.find(Student.class, id);
        s.setName(newName);
        s.setTech(newTech);
        em.getTransaction().commit();
        em.close();
    }
    public static void deleteStudentById(int id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Student s = em.find(Student.class, id);
        if (s != null) em.remove(s);
        em.getTransaction().commit();
        em.close();
    }

    public static void main(String[] args) {
        // create
       Student s = new Student();
       s.setName("Feven Tamene");
       s.setTech("Python");
       createStudent(s);

        // read
        System.out.println(getStudentById(1));

        // update
        updateStudentName("Redite", 1);
        
        updateStudentNameAndTech("Redite", "Java", 1);
        System.out.println(getStudentById(1));


        // delete
        deleteStudentById(1);
        System.out.println("After delete: " + getStudentById(s.getId()));
    }}
