package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "deane-coe_etal_canine_eye_color_GWAS_indiv_logR_per_marker.csv"; 
        byte[] inputBytes = { 0 };
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000 ; i++) {
            for (byte b : inputBytes) {
                s += (char)b; 
            }
        }
        System.out.println("Processing time with String: " + (System.currentTimeMillis() - start) + "ms");
    }
}
