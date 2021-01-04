/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parking.manager;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

 

public class Server {
    
    
    //declarare si initializare interfata grafica
    ArrayList<CarAccess> list = new ArrayList<>();
    
    String handlePlateNumberRequest(String plateNumber){
        int index = list.indexOf(new CarAccess(plateNumber, System.currentTimeMillis()));
        if(index!=-1){
            System.out.println("Plate number already exists.");
            CarAccess y = list.remove(index);
            int tax = ((int)System.currentTimeMillis() - (int)y.getAccessTime()) / 1000;
            System.out.println(plateNumber + ", you have to pay " + tax + " RON");
        }else{
             System.out.println("Plate number registered.");
             list.add(new CarAccess(plateNumber, System.currentTimeMillis()));
        }
        
        //acces la interfata grafica (pentru exercitiul 7)    
            
        return plateNumber;
    }
    
    void startServer() throws IOException{
        ServerSocket ss = new ServerSocket(4050);
        
        while(true){
            System.out.println("Waiting for clien connection...");
            Socket s = ss.accept(); //metoda blocanta
            System.out.println("Client connected");

            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);

            String line = "";
            while(!"close".equals(line)){
                line = fluxIn.readLine();
                if(!"close".equals(line)){
                    System.out.println("Received from client: "+line);
                    String x = handlePlateNumberRequest(line);
                    fluxOut.println(x);
                }
                
            }

           s.close();
            
        }
    }
    
    public static void main(String[] args) throws IOException {
        Server s = new Server();
        s.startServer();
    }
}