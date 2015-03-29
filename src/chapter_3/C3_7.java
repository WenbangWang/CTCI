package chapter_3;

import java.util.LinkedList;

import animal.*;

public class C3_7 {
	
	private LinkedList<Dog> dogs;
	private LinkedList<Cat> cats;
	private int order;
	
	public C3_7()
	{
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
		order = 0;
	}
	
	public void enqueue(Animal a)
	{
		a.setOrder(order);
		order++;
		if(a instanceof Dog)
			dogs.addLast((Dog) a);
		else if(a instanceof Cat)
			cats.addLast((Cat) a);
	}
	
	public Animal dequeueAny()
	{
		if(dogs.size()==0&&cats.size()==0)
			return null;
		else if(dogs.size()==0)
			return cats.poll();
		else if(cats.size()==0)
			return dogs.poll();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if(dog.isOlderThan(cat))
			return dogs.poll();
		else if(cat.isOlderThan(dog))
			return cats.poll();
		return null;
	}
	
	public Animal dequeueDog()
	{
		return dogs.poll();
	}
	
	public Animal dequeueCat()
	{
		return cats.poll();
	}
}
