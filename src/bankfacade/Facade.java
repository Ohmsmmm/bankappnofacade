package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;

import java.util.ArrayList;

public class Facade {
    public ArrayList<CustomerIf> bankCustomers;
    public Facade(){
        bankCustomers = new ArrayList();
        AccountIf acc1 = new BankAccount(1150);
        acc1.deposit(500);
        ArrayList<AccountIf> accCust1 = new ArrayList();
        accCust1.add(acc1);
        AccountIf acc2 = new BankAccount(1151);
        acc2.deposit(1000);
        accCust1.add(acc2);
        CustomerIf cust1 = new BankCustomer("Ohmsm", accCust1);
        bankCustomers.add(cust1);

        AccountIf acc3 = new BankAccount(1112);
        acc3.deposit(1200);
        ArrayList<AccountIf> accCust2 = new ArrayList();
        accCust2.add(acc3);
        AccountIf acc4 = new BankAccount(1113);
        acc4.deposit(1700);
        accCust2.add(acc4);
        CustomerIf cust2 = new BankCustomer("SakuBoyz", accCust2);
        bankCustomers.add(cust2);
    }
    public void doDeposit(double amt, CustomerIf cust, int accNo) {
        cust.getAccount(accNo).deposit(amt);
    }
    public AccountIf getBankAccount(CustomerIf cust, int accNo){
        return cust.getAccount(accNo);
    }
    public CustomerIf getBankCustomer(String custName){
        CustomerIf customer = null;
        for (int i = 0; i < bankCustomers.size (); i++) {
            if (bankCustomers.get(i).getCustomerName() == custName) {
                customer = bankCustomers.get(i);
                break;
            }
        }
        return customer;
    }
}
