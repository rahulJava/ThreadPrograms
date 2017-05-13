package Thread;

public class C {
	public static void main(String[] args) {
		E e1 = new E();
		D d1 = new D(e1,"Dhoni");
		D d2 = new D(e1,"Yuvraj");
		d1.start();
		d2.start();
		
		
	}

}
class D extends Thread
{
	E e1 ;
	String name;
	D(E e1 ,String name)
	{
		this.e1=e1;
		this.name=name;
	}
	public  synchronized void run()
	{
		e1.print(name);
		
	}
}
class E
{
	public  synchronized void print(String name)
	{
		for(int i=0;i<10;i++)
		{
		System.out.print("Good Morning");
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e)
		{
			
		}System.out.println(name);
		}
	}
}
