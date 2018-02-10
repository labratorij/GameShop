package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee", schema = "gameshop_eng")
public class Employee {

    @Id
    @GenericGenerator(name = "inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Employee number")
    private int id;

    @Column(name = "Name", length = 64, nullable = false, unique = true)
    private String name;

    @Column(name = "Passport", length = 10)
    private int passport;

    @Column(name = "Adress", length = 128, nullable = false)
    private String adress;

    @Column(name = "Telephone")
    private int telephone;

    @OneToMany(mappedBy = "employee")
    private List<Order> orderList = new ArrayList<Order>();

    public Employee() {
    }

    public Employee(String name, int passport, String adress, int telephone) {
        this.name = name;
        this.passport = passport;
        this.adress = adress;
        this.telephone = telephone;
    }

    public Employee(String name, int passport, String adress, int telephone, List<Order> orderList) {
        this.name = name;
        this.passport = passport;
        this.adress = adress;
        this.telephone = telephone;
        this.orderList = orderList;
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

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (passport != employee.passport) return false;
        if (telephone != employee.telephone) return false;
        if (!name.equals(employee.name)) return false;
        if (!adress.equals(employee.adress)) return false;
        return orderList != null ? orderList.equals(employee.orderList) : employee.orderList == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + passport;
        result = 31 * result + adress.hashCode();
        result = 31 * result + telephone;
        result = 31 * result + (orderList != null ? orderList.hashCode() : 0);
        return result;
    }
}
