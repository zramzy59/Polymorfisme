// Kelas abstrak Kue
abstract class Kue {
    protected String nama;
    protected double harga;

    // Konstruktor
    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    // Method abstrak untuk menghitung harga akhir
    public abstract double hitungHarga();

    // Method untuk menampilkan nama dan harga satuan
    public String toString() {
        return "Nama Kue: " + nama + ", Harga Satuan: Rp" + harga;
    }
}

// Subclass KuePesanan
class KuePesanan extends Kue {
    private double berat;

    // Konstruktor
    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    // Implementasi method hitungHarga khusus KuePesanan
    public double hitungHarga() {
        return harga * berat;
    }

    // Implementasi method toString khusus KuePesanan
    public String toString() {
        return "[KuePesanan] " + super.toString() + ", Berat: " + berat + " kg, Harga Akhir: Rp" + hitungHarga();
    }

    // Getter berat
    public double getBerat() {
        return berat;
    }
}

// Subclass KueJadi
class KueJadi extends Kue {
    private double jumlah;

    // Konstruktor
    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    // Implementasi method hitungHarga khusus KueJadi
    public double hitungHarga() {
        return harga * jumlah * 2;
    }

    // Implementasi method toString khusus KueJadi
    public String toString() {
        return "[KueJadi] " + super.toString() + ", Jumlah: " + jumlah + ", Harga Akhir: Rp" + hitungHarga();
    }

    // Getter jumlah
    public double getJumlah() {
        return jumlah;
    }
}

// Main class dengan nama Polymorfisme
public class polymorfisme {
    public static void main(String[] args) {
        // Membuat array berisi 20 kue
        Kue[] daftarKue = new Kue[20];

        // Mengisi array dengan objek KuePesanan dan KueJadi
        daftarKue[0] = new KuePesanan("Kue Lapis", 45000, 1.2);
        daftarKue[1] = new KueJadi("Donat", 5000, 12);
        daftarKue[2] = new KuePesanan("Kue Nastar", 75000, 0.8);
        daftarKue[3] = new KueJadi("Brownies", 15000, 6);
        daftarKue[4] = new KuePesanan("Kue Putri Salju", 80000, 1.0);
        daftarKue[5] = new KueJadi("Cupcake", 7000, 10);
        daftarKue[6] = new KuePesanan("Kue Lumpur", 60000, 0.9);
        daftarKue[7] = new KueJadi("Kue Cubit", 4000, 15);
        daftarKue[8] = new KuePesanan("Kue Bolu", 55000, 1.5);
        daftarKue[9] = new KueJadi("Macaron", 9000, 8);
        daftarKue[10] = new KuePesanan("Kue Talam", 48000, 1.1);
        daftarKue[11] = new KueJadi("Eclair", 8500, 7);
        daftarKue[12] = new KuePesanan("Kue Sagu", 53000, 0.7);
        daftarKue[13] = new KueJadi("Cheesecake", 12000, 5);
        daftarKue[14] = new KuePesanan("Kue Bika Ambon", 70000, 1.3);
        daftarKue[15] = new KueJadi("Pie Buah", 11000, 6);
        daftarKue[16] = new KuePesanan("Kue Lemper", 45000, 1.0);
        daftarKue[17] = new KueJadi("Kue Soes", 5000, 14);
        daftarKue[18] = new KuePesanan("Kue Pancong", 40000, 1.4);
        daftarKue[19] = new KueJadi("Tart Mini", 15000, 4);

        // Menampilkan semua kue
        System.out.println("=== Daftar Semua Kue ===");
        tampilkanSemuaKue(daftarKue);

        // Menghitung total harga semua kue
        double totalHargaSemuaKue = hitungTotalHarga(daftarKue);
        System.out.println("\nTotal Harga Semua Kue: Rp" + totalHargaSemuaKue);

        // Menghitung total harga dan berat dari KuePesanan
        hitungTotalKuePesanan(daftarKue);

        // Menghitung total harga dan jumlah dari KueJadi
        hitungTotalKueJadi(daftarKue);

        // Menampilkan kue dengan harga terbesar
        tampilkanKueTermahal(daftarKue);
    }

    // Menampilkan semua kue
    public static void tampilkanSemuaKue(Kue[] daftarKue) {
        for (Kue kue : daftarKue) {
            System.out.println(kue);
        }
    }

    // Menghitung total harga semua kue
    public static double hitungTotalHarga(Kue[] daftarKue) {
        double total = 0;
        for (Kue kue : daftarKue) {
            total += kue.hitungHarga();
        }
        return total;
    }

    // Menghitung total harga dan total berat KuePesanan
    public static void hitungTotalKuePesanan(Kue[] daftarKue) {
        double totalHarga = 0;
        double totalBerat = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KuePesanan) {
                totalHarga += kue.hitungHarga();
                totalBerat += ((KuePesanan) kue).getBerat();
            }
        }
        System.out.println("\nTotal Harga KuePesanan: Rp" + totalHarga);
        System.out.println("Total Berat KuePesanan: " + totalBerat + " kg");
    }

    // Menghitung total harga dan total jumlah KueJadi
    public static void hitungTotalKueJadi(Kue[] daftarKue) {
        double totalHarga = 0;
        double totalJumlah = 0;
        for (Kue kue : daftarKue) {
            if (kue instanceof KueJadi) {
                totalHarga += kue.hitungHarga();
                totalJumlah += ((KueJadi) kue).getJumlah();
            }
        }
        System.out.println("\nTotal Harga KueJadi: Rp" + totalHarga);
        System.out.println("Total Jumlah KueJadi: " + totalJumlah);
    }

    // Menampilkan kue dengan harga akhir terbesar
    public static void tampilkanKueTermahal(Kue[] daftarKue) {
        Kue kueTermahal = daftarKue[0];
        for (Kue kue : daftarKue) {
            if (kue.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = kue;
            }
        }
        System.out.println("\nKue dengan Harga Akhir Terbesar:");
        System.out.println(kueTermahal);
    }
}
