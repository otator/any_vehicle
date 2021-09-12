package com.example.AnyVehicle.model;

import javax.persistence.*;

@Entity(name="requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // car company (ex: mercedes)
    private String carManufacturer;
    // car model (ex: S500)
    private String carModel;
    // car number
    private String carNumber;
    // diesel, electrical, or hybrid
    private String carType;

    // A description of what maintenance the car needs.
    private String maintenanceDescription;

    @ManyToOne
    private UserApplication user;

    // empty constructor for the framework
    public Request(){

    }

    public Request(String carManufacturer, String carModel, String carNumber, String carType, UserApplication user){
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.carType = carType;
        this.user = user;
    }

    public long getId() {
        return id;
    }


    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

    public UserApplication getUser() {
        return user;
    }

    public void setUser(UserApplication user) {
        this.user = user;
    }
}
