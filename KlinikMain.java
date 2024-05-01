import java.util.Scanner;
public class KlinikMain{
    public static void menu(){
        System.out.println("==================================");
        System.out.println("            Pilih Menu:           ");
        System.out.println("==================================");
        System.out.println("1. Antrian Baru ");
        System.out.println("2. Antrian Keluar ");
        System.out.println("3. Cek Antrian Terdepan ");
        System.out.println("4. Cek Antrian Paling Belakang");
        System.out.println("5. Cek Posisi Antrian");
        System.out.println("6. Data Pasien");
        System.out.println("==================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scpasien = new Scanner(System.in);

        System.out.print("Masukkan kapasitas antrian: ");
        int kapasitasAntrian = sc.nextInt();
        sc.nextLine(); 

        Queue Klinik = new Queue(kapasitasAntrian);
        int pilihan;

        do {
            menu();
            pilihan = sc.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.print("Nomor ID          : ");
                    int noID = sc.nextInt();
                    System.out.print("Nama              : ");
                    String nama = scpasien.nextLine();
                    System.out.print("Jenis Kelamin (L/P): ");
                    char jenisKelamin = sc.next().charAt(0);
                    System.out.print("Umur               : ");
                    int umur = sc.nextInt();
                    System.out.println("-----------------------------");

                    Klinik pasienBaru = new Klinik(nama, noID, jenisKelamin, umur);
                    Klinik.enqueue(pasienBaru);
                    break;
                case 2:
                if (!Klinik.isEmpty()) {
                    Klinik pasienKeluar = Klinik.dequeue(); 
                    System.out.println("Pasien keluar: " + pasienKeluar.nama); 
                    Klinik.print(); 
                } else {
                    System.out.println("Antrian kosong!");
                }
                break;
            
                case 3:
                    Klinik.peek();
                    break;
                case 4:
                    Klinik.peekRear();
                    break;
                case 5:
                    System.out.println("Masukkan nama yang dicari: ");
                    String namePosition = scpasien.nextLine();
                    int position = -1;
                    for (int i = 0; i < Klinik.size; i++) {
                        if (Klinik.antrian[i].nama.equals(namePosition)) {
                            position = i + 1;
                            break;
                        }
                    }
                    if (position != -1) {
                        System.out.println("Posisi " + namePosition + " : " + position);
                    } else {
                        System.out.println("Elemen " + namePosition + " tidak ada dalam antrian");
                    }
                    break;
                case 6:
                    Klinik.print();
                    break;
            }
        } while (pilihan != 6);
        sc.close();
    }
}