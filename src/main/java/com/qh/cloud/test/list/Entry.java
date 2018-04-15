package com.qh.cloud.test.list;

/**
 * @Description 实体对象
 * @Date 2017年6月21日 下午4:49:43
 * @author QingHang
 * @version 1.0.0
 * @param <T>
 */
public class Entry<E> {

	E element;

	Entry<E> next;

	Entry<E> previous;

	public Entry() {

	}

	public Entry(E element) {
		this.element = element;
	}

	public Entry(Entry<E> next, Entry<E> previous) {
		super();
		this.next = next;
		this.previous = previous;
	}

	public Entry(E element, Entry<E> next, Entry<E> previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Entry<E> getNext() {
		return next;
	}

	public void setNext(Entry<E> next) {
		this.next = next;
	}

	public Entry<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Entry<E> previous) {
		this.previous = previous;
	}

}
