/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vehiclehireapp;
import au.edu.swin.vehicle.Vehicle; 
import au.edu.swin.vehicle.VehicleType; 
import java.util.ArrayList; 
import java.util.Scanner;

/**
 *
 * @author aarya
 */
public class VehicleHireApp {

    /**
     * @param args the command line arguments
     */
    /** 
  * @param args the command line arguments 
  */ 
    public static void main(String[] args) { 
        // Create the vehicle types 
        VehicleType sedan = new VehicleType("SEDAN", "A standard sedan", 4); 
        VehicleType limo6 = new VehicleType("LIMO6", "A six seater limo", 6); 
        VehicleType limo8 = new VehicleType("LIMO8", "An eight seater limo", 8); 

        // Create the vehicles 
        ArrayList<Vehicle> vehicles = new ArrayList(); 
        vehicles.add(new Vehicle("Ed's Holden Caprice", "Silver", sedan, 2002)); 
        vehicles.add(new Vehicle("John's Mercedes C200", "Black", sedan, 2005)); 
        vehicles.add(new Vehicle("Guy's Volvo 244 DL", "Blue", sedan, 1976)); 
        vehicles.add(new Vehicle("Sasco's Ford Limo", "White", limo6, 2014)); 
        vehicles.add(new Vehicle("Peter's Ford Limo", "White", limo6, 2004)); 
        vehicles.add(new Vehicle("Robert's Ford Limo", "White", limo8, 2003)); 

        System.out.println("\n\nList of vehicles in system:"); 
        for(Vehicle vehicle : vehicles) { 
            System.out.println(vehicle); 
        } 

        String typeCode = args[0]; 
        System.out.println("\n\nList of vehicle of type " + typeCode); 
        for(Vehicle vehicle : vehicles) { 
            if(vehicle.getType().getCode().equals(typeCode)) { 
                System.out.println(vehicle); 
            } 
        } 

        Scanner sc = new Scanner(System.in);
        int option = 0;

        System.out.println("\n\nSelect an option to display");
        while (option!= 4){
            System.out.println("\n\n1. SEDAN");
            System.out.println("\n\n2. LIMO6");
            System.out.println("\n\n3. LIMO8");
            System.out.println("\n\n4. EXIT");
            System.out.println("\n\nSelect an option");
            option = sc.nextInt();
            sc.nextLine();

            switch(option){
            case 1: System.out.println("\n\n Number 1 Working");break;
            case 2: System.out.println("\n\n Number 2 Working");break;
            case 3: System.out.println("\n\n Number 3 Working");break;
                   
            }

        }
    }
}
