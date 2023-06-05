package controllers;

public class Car {
    private String make;
    private String model;
    private String price;
    private String color;
    private String mileage;
    private String year;
    private byte[] image;
    private String image1;
    private String image2;

    public Car(String make, String model, String price, String color, String mileage, byte[] image) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.color = color;
        this.mileage = mileage;
        this.image = image;
    }

    public String getmake() {
        return make;
    }

    public String getmodel() {
        return model;
    }

    public String getprice() {
        return price;
    }

    public String getcolor() {
        return color;
    }

    public String getmileage() {
        return mileage;
    }

    public byte[] getimage() {
        return image;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
}