public class Operator
{
    private final String name;
    private boolean borrowed;
    private Person owner;

    public String getName()
    {
        return name;
    }

    public Operator(String name)
    {
        this.name = name;
        this.borrowed = false;
        this.owner = null;
    }

    public void take(Person owner)
    {
        this.borrowed = true;
        this.owner = owner;
    }

    public void putBack()
    {
        this.borrowed = false;
        this.owner = null;
    }

    public Person getOwner()
    {
        return this.owner;
    }

    public boolean hasOwner()
    {
        return borrowed;
    }
}
