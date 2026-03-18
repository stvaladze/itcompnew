package com.itcomp.model.person;

import java.util.Objects;

public abstract class Person {

    private String name;
    private String email;
    private String phone;
    private String country;
    private String city;


    public Person() {
    }

    public Person(String name, String email, String phone, String country, String city) {
        setName(name);
        setEmail(email);
        setPhone(phone);
        setCountry(country);
        setCity(city);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Person{name='" + name +
                "', email='" + email +
                "', phone='" + phone + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}