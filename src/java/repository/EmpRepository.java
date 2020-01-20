package repository;

import hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import model.Employees;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

//@Repository
public class EmpRepository {

    public void addEmployee(Employees employees) {
        Transaction trns = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            trns = session.beginTransaction();
            session.merge(employees);
            trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            // session.close();
        }
    }

    public List<Employees> getEmpList() {
        List<Employees> empList = new ArrayList<Employees>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Query query = session.createQuery("From Employees");

        empList = query.list();

        return empList;
    }

}
