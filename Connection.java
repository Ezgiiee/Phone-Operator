public class Connection
{
    private boolean busy;

    public boolean assignOperatorToHisRelative(Person person, Operator operator)
    {
        if (!busy)
        {
            busy = true;
            if (!operator.hasOwner())
            {
                operator.take(person);
                System.out.printf("[%s] managed to find a free connection and connection have been given the [%s]!\n", person.getPersonName(), operator.getName());
                busy = false;
                return true;
            }
            else
            {
                System.out.printf("[%s] managed to find a free connection but the connection was in use by [%s]!\n",person.getPersonName(), operator.getName(), operator.getOwner().getPersonName());
                busy = false;
                return false;
            }
        }
        return false;
    }
}
