/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectaims;

/**
 *
 * @author Tiến Thành
 */
public class Aims {
   
    public static void main(String[] args) {
       
        Cart cart = new Cart();

      
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

       
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

       
        System.out.println("Total cost is: " + cart.totalCost());

        cart.removeDigitalVideoDisc(dvd2);
        System.out.println("Total cost after remove: " + cart.totalCost());
    }
}

