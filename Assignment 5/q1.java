public class q1 extends Thread
{
    public static void main(String[] args)
    {
        q1 c = new q1();
        c.start();
    }

    public void run()
    {
        for(int i=1;i<=100;i++)
        {
            System.out.println(i);
            try
            {
                Thread.sleep(1000);
            }catch(Exception e){}
        }
    }

}

