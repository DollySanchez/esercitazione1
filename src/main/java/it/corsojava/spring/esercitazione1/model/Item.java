package it.corsojava.spring.esercitazione1.model;

public class Item {
    private Integer code;
    private String name;
    private Float prize;

    public Item() {
    }

    public Item(Integer code, String name, Float prize) {
        this.code = code;
        this.name = name;
        this.prize = prize;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrize() {
        return prize;
    }

    public void setPrize(Float prize) {
        this.prize = prize;
    }




}
