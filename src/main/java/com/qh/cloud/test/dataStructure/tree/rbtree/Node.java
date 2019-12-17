package com.qh.cloud.test.dataStructure.tree.rbtree;


import java.awt.*;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/9/11 9:37
 **/
public class  Node<K extends Comparable<K>,V extends Comparable<V>> {

    /**
     * key
     */
    private K key;

    /**
     * 值
     */
    private V  value;

    /**
     * 颜色， 红 或  黑
     */
    private Color color;

    /**
     * 左孩子节点
     */
    private Node left;

    /**
     * 右孩子节点
     */
    private Node right;

    /**
     * 父节点
     */
    private Node parent;

    public Node() {
    }

    public Node(K key) {
        this.key = key;
        this.color = Color.RED;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", color=" + color +
                ", left=" + left +
                ", right=" + right +
                ", parent=" + parent +
                '}';
    }
}
