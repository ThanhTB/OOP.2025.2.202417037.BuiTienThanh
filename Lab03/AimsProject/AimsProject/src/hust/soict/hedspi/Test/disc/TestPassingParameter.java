package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungLeDVD = new DigitalVideoDisc("JungLe");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        swap(jungLeDVD,cinderellaDVD);
        System.out.println("jungle dvd title: " + jungLeDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        changeTitle(jungLeDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungLeDVD.getTitle());
    }
    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        String tempTitle = o1.getTitle();
        o1.setTitle(o2.getTitle());
        o2.setTitle(tempTitle);
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
