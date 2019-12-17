package com.qh.cloud.test.dataStructure.tree.rbtree;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/9/11 9:35
 **/
public class RBTree {

    private Node<String ,String> root;


    public static void main(String[] args) {
        Node<String ,String>  node = new Node();
    }


    /**
     * 左旋
     * @param node
     */
    private void leftRotate(Node node){

        //设置node的右孩子 为r
        Node r = node.getRight();
        //将 r的左孩子 设为 node的 右孩子，（即：将节点 的 右孩子的左孩子设为当前节点的右孩子）
        node.setRight(r.getLeft());
        if(r.getLeft() != null){
            r.getLeft().setParent(node);
        }


    }

    /**
     * 右旋
     * @param node
     */
    private void rightRotate(Node node){




    }



}
