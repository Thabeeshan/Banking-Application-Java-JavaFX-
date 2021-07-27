/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528;

/**
 *
 * @author Thabeeshan
 */
public class Gold extends levels{
    private final double fee = 10;
    private double balance;
    
    @Override
    public void changeLevel(Client c) 
    {
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
        return fee;
    }
}
