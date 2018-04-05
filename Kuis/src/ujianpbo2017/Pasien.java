/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ujianpbo2017;

/**
 *
 * @author ahmadluky
 */
public class Pasien {
    int id;
    String nama_pasien;

    //lengkapi
    public Pasien(int id, String nama_pasien) {
        this.id=id;
        this.nama_pasien=nama_pasien;
    }

    //lengkapi
    public void print() {
        System.out.println("id pasien:"+id+", nama pasien:"+nama_pasien);
    }

    public static void main(String[] args) {
        Pasien t = new Pasien(1,"Rudi");
        t.print();
    }
}

//output
//id pasien:1, nama pasien:Rudi