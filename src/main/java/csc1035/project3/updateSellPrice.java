package csc1035.project3;

import Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Scanner;

public class updateSellPrice {
    /**
     * Allows the user to update the sell price of an item. They are asked for the id of the item and the new price.
     * The item is then found, it's price is updated and the changes are committed. Finally, the session is closed.
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

            System.out.println("Enter new sell price:");
            String sellPrice = scan.nextLine();
            Double ed = Double.parseDouble(sellPrice);
            car.setSell_price(ed);
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
