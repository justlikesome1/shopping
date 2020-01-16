package com.woniuxy.exercises;

public class Zhan<E> {


	private int size=10;
	 
	private Object container[];
	private int count;
	
	public Zhan() {
		// TODO Auto-generated constructor stub
		
		container=new Object[size];
		
	}
	
	public Zhan(int size) {
		// TODO Auto-generated constructor stub
		this.size=size;
		container=new Object[size];
		
	}
	
	
	public void add(E element){
		
		
		container[count]=element;
		count++;
	}
	
	
	public E get(int index){
		
		return (E)container[index];
		
	}
	
	public int getCount() {
		return count;
	}
	
}
