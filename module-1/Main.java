import java.util.ArrayList;
import java.util.Scanner;
import java.String;

public class Main
{
    public static void main(String args[])
    {
        ArrayList<Attribute> attributeArray = new ArrayList<Attribute>();
        
        System.out.println("Please enter the list of attribute names seperated by spaces followed by newline after all of the names have been entered : \n"); 
    
        public String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        String[] words = s.split("\\s+");
        public int numberOfAttributes = words.length;
        for(int i=0;i<numberOfAttributes;i++)
        {
            attributeArray.add(new Attribute(words[i]));
        }

    }
}
