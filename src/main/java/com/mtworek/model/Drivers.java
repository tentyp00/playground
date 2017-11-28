package com.mtworek.model;

import javax.persistence.*;
/**
 * Created by mikolaj on 28.11.17.
 */
@Entity
public class Drivers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRIVER_SEQ")
    @SequenceGenerator(sequenceName = "driver_seq", allocationSize = 1, name = "DRIVER_SEQ")
    @Column(name = "DRIVER_ID")
    private Long driverId;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "AGE")
    private int age;
    @Column(name = "AVG_FUEL_CONSUMPTION")
    private double avgFuelConsumption;

    public Drivers(){

    }
    public Drivers(String firstName, String lastName, int age, double avgFuelConsumption) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setAvgFuelConsumption(double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "driverId=" + driverId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", avgFuelConsumption=" + avgFuelConsumption +
                '}';
    }
}
