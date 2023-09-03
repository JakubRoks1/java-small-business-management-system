package csc1035.project3;

import Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Scanner;




public class deleteStock {
    /**
     * The main method of this file asks the user to input the id of the item that they want to remove.
     * A session is opened, a transaction is begun and the item with that id is then located in the database and removed.
     * Next the changes are committed and the session is closed.
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); //generate
        System.out.println("Enter id of item to be deleted");
        String id = scan.nextLine();
        int i = Integer.parseInt(id);



        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            itemsClass del = session.get(itemsClass.class, i);
            session.delete(del);
            session.getTransaction().commit();
        } catch (
                HibernateException e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
