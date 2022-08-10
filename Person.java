public class Person extends Thread implements Runnable
{
    private final String personName;
    private Operator desiredOperator;
    private boolean isSpeakHisRelative;


    public Person(String personName)
    {
        this.personName = personName;
        isSpeakHisRelative = false;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public void run() {
        while (!isSpeakHisRelative)
        {
            pickRandomOperator();
            connectConnection();
            speakToRelative();
            finishCallAndReturn();
        }
        System.out.printf("[%s] spoke his relative!\n", getPersonName());
        Program.persons.remove(this);

        if (Program.persons.size() == 0)
            Utils.printTotalRuntime();
    }

    private void waitSomeTimeBetween(int min, int max) //Puts thread to sleep between min and max milliseconds.
    {
        int waitTime = Utils.getRandomIntegerBetween(min, max);
        try
        {
            Thread.sleep(waitTime); //Wait for the size of the random generated int in milliseconds.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void pickRandomOperator()
    {
        desiredOperator = Utils.getRandomElementFromArrayList(Program.operators);
        System.out.printf("[%s] try to connect [%s]\n", getPersonName(), desiredOperator.getName());
    }

    private void connectConnection()
    {
        boolean connectionFound = false;

        while (!connectionFound)
        {
            Connection connection = Program.connection;
            connectionFound = connection.assignOperatorToHisRelative(this, desiredOperator);
            if (!connectionFound)
            {
                waitSomeTimeBetween(1000, 2500);
                System.out.printf("[%s] tried to talk to his relative but the connection was busy... \n", getPersonName());
            }
        }
    }

    private void speakToRelative()
    {
        System.out.printf("[%s] is speaking the his relative on [%s]...\n", getPersonName(), desiredOperator.getName());
        waitSomeTimeBetween(2500, 4000);
    }

    private void finishCallAndReturn()
    {
        System.out.printf("[%s] has finished speaking his/her relative on [%s] and the operator return back to for free!\n", getPersonName(), this.desiredOperator.getName());
        isSpeakHisRelative = true;
        desiredOperator.putBack();
    }
}
