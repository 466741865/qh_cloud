package com.qh.cloud.test.arithmetic.binarytree;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/6/26 22:13
 **/
public class Node {

    //数据
    private int date;

    //描述
    private String des;

    //左节点
    private Node leftNode;

    //右节点
    private Node righeNode;

    public Node(int date) {
        this.date = date;
        this.leftNode = null;
        this.righeNode = null;

    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRigheNode() {
        return righeNode;
    }

    public void setRigheNode(Node righeNode) {
        this.righeNode = righeNode;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                ", des='" + des + '\'' +
                ", leftNode=" + leftNode +
                ", righeNode=" + righeNode +
                '}';
    }
}
