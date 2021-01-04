/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parking.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author stanc
 */
public class Client {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Connecting to server...");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Connection established.");
         //...... 
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        
        fluxOut.println("CJ-01-ABC");
        String response = fluxIn.readLine();
        System.out.println(response);
        
        fluxOut.println("close");
        response = fluxIn.readLine();
        System.out.println(response);
        
        
        s.close();
    }
}
