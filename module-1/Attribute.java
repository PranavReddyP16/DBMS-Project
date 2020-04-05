public class Attribute
{
    public bool isPrimaryKey = false;
    public void setKey(bool b)
    {
        this.isPrimaryKey = b;
    }

    public String name;
    public ArrayList<Attribute> functionalDependencies = new ArrayList<Attribute>();

    public void addFunctionalDependency(Attribute a)
    {
        functionalDependencies.add(a);
    }

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
