import java.util.Scanner;

// Kelas Barang (Parent Class)
class Barang {
    String kodeBarang;
    String namaBarang;
    double hargaBarang;

    // Konstruktor
    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }
}

// Kelas Penjualan (Child Class)
class Penjualan extends Barang {
    String noFaktur;
    int jmlbeli;
    double total;

    // Konstruktor
    public Penjualan(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jmlbeli)
            throws IllegalArgumentException {
        super(kodeBarang, namaBarang, hargaBarang);
        this.noFaktur = noFaktur;
        if (hargaBarang < 0 || jmlbeli < 0) {
            throw new IllegalArgumentException("Harga barang atau jumlah beli tidak boleh negatif!");
        }
        this.jmlbeli = jmlbeli;
        this.total = hargaBarang * jmlbeli;
    }

    // Method untuk menampilkan data
    public void tampilkanData() {
        System.out.println("\n=== Detail Penjualan ===");
        System.out.println("No Faktur    : " + noFaktur);
        System.out.println("Kode Barang  : " + kodeBarang);
        System.out.println("Nama Barang  : " + namaBarang);
        System.out.println("Harga Barang : Rp" + hargaBarang);
        System.out.println("Jumlah Beli  : " + jmlbeli);
        System.out.println("Total        : Rp" + total);
    }
}

// Kelas utama
public class ProgramPenjualan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input data penjualan
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();

            System.out.print("Masukkan Jumlah Beli: ");
            int jmlbeli = scanner.nextInt();

            // Membuat objek Penjualan
            Penjualan penjualan = new Penjualan(noFaktur, kodeBarang, namaBarang, hargaBarang, jmlbeli);

            // Menampilkan data
            penjualan.tampilkanData();

        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nError: Input tidak valid!");
        } finally {
            scanner.close();
            System.out.println("Program selesai.");
        }
    }
}
