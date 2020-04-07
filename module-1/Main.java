import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main 
{

    public static void f(String prefix, String chars, ArrayList<String> result) 
    {
        for (int i = 0; i < chars.length(); i++) 
        {
            result.add(prefix + chars.charAt(i));
            f(prefix + chars.charAt(i), chars.substring(i + 1), result);
        }
    }

    public static ArrayList<String> getCombinations(ArrayList<Attribute> attributes) 
    {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> chars = new ArrayList<String>();
        for(int i=0;i<chars.size();i++)
        {
            chars.add(attributes.get(i).name);
        }
        String str = new String();
        for (String c : chars) 
        {
            str = str + c;
        }
        Main.f("", str, result);
        return result;
    }

    public static HashSet<String> closure(HashSet<String> attributes, Map<HashSet<String>, HashSet<String>> dependencies) 
    {
        HashSet<String> closureSet = new HashSet<String>(attributes);

        for (Entry<HashSet<String>, HashSet<String>> dependency : dependencies.entrySet()) 
        {
            if (closureSet.containsAll(dependency.getKey()) && !closureSet.containsAll(dependency.getValue())) 
            {
                closureSet.addAll(dependency.getValue());
            }
        }
        return closureSet;
    }

    public static void main(String[] args) 
    {
        try 
        {

            FindKey FK = new FindKey();
            Scanner commandLine = new Scanner(System.in);
            System.out.println("======> Key Finder Project <======");

            do 
            {
                System.out.print("Enter the attributes as: A,B,... or Type Exit ");
                String attributes = commandLine.next();
                if (attributes.equalsIgnoreCase("exit")) 
                {
                    break;
                }
                FK.addAttributes(attributes);

                System.out.print("Enter the FDs as: A->B,AC->B,... or Type Exit ");
                String fd = commandLine.next();
                if (fd.equalsIgnoreCase("exit")) 
                {
                    break;
                }

                FK.addFD(fd);
                System.out.println(" \n\n ==> The candidate keys are: " + FK.getCandidateKeys() + "\n\n");

                FK = new FindKey();

            } while (true);
        } 

        catch (Exception E) 
        {
            System.out.println(" Something went wrong, please check your input, here is the Exception:");
            E.printStackTrace();
        }
    }
}
