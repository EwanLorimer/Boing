//package com.example.boing;
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */
import java.util.NoSuchElementException;

public class Queue<T> {

	//TODO:  You need some data to store the queue.  Put the attributes here.
	private QueueElement<T> head;
	private QueueElement<T> tail;

	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
	    //TODO:  Needs to return true when empty and false otherwise
		if (this.head == null && this.tail == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		} else {
			return (T) this.head.getElement();
		}
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
	    //Dequeue code is needed here

		if (this.head == null) {
			this.tail = null;
			throw new NoSuchElementException("Queue is empty");
		} else {
			this.head = this.head.getNext();
			if (this.head == null) {
				this.tail = null;
			}
		}

	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
	    //Enqueue code is needed here
		QueueElement<T> newElement = new QueueElement<T>(element, null);
		if (this.tail == null) {
			this.head = newElement;
			this.tail = newElement;
		} else {
			this.tail.setNext(newElement);
			this.tail = newElement;

		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
	    //Code to print the code is needed here
		QueueElement<T> pointer = this.head;
		if (isEmpty()) {
			System.out.println("");
		} else {
			while (pointer != tail) {
				System.out.println(pointer.getElement());
				pointer = pointer.getNext();
			}
			System.out.println(pointer.getElement());

		}
	}
}
