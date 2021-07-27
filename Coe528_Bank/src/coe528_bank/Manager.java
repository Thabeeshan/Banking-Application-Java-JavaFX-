/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528_bank;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Thabeeshan
 */
public class Manager {
    static ArrayList<Client> clientList = new ArrayList<>();
    public boolean createClient(String user, String pass, double b){
        boolean check = false;
        for (Client client: clientList){
            if (client.name.equals(user)){
                return false;
            }
            else{
                check = true;
            }
        }
        try{
            if(check = true){
                clientList.add(new Client(user,b));
                File f = new File(user + ".txt");
                f.createNewFile();
                PrintWriter pw = new PrintWriter(f);
                pw.println(pass);
                pw.close();
            }
        }
        catch (IOException e){
            System.out.println("Error");
        }
        return check;
    }
    public boolean deleteClient(String user){
        boolean check = false;
        for (Client client : clientList)
        {
            if(client.name.equals(user))
            {
                File f = new File(user + ".txt");
                f.delete();
                clientList.remove(client);
                return true;
            }
            else
            {
                check = false;
            }
        }
        return check;
    }
}