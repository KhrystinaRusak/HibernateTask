package student;
import student.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        HQLWithParametersSample();
    }

    public static void sample() {
        Student student = new Student();
        student.setId(1);
        student.setGroup(62492);
        student.setName("Artem");
        student.setSurname("Belyaev");
        student.setGroup_head(false);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction t = session.beginTransaction();

        Integer id = (Integer) session.save(student);

        t.commit();
    }

    public static void selectIdsample() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = session.load(Student.class, 1);
        System.out.println(student);
        System.out.println(student.getName());
    }

    public static void HQLListSample() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM Student");
        List<Student> students = query.getResultList();
        System.out.println(students);
        System.out.println(students.get(0).getName());
    }

    public static void HQLWithParametersSample() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM Student WHERE id = :idParam");
        query.setParameter("idParam", 127654);

        Student student = (Student) query.getSingleResult();
        System.out.println(student);
    }

    public static void HQLWithAggregateSample() {
        SessionFactory sessionFactory  =HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("SELECT MAX(Group) FROM Student");

        Integer maxGroup = (Integer) query.getSingleResult();
        System.out.println(maxGroup);
    }
}
