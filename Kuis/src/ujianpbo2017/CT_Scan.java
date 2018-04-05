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
public class CT_Scan extends Fasilitas  {
    
    public static int harga = 1400;
    public static int jumPemeriksaan;
    int asuransi;
        
    public CT_Scan() {
        String satuan = "periksa";
    }
    
    //hitung tagihan : harga pemeriksaaan * jumlah pemeriksaan + asuransi * jumlah pemeriksaan
    //lengkapi
    @Override
    public double hitungTagihan() {
        return harga*jumPemeriksaan+asuransi*jumPemeriksaan;
    }
    
    //overloading
    //lengkapi
    public static double hitungTagihan(int asuransi) {
        // tagihan pemeriksaan ct_scan
        // asuransi: harga asuransi setiap pemeriksaan
        return asuransi;
    }
    
    //lengkapi
    public void print() {
        asuransi=(int) hitungTagihan(asuransi);
        System.out.println("Pemeriksaan CT Scan - Jumlah: "+jumPemeriksaan+", asuransi: "+asuransi+", harga: "+harga);
    }
    
    //lengkapi
    public static void print(int asuransi) {
        System.out.println(asuransi);
    }

    public static void main(String[] args) {
        CT_Scan ctScan=new CT_Scan();
        ctScan.asuransi=3000;
        jumPemeriksaan=3;
        System.out.println("Tagihan Cek Darah:"+ctScan.hitungTagihan()); 
        //lengkapi 
        //main class dengan menggunakan karakteristik class dan fungsi static
        // -jumlah pemeriksaan = 3
        // -asuransi = 3000
    }
    
    
}

//output:
//Tagihan CT Scan:13200.0