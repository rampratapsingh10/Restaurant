import java.io.*;  
class AbstractFactoryPatternExample {  
      public static void main(String args[])throws IOException {  
       
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
      System.out.print("Enter the name of Bank from where you want to take loan amount: ");  
      String bankName=br.readLine();  
  
System.out.print("\n");  
System.out.print("Enter the type of loan e.g. home loan or business loan or education loan : ");  
  
String loanName=br.readLine();  
AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");  
Bank b=bankFactory.getBank(bankName);  
  
System.out.print("\n");  
System.out.print("Enter the interest rate for "+b.getBankName()+ ": ");  
  
double rate=Double.parseDouble(br.readLine());  
System.out.print("\n");  
System.out.print("Enter the loan amount you want to take: ");  
  
double loanAmount=Double.parseDouble(br.readLine());  
System.out.print("\n");  
System.out.print("Enter the number of years to pay your entire loan amount: ");  
int years=Integer.parseInt(br.readLine());  
  
System.out.print("\n");  
System.out.println("you are taking the loan from "+ b.getBankName());  
  
AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");  
           Loan l=loanFactory.getLoan(loanName);  
           l.getInterestRate(rate);  
           l.calculateLoanPayment(loanAmount,years);  
  }  
}


}// end of the Loan abstract class.



// Step 4 

             //Create concrete classes that will extends the  Loan abstract class. 


class HomeLoan extends Loan
{

     public void getInterestRate(double r)
     {

           rate=r;

     }


}//End of the HomeLoan class.



class BussinessLoan extends Loan
{

     public void getInterestRate(double r)
     {

           rate=r;

     }


}//End of the BusssinessLoan class.



class EducationLoan extends Loan
{

     public void getInterestRate(double r)
     {

           rate=r;

     }


}//End of the EducationLoan class.




// Step 5 

     //Create an abstract class (i.e AbstractFactory) to get the factories for Bank and Loan Objects.


abstract class AbstractFactory
{
  public abstract Bank getBank(String bank);
  
  public abstract Loan getLoan(String loan);

}//End of the AbstractFactory.


// Step 6 

     //Create Factory classes extending AbstractFactory to generate object of concrete class based on given information.


class BankFactory extends AbstractFactory
{
   //@override
    
         
   public Bank getBank(String bank){
      if(bank == null){
         return null;
      }

		
      if(bank.equalsIgnoreCase("HDFC")){
         return new HDFC();
      } else if(bank.equalsIgnoreCase("ICICI")){
         return new ICICI();
      } else if(bank.equalsIgnoreCase("SBI")){
         return new SBI();
      }
      return null;
   }
   
  //@Override

  public Loan getLoan(String loan) {
      return null;
   }

}//End of the BankFactory class.



class LoanFactory extends AbstractFactory
{
   
    //@Override

           public Bank getBank(String bank)
          {
                return null;
          }

   //@Override
      
     public Loan getLoan(String loan){
      if(loan == null){
         return null;
      }

		
      if(loan.equalsIgnoreCase("Home")){
         return new HomeLoan();
      } else if(loan.equalsIgnoreCase("Business")){
         return new BussinessLoan();
      } else if(loan.equalsIgnoreCase("Education")){
         return new EducationLoan();
      }
      return null;
   }
   
}//End of the LoanFactory class.


// Step 7 
      
   //Create a FactoryCreator class to get the factories by passing an information such as Bank or Loan.



 class FactoryCreator {
     public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("Bank")){
         return new BankFactory();
      } else if(choice.equalsIgnoreCase("Loan")){
         return new LoanFactory();
      }
      return null;
   }
}//End of the FactoryCreator.


// Step 8 
      
    //Use the FactoryCreator to get AbstractFactory in order to get factories of concrete classes by passing an information such as type.


class AbstractFactoryPatternExample 
{
      
      public static void main(String args[])throws IOException
   {
       
      //get Bank factory

       //get an object of Bank and call its method getBank().But we want to get one bank at time not all.for this we IO concept.

      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

      System.out.print("Enter the name of Bank from where you want to take loan amount: ");
      

      String bankName=br.readLine();


System.out.print("\n");
System.out.print("Enter the type of loan you want to take, like home loan or bussiness loan or education loan : ");

      String loanName=br.readLine();

 
      AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");


      Bank b=bankFactory.getBank(bankName);

System.out.print("\n");
System.out.print("Enter the interest rate for "+b.getBankName()+ ": ");

      double rate=Double.parseDouble(br.readLine());


System.out.print("\n");
System.out.print("Enter the loan amount you want to take: ");

      double loanAmount=Double.parseDouble(br.readLine());



System.out.print("\n");
System.out.print("Enter the number of years to pay your entire loan amount: ");

      int years=Integer.parseInt(br.readLine());


System.out.print("\n");
System.out.println("you are taking the loan from "+ b.getBankName());


AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");

      
     
           Loan l=loanFactory.getLoan(loanName);

           l.getInterestRate(rate);
           l.calculateLoanPayment(loanAmount,years);

  }


}//End of the  AbstractFactoryPatternExample 













