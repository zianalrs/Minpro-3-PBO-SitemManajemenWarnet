/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import java.util.ArrayList;
import Model.Transaksi;
/**
 *
 * @author LOQ
 */
public class TransaksiService {
    private ArrayList<Transaksi> daftarTransaksi;
 
    public TransaksiService() {
        daftarTransaksi = new ArrayList<>();
    }
 
    public void tambah(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
    }
 
    public void tambah(String namaPelanggan, int nomorKomputer, int durasiJam, double totalBayar) {
        int idTransaksi = jumlahTransaksi() + 1;
        tambah(new Transaksi(idTransaksi, namaPelanggan, nomorKomputer, durasiJam, totalBayar));
    }
 
    public int jumlahTransaksi() {
        return daftarTransaksi.size();
    }
 
    public void tampilkanSemua() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.println("--------------------");
            daftarTransaksi.get(i).tampilkanInfo();
        }
    }
}
