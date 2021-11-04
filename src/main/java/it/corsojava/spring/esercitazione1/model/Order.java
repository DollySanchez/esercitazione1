package it.corsojava.spring.esercitazione1.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer code;
    private LocalDateTime orderDate;
    private LocalDateTime shippingDate;
    private List<Item> items ;
    private Integer totalPrice;
    private static int codeNumber=1;

    public Order() {
    }

    public Order(List<Item> items, Integer totalPrice) {
        this.code= codeNumber++;
        this.orderDate = LocalDateTime.now();
        this.shippingDate = LocalDateTime.now().plusDays(3);
        this.items = items;
        this.totalPrice = totalPrice;

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getOrderDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return orderDate.format(formatter);
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return shippingDate.format(formatter);
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "code=" + code +
                ", orderDate=" + orderDate +
                ", shippingDate=" + shippingDate +
                ", items=" + items.size() +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
