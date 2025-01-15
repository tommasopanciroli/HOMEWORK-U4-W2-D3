import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Test {
    public static List<Product> menoDiCento(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getPrice() < 100 && product.getCategory().equals("book"))
                .collect(Collectors.toList());
    }

    public static List<Product> baby(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getCategory().equals("baby"))
                .collect(Collectors.toList());
    }

    public static List<Product> boys(List<Product> productList) {
        return productList.stream()
                .filter(product -> product.getCategory().equals("boys"))
                .map(product -> {
                    double prezzoScontato = product.getPrice() * 0.9;
                    product.setPrice(prezzoScontato);
                    return product;
                })
                .collect(Collectors.toList());
    }

    public static Set<Product> ordiniTier2(List<Order> orderList) {
        LocalDate dataDal = LocalDate.of(2021, 2, 1);
        LocalDate dataAl = LocalDate.of(2021, 4, 1);

        return orderList.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> !order.getOrderDate().isBefore(dataDal) && !order.getOrderDate().isAfter(dataAl))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());
    }


    public static void main(String[] args) {
        Product prodotto1 = new Product(121L, "harry potter e la pietra filosofale", "book", 20.99);
        Product prodotto2 = new Product(131L, "cofanetto berserk", "book", 40.99);
        Product prodotto3 = new Product(141L, "collezione completa di star wars", "book", 199.99);
        Product prodotto4 = new Product(151L, "harry potter e il calice di fuoco", "book", 15.99);
        Product prodotto5 = new Product(161L, "cuffie gaming", "electronics", 100.99);
        Product prodotto6 = new Product(171L, "ciuccio", "baby", 18.99);
        Product prodotto7 = new Product(181L, "pannolini", "baby", 15.99);
        Product prodotto8 = new Product(191L, "cappellino xs", "baby", 22.99);
        Product prodotto9 = new Product(192L, "pantaloncini", "boys", 20.99);
        Product prodotto10 = new Product(193L, "jordan 4", "boys", 220.99);
        Product prodotto11 = new Product(194L, "bracciale tennis", "boys", 39.99);


        List<Product> productList = Arrays.asList(prodotto1, prodotto2, prodotto3, prodotto4, prodotto5, prodotto6, prodotto7, prodotto8, prodotto9, prodotto10, prodotto11);
        List<Product> babyList = baby(productList);
        Customer customer1 = new Customer(20L, "Tommaso Panciroli", 2);
        Customer customer2 = new Customer(21L, "Rachele Burgio", 2);
        Customer customer3 = new Customer(22L, "Nicolo Albanese", 3);
        Customer customer4 = new Customer(23L, "Anna Landi", 1);
        Customer customer5 = new Customer(24L, "Stefano Casasola", 1);
        Customer customer6 = new Customer(25L, "Gabriele Latinese", 2);


        Order ordine1 = new Order(100L, "in carico", LocalDate.now(), LocalDate.now().plusDays(7), babyList, customer1);
        Order ordine2 = new Order(101L, "spedito", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 17), babyList, customer2);
        Order ordine3 = new Order(102L, "consegnato", LocalDate.of(2021, 5, 10), LocalDate.of(2021, 3, 12), babyList, customer3);
        Order ordine4 = new Order(103L, "in carico", LocalDate.of(2021, 1, 10), LocalDate.of(2021, 5, 7), productList, customer4);
        Order ordine5 = new Order(104L, "consegnato", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), babyList, customer5);
        Order ordine6 = new Order(105L, "consegnato", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 5, 17), productList, customer6);


        List<Order> orderList = Arrays.asList(ordine1, ordine2, ordine3, ordine4, ordine5, ordine6);
        List<Product> prodottiOttenuti = menoDiCento(productList);
        List<Product> prodottiBoys = boys(productList);
        Set<Product> prodottiTier2 = ordiniTier2(orderList);

        System.out.println("------------");
        System.out.println("I prodotti con un prezzo inferiore a 100 euro nella categoria book sono:");
        prodottiOttenuti.forEach(System.out::println);
        System.out.println("------------");
        System.out.println("L'ordine di prodotti baby:");
        orderList.forEach(System.out::println);
        System.out.println("------------");
        System.out.println("I prodotti della categoria boys scontati del 10%");
        prodottiBoys.forEach(System.out::println);
        System.out.println("------------");
        System.out.println("Prodotti ordinati da clienti Tier 2 tra il 01 febbraio 2021 e il 01 aprile 2021:");
        prodottiTier2.forEach(System.out::println);
        System.out.println("------------");
    }
}
