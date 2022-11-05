import java.util.*;
import java.util.Locale.Category;

public class Flipzon {
    public class category {
        public ArrayList<product> products = new ArrayList<product>();
        public String name;
        private double ID;

        category() {

        }

        category(String name, double id) {
            this.name = name;
            this.ID = id;

        }

    }

    public class product {
        public String name;
        private double ID;
        public int price;
        public String description;
        private int discount[] = new int[3];
        public static ArrayList<product> products = new ArrayList<product>();

        void setDetails() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Product Name : ");
            this.name = sc.nextLine();
            System.out.println("Product ID : ");
            this.ID = sc.nextDouble();

            sc.nextLine();
            System.out.println("Product Price : ");
            this.price = sc.nextInt();
            sc.nextLine();
            System.out.println("Descrition(Enter everything using comma) : ");
            this.description = sc.nextLine();
            this.products.add(this);

        }

        void getDetails() {
            System.out.println("Name of the product : " + this.name);
            System.out.println("Price of the product : " + this.price);
            System.out.println("Description : " + this.description);
        }

    }

    public class admin {
        private String userName;
        private int password;
        public static ArrayList<category> categories = new ArrayList<category>();
        public static ArrayList<product> giveAway = new ArrayList<product>();
        private static int giveAwayDeal;

        admin() {

        }

        admin(String username, int password) {
            this.userName = username;
            this.password = password;
        }

        void giveAwayDealMake() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id of product 1");
            double tempId1 = sc.nextDouble();
            System.out.println("Enter id of product 2");
            double tempId2 = sc.nextDouble();
            for (int i = 0; i < product.products.size(); i++) {
                if (product.products.get(i).ID == tempId1 || product.products.get(i).ID == tempId2) {
                    giveAway.add(product.products.get(i));
                }
            }
            System.out.println("Enter the offered price : ");
            int offerPrice = sc.nextInt();
            this.giveAwayDeal = offerPrice;
        }

        void showDeals() {
            if (giveAway.size() == 0) {
                System.out.println("Sorry no deal availaible currently");
            } else {
                System.out.println("Hurry up this ends in few hours");
                for (int i = 0; i < giveAway.size(); i++) {
                    giveAway.get(i).getDetails();
                }
                System.out.println("Get all of them for only " + giveAwayDeal);
            }
        }

        void addCategory() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter category ID : ");
            double categoryID = sc.nextDouble();
            sc.nextLine();
            for (int i = 0; i < this.categories.size(); i++) {
                if (this.categories.get(i).ID == categoryID) {
                    System.out.println("Dear customer you have already created the product");
                    return;
                }
            }
            System.out.println("Enter the Category name : ");
            String categoryName = sc.nextLine();

            category newCategory = new category(categoryName, categoryID);
            categories.add(newCategory);
            product newProduct = new product();
            newProduct.setDetails();
            newCategory.products.add(newProduct);

        }

        void deleteCategory() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Category name : ");
            String categoryName = sc.nextLine();
            System.out.println("Enter category ID : ");
            int categoryID = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < this.categories.size(); i++) {
                if (this.categories.get(i).name.equals(categoryName)) {
                    this.categories.remove(i);

                    System.out.print("Successfully removed" + categoryName);
                    return;

                }
            }
            System.out.println("Could not find the element");
            return;

        }

        int addProduct() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the details : ");
            System.out.println("Category ID : ");
            double ID = sc.nextDouble();
            sc.nextLine();
            for (int i = 0; i < this.categories.size(); i++) {
                if (this.categories.get(i).ID == ID) {
                    product tempProd = new product();
                    tempProd.setDetails();
                    System.out.println("Successfully created the product.");
                    return 1;

                }
            }
            System.out.println("Sorry the category do not exist ");
            return 0;

        }

        int deleteProduct() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the details : ");
            System.out.println("Category ID : ");
            double ID = sc.nextDouble();
            sc.nextLine();
            for (int i = 0; i < this.categories.size(); i++) {
                if (this.categories.get(i).ID == ID) {
                    System.out.println("Enter the product ID : ");
                    double prodID = sc.nextDouble();
                    sc.nextLine();
                    for (int j = 0; j < this.categories.get(i).products.size(); j++) {
                        if (this.categories.get(i).products.get(j).ID == prodID) {
                            this.categories.get(i).products.remove(j);

                            System.out.println("Successfully removed the product");

                        }
                    }
                    product tempProd = new product();
                    for (int j = 0; j < tempProd.products.size(); j++) {
                        if (tempProd.products.get(i).ID == prodID) {
                            tempProd.products.remove(j);

                        }
                    }
                    return 1;

                }
            }

            System.out.println("Sorry the category do not exist ");
            return 0;
        }

        void setDiscountOnProduct(double categoryID, double productid) {
            for (int i = 0; i < this.categories.size(); i++) {
                if (this.categories.get(i).ID == categoryID) {
                    for (int j = 0; j < this.categories.get(i).products.size(); j++) {
                        if (this.categories.get(i).products.get(j).ID == productid) {
                            Scanner sc = new Scanner(System.in);
                            int eliteDiscount = sc.nextInt();
                            int primeDiscount = sc.nextInt();
                            int normalDiscount = sc.nextInt();
                            sc.nextLine();
                            int discount[] = new int[3];
                            discount[0] = eliteDiscount;
                            discount[1] = primeDiscount;
                            discount[2] = normalDiscount;
                            this.categories.get(i).products.get(j).discount = discount;
                            System.out.println("Successfully added the discounts");
                            return;

                        }
                    }
                }
            }
            System.out.println("please provide valid input");
        }

    }

    interface user {
        public String name = null;
        public double ID = 0;
        public int age = 0;
        public int phone_num = 0;
        public String email = null;
        public String password = null;
        public String type = null;

        void SignUp(String name, double ID, int age, int phone_num, String email, String password);

        users LogIn(double id, String password);

        void upgradeStatus(String status);

        void exploreProductCatalog();

        void addProductToCart(product p);

        void makePayment();

    }

    public class users implements user {
        public String name;
        private double ID;
        public int age;
        public int phone_num;
        public String email;
        public String type;
        public double discount;
        public double wallet;
        private String password;
        private boolean LogInStatus;
        public ArrayList<Integer> coupans = new ArrayList<Integer>();
        public static ArrayList<users> Users = new ArrayList<users>();
        public ArrayList<product> cart = new ArrayList<product>();
        public int cartTotal;

        public void SignUp(String name, double ID, int age, int phone_num, String email, String password) {
            this.name = name;
            this.ID = ID;
            this.age = age;
            this.phone_num = phone_num;
            this.email = email;
            this.type = "normal";
            this.discount = 0;
            this.wallet = 1000;
            this.password = password;
            this.LogInStatus = false;
            this.cartTotal = 0;

            Users.add(this);

        };

        public users isRegistered(double Id, String password) {
            for (int i = 0; i < Users.size(); i++) {
                if (Users.get(i).ID == Id && Users.get(i).password.equals(password)) {
                    return Users.get(i);
                }
            }
            return null;
        }

        public users LogIn(double id, String password) {
            if (isRegistered(id, password) == null) {
                System.out.println("Please register first");
                return null;
            } else {
                System.out.println("Welcome sir!");
                System.out.println("You are successfully logined to flipzon");
                this.LogInStatus = true;
                return isRegistered(id, password);

            }

        };

        public void upgradeStatus(String status) {
            this.type = status;
            if (status.equals("elite")) {
                this.wallet -= 300;
            } else {
                this.wallet -= 200;
            }
            System.out.println("Status updated successfully");

        };

        public void exploreProductCatalog() {
            for (int i = 0; i < product.products.size(); i++) {
                product.products.get(i).getDetails();
            }

        };

        public void grabDeal() {
            if (admin.giveAway.size() == 0) {
                System.out.println("No deal present currently");
                return;
            }
            for (int i = 0; i < admin.giveAway.size(); i++) {
                cart.add(admin.giveAway.get(i));
            }
            cartTotal += admin.giveAwayDeal;
        }

        public void addProductToCart(product p) {
            this.cart.add(p);
            cartTotal += p.price;
            if (this.type.equals("elite")) {
                cartTotal -= p.price * (p.discount[0] / 100);

            } else if (this.type.equals("prime")) {
                cartTotal -= p.price * (p.discount[1] / 100);
            } else {
                cartTotal -= p.price * (p.discount[2] / 100);

            }

        };

        public void makePayment() {
            System.out.println("Dear User");
            System.out.println("Following are your transaction details : ");
            int totlAmt = 0;
            for (int i = 0; i < this.cart.size(); i++) {
                totlAmt += this.cart.get(i).price;

            }

            System.out.println("Total Amount : " + totlAmt);
            System.out.println("Discounted price is : " + cartTotal);
            double delivary = 0;
            if (this.type.equals("normal")) {
                delivary = 100 + 0.05 * cartTotal;
            } else if (this.type.equals("prime")) {
                delivary = 100 + 0.02 * cartTotal;
            }
            System.out.println("Delivary charge : " + delivary);
            if (this.coupans.size() != 0) {
                System.out.println("Hurray we got some coupans");
                cartTotal -= ((coupans.get(0) / 100) * cartTotal);
                System.out.println("Cart total after applying coupans : " + cartTotal);
            }
            System.out.println("Final price to pay : " + (cartTotal + delivary));
            System.out.println("processing the payment");
            if (this.wallet >= (cartTotal + delivary)) {
                this.wallet -= (cartTotal + delivary);
                System.out.println("Payment successful");
                if (this.type.equals("elite")) {
                    System.out.println("Delivery with 2 days");
                    if (cartTotal >= 5000) {
                        System.out.println("Hurray we got some coupans of 15% discount");
                        this.coupans.add(15);
                    }
                } else if (this.type.equals("prime")) {
                    System.out.println("delivary within 3-6 days");
                    if (cartTotal >= 5000) {
                        this.coupans.add(10);
                        System.out.println("Hurray we got some coupans of 10% discount");
                    }
                } else {
                    System.out.println("delivery within 10 days");
                    if (cartTotal >= 5000) {
                        this.coupans.add(5);
                        System.out.println("Hurray we got some coupans of 5% discount");
                    }
                }

            } else {
                System.out.println("Insufficient balance");

            }

        };

    }

    public static void main(String[] args) {
        Flipzon flipzon = new Flipzon();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Hello sir ,We welcome you to flipzone ");
            System.out.println("1) Enter as Admin");
            System.out.println("2) Explore the Product Catalog");
            System.out.println("3) Show Available Deals");
            System.out.println("4) Enter as Customer");
            System.out.println("5) Exit the Application");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Sir kindly provide us your id and pass word");
                System.out.println("Username : ");
                String id = sc.nextLine();
                System.out.println("Please provide your password : ");
                int password = sc.nextInt();
                sc.nextLine();
                admin newAdmin = flipzon.new admin(id, password);
                while (true) {
                    System.out.println(
                            "1) Add category\n2) Delete category\n3) Add Product\n4) Delete Product\n5) Set Discount on Product\n6) Add giveaway deal\n7) Back");
                    int adminChoice = sc.nextInt();
                    sc.nextLine();
                    if (adminChoice == 1) {
                        newAdmin.addCategory();

                    } else if (adminChoice == 2) {
                        newAdmin.deleteCategory();

                    } else if (adminChoice == 3) {
                        newAdmin.addProduct();

                    } else if (adminChoice == 4) {
                        newAdmin.deleteProduct();

                    } else if (adminChoice == 5) {
                        System.out.println("Enter the category id : ");
                        double categoryId = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter the product id : ");
                        double productid = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter the discount : ");

                        newAdmin.setDiscountOnProduct(categoryId, productid);

                    } else if (adminChoice == 6) {
                        newAdmin.giveAwayDealMake();

                    } else if (adminChoice == 7) {
                        break;

                    } else {
                        System.out.println("Please input a valid value");
                    }
                }

            } else if (choice == 2) {
                users user = flipzon.new users();
                user.exploreProductCatalog();

            } else if (choice == 3) {
                admin newAdmin = flipzon.new admin();
                newAdmin.showDeals();

            } else if (choice == 4) {
                while (true) {
                    System.out.println("Welcome to customer mode");
                    System.out.println("1. Sign Up");
                    System.out.println("2 Log In");
                    System.out.println("3. back");
                    int Userchoice = sc.nextInt();
                    sc.nextLine();
                    if (Userchoice == 1) {
                        users newUser = flipzon.new users();
                        System.out.println("Enter your name : ");
                        String name = sc.nextLine();
                        System.out.println("Enter your id : ");
                        double id = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter your age : ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Phone number : ");
                        int phone_num = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter your email : ");
                        String email = sc.nextLine();
                        System.out.println("Enter a password : ");
                        String password = sc.nextLine();

                        newUser.SignUp(name, id, age, phone_num, email, password);
                    } else if (Userchoice == 2) {
                        users newUser = flipzon.new users();
                        System.out.println("Enter your id : ");

                        double id = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter your password : ");
                        String password = sc.nextLine();
                        users success = newUser.LogIn(id, password);

                        if (success != null) {
                            newUser = success;
                            while (true) {
                                System.out.println(
                                        "1) browse products\n2) browse deals\n3) add a product to cart \n4) add products in deal to cart \n5) view coupons \n6) check account balance\n7) view cart\n8) empty cart\n9) checkout cart\n10) upgrade customer status\n11) Add amount to wallet\n12) back");
                                int LoginChoice = sc.nextInt();
                                if (LoginChoice == 1) {
                                    newUser.exploreProductCatalog();

                                } else if (LoginChoice == 2) {
                                    newUser.exploreProductCatalog();

                                } else if (LoginChoice == 3) {
                                    System.out.println("Enter the product id : ");
                                    double prodid = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Enter the quantity : ");
                                    int qty = sc.nextInt();
                                    sc.nextLine();
                                    boolean found = false;
                                    product temp = flipzon.new product();
                                    for (int i = 0; i < temp.products.size(); i++) {
                                        if (temp.products.get(i).ID == prodid) {
                                            for (int j = 0; j < qty; j++) {
                                                newUser.addProductToCart(temp.products.get(i));

                                            }

                                            System.out.println("added successfully");
                                            found = true;

                                            break;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Product not found");

                                    }

                                } else if (LoginChoice == 4) {
                                    newUser.grabDeal();

                                } else if (LoginChoice == 5) {
                                    if (newUser.coupans.size() == 0) {
                                        System.out.println("No coupans availaible ");
                                    } else {
                                        System.out.println("We got coupans worth : ");
                                        for (int i = 0; i < newUser.coupans.size(); i++) {
                                            System.out.println("Get " + newUser.coupans.get(i) + "% off a payment");
                                        }
                                    }

                                } else if (LoginChoice == 6) {
                                    System.out.println("Your account balance is : " + newUser.wallet);

                                } else if (LoginChoice == 7) {
                                    if (newUser.cart.size() == 0) {
                                        System.out.println("Your cart is empty! ");
                                    } else {
                                        System.out.println("Your cart contains : ");
                                        for (int i = 0; i < newUser.cart.size(); i++) {
                                            newUser.cart.get(i).getDetails();

                                        }

                                    }

                                } else if (LoginChoice == 8) {
                                    newUser.cart.clear();
                                    newUser.cartTotal = 0;
                                    System.out.println("Cart successfully emptied");

                                } else if (LoginChoice == 9) {
                                    newUser.makePayment();

                                } else if (LoginChoice == 10) {
                                    sc.nextLine();
                                    System.out.println("Current status : " + newUser.type);

                                    String newStatus = sc.nextLine();

                                    newUser.upgradeStatus(newStatus);

                                } else if (LoginChoice == 11) {
                                    System.out.println("Enter the amount you want to add : ");
                                    int amount = sc.nextInt();
                                    sc.nextLine();
                                    newUser.wallet += amount;

                                } else if (LoginChoice == 12) {
                                    break;

                                } else {
                                    System.out.println("Please provide a valid choice ");
                                }

                            }

                        } else {
                            System.out.println("Try again");
                        }

                    } else if (Userchoice == 3) {
                        break;

                    } else {
                        System.out.println("Please provide a valid input");
                    }

                }

            } else if (choice == 5) {
                break;

            } else {
                System.out.println("Please enter a valid choice ");

            }
        }
        System.out.println("Thankyou for choosing flipzon ");

    }

}