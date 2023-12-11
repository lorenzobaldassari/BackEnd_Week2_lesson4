package Day4.Entitites;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Order {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Customer customer;
    private List<Product> produtcs;


    public Order(String status, Customer customer, List<Product> produtcs) {
        Random rnd= new Random();
        Long num= rnd.nextLong(1000,9999);
        this.id = num;
        this.status = status;
        this.orderDate =LocalDate.now() ;
        this.deliveryDate = LocalDate.now().plusDays(3);
        this.customer = customer;
        this.produtcs = produtcs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProdutcs() {
        return produtcs;
    }

    public void setProdutcs(List<Product> produtcs) {
        this.produtcs = produtcs;
    }

    public double getTotal(){
        return this.produtcs.stream().collect(Collectors.summingDouble(a->a.getPrice()));
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", customer=" + customer +
                ", produtcs=" + produtcs +
                '}';
    }
}
