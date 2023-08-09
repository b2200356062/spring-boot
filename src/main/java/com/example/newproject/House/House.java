package com.example.newproject.House;

import jakarta.persistence.*;

@Entity
@Table(name = "house")
public class House{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "location")
    private String location;
    @Column(name = "yatak_sayisi")
    private int yatak_sayisi;
    @Column(name = "metrekare")
    private int metrekare;
    @Column(name = "banyo_sayisi")
    private int banyo_sayisi;
    @Column(name = "description")
    private String description;
    @Column(name="imagePath")
    private String imagePath;

    public House(){}

    public House(Long id, String name, int price, String location, int yatak_sayisi, int metrekare, int banyo_sayisi, String description, String imagePath) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.id = id;
        this.banyo_sayisi = banyo_sayisi;
        this.yatak_sayisi = yatak_sayisi;
        this.metrekare = metrekare;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYatak_sayisi() {
        return yatak_sayisi;
    }

    public void setYatak_sayisi(int yatak_sayisi) {
        this.yatak_sayisi = yatak_sayisi;
    }

    public int getMetrekare() {
        return metrekare;
    }

    public void setMetrekare(int metrekare) {
        this.metrekare = metrekare;
    }

    public int getBanyo_sayisi() {
        return banyo_sayisi;
    }

    public void setBanyo_sayisi(int banyo_sayisi) {
        this.banyo_sayisi = banyo_sayisi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "ID: " + id + "\n" + "Price: " + price + "\n" +  "Location: " + location;
    }
}
