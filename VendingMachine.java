import java.util.Scanner;


enum ProductName {
    GUM,
    CHIPS,
    WATER,
    CANDY,
    POPROCKS,
    SODA
}


class Product {
    private ProductName category;
    private double price;
    private String expirationInfo;

    public Product(ProductName category, double price, String expirationInfo) {
        this.category = category;
        this.price = price;
        this.expirationInfo = expirationInfo;
    }

    public ProductName getName() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getExpirationInfo() {
        return expirationInfo;
    }
}


public class VendingMachine {
    private double totalAmount = 0.0;

    private Product[][][] products;
    Scanner scanner = new Scanner(System.in);
    public VendingMachine(int rows, int cols, int depths) {



        products = new Product[rows][cols][depths];



    }

    public void addProduct(int row, int col, int depth, ProductName category, double price, String expirationInfo) {
        if (row >= 0 && row < products.length && col >= 0 && col < products[0].length && depth >= 0 && depth < products[0][0].length) {
            products[row][col][depth] = new Product(category, price, expirationInfo);
        } else {
            System.out.println("Invalid location for adding a product.");
        }
    }
public Product getProduct(int row, int col, int depth){
        if(row >= 0 && row < products.length && col >= 0 && col < products[0].length && depth >= 0 && depth < products[0][0].length) {
            Product product = products[row][col][depth];
            if (product != null) {
                products[row][col][depth] = null;
                return product;
            } else {
                return null;
            }
        } else {
            return null;
        }
}

    public void displayProducts() {
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products[0].length; j++) {
                for (int k = 0; k < products[0][0].length; k++) {
                Product product = products[i][j][k];
                if (product == null) {
                    System.out.print("[Empty] ");
                } else {
                    System.out.print("[" + product.getName() + "] ");
                }
            }
            System.out.println();
        }
            System.out.println();
    }



    }

    public double acceptPayment(Product selectedProduct) {
        System.out.print("Insert coins (e.g., 1.00 for $1.00): $");
        double payment = scanner.nextDouble();


        while (payment < selectedProduct.getPrice()) {
            System.out.println("Insufficient payment. Please insert more coins.");
            System.out.print("Insert coins (e.g., 1.00 for $1.00): $");
            payment += scanner.nextDouble();
        }  {
            double change = payment - selectedProduct.getPrice();
            totalAmount += selectedProduct.getPrice();
            System.out.println("Dispensing " + selectedProduct.getName());
            return change;


        }
    }


    public int getUserChoice() {
        int choice = 0;
        while (true) {

            System.out.print("Enter the item number (1-" + products.length + ") or 0 to exit: ");
             choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice < 1 || choice > products.length) {
                System.out.println("Invalid choice. Please try again.");

            } else {
                Product selectedProduct = getSelectedProduct(choice) ;
                if (selectedProduct != null) {
                    System.out.println("You selected: " + selectedProduct.getName());
                    System.out.println("Price: " + selectedProduct.getPrice());
                    System.out.println("Exp: "+ selectedProduct.getExpirationInfo());
                    break;
                }

            }
        }
        return choice;
    }


    public Product getSelectedProduct(int choice) {
        int itemNumber = 1;
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products[0].length; j++) {
                for (int k = 0; k < products[0][0].length; k++) {
                    Product product = products[i][j][k];
                    if (product != null) {
                        if (itemNumber == choice) {
                            return product;
                        }
                        itemNumber++;

                    }
                }
            }
        }
        return null;
    }

    public void dispenseProduct(Product selectedProduct) {

    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(6, 6, 6);
        for (int col = 0; col < 6; col++) {
            for (int depth = 0; depth < 6; depth++){


        vendingMachine.addProduct(0,  0,0, ProductName.GUM, 1.00, "Good until 12/31/2023");
        vendingMachine.addProduct(1, 0, 0, ProductName.GUM, 1.00, "Good until 12/15/2023");
        vendingMachine.addProduct(2, 0, 0, ProductName.GUM, 1.00, "Good until 12/15/2023");
        vendingMachine.addProduct(3, 0, 0, ProductName.GUM, 1.00, "Good until 12/15/2023");
        vendingMachine.addProduct(4, 0, 0, ProductName.GUM, 1.00, "Good until 12/15/2023");
        vendingMachine.addProduct(5, 0, 0, ProductName.GUM, 1.00, "Good until 12/15/2023");

        vendingMachine.addProduct(0, 0, 1, ProductName.SODA, 1.50, "Good until 12/31/2023");
        vendingMachine.addProduct(1, 0, 1, ProductName.SODA, 1.50, "Good until 12/31/2023");
        vendingMachine.addProduct(2, 0, 1, ProductName.SODA, 1.50, "Good until 12/31/2023");
        vendingMachine.addProduct(3, 0, 1, ProductName.SODA, 1.50, "Good until 12/31/2023");
        vendingMachine.addProduct(4, 0, 1, ProductName.SODA, 1.50, "Good until 12/31/2023");
        vendingMachine.addProduct(5, 0, 1, ProductName.SODA, 1.50, "Good until 12/31/2023");

        vendingMachine.addProduct(0, 0, 2, ProductName.CANDY, 1.25, "Good until 12/10/2023");
        vendingMachine.addProduct(1, 0, 2, ProductName.CANDY, 1.25, "Good until 12/10/2023");
        vendingMachine.addProduct(2, 0, 2, ProductName.CANDY, 1.25, "Good until 12/10/2023");
        vendingMachine.addProduct(3, 0, 2, ProductName.CANDY, 1.25, "Good until 12/10/2023");
        vendingMachine.addProduct(4, 0, 2, ProductName.CANDY, 1.25, "Good until 12/10/2023");
        vendingMachine.addProduct(5, 0, 2, ProductName.CANDY, 1.25, "Good until 12/10/2023");

        vendingMachine.addProduct(0, 0, 3, ProductName.CHIPS, 1.35, "Good until 12/09/2023");
        vendingMachine.addProduct(1, 0, 3, ProductName.CHIPS, 1.35, "Good until 12/09/2023");
        vendingMachine.addProduct(2, 0, 3, ProductName.CHIPS, 1.35, "Good until 12/09/2023");
        vendingMachine.addProduct(3, 0, 3, ProductName.CHIPS, 1.35, "Good until 12/09/2023");
        vendingMachine.addProduct(4, 0, 3, ProductName.CHIPS, 1.35, "Good until 12/09/2023");
        vendingMachine.addProduct(5, 0, 3, ProductName.CHIPS, 1.35, "Good until 12/09/2023");

        vendingMachine.addProduct(0, 0, 4, ProductName.WATER, 2.00, "Good until 12/30/2023");
        vendingMachine.addProduct(1, 0, 4, ProductName.WATER, 2.00, "Good until 12/30/2023");
        vendingMachine.addProduct(2, 0, 4, ProductName.WATER, 2.00, "Good until 12/30/2023");
        vendingMachine.addProduct(3, 0, 4, ProductName.WATER, 2.00, "Good until 12/30/2023");
        vendingMachine.addProduct(4, 0, 4, ProductName.WATER, 2.00, "Good until 12/30/2023");
        vendingMachine.addProduct(5, 0, 4, ProductName.WATER, 2.00, "Good until 12/30/2023");

        vendingMachine.addProduct(0, 0, 5, ProductName.POPROCKS, 0.75, "Good until 12/05/2023");
        vendingMachine.addProduct(1, 0, 5, ProductName.POPROCKS, 0.75, "Good until 12/05/2023");
        vendingMachine.addProduct(2, 0, 5, ProductName.POPROCKS, 0.75, "Good until 12/05/2023");
        vendingMachine.addProduct(3, 0, 5, ProductName.POPROCKS, 0.75, "Good until 12/05/2023");
        vendingMachine.addProduct(4, 0, 5, ProductName.POPROCKS, 0.75, "Good until 12/05/2023");
        vendingMachine.addProduct(5, 0, 5, ProductName.POPROCKS, 0.75, "Good until 12/05/2023");
            }

            System.out.println("Welcome to the Vending Machine!");
            System.out.println("Available items:");
            vendingMachine.displayProducts();
            System.out.println("\nGetting products from the vending machine:");
            System.out.println("1. " + vendingMachine.getProduct(0, 0, 0).getName());
            System.out.println("2. " + vendingMachine.getProduct(0, 0, 1).getName());
            System.out.println("3. " + vendingMachine.getProduct(0, 0, 2).getName());
            System.out.println("4. " + vendingMachine.getProduct(0, 0, 3).getName());
            System.out.println("5. " + vendingMachine.getProduct(0, 0, 4).getName());
            System.out.println("6. " + vendingMachine.getProduct(0, 0, 5).getName());



        while (true) {



            int choice = vendingMachine.getUserChoice();
            if (choice == 0) {
                break;
            } else  {
                Product selectedProduct = vendingMachine.getSelectedProduct(choice);
                if (selectedProduct != null) {
                    double change = vendingMachine.acceptPayment(selectedProduct);

                    if (change > 0) {
                        vendingMachine.dispenseProduct(selectedProduct);
                        System.out.println("Change: $" + change);
                    }



                }
            }
        }
        System.out.println("Thank you for using the Vending Machine!");
        System.out.println("Total amount earned: $" + vendingMachine.totalAmount);
        vendingMachine.scanner.close();
        break;
        }}}
