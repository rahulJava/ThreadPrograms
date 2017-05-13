import java.util.HashMap;
import java.util.Map.Entry;


public class DuplicatCharacter
{
	public static void main(String[] args) {
		
		getDuplicateCharacter("Nitin");
		
	}
	
	public static void  getDuplicateCharacter(String word)
	{
		HashMap<Character, Integer> char1 = new HashMap<>();
		char [] chars = word.toCharArray();
		for(Character c:chars)
		{
			if(char1.containsKey(c))
			{
				char1.put(c,char1.get(c)+1);
			}
			else
			{
				char1.put(c, 1);
			}
			
		}
		for (Character char2:chars) {
			if(char1.get(char2)>1)
			{
				System.out.println(char2);
			}
			
		}
		
		
	}
	

}
