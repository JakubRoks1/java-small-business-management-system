package csc1035.project3;

import Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu {
    /**
     * The main method of this class opens the console and presents the user with seven options. It allows them to
     * quickly navigate through the programme and choose what they would like to do. Depending on which digit they
     * input the chosen action will be carried out.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1 - Add a new item to stock");
        System.out.println("2 - Delete an item from stock");
        System.out.println("3 - Begin a transaction");
        System.out.println("4 - Update the cost of an item");
        System.out.println("5 - Update the sell price of an item");
        System.out.println("6 - Update the quantity of an item");
        System.out.println("7 - View all stock");
        String option = scan.nextLine();
        int i = Integer.parseInt(option);

        switch(i){

            case 1: newItem.main(args);
                break;

            case 2: deleteStock.main(args);
                break;

            case 3: Transaction.main(args);
                break;

            case 4: updateCost.main(args);
                break;

            case 5: updateSellPrice.main(args);
                break;

            case 6: updateStock.main(args);
                break;

            case 7: viewStock.main(args);
                break;
        }

    }
}
