package org.example.dao;


import org.example.models.*;
import org.example.util.PropertiesReader;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class CityDao {

    private Connection connection;
    public CityDao() throws IOException, SQLException {
        Properties properties = PropertiesReader.getProperties("config.properties");
        String jdbcURL = properties.getProperty("jdbcURL");
        String username = properties.getProperty("username");
        String passwd = properties.getProperty("passwd");

        this.connection = DriverManager.getConnection(jdbcURL, username, passwd);
    }
    public City findById(long id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    public void save(City city){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.getTransaction();
        tx1.begin();
        session.save(city);
        tx1.commit();
        session.close();
    }

    public void update(City city){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.getTransaction();
        tx1.begin();
        session.update(city);
        tx1.commit();
        session.close();
    }

    public void delete(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        tx1.begin();
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

    // тестирование того, как работают запросы
    public List<City> zpr(String name){
        String st = "from City where name = " + name;
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from City where name = :cityName");
        query.setParameter("cityName", name);
        return query.list();
    }

    // метод, создающий индексы
    public void createIndex() throws SQLException {
        PreparedStatement preparedStatement = this.connection.prepareStatement("CREATE INDEX new_index ON city(id)");
        preparedStatement.executeUpdate();
        preparedStatement = this.connection.prepareStatement("CREATE INDEX climate_ind ON city(climate);");
        preparedStatement.executeUpdate();
        preparedStatement = this.connection.prepareStatement("CREATE INDEX government_ind ON city(government);");
        preparedStatement.executeUpdate();
        preparedStatement = this.connection.prepareStatement("CREATE INDEX standard_ind ON city(standard_of_living);");
        preparedStatement.executeUpdate();
    }

    // метод, вызывающий лайтовый SELECT
    public void goodSelection() throws SQLException {
        PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM city;");
        preparedStatement.executeQuery();
    }


    // метод, вызывающий сложный SELECT
    public void goodGoodSelection() throws SQLException {
        PreparedStatement preparedStatement = this.connection.prepareStatement("\n" +
                "\n" +
                "SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM (SELECT * FROM city WHERE id > 0 AND climate > 0 AND government > 0) WHERE id > 0 AND climate > 0 AND government > 0) WHERE id > 0 AND standard_of_living > 0) WHERE id > 0 AND governor > 0) WHERE id > 0)) WHERE id > 0 AND climate > 0 AND government > 0) WHERE id > 0 AND climate > 0 AND government > 0) WHERE id > 0) WHERE id > 0) WHERE id > 0);\n\n");
        preparedStatement.executeQuery();
    }
}
