//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Item[] store = setupStore();
        ArrayList<Item> cart = createCart(args, store);
        if (cart.size() > 0){
            printReciptInOrder(cart);
            emptyCartReverseOrder(cart);
        }
    }

    //sets up an array for store with 5 items
    public static Item[] setupStore() {
        Item[] store = new Item[5];

        store[0] = new Item("Soup", 1.5);
        store[1] = new Item("Cheese", 8.0);
        store[2] = new Item("Chicken", 3.0);
        store[3] = new Item("Juice", 3.5);
        store[4] = new Item("Butter", 2.5);

        return store;
    }

    //method receives String array for args and Item array for store and creates a cart based on the index from the command line, checks for exceptions and prints if so
    public static ArrayList<Item> createCart(String [] args, Item[] store) {
        ArrayList<Item> cart = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            try {
                int index = Integer.parseInt(arg);
                if (index >= 0 && index < store.length) {
                    cart.add(store[index]);
                } else {
                    System.out.println("The store does not have an item of index " + index + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("\"" + arg + "\" is not a valid integer.");
            }
        }

        if (cart.size() == 0){
            System.out.println("No valid Input to cart.");
        }

        return cart;
    }

    //method that receives an array list of a cart and prints out a receipt of things in the cart and the subtotal, tax, and total
    public static void printReciptInOrder(ArrayList<Item> cart){
        double subtotal = 0.0;
        System.out.println("Receipt");
        System.out.println("========================");
        System.out.println("Item         Price");
        for (int i = 0; i < cart.size(); i++){
            System.out.printf("%-12s %.2f%n", cart.get(i).getItemName(), cart.get(i).getItemPrice());
            subtotal += cart.get(i).getItemPrice();
        }
        System.out.println("========================");
        System.out.println("(a) Subtotal: " + subtotal);
        System.out.println("(b) Sales tax: 5%");
        double total = subtotal * 1.05;
        System.out.printf("(c) Total: %.2f\n", total);
    }

    //method that receives an array list of a cart and removes each Item and prints out when an item is removed
    public static void emptyCartReverseOrder(ArrayList<Item> cart){
        System.out.println("Removing all items in the cart from in \"Last in First Out\" order...");
        while (cart.size() > 0){
            System.out.println("Removing: " + cart.get(cart.size()-1).getItemName());
            cart.remove(cart.size()-1);
        }
        System.out.println("Cart has been emptied");
    }
}
