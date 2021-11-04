package it.corsojava.spring.esercitazione1.controller;

import it.corsojava.spring.esercitazione1.model.FormData;
import it.corsojava.spring.esercitazione1.model.Item;
import it.corsojava.spring.esercitazione1.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CarrelloController {
    List<Item> items = generateItems();
    private List<Item> generateItems(){
        List<Item> items =new ArrayList<>();
        Item i1 = new Item(1,"TV Samsung",333F);
        Item i2 = new Item(2,"Macbook APPLE",1088F);
        Item i3 = new Item(3,"Lavatrici Whirpool",449F);
        Item i4 = new Item(4,"Aspirapolvere IROBOT",549F);
        Item i5 = new Item(5,"Smartphone APPLE iPhone 12",869F);
        Collections.addAll(items,i1,i2,i3,i4,i5);
        return items;
    }
    List<Item> carrello= new ArrayList<>();
    static List<Order> ordini = new ArrayList<>();

    @GetMapping("/carrello")
    public String carrello(Model model){
        model.addAttribute("lista",items);
        model.addAttribute("formData", new FormData());
        model.addAttribute("carrello",carrello);
        model.addAttribute("currentTotal", getCurrentTotal(carrello));
        return "carrello";
    }
    @PostMapping("/add_item")
    public String addItem(@ModelAttribute FormData formData, Model model){
        carrello.add(items.get(Integer.parseInt(formData.getItemCode())-1));

        model.addAttribute("lista",items);
        model.addAttribute("formData", new FormData());
        model.addAttribute("carrello",carrello);
        model.addAttribute("currentTotal", getCurrentTotal(carrello));

        return "carrello";
    }
    public static int getCurrentTotal(List<Item> carrello){
        int sum=0;
        for (Item i:carrello){
            sum+=i.getPrize();
        }
        return sum;
    }


    @GetMapping("/newOrder")
    public String newOrder(Model model){
        Order ordine = new Order(carrello,getCurrentTotal(carrello));
        ordini.add(ordine);
        model.addAttribute("ordini",ordini);
        model.addAttribute("currentOrdiniPrice",currentOrdiniPrice(ordini));
        carrello=new ArrayList<>();
        System.out.println(ordine);
        System.out.println("Carrello vuoto?"+carrello.isEmpty());
        System.out.println("Ordini vuoto?"+ordini.isEmpty());
        return "ordini";
    }
    private static int currentOrdiniPrice(List<Order> ordini){
        int sum=0;
        for(Order o:ordini){
            sum+=o.getTotalPrice();
        }
        return sum;
    }


    @GetMapping("/ordini")
    public String ordini(Model model){
        model.addAttribute("ordini",ordini);
        model.addAttribute("currentOrdiniPrice",currentOrdiniPrice(ordini));
        return "ordini";
    }









}
