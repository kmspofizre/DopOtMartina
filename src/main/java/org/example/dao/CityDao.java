package org.example.dao;


import org.example.models.*;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CityDao {
    public City findById(long id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    public void save(City city){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.getTransaction();
        session.save(city);
        tx1.commit();
        session.close();
    }

    public void update(City city){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.getTransaction();
        session.update(city);
        tx1.commit();
        session.close();
    }

    public void delete(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(city);
        tx1.commit();
        session.close();
    }

    public List<City> findAll() {
        List<City> cities = (List<City>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From City").list();
        return cities;
    }

    public Human findHumanById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Human.class, id);
    }

    public Coordinate findCoordinatesById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Coordinate.class, id);
    }

    public StandardOfLiving findStandardOfLivingById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(StandardOfLiving.class, id);
    }

    public Government findGovernmentById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Government.class, id);
    }

    public Climate findClimateById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Climate.class, id);
    }

    public User findUserById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }
    public List<City> zpr(String name){
        String st = "from City where name = " + name;
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from City where name = :cityName");
        query.setParameter("cityName", name);
        return query.list();
    }
}
