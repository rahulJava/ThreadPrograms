package DS;

public class App {
	public static void main(String[] args) {
		Stack  theStack = new Stack(3);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);
		while(!theStack.isEmpty())
		{
			long dat= theStack.pop();
			System.out.println(dat);
		}
	}
	

}
