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
        List<Customer> customerList = new ArrayList<>();
        List<Order> oredrList = new ArrayList<>();

        productList.add(new Product("harry potter e la pietra filosofale", "Books", 120));
        productList.add(new Product("Halo Reach", "Books", 80));
        productList.add(new Product("toys", "Baby", 140));
        productList2.add(new Product("XboxSerieX", "Boys", 2000));
        productList2.add(new Product("playstation", "Boys", 500));
        productList2.add(new Product("biberon", "Baby", 15));
        productList2.add(new Product("gaming pc", "Boys", 2000));

        Customer mario = new Customer("Mario", 2);
        Customer paolo = new Customer("Paolo", 1);
        Customer gianni = new Customer("Gianni", 2);
        Customer maria = new Customer("Maria", 5);

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
//        Map<Customer,Integer> orderByCOstumer1 = oredrList.stream().collect(Collectors.groupingBy(order ->Collectors.summarizingInt(order.getProdutcs().stream().map(a->a.getPrice()).reduce())
//        Map<Customer,Integer> sumByCustomerProductList= orderByCOstumer1.stream().
//        productList2.forEach(elem->System.out.println(elem));
//        Ex3
        onlyTheMostValueStuffMethod(productList2);
    }
    //methods



    public static void orderByCustomerMethod(List<Order> orderList){
        Map<Customer,List<Order>> orderByCustomer =orderList.stream().collect(Collectors.groupingBy(order -> order.getCustomer()));
        System.out.println("esercizio 1 ");
        orderByCustomer.forEach((customer,orderlist)->System.out.println(customer+ " "+orderList));
    }
    public static void onlyTheMostValueStuffMethod(List<Product> productlist){
        System.out.println("esercizio 3 ");
        List<Product> orderedList2= productlist.stream().sorted(Comparator.comparing(product -> product.getPrice(),Comparator.reverseOrder())).limit(3).toList();
        orderedList2.forEach(elem->System.out.println(elem));
    }
}
