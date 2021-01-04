/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.utcluj.ssatr.curs2.ssatr.ia;

import java.util.Objects;

/**
 *
 * @author stanc
 */
public class Sensor {
    //atribute
    private  int value;
    private String location;
    
    //constructori
    Sensor(int value, String location){
        this.value = value;
        this.location = location;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(){
        this.value = value;
    }
    
    public String getLocation(){
        return location;
    }
    
    public void setLocation(){
        this.location = location;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Sensor){
                Sensor s = (Sensor)obj;
                return location == s.location;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.location);
        return hash;
    }
    
    public static void main(String[] args){
        Sensor s1 = new Sensor(1, "1st location");
        Sensor s2 = new Sensor(2, "2nd location");
        Sensor s3 = new Sensor(3, "3rd location");
        
        System.out.println(s1 + " and " + s2 + " -> " + s1.equals(s2));
        System.out.println(s2 + " and " + s3 + " -> " + s2.equals(s3));
        System.out.println(s1 + " and " + s3 + " -> " + s1.equals(s3));
        
        Controler c = new Controler();
        
        c.addSensor(new Sensor(10, "Loc1"));
        c.addSensor(new Sensor(70, "Loc2"));
        c.addSensor(new Sensor(75, "Loc3"));
        
        c.control();
    }
}
