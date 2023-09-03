package csc1035.project3;

import Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Scanner;

public class updateStock {
    /**
     * Allows the user to update the quantity of an item. They are asked for the id of the item and the new quantity.
     * The item is then found, it's quantity is updated and the changes are committed. Finally, the session is closed.
     * @param args
     */

    public static void main(String[] args) {



        Scanner scan = new Scanner(System.in);
        System.out.println("Enter id");
        String id = scan.nextLine();
        int i = Integer.parseInt(id);



        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            itemsClass car = session.get(itemsClass.class, i);

            System.out.println("Enter new quantity");
            String stock = scan.nextLine();
            int ed = Integer.parseInt(stock);
            car.setStock(ed);
            session.update(car);
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
