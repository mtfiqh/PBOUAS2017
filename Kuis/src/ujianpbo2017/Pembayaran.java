/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ujianpbo2017;

import java.util.ArrayList;

/**
 *
 * @author ahmadluky
 */
public class Pembayaran {
    Pasien pasien;
    double TagihanDokter;
    double TagihanFasilitas;
    
    private ArrayList<Fasilitas> alFasilitas = new ArrayList<>();
    private ArrayList<Dokter> alDokter = new ArrayList<>();

    //lengkapi
    public void addFasilitas(Fasilitas f) {
        alFasilitas.add(f);
    }
    
    //lengapi
    public void addDokter(Dokter d){
        alDokter.add(d);
    }
    
    //lengkapi
    public double hitungDokterTagihan(){
        double sum = 0;
        for(int i=0;i<alDokter.size();i++){
            sum=sum+alDokter.get(i).HitungHarga();
        }
        return sum;
    }
    
    //lengkapi
    public double hitungFasilitasTagihan(){
        double sum = 0;
        for(int i=0;i<alFasilitas.size();i++){
            sum=sum+alFasilitas.get(i).hitungTagihan();
        }
        return sum;
    }
    
    //lengkapi
    public double hitungSemuaTagihan() {
        return hitungDokterTagihan()+hitungFasilitasTagihan();
    }

    public Pembayaran(Pasien p) {
        this.pasien = p;
    }

    public static void main(String[] args) {
        Pasien pasien = new Pasien(1,"Rudi");
        Pembayaran  pembayaran_pasien = new Pembayaran(pasien);
        
        /*
         * Lengkapi fungsu main, dengan ketentuan:
         * - jumlah pemeriksaan usg = 3 kali
         * - jumlah pemeriksaan ct scan = 3 kali
         * - jumlah pemeriksaan cek darah = 3 kali
         * - asuransi:200
         * - ruang rawat inap id=231 harga=200
         */
        
        // Cotoh USG:
        System.out.println("=========================");
        USG usg = new USG();
        usg.jumPemeriksaan = 3;
        usg.print();
        pembayaran_pasien.addFasilitas(usg);
        //CTScan
        CT_Scan ctScan = new CT_Scan();
        ctScan.asuransi=200; 
        ctScan.jumPemeriksaan=3;
        ctScan.print();
        pembayaran_pasien.addFasilitas(ctScan);
        //CekDarah
        Cek_Darah cekDarah= new Cek_Darah();
        cekDarah.jumPemeriksaan=3;
        cekDarah.print();
        pembayaran_pasien.addFasilitas(cekDarah);
        //Ruangan
        Ruang_Rawat_Inap ruangInap = new Ruang_Rawat_Inap(231, 200);
        ruangInap.print();
        //Jumlah Hari (Fasilitas ruangan)
        FasilitasRuangan fr = new FasilitasRuangan(ruangInap);
        fr.jumHari=3;
        fr.print();
        pembayaran_pasien.addFasilitas(fr);
        System.out.println("=========================");
        System.out.println("#Tagihan Fasilitas: "+pembayaran_pasien.hitungFasilitasTagihan());
        System.out.println("=========================");
        Dokter_Spesialis dokterSp = new Dokter_Spesialis(1, "DR. Joni", "Jantung", "04-04-2017 20:00");
        dokterSp.print();
        System.out.println("=========================");
        dokterSp.awal="04-04-2017 20:00";
        dokterSp.akhir="04-04-2017 20:40";
        pembayaran_pasien.alDokter.add(dokterSp);
        System.out.println("#Tagihan Dokter: "+pembayaran_pasien.hitungDokterTagihan());
        System.out.println("");
        System.out.println("#Tagihan Semua : "+pembayaran_pasien.hitungSemuaTagihan());
        
    }
}

//output:
/*
|=========================|
Pemeriksaan USG - Jumlah : 3 kali , harga : 15
Pemeriksaan CT Scan - Jumlah : 3 kali , asuransi : 200, harga : 1400
Pemeriksaan Cek Darah - Jumlah : 3 kali , harga : 10
Ruangan - id ruangan : 231, harga : 200
jumlah hari :3
|=========================|
#Tagihan Faslilitas : 4875.0

|=========================|
id dokter : 1, nama : DR. Joni, waktu : 04-04-2017 20:00, spesialis : Jantung
|=========================|
#Tagihan Docter : 80000.0

#Tagihan Semua : 84875.0
*/