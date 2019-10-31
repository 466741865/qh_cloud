package com.qh.cloud.test.dataStructure;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : 单节点
 * @date : 2019/10/24 16:01
 **/
public class SingleNode {


    private String  value;

    private SingleNode next;

    public SingleNode() {
    }
    public SingleNode(String value) {
        this.value = value;
    }

    public SingleNode(String value, SingleNode next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}
