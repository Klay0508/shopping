/**
 * @Author: Kiyoshi Lay
 * @Date Mar 15 2025
 * Description: This program is a basic shopping system which will ask the user which category they would like to shop for.
 * For example dairy,produce,bread,beverages,frozen food,etc.We want to display the price for each item too, the user will have a set
 * amount of money at the beginning to spend once they run out it should list the items the user bought with the price.
 */
package Shopping;

import java.util.*;

public class ShoppingProgram {
    double moneySpent = 0;
    double balance = 50;
    Scanner scanner = new Scanner(System.in);
    List<String> basket = new ArrayList<>();
    public static void main(String[] args) {
        ShoppingProgram sp = new ShoppingProgram();
        boolean valid = false;

        while (!valid) {
            System.out.printf("Welcome to Kroger!\nTotal Balance: %.2f%nSelect which category you would like to shop for.\n1.Bread\n2.Dairy\n3.Fruits\n4.Vegetables\n5.Snacks\n6.Check Basket\n7.Exit\n",sp.balance);
            try {
                int number = sp.scanner.nextInt();
                sp.scanner.nextLine();
                if (number < 1 || number > 7) {
                    System.out.println("Sorry please choose a number 1-7");
                }
                switch (number){
                    case 1:
                        sp.shopBread();
                        break;
                    case 2:
                        sp.shopDiary();
                        break;
                    case 3:
                        sp.shopFruits();
                        break;
                    case 4:
                        sp.shopVegetables();
                        break;

                    case 5:
                        sp.shopSnacks();
                        break;

                    case 6:
                        sp.printBasket();
                        break;

                    case 7:
                        valid = true;

                }
            }catch (InputMismatchException ime){
                System.err.println("invalid input");
                sp.scanner.nextLine();
            }
        }
        sp.scanner.close();
    }

    public void shopBread() {
        Map<String, Double> breads = new HashMap<>();
        String[] names = {"White Bread", "Wheat Bread", "Honey Wheat", "Buttered Bread"};
        double[] prices = {1.79, 1.50, 2.99, 3.50};

        for (int i = 0; i <= names.length - 1; i++) {
            breads.put(names[i], prices[i]);
        }

        System.out.println("Which type of bread would you like? Please make sure you spell it correctly!\nType 1 to exit");

        Iterator<Map.Entry<String, Double>> iterator = breads.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Double> current = iterator.next();
            System.out.printf("%s Price: $%.2f%n",current.getKey(),current.getValue());
        }

        boolean valid = false;

        while (!valid) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                valid = true;
            } else {
                boolean flag = false;
                for (Map.Entry<String, Double> entry : breads.entrySet()) {
                    if (entry.getKey().equalsIgnoreCase(input)) {
                        if (balance >= entry.getValue()) {
                            moneySpent += entry.getValue();
                            balance -= entry.getValue();
                            addToBasket(entry.getKey());
                            valid = true;
                            flag = true;
                        } else {
                            System.out.println("Sorry you dont have enough money.Please pick a cheaper option");
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    System.out.println("Sorry we dont have that bread.");
                }
            }
        }
    }

    public void shopDiary() {
        Map<String, Double> diary = new HashMap<>();

        String[] diaryNames = {"Milk", "American Cheese 8 slices", "Pepper Jack 8 slices", "Butter 16oz", "Sour cream 16oz",
                "Mozzarella 8 oz"};
        double[] prices = {3.59, 2.50, 2.59, 4.29, 2.19, 2.29};

        for (int i = 0; i <= diaryNames.length - 1; i++) {
            diary.put(diaryNames[i], prices[i]);
        }

        Iterator<Map.Entry<String, Double>> iterator = diary.entrySet().iterator();
        System.out.println("Which dairy product would you like?\nType 1 to exit out");

        while (iterator.hasNext()) {
            Map.Entry<String, Double> current = iterator.next();
            System.out.printf("%s Price: $%.2f%n", current.getKey(), current.getValue());
        }


        boolean valid = false;
        while (!valid) {
            String input = scanner.nextLine();
            boolean flag = false;
            if (input.equals("1")) {
                valid = true;
            } else {

                for (Map.Entry<String, Double> entry : diary.entrySet()) {
                    if (entry.getKey().equalsIgnoreCase(input)) {
                        if (balance >= entry.getValue()) {
                            moneySpent += entry.getValue();
                            balance -= entry.getValue();
                            addToBasket(entry.getKey());
                            valid = true;
                            flag = true;
                        } else {
                            System.out.println("Sorry you dont have enough money for that.Please choose a cheaper option.");
                            flag = true;
                            break;
                        }
                    }
                }
                    if (!flag) {
                        System.out.println("Sorry we dont have that diary product.");
                    }
                }
            }
        }

    public void shopFruits(){
        Map<String,Fruit> fruits = new HashMap<>();
        Random rn = new Random();
        double apple = rn.nextDouble(.33,.45);
        double banana = rn.nextDouble(.26,.35);
        double tomato = rn.nextDouble(.24,.39 );
        double avocado = rn.nextDouble(.40,.54);
        double orange = rn.nextDouble(.28,.36);
        double peaches = rn.nextDouble(.33,.50);
        double pears = rn.nextDouble(.33,.48);
        double mangoes = rn.nextDouble(.50,1.43);

        Double[] weight = {apple,banana,tomato,avocado,orange,peaches,pears,mangoes};
        Double[] pricePerPound = {1.32,.80,1.59,1.60,1.23,1.56,1.80,1.25};
        String[] fruitNames = {"Apple","Banana","Tomato","Avocado","Oranges","Peaches","Pears","Mangoes"};

        for(int i = 0;i < fruitNames.length-1;i++){
            fruits.put(fruitNames[i],new Fruit(fruitNames[i],pricePerPound[i],weight[i]));
        }

        Iterator<Map.Entry<String,Fruit>> iterator = fruits.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String,Fruit> current = iterator.next();
            System.out.printf("%s \nPrice per pound: $%.2f\nAverage weight of one: %.2flb\n"
                    ,current.getKey(),current.getValue().getPricePerPound(),current.getValue().getWeight());
        }

        boolean valid = false;
        while(!valid) {
            System.out.println("Which fruit would you like?\nType 1 to exit out");
            String input = scanner.nextLine();
            boolean flag = false;
            if(input.equals("1")){
                valid = true;
            }else {
                    for (Map.Entry<String, Fruit> entry : fruits.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(input)) {
                            System.out.println("How many " + entry.getKey() + " would you like?");
                            try {
                                int count = scanner.nextInt();

                                if (count >= 1) {

                                    double weightOfFruit = entry.getValue().getWeight() * count;
                                    double priceOfFruit = entry.getValue().getPricePerPound() * weightOfFruit;
                                    if (balance >= priceOfFruit) {
                                        moneySpent += priceOfFruit;
                                        balance -= priceOfFruit;
                                        addToBasket(entry.getKey());
                                        valid = true;
                                        flag = true;
                                    }
                                } else {
                                    System.out.println("Sorry You cant have negative number of fruits");
                                    flag = true;
                                    scanner.nextLine();
                                    break;
                                }
                            } catch (InputMismatchException ime) {
                                System.err.println("Sorry invalid input");
                            }
                        }
                    }
                    if(!flag) {
                        System.out.println("Sorry we dont have that fruit product.");
                    }
                }
            }
        }
        public void shopSnacks() {
            Map<String, Double> snacks = new HashMap<>();

            String[] name = {"Pringles", "Oreo's", "Ritz", "Doritos", "Cheetos", "Funyuns"};
            Double[] prices = {2.99, 3.99, 3.49, 1.89, 1.99, 1.79};

            for (int i = 0; i < name.length - 1; i++) {
                snacks.put(name[i], prices[i]);
            }

            Iterator<Map.Entry<String, Double>> iterator = snacks.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Double> current = iterator.next();
                System.out.printf("%s \n  Price: %.2f\n", current.getKey(), current.getValue());
            }

            boolean valid = false;
            while (!valid) {
                System.out.println("Which snack would you like?Type 1 to exit out");
                String input = scanner.nextLine();
                boolean flag = false;
                if (input.equals("1")) {
                    valid = true;
                } else {
                    for (Map.Entry<String, Double> entry : snacks.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(input)) {
                            if (balance >= entry.getValue()) {
                                moneySpent += entry.getValue();
                                balance -= entry.getValue();
                                addToBasket(entry.getKey());
                                valid = true;
                                flag = true;
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println("Sorry we dont have that snack product.");
                    }
                }
            }
        }

        public void shopVegetables() {
            Map<String, Vegetable> vegetables = new HashMap<>();

            Random rand = new Random();
            double carrot = rand.nextDouble(.12, .19);
            double bellPeppers = rand.nextDouble(.3, .5);
            double broccoli = rand.nextDouble(1, 1.5);
            double potatoes = rand.nextDouble(.4, .6);
            double mushrooms = rand.nextDouble(.5, .8);

            String[] name = {"Carrots", "Bell Peppers", "Broccoli", "Potatoes", "Mushrooms"};
            Double[] weight = {carrot, bellPeppers, broccoli, potatoes, mushrooms};
            Double[] pricePerPound = {1.49,1.89,1.29,.98,.99};

            for (int i = 0; i < name.length - 1; i++) {
                vegetables.put(name[i],new Vegetable(name[i],weight[i],pricePerPound[i]));
            }
            Iterator<Map.Entry<String, Vegetable>> iterator = vegetables.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Vegetable> current = iterator.next();
                System.out.printf("%s \n  Price per pound: $%.2f\n  Weight of one: %.2flb\n",
                        current.getKey(),current.getValue().getPricePerPound(),current.getValue().getWeight());
            }
            boolean valid = false;
            while(!valid) {
                System.out.println("Which Vegetable would you like?\nType 1 to exit out");
                String input = scanner.nextLine();
                boolean flag = false;
                if (input.equals("1")) {
                    valid = true;
                } else {
                    for (Map.Entry<String, Vegetable> entry : vegetables.entrySet()) {
                        if (entry.getKey().equalsIgnoreCase(input)) {
                            System.out.println("How many " + entry.getKey() + " would you like?");
                            try {
                                int count = scanner.nextInt();

                                if (count >= 1) {

                                    double weightOfFruit = entry.getValue().getWeight() * count;
                                    double priceOfFruit = entry.getValue().getPricePerPound() * weightOfFruit;
                                    if (balance >= priceOfFruit) {
                                        balance -= priceOfFruit;
                                        addToBasket(entry.getKey());
                                        valid = true;
                                        flag = true;
                                    }
                                } else {
                                    System.out.println("Sorry You cant have negative number of Vegetables");
                                    flag = true;
                                    scanner.nextLine();
                                    break;
                                }
                            } catch (InputMismatchException ime) {
                                System.err.println("Sorry invalid input");
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println("Sorry we dont have that Vegetable product.");
                    }
                }
            }
        }

    public void addToBasket(String items){
        basket.add(items);
    }

    public void printBasket(){
        System.out.println("Basket: " + basket);
        System.out.printf("Total money spent: $%.2fn\n",moneySpent);
    }


}
