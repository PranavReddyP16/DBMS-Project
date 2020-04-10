import java.util.*;

public class NormalForm
{
    public int NF = 1;

    public NormalForm(HashSet<String> keys, FindKey FK)
    {
        for(String i : FK.leftHandSide)
        {
            for(String j : keys)
            {
                if(Main.checkSubstring(j,i))
                {
                    return;
                }
            }
        }

        int flag=0;
        for(Map.Entry<HashSet<String>,HashSet<String>> entry : FK.fdMap.entrySet())
        {
            String lhs = "";
            String rhs = "";
            for(String s : entry.getKey())
            {
                lhs.concat(s);
            }
            for(String s : entry.getValue())
            {
                rhs.concat(s);
            }

            if(isSuperKey(lhs,keys)==false&&isPrimeAttribute(rhs,keys)==false)
            {
                this.NF = 2;
                flag=1;
                break;
            }

        }
        if(flag==1) return;

        flag=0;
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
        for(String j : keys)
        {
            if(Main.checkSubstring(i,j)==true)
            {
                flag1=1;
                break;
            }
        }
        if(flag1==0)
        {
            return false;
        }
        else
        {
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
