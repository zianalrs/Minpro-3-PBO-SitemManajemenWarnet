# Sistem Manajemen Warnet

---

## Deskripsi Singkat Program

Program ini adalah aplikasi CRUD berbasis console yang dibuat menggunakan bahasa Java dengan menerapkan konsep Object Oriented Programming (OOP). Program ini dibuat untuk mensimulasikan sistem manajemen komputer pada sebuah warnet.

Program dapat digunakan untuk melihat, menambah, mengubah, dan menghapus data komputer, melakukan booking komputer, serta melihat riwayat transaksi. Komputer pada program dibedakan menjadi dua kategori dengan tarif tetap, yaitu Komputer Reguler (Rp7.000/jam) dan Komputer VIP (Rp14.000/jam dengan fasilitas tambahan).

Data program disimpan menggunakan `ArrayList` selama program berjalan. Ketika program dijalankan kembali, data akan kembali menggunakan data awal (dummy data) berupa satu komputer Reguler yang sedang dipakai dan satu komputer VIP yang kosong.

---

## Fitur Program

- Melihat seluruh data komputer
- Melakukan booking komputer beserta perhitungan total biaya
- Melihat riwayat transaksi
- Menambah data komputer dengan memilih kategori Reguler atau VIP
- Mengubah spesifikasi komputer
- Menghapus data komputer
- Mengosongkan status komputer
- Validasi input agar program tidak error saat salah tipe data
- Program berjalan terus sampai user memilih menu keluar

---

## Penjelasan Struktur Package

Program dibagi menjadi enam package berdasarkan fungsi masing-masing, dengan mengacu pada struktur MVC (Model, View, Controller).

<img width="300" height="403" alt="Screenshot 2026-10-08 202021" src="https://github.com/user-attachments/assets/bfff7f09-3ce7-45d0-b86c-22fcb2b4ae4d" />

### 1. Package Model

Package `Model` berisi class yang digunakan untuk merepresentasikan data atau objek dalam program.

- `Komputer` (abstract class, berfungsi sebagai superclass)
- `KomputerReguler` (subclass dari `Komputer`)
- `KomputerVIP` (subclass dari `Komputer`)
- `Transaksi`

### 2. Package View

Package `View` berisi class `View` yang khusus bertugas menampilkan teks ke layar, seperti menu utama, menu kelola komputer, pilihan kategori, informasi booking, dan pesan-pesan kepada user. Class ini tidak membaca input dan tidak memproses data.

### 3. Package Controller

Package `Controller` berisi class `Controller` yang menjadi penghubung antara `View` dan bagian data. Class ini menjalankan perulangan menu, membaca pilihan user, menjalankan percabangan `switch-case`, memanggil `Service` untuk memproses data, lalu meminta `View` menampilkan hasilnya.

### 4. Package Service

Package `Service` digunakan untuk menangani proses atau logic pengelolaan data.

- `KomputerService` mengelola data komputer yang disimpan dalam `ArrayList`, seperti menambah, mencari, mengubah, menghapus, membooking, dan mengosongkan komputer.
- `TransaksiService` menyimpan dan mengelola data transaksi booking.

Package ini merupakan lapisan tambahan di luar MVC klasik, yang dipakai agar `Controller` tidak perlu mengakses `ArrayList` secara langsung.

### 5. Package Util

Package `Util` berisi class `Validasi`, yaitu class bantuan untuk membaca input dari user agar program tidak error ketika user memasukkan tipe data yang tidak sesuai, serta memastikan angka bernilai lebih dari 0 dan teks tidak kosong.

### 6. Package Main

Package `Main` berisi class `Warnet` yang merupakan entry point dari program. Class ini hanya membuat objek `Controller` lalu menjalankannya, karena seluruh alur dan tampilan sudah dipisahkan ke `Controller` dan `View`.

---

## Penjelasan Alur Program

Program dimulai dengan menjalankan class `Warnet`, yang membuat objek `Controller` lalu memanggil method `jalankan()`. Setelah itu sistem menampilkan menu utama yang berisi pilihan untuk melihat komputer, melakukan booking, melihat riwayat transaksi, mengelola komputer, dan keluar dari program.

<img width="247" height="202" alt="Screenshot 2026-10-08 202134" src="https://github.com/user-attachments/assets/917171ac-e581-48db-a04c-c15419149446" />

User memilih menu dengan memasukkan angka sesuai pilihan. Program menggunakan perulangan `while` sehingga menu utama akan terus ditampilkan sampai user memilih menu keluar, dan setiap pilihan diproses menggunakan `switch-case`. Seluruh input dibaca lewat class `Validasi`, sehingga jika user memasukkan huruf pada input angka, program tidak berhenti dan meminta user mengulang input.

---

### 1. Lihat Komputer

Menu **Lihat Komputer** digunakan untuk menampilkan seluruh data komputer yang tersedia pada warnet. Program memanggil `KomputerService`, menelusuri `ArrayList` dengan perulangan `for`, lalu menampilkan informasi setiap komputer yang meliputi nomor, kategori, spesifikasi, harga per jam, dan status. Untuk komputer VIP, ditampilkan juga fasilitas tambahannya.

<img width="470" height="267" alt="Screenshot 2026-10-08 202205" src="https://github.com/user-attachments/assets/f6f617d7-1046-440f-90b3-0620bff9532b" />

---

### 2. Booking Komputer

Menu **Booking Komputer** digunakan untuk melakukan penyewaan komputer oleh pelanggan.

- User memasukkan nomor komputer yang ingin digunakan.
- Jika nomor tidak ditemukan atau komputer sedang digunakan, program menampilkan pesan dan proses booking tidak dilanjutkan.
- Jika komputer tersedia, user diminta memasukkan nama pelanggan dan durasi penggunaan dalam jam. Kedua input ini diminta ulang jika kosong atau tidak lebih dari 0.
- Program menghitung total biaya berdasarkan durasi dan harga komputer per jam.

```text
Total Bayar = Durasi × Harga per Jam
```

<img width="423" height="117" alt="Screenshot 2026-10-08 202254" src="https://github.com/user-attachments/assets/20121a89-d029-4475-9ad8-59abf8e2b27f" />


Setelah proses berhasil, status komputer berubah menjadi sedang dipakai dan transaksi disimpan ke dalam `TransaksiService`.

---

### 3. Riwayat Transaksi

<img width="248" height="119" alt="Screenshot 2026-10-08 202326" src="https://github.com/user-attachments/assets/b6dab1c4-911d-4f6e-a2aa-4d472ec706e2" />

Menu **Riwayat Transaksi** digunakan untuk melihat seluruh transaksi booking yang telah dilakukan, meliputi ID transaksi, nama pelanggan, nomor komputer, durasi penggunaan, dan total pembayaran. Jika belum ada transaksi, program menampilkan pesan bahwa belum ada transaksi.

---

### 4. Kelola Komputer

<img width="244" height="202" alt="Screenshot 2026-10-08 202355" src="https://github.com/user-attachments/assets/0574caa4-1a8e-48cb-bcaf-9cdbabf1f925" />

Menu **Kelola Komputer** membuka submenu dengan perulangannya sendiri, berisi lima pilihan: Tambah Komputer, Ubah Data Komputer, Hapus Komputer, Kosongkan Komputer, dan Kembali ke menu utama. Pilihan Ubah, Hapus, dan Kosongkan ditolak dengan pesan yang jelas jika data komputer masih kosong.

#### 4.1 Tambah Komputer

<img width="486" height="138" alt="Screenshot 2026-10-08 202645" src="https://github.com/user-attachments/assets/abaafd66-fc20-4ed5-8996-131238285b83" />

User memasukkan nomor komputer, spesifikasi, dan memilih kategori Reguler atau VIP. Harga per jam tidak diinput manual karena sudah ditentukan oleh kategori. Jika nomor komputer sudah digunakan, komputer baru tidak dapat ditambahkan dengan nomor yang sama.

#### 4.2 Ubah Data Komputer

<img width="504" height="57" alt="Screenshot 2026-10-08 203002" src="https://github.com/user-attachments/assets/fac1f5de-6062-4df5-8085-04fba5ef7d07" />

User memasukkan nomor komputer yang ingin diubah, lalu memasukkan spesifikasi baru. Jika nomor ditemukan, spesifikasi diperbarui; jika tidak, program menampilkan pesan bahwa komputer tidak ditemukan.

#### 4.3 Hapus Komputer

<img width="411" height="36" alt="Screenshot 2026-10-08 203025" src="https://github.com/user-attachments/assets/206f9a5c-135c-4229-bec8-a5d9c7661f4a" />

User memasukkan nomor komputer yang ingin dihapus. Jika komputer ditemukan, datanya dihapus dari `ArrayList`.

#### 4.4 Kosongkan Komputer

<img width="457" height="39" alt="Screenshot 2026-10-08 203044" src="https://github.com/user-attachments/assets/5fc8f86a-8996-4db7-b439-c33c8985c6fc" />

User memasukkan nomor komputer yang ingin dikosongkan. Jika komputer sedang dipakai, statusnya diubah kembali menjadi kosong sehingga bisa dibooking lagi. Jika komputer memang sudah kosong, program memberi tahu hal tersebut.

---

### 5. Keluar Program

<img width="415" height="227" alt="image" src="https://github.com/user-attachments/assets/9488698c-a227-446f-a5eb-973e7f643e06" />

Menu **Keluar** menghentikan perulangan `while` pada menu utama sehingga program selesai dijalankan.

---

## Penjelasan Penerapan Encapsulation dan Inheritance

### Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier `private` pada atribut di class model, sehingga atribut tidak dapat diakses langsung dari luar class.

```java
private final int nomor;
private String spesifikasi;
private boolean dipakai;
```

Atribut yang nilainya tidak pernah berubah dideklarasikan `final`, yaitu `nomor` pada `Komputer`, seluruh atribut pada `Transaksi`, serta konstanta harga dan fasilitas pada subclass. Atribut `final` diisi satu kali lewat constructor dan tidak memiliki setter.

Untuk atribut yang memang dapat berubah, program menggunakan getter dan setter. Validasi nilai diletakkan langsung di dalam setter:

```java
public String getSpesifikasi() {
    return spesifikasi;
}

public void setSpesifikasi(String spesifikasi) {
    if (spesifikasi != null && !spesifikasi.trim().isEmpty()) {
        this.spesifikasi = spesifikasi;
    } else {
        System.out.println("Spesifikasi tidak boleh kosong.");
    }
}
```

Dengan demikian, data pada objek hanya dapat diubah melalui method yang telah disediakan dan dikontrol oleh class itu sendiri.

### Inheritance

Inheritance diterapkan pada class komputer. Class `Komputer` digunakan sebagai superclass, sedangkan `KomputerReguler` dan `KomputerVIP` merupakan subclass yang mewarisi atribut dan method dari `Komputer` menggunakan `extends`.

```java
public class KomputerReguler extends Komputer {

    public KomputerReguler(int nomor, String spesifikasi) {
        super(nomor, spesifikasi);
    }
}
```

Pada constructor subclass digunakan `super(...)` untuk memanggil constructor dari superclass. Dengan pewarisan ini, atribut dan method yang sama untuk semua komputer cukup ditulis satu kali di `Komputer`, dan subclass hanya menambahkan hal yang membedakannya, seperti harga sewa dan fasilitas tambahan pada `KomputerVIP`.

---

## Penjelasan Penerapan Polymorphism dan Abstraction

### Polymorphism

**Method overriding.** `KomputerReguler` dan `KomputerVIP` meng-override method `getKategori()` dan `getHargaPerJam()` dari superclass dengan isi yang berbeda sesuai jenis komputer.

```java
@Override
public String getKategori() {
    return "Reguler";
}

@Override
public double getHargaPerJam() {
    return HARGA_PER_JAM;
}
```

Class `KomputerVIP` juga meng-override `tampilkanInfo()` untuk menambahkan informasi fasilitas:

```java
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Fasilitas     : " + FASILITAS_TAMBAHAN);
}
```

Selain itu, `ArrayList<Komputer>` dapat menyimpan objek `KomputerReguler` dan `KomputerVIP` dalam satu daftar. Saat `tampilkanInfo()` dipanggil pada setiap elemen, Java otomatis menjalankan versi method yang sesuai dengan jenis objeknya.

```java
private ArrayList<Komputer> daftarKomputer;
```

**Method overloading.** Method `tambah()` dibuat dengan dua versi parameter yang berbeda, baik pada `KomputerService` maupun `TransaksiService`.

```java
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
```

Pada `TransaksiService`, versi kedua dari `tambah()` menerima data transaksi mentah lalu membuat ID transaksi secara otomatis sebelum memanggil versi pertama.

```java
public void tambah(Transaksi transaksi) {
    daftarTransaksi.add(transaksi);
}

public void tambah(String namaPelanggan, int nomorKomputer, int durasiJam, double totalBayar) {
    int idTransaksi = jumlahTransaksi() + 1;
    tambah(new Transaksi(idTransaksi, namaPelanggan, nomorKomputer, durasiJam, totalBayar));
}
```

### Abstraction

Abstraction diterapkan dengan menjadikan `Komputer` sebagai `abstract class`, karena dalam sistem ini tidak pernah ada komputer tanpa kategori; yang ada selalu `KomputerReguler` atau `KomputerVIP`. Dengan begitu, objek `Komputer` tidak dapat dibuat secara langsung.

Di dalamnya terdapat dua abstract method, yaitu `getKategori()` dan `getHargaPerJam()`, yang hanya berisi deklarasi tanpa isi.

```java
public abstract class Komputer {

    public abstract String getKategori();

    public abstract double getHargaPerJam();
}
```

Setiap subclass wajib mengimplementasikan kedua method tersebut, dan kompilasi akan gagal jika ada subclass yang tidak melakukannya. Method lain seperti `tampilkanInfo()` tetap memiliki isi di superclass karena logikanya sama untuk semua kategori.
