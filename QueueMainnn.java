import java.util.Scanner;
public class QueueMainnn{
    public static void menu(){
        System.out.println("==================================");
        System.out.println("            Pilih Menu:           ");
        System.out.println("==================================");
        System.out.println("1. Antrian Baru ");
        System.out.println("2. Antrian Keluar ");
        System.out.println("3. Cek Antrian Terdepan ");
        System.out.println("4. Cek Semua Antrian ");
        System.out.println("5. Cek Antrian Paling Belakang");
        System.out.println("==================================");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc.nextInt();
        Queue antri = new Queue(jumlah);

        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih){
                case 1:
                    System.out.println("==================================");
                    System.out.print("No Rekening : ");
                    String norek = sc.nextLine();
                    System.out.print("Nama        : ");
                    String nama = sc.nextLine();
                    System.out.print("Alamat      : ");
                    String alamat = sc.nextLine();
                    System.out.print("Umur        : ");
                    int Umur = sc.nextInt();
                    System.out.print("Saldo       : ");
                    double saldo = sc.nextDouble();
                    System.out.println("==================================");
                    Nasabah nb = new Nasabah(norek, nama, alamat, Umur, saldo);
                    sc.nextLine();
                    antri.Enqueue(nb);
                    break;
                case 2:
                    Nasabah data = antri.Dequeue();
                    if (!"".equals(data.norek) && !"".equals(data.nama) && !"".equals
                    (data.alamat) && data.umur !=0 && data.saldo !=0){
                        System.out.println("Antrian yang keluar: " + data.norek + " " + data.nama + " " + data.alamat + " " + data.umur + " " + data.saldo);
                        break;
                    }
                case 3:
                    antri.peek();
                case 4:
                    antri.print();
                    break;
                case 5:
                    Nasabah dataBelakang = antri.peekRear();
                    if (dataBelakang != null) {
                        System.out.println("Data Antrian Paling Belakang:");
                        System.out.println("-----------------------------");
                        System.out.println("No Rekening : " + dataBelakang.norek);
                        System.out.println("Nama        : " + dataBelakang.nama);
                        System.out.println("Alamat      : " + dataBelakang.alamat);
                        System.out.println("Umur        : " + dataBelakang.umur);
                        System.out.println("Saldo       : " + dataBelakang.saldo);
                        System.out.println("-----------------------------");
                    } else {
                        System.out.println("Antrian masih kosong");
                    }
                    break;
            }
        } while(pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
}