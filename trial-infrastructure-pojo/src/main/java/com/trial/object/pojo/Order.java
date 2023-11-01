package com.trial.object.pojo;

/**
 * @description: 订单
 * @author: Mr.Luo
 * @create: 2023-11-01 16:12
 **/
public class Order {

    private Long orderId;

    private String name;

    private Integer sum;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Order(Long orderId, String name, Integer sum) {
        this.orderId = orderId;
        this.name = name;
        this.sum = sum;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
