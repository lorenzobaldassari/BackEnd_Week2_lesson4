package Day4;

import Day4.Entitites.Customer;
import Day4.Entitites.Order;
import Day4.Entitites.Product;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        List<Product> productList2 = new ArrayList<>();

        productList.add(new Product("harry potter e la pietra filosofale", "Books", 120));
        productList.add(new Product("Halo Reach", "Books", 80));
        productList.add(new Product("toys", "Baby", 140));
        productList.add(new Product("XboxSerieX", "Boys", 2000));
        productList.add(new Product("playstation", "Boys", 500));
        productList2.add(new Product("biberon", "Baby", 15));
        productList2.add(new Product("gaming pc", "Boys", 2000));

        List<Customer> customerList = new ArrayList<>();

        Customer mario = new Customer("Mario", 2);
        Customer paolo = new Customer("Paolo", 1);
        Customer gianni = new Customer("Gianni", 2);
        Customer maria = new Customer("Maria", 5);

        List<Order> oredrList = new ArrayList<>();

        oredrList.add(new Order("evaded", mario, productList));
        oredrList.add(new Order("evaded", mario, productList));
        oredrList.add(new Order("evaded", paolo, productList2));
        oredrList.add(new Order("evaded", paolo, productList));
        oredrList.add(new Order("evaded", maria, productList));
        oredrList.add(new Order("evaded", maria, productList));
        oredrList.add(new Order("evaded", gianni, productList2));
        oredrList.add(new Order("evaded", gianni, productList2));

//        Ex1
        orderByCustomerMethod(oredrList);
//        Ex2
        sumSortedByCustomer(oredrList);
//        Ex3
        onlyTheMostValueStuffMethod(productList2);
//        Ex4
        averagePrice(oredrList);
//        Ex5
        averagePricePerCategory(productList);




    }
    //methods



    public static void orderByCustomerMethod(List<Order> orderList){
        Map<Customer,List<Order>> orderByCustomer =orderList.stream().collect(Collectors.groupingBy(order -> order.getCustomer()));
        System.out.println("****************---esercizio 1---**********************");
        orderByCustomer.forEach((customer,orderlist)->System.out.println(customer+ " "+orderList));
    }

    public static void sumSortedByCustomer(List<Order> orderlist){
        System.out.println("****************---esercizio 2---********************** ");
        Map<Customer,Double> orderByCostumer = orderlist.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer(), Collectors.summingDouble(order->order.getTotal())));
        orderByCostumer.forEach((customer,priceSum)-> System.out.println("lcustomer somma dei prodotti di "+customer.getName()+" e' "+priceSum));
    }
    public static void onlyTheMostValueStuffMethod(List<Product> productlist){
        System.out.println("****************---esercizio 3---**********************");
        List<Product> orderedList2= productlist.stream().sorted(Comparator.comparing(product -> product.getPrice(),Comparator.reverseOrder())).limit(3).toList();
        orderedList2.forEach(elem->System.out.println(elem));
    }
    public static void averagePrice (List<Order> orderlist){
        System.out.println("****************---esercizio 4---**********************");
        double averagePrice = orderlist.stream().collect(Collectors.averagingDouble(order->order.getProdutcs().stream().collect(Collectors.averagingDouble(proudct->proudct.getPrice()))));
        System.out.println("la media degli importi dell'ordine e' "+averagePrice);
    }

    public static void averagePricePerCategory (List<Product> productlist){
        System.out.println("****************---esercizio 5---**********************");
        Map<String,List<Product>> sortedByCategory= productlist.stream().collect(Collectors.groupingBy(product -> product.getCategory()));
        sortedByCategory.forEach((category,order)->{
            System.out.println(category+ " media "+order.stream().collect(Collectors.summarizingDouble(value -> value.getPrice())).getAverage());
        });
    }
}
