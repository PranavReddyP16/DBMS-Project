import java.util.*;

public class NormalForm
{
    public int NF = 1;
    HashMap <HashMap<String, String>, Integer> individualNormalForms = new HashMap<HashMap<String, String>, Integer>();

    public NormalForm(HashSet<String> keys, FindKey FK)
    {
        for(HashMap.Entry<String, String> entry : FK.functionalDependencyMap.entrySet())
        {
            HashMap<String, String> currentFunctionalDependency = new HashMap<String, String>();
            currentFunctionalDependency.put(entry.getKey(), entry.getKey());
            individualNormalForms.put(currentFunctionalDependency, 1);
            int flag=0;
            for(String j : keys)
            {
                if(!isPrimeAttribute(entry.getValue(), keys) && Main.checkIncompleteSubstring(j,entry.getKey()))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                continue;
            if(isSuperKey(entry.getKey(),keys)==false&&isPrimeAttribute(entry.getValue(),keys)==false)
            {
                individualNormalForms.replace(currentFunctionalDependency,2);
                continue;
            }
            if(isSuperKey(entry.getKey(),keys)==false)
            {
                individualNormalForms.replace(currentFunctionalDependency,3);
                continue;
            }
            individualNormalForms.replace(currentFunctionalDependency,4);
            /*int flag=0;
            for(char i : entry.getKey().toCharArray())
            {
                if(isSuperKey(Character.toString(i),keys)==false)
                {
                    flag=1;
                    individualNormalForms.replace(currentFunctionalDependency,3);
                    break;
                }
            }
            if(flag==1) return;
            else
            {
                individualNormalForms.replace(currentFunctionalDependency,4);
                return;
            }*/
        }

        int totalMinimumFD = 4;
        ArrayList<HashMap<String, String>> minimumFDs = new ArrayList<HashMap<String, String>>();

        for(HashMap.Entry<HashMap<String, String>, Integer> entry : individualNormalForms.entrySet())
        {
            if(entry.getValue() < totalMinimumFD) totalMinimumFD = entry.getValue();
        }

        for(HashMap.Entry<HashMap<String, String>, Integer> entry : individualNormalForms.entrySet())
        {
            if(entry.getValue()==totalMinimumFD) minimumFDs.add(entry.getKey());
        }

        this.NF = totalMinimumFD;

        System.out.println("Create new tables with the following functional dependencies : \n");
        for(HashMap<String, String> i : minimumFDs)
        {
            for(HashMap.Entry<String, String> entry : i.entrySet())
            {
                String lhs,rhs;
                rhs = "";
                lhs = entry.getKey();
                for(char j : entry.getValue().toCharArray())
                {
                    if(isPrimeAttribute(String.valueOf(j),keys)) rhs += String.valueOf(j);
                }

                System.out.println(lhs + "->" + rhs + "\n");
            }
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
