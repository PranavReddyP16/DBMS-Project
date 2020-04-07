import java.util.*;

public class Attribute
{
    public boolean isPrimaryKey = false;
    public void setKey(boolean b)
    {
        this.isPrimaryKey = b;
    }

    public String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public Attribute(String name)
    {
        setName(name);
    }
}
