package com.qh.cloud.test.dataStructure.linked;

import com.qh.cloud.test.dataStructure.SingleNode;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/10/24 15:47
 **/
public class SingleLinkedTest {


    public static void main(String[] args) {


        System.out.println("==================================链表反转");
        SingleNode head = new SingleNode("1");
        SingleNode next2 = new SingleNode("2");
        SingleNode next3 = new SingleNode("3");
        SingleNode next4 = new SingleNode("4");
        SingleNode next5 = new SingleNode("5");
        next4.setNext(next5);
        next3.setNext(next4);
        next2.setNext(next3);
        head.setNext(next2);
        System.out.print("初始化链表：");
        show(head);
        //链表反转：

        SingleNode reversalLink = reversal(head);
        System.out.print("反转后的链表：");
        show(reversalLink);


        System.out.println("==================================链表合并");
        //连1
        SingleNode link1 = new SingleNode("1");
        SingleNode node3 = new SingleNode("3");
        SingleNode node5 = new SingleNode("4");
        SingleNode node7 = new SingleNode("7");
        SingleNode node9 = new SingleNode("9");
        node7.setNext(node9);
        node5.setNext(node7);
        node3.setNext(node5);
        link1.setNext(node3);

        //连2
        SingleNode link2 = new SingleNode("2");
        SingleNode node4 = new SingleNode("5");
        SingleNode node6 = new SingleNode("6");
        SingleNode node8 = new SingleNode("8");
        node6.setNext(node8);
        node4.setNext(node6);
        link2.setNext(node4);

        System.out.print("初始化链表1：");
        show(link1);
        System.out.print("初始化链表2：");
        show(link2);
        SingleNode merge = merge(link1,link2);
        System.out.print("链表合并：");
        show(merge);


        System.out.println("==================================删除倒数第n个节点：");
        SingleNode h = new SingleNode("1");
        SingleNode n2 = new SingleNode("2");
        SingleNode n3 = new SingleNode("3");
        SingleNode n4 = new SingleNode("4");
        SingleNode n5 = new SingleNode("5");
        n4.setNext(n5);
        n3.setNext(n4);
        n2.setNext(n3);
        h.setNext(n2);
        System.out.print("删除链表倒数第n个节点：");
        show(h);
        SingleNode dd = deleteLastN(h,2);
        System.out.print("删除倒数第n个节点：");
        show(dd);



        System.out.println("==================================获取链表的中间节点：");
        SingleNode hh = new SingleNode("1");
        SingleNode nn2 = new SingleNode("2");
        SingleNode nn3 = new SingleNode("3");
        SingleNode nn4 = new SingleNode("4");
        SingleNode nn5 = new SingleNode("5");
        SingleNode nn6 = new SingleNode("6");
        nn4.setNext(nn5);
        nn3.setNext(nn4);
        nn2.setNext(nn3);
        hh.setNext(nn2);
        System.out.print("获取链表的中间节点：");
        show(hh);
        SingleNode cn =  getCentreNode(hh);
        System.out.print("获取链表的中间节点："+cn.getValue());


    }


    /**
     * 检测是否是回文串
     * 核心思想：使用快慢指针，快指针一步走两格，慢指针一步一格（并且将慢指针所路过的链反转），当快指针到尾部时，慢指针的位置是中间位置，
     * 最终得到两格子串，再比较两个子串是否相等。
     * @param head
     * @return
     */
    public static Boolean isPlalindromeString(SingleNode head){

        return null;
    }



    /**
     * 检测是否是环型
     * 核心思想：使用快慢指针，快指针一次走两格，慢指针一步一格，若像个指针相遇，则表示有环，若快指针出现null则表示无环。
     * @param head
     * @return
     */
    public static SingleNode isChechLoop(SingleNode head){

        return null;
    }



    /**
     * 获取链表的中间节点，
     * 核心思想：使用快慢指针，快指针一步走两格，慢指针一步走一格，快指针走到尾节点时，慢指针的即为中间节点。
     * @param head
     * @return
     */
    public static  SingleNode getCentreNode(SingleNode head ){

        if(head == null || head.getNext() == null || head.getNext().getNext() == null){
            return head;
        }
        //快指针
        SingleNode front = head.getNext().getNext();
        //慢指针
        SingleNode rear = head;

        while (front != null){

            rear = rear.getNext();
            if(front.getNext() == null){
                break;
            }
            if(front.getNext().getNext() == null){
                break;
            }
            front = front.getNext().getNext();

        }

        System.out.println("----链表的中间节点是："+rear.getValue());
        return rear;
    }



    /**
     * 删除倒数第n个节点
     * 核心思想：使用先后指针，两指针同时指向头结点，先指针先走n步，然后两个指针再同时走，当先指针走到尾节点，则后指针的位置即为删除的节点。
     * @param head
     * @param n
     * @return
     */
    public static SingleNode deleteLastN(SingleNode head ,int n){
        if(head == null || head.getNext() == null || n < 0){
            return head;
        }

        //快指针
        SingleNode front = head;
        //慢指针
        SingleNode rear = head;
        //快指针先走
        for(int i = 0 ;i < n ;i++){
            front = front.getNext();
        }
        System.out.println("----当前快指针的节点是："+front.getValue());
        //
        while (front.getNext() != null){
            front = front.getNext();
            rear = rear.getNext();
        }

        System.out.println("----要删除的节点的父节点是："+rear.getValue());

        rear.setNext(rear.getNext().getNext());
        rear.getNext().setNext(null);
        return head;
    }



    /**
     *  合并有序链表
     *  核心思想：双层循环，外层同时遍历两个链表，
     *  判断两个链表的指针值大小，1 >= 2 ： 则遍历2和1的指针值比较，直到1、2两个指针值相等，跳出当前内层循环。
     *                         1 < 2 ：遍历1和2的指针值比较，直到1、2两个指针值相等，跳出当前内层循环。
     * @param head1
     * @param head2
     * @return
     */
    public static SingleNode merge(SingleNode head1,SingleNode head2){
        SingleNode link = new SingleNode("top");
        SingleNode newHead = link;

         while(head1 != null && head2 != null){

             if(head1.getValue().compareTo(head2.getValue()) <= 0){
                while (head1 != null &&(head1.getValue().compareTo(head2.getValue()) <= 0)){
                    newHead.setNext(head1);
                    newHead = newHead.getNext();
                    head1 = head1.getNext();
                }
             }else{
                 while (head2 != null &&( head1.getValue().compareTo(head2.getValue()) > 0 )){
                     newHead.setNext(head2);
                     newHead = head2;
                     head2 = head2.getNext();
                 }
             }

             if(head1 != null){
                 newHead.setNext(head1);
             }
             if(head2 != null){
                 newHead.setNext(head2);
             }
         }
        return link.getNext();
    }





    /**
     * 单链表反转
     * 核心思想：使用临时节点存储，遍历原链表，逐个取出。
     * @param head
     * @return
     */
    public static SingleNode reversal(SingleNode head){

        if(head == null || head.getNext() == null){
            return head;
        }
        //临时节点
        SingleNode tmp = null;
        //头结点
        SingleNode newHead =head;
        //下一个节点
        SingleNode next = head.getNext();

        while (next != null){
            //将临时节点设置为头结点的next节点，（第一次循环，可认为设置节点的next = null）
            newHead.setNext(tmp);
            //将头结点给 临时节点
            tmp = newHead;
            // 将下一个节点 设为头结点（即：当前循环的next节点为下一轮循环时的头结点）
            newHead = next;
            //将next的next节点 设为next节点（即：当前循环的next的next节点，为下一轮循环的next节点）
            next = next.getNext();
        }
        //原链表的尾结点的next为空，so 循环中不会将 tmp节点放到头结点中，
        newHead.setNext(tmp);
        return newHead;
    }


    /**
     * 节点的遍历输出
     * @param head
     */
    public static void show(SingleNode head){

        if(head == null ){
            System.out.println("[]");
            return;
        }
        if( head.getNext() == null){
            System.out.println("["+head.getValue() +"]");
            return;
        }
        SingleNode nextNode = head.getNext();
        System.out.print("[");
        System.out.print(head.getValue()+",");
        while(nextNode != null){
            System.out.print(nextNode.getValue());
            if(nextNode.getNext() != null){
                System.out.print(",");
            }
            nextNode = nextNode.getNext();
        }
        System.out.println("]");
        return;
    }




}
