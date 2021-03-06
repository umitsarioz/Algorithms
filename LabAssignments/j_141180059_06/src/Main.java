// 6. Haftanın lab sorusu
/*
 * 1. Soru:
 * min_heap=[3,7,8,11,13,10,17,19,23]
 * 7 elemanını ağaç yapısından silip heap yapısını düzenle ve ekrana yazdır.
 *
 * 2.Soru:
 * Min_heap = [5 7 11 8 10 22 12 14 20 11] min heap yapısını max heap yapan kodu yazınız.
 **************************
 * 141180059 - Ümit SARIÖZ*
 * ************************/

class HeapSort{
    public static void soru1(){
        int [] min_heap = {3,7,8,11,13,10,17,19,23};
        int silinecekIndeks=1;
        System.out.print("Min Heap başlangıç: ");
        Main.diziyiYazdir(min_heap);
        System.out.print("\nMin heap son durum: ");
        sil(min_heap,silinecekIndeks);
        System.out.print("\nHeapsort ile sıralı: ");
        min_sort(min_heap);
    }
    // Minimum heap fonksiyonları.
    private static void min_sort(int[]heap){
        min_build(heap);
        int b = heap.length-1; // heapsize[heap]
        for(int i = b-1;i>0;i--)
        {
            degistir(heap,0,i);
            b-=1; // heapsize
            min_heapify(heap,0,b);
        }
        for(int j=0;j<heap.length-1;j++)
            System.out.print(heap[j]+" ");
    }
    private static void min_build(int[]heap){
        int heapsize = heap.length-1;
        for(int i=((int)Math.floor(heap.length/2))-1;i>=0;i--)
            min_heapify(heap,i,heapsize);
    }
    private static void min_heapify(int[]heap,int i,int heapsize){
        int sol = sol(i); // sol cocuk
        int sag = sag(i); // sag cocuk
        int enk = i; // en kucuk deger yani parent  .
        if(sol<heapsize && heap[sol]<heap[enk])
            enk=sol;
        if(sag<heapsize && heap[sag]<heap[enk])
            enk=sag;
        if(enk != i) {
            degistir(heap, i, enk);
            min_heapify(heap, enk,heapsize);
        }
    }
    // Belirli bir node'u nasıl silebilirim ? Silenecek indeksteki degerle en son degeri yer degistir. Sonra heap özelligin tekrar kontrol et.
    private static void sil(int []heap,int silinecekIndeks){
        int sonEleman=heap.length-1;
        heap[silinecekIndeks]=heap[sonEleman]; // silenecek indeksle en son elemanı yer degistir.
        min_heapify(heap,silinecekIndeks,sonEleman); // heap'in heap özeligini saglayıp saglamadıgını kontrol et.
        for(int i=0;i<sonEleman;i++)
            System.out.print(heap[i]+" ");
    }


    //////////////////////// *********------------ SORU 2 ----------------*********//////////////////
    public static void soru2(){
        int[] min_heap={5,7,11,8,10,22,12,14,20,11};
        System.out.print("Min heap: ");
        Main.diziyiYazdir(min_heap);
        System.out.print("\nMax heap: ");
        donustur(min_heap);

    }
    // Maximum heap'e dönüştürmek için sadece build ve max heapify fonksiyonları yeterli oldugunu gördm.
    private static void donustur(int[]heap){
        build(heap);
        Main.diziyiYazdir(heap);
    }
    private static void build(int []heap){
        for(int i=(heap.length-2)/2;i>=0;i--)
            max_heapify(heap,i);
    }
    private static void max_heapify(int[]heap,int i){
        int heapsize= heap.length;
        int sol = sol(i); // sol cocuk
        int sag = sag(i); // sag cocuk
        int enb = i; // en buyuk deger yani parent/root .
        if(sol<heapsize && heap[sol]>heap[enb])
            enb=sol;
        if(sag<heapsize && heap[sag]>heap[enb])
            enb=sag;
        if(enb != i) {
            degistir(heap, i, enb);
            max_heapify(heap, enb);
        }
    }

    // Ortak fonksiyonlar
    private static void degistir(int []dizi,int atanacakdeger,int ilkdeger){
        int mandal = dizi[atanacakdeger];
        dizi[atanacakdeger]=dizi[ilkdeger];
        dizi[ilkdeger]=mandal;
    }
    private static int sol(int i){
        return 2*(i+1)-1;
    } //0 dan başladıgım için i ile degil i+1 ile çarpıyorum.ilk sol cocuk i=0 için i=1 bulunmalı.
    private static int sag(int i){
        return 2*(i+1);
    }

}
public class Main {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        System.out.println("Soru-1: Aşağıdaki min heap yapısından \"7\" elemanını siliniz ve yeniden heapsort ile sıralayan kodu yazınız.");
        heapSort.soru1();
        System.out.println("\n\nSoru-2: Aşağıdaki min heap yapısını -> max heap'e dönüştürünüz.");
        heapSort.soru2();
    }
    public static void diziyiYazdir(int[]dizi) {
        for (int i:dizi)
            System.out.print(i+" ");
    }

}
