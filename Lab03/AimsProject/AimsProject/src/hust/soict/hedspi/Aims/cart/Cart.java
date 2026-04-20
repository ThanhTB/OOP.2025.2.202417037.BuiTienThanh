package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Cart {
    public int qtyOrdered;
    public static final int Max_numbers_ordered = 20;
    private DigitalVideoDisc itemOrdered[] = 
        new DigitalVideoDisc[Max_numbers_ordered];
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int idx=-1;
        for(int i =0; i < qtyOrdered; i++){
            if(itemOrdered[i]==disc){
                idx = i;
                break;
            }
        }
        if(idx != -1){
            for(int i = idx; i < qtyOrdered-1; i++){
                itemOrdered[i] = itemOrdered[i+1];
            }
            itemOrdered[qtyOrdered-1] = null;
            qtyOrdered--;
            System.out.println( disc.getTitle() + "has been removed");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < Max_numbers_ordered){
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else{
            System.out.println("The cart is almost full");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for (DigitalVideoDisc dvdList1 : dvdList) {
            addDigitalVideoDisc(dvdList1);
        }
        System.out.println("The list has been added"); 
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
        System.out.println("dvds have been added");
    }
    public float totalCost(){
        float sum = 0;
        for(int i =0; i < qtyOrdered; i++){
            sum += itemOrdered[i].getCost();
        }
        return sum;
    }
    public void print(){
        System.out.println("**********************cart********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++){
            System.out.println((i+1)+ "." + itemOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***********************************************");
    }
    public void searchById(int id){
        for (int i = 0; i < qtyOrdered; i++){
            if(itemOrdered[i].getId() == id){
                System.out.println(itemOrdered[i]);
                return;
            }
        }
        System.out.println("No matching DVD found.");
    }
    public void searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].isMatch(title)) {
                System.out.println(itemOrdered[i]);
                return;
            }
        }
        System.out.println("No matching DVD found.");
    }
}
