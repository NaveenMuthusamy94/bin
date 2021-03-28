public class car {
private String make;
private String model;
private int mileage;
private int year;
private float price;
public car(String make, String model, int mileage, int year, float price) {
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
public float getPrice() {
    return price;
}
public String toString() {
    return "Make:"+getMake()+"\nModel:"+getModel()+"\nMileage:"+getMileage()+"\nYear:"+getYear()+"\nPrice:"+getPrice();
}
}