package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "deane-coe_etal_canine_eye_color_GWAS_indiv_logR_per_marker.csv"; 
        byte[] inputBytes = { 0 };
        
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
        }

        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000 ; i++ ){
            for (byte b : inputBytes) {
                sb.append((char)b);
            }
        }
        String s = sb.toString();        
        System.out.println("Processing time with StringBuilder: " + (System.currentTimeMillis() - start) + "ms");
    }
}
