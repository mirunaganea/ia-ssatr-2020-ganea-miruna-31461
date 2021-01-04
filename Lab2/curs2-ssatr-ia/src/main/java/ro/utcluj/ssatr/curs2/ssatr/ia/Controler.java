/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs2.ssatr.ia;

import java.util.ArrayList;

/**
 *
 * @author stanc
 */
public class Controler {
    ArrayList<Sensor> list = new ArrayList<Sensor>();
    
    public void addSensor(Sensor s){
        list.add(s);
    }
    
    public void control(){
        for(int i=0;i<list.size();i++){
            Sensor x = list.get(i);
            if(x.getValue()> 25)
                System.out.println("Activating cooling mode..."); 
            else if(x.getValue() < 15)
                System.out.println("Activating heating mode..."); 
       }
        
    }
}
