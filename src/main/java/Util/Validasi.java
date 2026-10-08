/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;
import java.util.Scanner;
            
/**
 *
 * @author LOQ
 */

public class Validasi {
 
    public int bacaInt(Scanner input, String label) {
        while (true) {
            System.out.print(label);
            if (input.hasNextInt()) {
                int nilai = input.nextInt();
                input.nextLine();
                return nilai;
            } else {
                System.out.println("Input harus berupa angka bulat, coba lagi.");
                input.nextLine();
            }
        }
    }
 
    public double bacaDouble(Scanner input, String label) {
        while (true) {
            System.out.print(label);
            if (input.hasNextDouble()) {
                double nilai = input.nextDouble();
                input.nextLine();
                return nilai;
            } else {
                System.out.println("Input harus berupa angka, coba lagi.");
                input.nextLine();
            }
        }
    }
 
    public int bacaIntPositif(Scanner input, String label) {
        while (true) {
            int nilai = bacaInt(input, label);
            if (nilai > 0) {
                return nilai;
            }
            System.out.println("Nilai harus lebih dari 0, coba lagi.");
        }
    }
 
    public double bacaDoublePositif(Scanner input, String label) {
        while (true) {
            double nilai = bacaDouble(input, label);
            if (nilai > 0) {
                return nilai;
            }
            System.out.println("Nilai harus lebih dari 0, coba lagi.");
        }
    }
 
    public String bacaTeks(Scanner input, String label) {
        while (true) {
            System.out.print(label);
            String teks = input.nextLine();
            if (teks != null && !teks.trim().isEmpty()) {
                return teks;
            }
            System.out.println("Input tidak boleh kosong, coba lagi.");
        }
    }
}