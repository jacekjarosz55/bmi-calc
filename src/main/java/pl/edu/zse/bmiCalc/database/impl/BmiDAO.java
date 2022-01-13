package pl.edu.zse.bmiCalc.database.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.zse.bmiCalc.database.IBmiDAO;
import pl.edu.zse.bmiCalc.model.Bmi;
import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;

@Repository
public class BmiDAO implements IBmiDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<Bmi> getBmiById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Bmi> query = session.createQuery("FROM pl.edu.zse.bmiCalc.model.Bmi WHERE id = :id");
        query.setParameter("id",id);
        try {
            Bmi bmi = query.getSingleResult();
            session.close();
            return Optional.of(bmi);
        } catch (NoResultException e) {
            session.close();
            return Optional.empty();
        }
    }
    
    @Override
    public List<Bmi> getAllBmi() {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM pl.edu.zse.bmiCalc.model.Bmi";

        List<Bmi> list = session.createQuery(hql).getResultList();
        session.close();
        return list;
    }
    @Override
    public void addBmi(Bmi bmi) {
        Transaction tx = null;
        try { 
            Session session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(bmi);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        }
    }
}

