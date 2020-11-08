/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bank.sim;

/**
 *
 * @author stanc
 */
public class AccountsManager {
    
    BankAccount[] accounts = new BankAccount[10];
    
    void addAccount(BankAccount a) {
        for(int i=0;i<accounts.length;i++){
           if(accounts[i]==null){
               accounts[i] = a;
               return;
           }           
       }
       System.out.println("You can't creare more than "+accounts.length+" accounts");
    }
    
    int getTotalBalance() {
       int balance = 0;
       for(BankAccount a: accounts){ 
           if(a!=null){
            balance=balance+a.getBalance();
           }
       }
       return balance;
    }
    
    String getAccountDetails() {
       String message = "";
       for(BankAccount a: accounts){ 
           if(a!=null){
            String line = "The owner is "+a.getOwner()+" and the balance is "+a.getBalance()+"\n";
            message=message+line;
           }
       }
       return message;
        
    }
    boolean transfer(String fromOwnerName, String toOwnerName, int amount) {
        boolean indice = false;
        for(BankAccount a: accounts){
            if(a!=null){
               System.out.println(-amount);
               String owner = a.getOwner();
               int balance = a.getBalance();
               
               if(owner.equals(fromOwnerName) && balance>=amount) {
                   a.getBalance(-amount);
                   indice = true;
               } 
               else if(owner.equals(toOwnerName)) {
                   a.getBalance(amount);
                   indice = true;
               } 
            }
           }
        return indice;
    }
    
    
    public static void main(String[] args) {
        AccountsManager am = new AccountsManager();
        
        am.addAccount(new BankAccount("Miruna Ganea", 250));
        am.addAccount(new BankAccount("Popescu Ion", 300));
        
    }
}
