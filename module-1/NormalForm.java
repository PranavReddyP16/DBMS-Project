import java.util.*;

public class NormalForm
{
    public int NF = 1;

    public NormalForm(HashSet<String> keys, FindKey FK)
    {
        for(String i : FK.leftHandSide)
        {
            //System.out.println("lhs : "+i);
            for(String j : keys)
            {
                //System.out.println("key : "+j);
                if(Main.checkSubstr(j,i))
                {
                    return;
                }
            }
        }

        for(Map.Entry<String, String> entry : FK.functionalDependencyMap.entrySet())
        {

            if(isSuperKey(entry.getKey(),keys)==false&&isPrimeAttribute(entry.getValue(),keys)==false)
            {
                this.NF = 2;
                return;
            }

        }

        int flag=0;
        for(String i : FK.leftHandSide)
        {
            if(isSuperKey(i,keys)==false)
            {
                flag=1;
                NF = 3;
                break;
            }
        }
        if(flag==1) return;
        else
        {
            NF = 4;
            return;
        }
    }

    public boolean isSuperKey(String i,HashSet<String> keys)
    {
        int flag1=0;
        //System.out.println("i "+i);
        for(String j : keys)
        {
            //System.out.println("j "+j);
            if(Main.checkSubstring(i,j)==true)
            {
                flag1=1;
                break;
            }
        }
        if(flag1==0)
        {
            //System.out.println("return false from superkey");
            return false;
        }
        else
        {
            //System.out.println("return true from superkey");
            return true;
        }
    }

    public boolean isPrimeAttribute(String i, HashSet<String> keys)
    {
        int flag1=0;
        for(char j : i.toCharArray())
        {
            int flag2=0;
            for(String k : keys)
            {
                if(Main.checkSubstring(k,Character.toString(j))==true) 
                {
                    flag2=1;
                    break;
                }
            }
            if(flag2==0)
            {
                flag1=1;
                break;
            }
        }
        if(flag1==1) return false;
        else return true;
    }

    public void printNormalForm(NormalForm NF)
    {
        System.out.println("The highest Normal Form for this database model is : " + NF.NF);
    }
}
