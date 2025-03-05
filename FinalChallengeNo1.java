//cc3
//mndiola


//product class (parent class)
class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //method to display
    public void displayInfo(){
        System.out.println("Product: " + name + "Price: $" + price + "Quantity: " + quantity);
    }

    //method for calculating total price
    public double calculateTotalPrice(){
        return price * quantity;
    }
}

//derive class for electronics.
class Electronics extends Product{
    private int warrantyMonths;

    public Electronics(String name, double price, int quantity, int warrantyMonths){
        super(name, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayInfo(){
        System.out.println("Electronics: " + name + " Price: $ " + price + " Quantity: " + quantity + " Warranty months: " + warrantyMonths);
    }

    public void extendWarranty(int extraMonths) {
        warrantyMonths += extraMonths;
        System.out.println("Warranty extended by " + extraMonths + " months. New warranty period: " + warrantyMonths + " months");
    }
}

//derive class for Clothing.
class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Clothing: " + name + ", Price: $" + price + ", Quantity: " + quantity +
                ", Size: " + size);
    }

    public void tryOn() {
        System.out.println("Trying on " + name + " in size " + size);
    }
}

//derice class for Book
class Book extends Product {
    private String author;

    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + name + ", Price: $ " + price + ", Quantity: " + quantity +
                ", Author: " + author);
    }

    public void readPreview() {
        System.out.println("Reading a preview of " + name + " by " + author);
    }
}


public class FinalChallenge1 {
    public static void main(String[] args) {

        //instantation 
        Electronics Laptop = new Electronics("Laptop" , 1200, 10, 24);
        Clothing tshirt = new Clothing("T-Shirt" , 25.00 , 50 , "L");
        Book book = new Book("1984", 15.00, 100, "George Orwell");

                //polymorphism
                Product[] products = {Laptop, tshirt, book};

        System.out.println("E-COMMERCE SYSTEM\n");

        for (Product product : products) {
            product.displayInfo();
            System.out.println("Total Price: $" + product.calculateTotalPrice());

            //instanceof of each product
            if (product instanceof Electronics) {
                ((Electronics) product).extendWarranty(6);
            } else if (product instanceof Clothing) {
                ((Clothing) product).tryOn();
            } else if (product instanceof Book) {
                ((Book) product).readPreview();
            }

            System.out.println("------------------------------");
        }
    }
}
