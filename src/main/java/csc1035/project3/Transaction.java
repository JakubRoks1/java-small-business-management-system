package csc1035.project3;
import Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a order which has an id, name, quantity and price.
 */
public class Transaction {
    private int idi;
    private int quant;
    private String namo;
    private double price;

    /**
     * Allows setting the orders id.
     * @param idi The orders id.
     */

    public void setIdi(int idi) {
        this.idi = idi;
    }

    /**
     * Allows setting the orders quantity.
     * @param quant The quantity of an order.
     */
    public void setQuant(int quant) {
        this.quant = quant;
    }

    /**
     * Allows returning the orders name.
     * @return The orders name.
     */
    public String getNamo() {
        return namo;
    }

    /**
     * Allows setting the orders name.
     * @param namo The orders name.
     */
    public void setNamo(String namo) {
        this.namo = namo;
    }

    /**
     * Creates an instance of an order with an id, name, quantity and price.
     * @param idi The orders id.
     * @param quant The orders quantity.
     * @param price The orders price.
     * @param namo The orders name.
     */
    public Transaction(int idi, int quant, double price, String namo) {
        this.idi = idi;
        this.quant = quant;
        this.price = price;
        this.namo=namo;
    }

    /**
     * Allows returning the orders id.
     * @return Returns the orders id.
     */
    public int getIdi() {
        return idi;
    }

    /**
     * Allows returning the orders quantity.
     * @return Returns the orders quantity.
     */
    public int getQuant() {
        return quant;
    }

    /**
     * Allows returning the orders price.
     * @return Returns the orders price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Allows setting the orders price.
     * @param price The orders price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * When a transaction is created an empty list is created. This list will be used to store items purchased by one
     * customer in one order. It then asks the user what they would like to do. Upon clicking 1 the user will have the
     * to add items to the order. They will be asked for the items id and the quantity. Next they can either keep adding
     * items to the order by choosing 1, complete the transaction, by printing a receipt with the total and change
     * depending on the cash they were given, by choosing 2 or cancel the transaction by choosing 3.
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Transaction> orders = new ArrayList<>();
        boolean stop = false;
        while (!stop) {


        HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<itemsClass> items = session.createQuery("FROM Items").list();
        Scanner scan = new Scanner(System.in);

            System.out.println("What would you like to do?");
            System.out.println("1 - Add to order");
            System.out.println("2 - Complete transaction");
            System.out.println("3 - Cancel the order");

            String id = scan.nextLine();
            int i = Integer.parseInt(id);
            switch (i) {
                case 1:
                    Scanner scanId = new Scanner(System.in);
                    System.out.println("Enter id");
                    String id1 = scanId.nextLine();
                    int iD = Integer.parseInt(id1);
                    for (itemsClass item : items) {
                        if (iD == item.getId()) {
                            Scanner scan1 = new Scanner(System.in);
                            System.out.println("Enter quantity");
                            String quantity = scan1.nextLine();
                            int q = Integer.parseInt(quantity);
                            if (q<item.getStock()){
                                double prrrice = q * item.getSell_price();
                                String namooo = item.getName();
                                Transaction order = new Transaction(iD, q, prrrice, namooo);
                                orders.add(order);
                                System.out.println(orders.size());
                                for (Transaction e : orders) {
                                    System.out.println(e.toString());
                                }

                                int a = item.getStock() - q;
                                item.setStock(a);
//                        System.out.println(item.getStock());
//                        System.out.println(order.getIdi());
//                        System.out.println(order.getQuant());
//                        System.out.println(order.getPrice());
                                session.update(item);
                                session.getTransaction().commit();

                            }
                            else {
                                System.out.println("There is not enough of that item in the stock.");
                                stop = true;
                            }


                        }


                    }
                    break;
                case 2:
                    double sum = 0;
                    for (Transaction e  : orders)
                        sum = sum + e.price;
//                    System.out.println(sum);
                    Scanner scanMoney = new Scanner(System.in);
                    System.out.println("Enter cash given");
                    String money = scanMoney.nextLine();
                    double cash = Double.parseDouble(money);
                    double change = cash - sum;
//                    System.out.println("Change: " + change);




                    String centreAlignFormat = "| %-15s | %-12s | %-11s | %n";
                    String leftAlignFormat = "| %55s | %n";
                    System.out.format("+---------------------------------------------------------+%n");
                    System.out.format("|                     Tricky Trinkets                     |%n");
                    System.out.format("+----------------------------+--------------+-------------+%n");
                    System.out.format("|            Name            |   Quantity   |    Price    |%n");
                    System.out.format("+----------------------------+--------------+-------------+%n");
                    for (Transaction e : orders) {
                        System.out.format(centreAlignFormat, e.getNamo(), e.getQuant(), e.getPrice());
                    }
                    System.out.format("+----------------------------+--------------+-------------+%n");
                    System.out.format(leftAlignFormat, "Total: " + sum);
                    System.out.format("+---------------------------------------------------------+%n");
                    System.out.format(leftAlignFormat, "Cash: " + cash);
                    System.out.format("+---------------------------------------------------------+%n");
                    System.out.format(leftAlignFormat, "Change: " + change);
                    System.out.format("+---------------------------------------------------------+%n");
                    System.out.println("Transaction completed");

                case 3: {
                    System.out.println("Exiting the program");
                    stop = true;
                    session.close();
                    break;}





            }

            }
    }
}