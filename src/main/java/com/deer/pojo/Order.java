package com.deer.pojo;

import java.util.Date;

/**
 * @author: 86175
 * @date: 2021/12/2 19:43
 * @description:
 */
public class Order {
    private Long orderId;
    private String remark;
    private String orderNo;
    private String cost;
    private Date createTime;
    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", remark='" + remark + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", cost='" + cost + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                '}';
    }
}
