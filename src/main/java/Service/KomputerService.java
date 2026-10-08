/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.util.ArrayList;
import Model.Komputer;
import Model.KomputerReguler;
import Model.KomputerVIP;
/**
 *
 * @author LOQ
 */

public class KomputerService {
    private ArrayList<Komputer> daftarKomputer;
 
    public KomputerService() {
        daftarKomputer = new ArrayList<>();
 
        KomputerReguler pc1 = new KomputerReguler(1, "Ryzen 5 5600, RTX 3050 Ti, RAM 16GB");
        pc1.setDipakai(true);
        daftarKomputer.add(pc1);
 
        KomputerVIP pc2 = new KomputerVIP(2, "Intel i7-13700F, RTX 4070, RAM 32GB");
        daftarKomputer.add(pc2);
    }
 
    public boolean adaData() {
        return !daftarKomputer.isEmpty();
    }
 
    public void tambah(Komputer komputer) {
        daftarKomputer.add(komputer);
    }
 
    public void tambah(int nomor, String spesifikasi, String kategori) {
        if (kategori.equalsIgnoreCase("VIP")) {
            tambah(new KomputerVIP(nomor, spesifikasi));
        } else {
            tambah(new KomputerReguler(nomor, spesifikasi));
        }
    }
 
    public void tampilkanSemua() {
        if (daftarKomputer.isEmpty()) {
            System.out.println("Belum ada data komputer.");
            return;
        }
        for (int i = 0; i < daftarKomputer.size(); i++) {
            System.out.println("--------------------");
            daftarKomputer.get(i).tampilkanInfo();
        }
    }
 
    public Komputer cariByNomor(int nomor) {
        for (int i = 0; i < daftarKomputer.size(); i++) {
            if (daftarKomputer.get(i).getNomor() == nomor) {
                return daftarKomputer.get(i);
            }
        }
        return null;
    }
 
    public boolean ubah(int nomor, String spesifikasiBaru) {
        Komputer k = cariByNomor(nomor);
        if (k == null) {
            return false;
        }
        k.setSpesifikasi(spesifikasiBaru);
        return true;
    }
 
    public boolean hapus(int nomor) {
        Komputer k = cariByNomor(nomor);
        if (k == null) {
            return false;
        }
        daftarKomputer.remove(k);
        return true;
    }
 
    public String booking(int nomor) {
        Komputer k = cariByNomor(nomor);
        if (k == null) {
            return "tidak_ditemukan";
        }
        if (k.isDipakai()) {
            return "sudah_dipakai";
        }
        k.setDipakai(true);
        return "berhasil";
    }
 
    public String kosongkan(int nomor) {
        Komputer k = cariByNomor(nomor);
        if (k == null) {
            return "tidak_ditemukan";
        }
        if (!k.isDipakai()) {
            return "belum_dipakai";
        }
        k.setDipakai(false);
        return "berhasil";
    }
}