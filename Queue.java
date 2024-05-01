public class Queue{
    Klinik[] antrian;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n) {
        max = n;
        antrian = new Klinik[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(Klinik pasien) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            if (rear == max - 1) {
                rear = 0;
            } else {
                rear++;
            }
        }
        antrian[rear] = pasien;
        size++;
    }

    public Klinik dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return null;
        } else {
            Klinik pasien = antrian[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
            return pasien;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Pasien di antrian depan: " + antrian[front].nama);
    }

    public int peekPosition(String nama){
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (antrian[i].nama.equals(nama)) {
                position = i + 1;
                break;
            }
        }
        return position;
    }

    public void peekRear() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Pasien di antrian belakang: " + antrian[rear].nama);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Daftar Pasien: ");
        for (int i = front; i <= rear; i++) {
            System.out.println("Pasien : " + antrian[i].nama + ", Nomor ID : " + antrian[i].noID);
        }
        System.out.println("Total Pasien = " +size);
    }
}