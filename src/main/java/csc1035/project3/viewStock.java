package csc1035.project3;

import Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class viewStock {
    /**
     * Allows the user to view a list of all the stock with their name, id and quantity.
     * @param args
     */

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<itemsClass> items = session.createQuery("FROM Items").list();
            for (itemsClass item : items) {
                System.out.println("The stock for " + item.getName() +", id: " + item.getId()+ ", "+ " is: " +
                        item.getStock());

            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session!=null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
