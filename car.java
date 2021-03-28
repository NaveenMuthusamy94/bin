public class car {
private String make;
private String model;
private int mileage;
private int year;
private int price;
public car(String make, String model, int mileage, int year, int price) {
    this.make = make;
    this.model = model;
    this.mileage = mileage;
    this.year = year;
    this.price = price;
} 
public String getMake() {
    return make;
}
public String getModel() {
    return model;
}
public int getMileage() {
    return mileage;
}
public int getYear() {
    return year;
}
public int getPrice() {
    return price;
}
public String toString() {
    return "Make:"+getMake()+"\nModel:"+getModel()+"\nMileage:"+getMileage()+"\nYear:"+getYear()+"\nPrice:"+getPrice();
}
}