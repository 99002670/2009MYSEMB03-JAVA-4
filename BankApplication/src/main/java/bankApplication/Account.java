package bankApplication;

abstract class Account
{
        protected int number;
        protected String name;
        Account(int num, String name)
        {
            number=num;
            this.name=name;
        }
        abstract void display();
}
