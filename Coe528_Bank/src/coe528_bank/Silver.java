/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528_bank;

/**
 *
 * @author Thabeeshan
 */
public class Silver extends levels{
    /*
    Question 2 of Work Items)
    Overview:
    Used to classify level of client. Using If/else if/else statements,
    compares the balance of a certain customer to determine their level 
    */
    private final double fee = 20;
    private double balance;
    private Client client_rep;
    
    @Override
    public void changeLevel(Client c) 
    {
        /*
        Requires: None
        Modifies: setLevel 
        Effects: changes to different levels accordingly to customer's balance
        */
        this.balance = c.getBalance();
        if (balance < 10000)
            c.setLevel(new Silver());
        else if(balance >= 10000 && balance < 20000)
            c.setLevel(new Gold());
        else
            c.setLevel(new Platinum());
    }
    @Override
    public double getFee()
    {
        /*
        Requires: None
        Modifies: None  
        Effects: Returns the fee of a customer being silver level
        */
        return fee;
    }
    public boolean repOK()
    {
        /*
        Requires: None
        Modifies: None
        Effects: Returns true if rep invarient balance is double
        */
        if (client_rep.getBalance() == (double)client_rep.getBalance()){
            return true;
        }
        else
            return false;
    }
    @Override
    public String toString()
    {
        /*
        Requires: None
        Modifies: None
        Effects: Returns the balance of customer of silver level
        */
        return "Silver Customer has a balance:" + client_rep.getBalance();
    }
}
