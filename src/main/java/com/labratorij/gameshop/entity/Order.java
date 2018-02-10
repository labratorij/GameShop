package com.labratorij.gameshop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order", schema = "gameshop_eng")
public class Order {

    @Id
    @GenericGenerator(name = "inc", strategy = "increment")
    @GeneratedValue(generator = "inc")
    @Column(name = "Number of order")
    private  int numberOfOrder;

    @Column(name = "Date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employee number")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Number of card")
    private Client client;

    public Order() {
    }

    public Order(Date date, Employee employee, Client client) {
        this.date = date;
        this.employee = employee;
        this.client = client;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (numberOfOrder != order.numberOfOrder) return false;
        if (!date.equals(order.date)) return false;
        if (!employee.equals(order.employee)) return false;
        return client.equals(order.client);
    }

    @Override
    public int hashCode() {
        int result = numberOfOrder;
        result = 31 * result + date.hashCode();
        result = 31 * result + employee.hashCode();
        result = 31 * result + client.hashCode();
        return result;
    }
}
