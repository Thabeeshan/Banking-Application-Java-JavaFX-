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
public class Client {
    private double balance;
    static levels level = new Silver();
    String name = "null";
    public Client(String username, double b){
        name = username;
        balance = b;
        if (balance < 10000){
            level = new Silver();
        }
        else if (balance < 20000){
            level = new Gold();
        }
        else{
            level = new Platinum();
        }
    }
    public void withdraw(double amount){
        balance = balance - amount;
    }
    public void deposit(double amount){
        balance = balance + amount;
    }
    public void purchase(double amount){
        balance = balance - amount;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double b)
    {
        balance = b;
    }
    public void setLevel(levels l)
    {
        level = l;
    }
    public Client getClient(){
        return this;
    }
    @Override
    public String toString(){
        return name;
    }
}