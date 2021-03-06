//Team S^3: James Smith, Ryan Siu, Mark Shafran
//APCS1 pd 5
//HW 13 -- Outsourcing
//2016-10-05

public class Teller {
    public static void main( String[] args){
	
	BankAccount a = new BankAccount();
	System.out.println(a); //default info
	
	BankAccount b = new BankAccount();
	b.setOwner("Hugh Mongus");
	b.setPassword("KappaKappa123");
	b.setPin(9876);
	b.setAccNum(123456789);
	b.setBalance(357.73);
	System.out.println(b);//should switch from default info to the info set from mutators above
	
	b.setPin(36);//error
	System.out.println(b);//9876
	
	b.setAccNum(30); //error
	System.out.println(b);//123456789

	BankAccount c = new BankAccount( "Mr Salad", 2000, "RanchDaddy", 1738, 657482915 );
	System.out.println(c);//print out this ^^^ information
	c.deposit(45.64);//2045.64
	System.out.println(c);//2045.64
	
	c.withdraw(45.64);//2000
	System.out.println(c);//2000

	c.withdraw(5000); //error
	System.out.println(c);//2000
	
	System.out.println(c.authenticate( 657482915, "RanchDaddy" ));  // true
	System.out.println(c.authenticate( 123456789, "bc123" ));   // false
    }
}
/*Errors in their code:
setAccNum's else statement changes the pin to 999999999! IT SHOULD CHANGE THE ACC NUMBER.

setAccNum's else statement shouldn't change the account number to the default, but instead just make it the same account number as it was before.
 */
