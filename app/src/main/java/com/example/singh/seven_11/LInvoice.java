package com.example.singh.seven_11;

/**
 * Created by Singh on 12/27/2014.
 */
public class LInvoice
{
    int id;
    String name;
    double retail;
    double cost;

    public LInvoice()   {}
    public  LInvoice(int id, String name, double retail, double cost) {
        this.id = id;
        this.name = name;
        this.retail = retail;
        this.cost = cost;
    }
    public  LInvoice(String name, double retail, double cost) {
        this.name = name;
        this.retail = retail;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRetail() {
        return retail;
    }

    public void setRetail(Double retail) {
        this.retail = retail;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
