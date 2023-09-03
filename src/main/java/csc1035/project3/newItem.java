package csc1035.project3;

import Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Scanner;


public class newItem {
    /**
     * This method allows the user to add a new item to the stock via the console. A session is opened, transaction is
     * begun and the user is asked to provide the name, category, sell price, cost, quantity and if it is perishable.
     * A new instance of an item is then created and the following data is assigned to it. All changes are then saved,
     * committed and the session is closed.
     * @param args
     */

    public static void main(String[] args) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Name:");
            String name = scan.nextLine();
            System.out.println("Enter Category:");
            String category = scan.nextLine();
            System.out.println("Enter Sell_Price:");
            String sell_price = scan.nextLine();
            Double sp = Double.parseDouble(sell_price);
            System.out.println("Enter Cost:");
            String cost = scan.nextLine();
            Double c = Double.parseDouble(cost);
            System.out.println("Enter Stock:");
            String stock = scan.nextLine();
            Integer s = Integer.parseInt(stock);
            System.out.println("Is It Perishable (true/false):");
            String perishable = scan.nextLine();
            boolean p = Boolean.parseBoolean(perishable);

            itemsClass i1 = new itemsClass(name,category,p,c,s,sp);

            session.save(i1);
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
