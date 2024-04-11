package com.berkayg._01_JDBC_SchoolDB;

import com.berkayg._01_JDBC_SchoolDB.entity.Ders;
import com.berkayg._01_JDBC_SchoolDB.entity.Ogrenci;
import com.berkayg._01_JDBC_SchoolDB.repository.DersRepository;
import com.berkayg._01_JDBC_SchoolDB.repository.OgrenciRepository;

import java.util.Scanner;

public class Runner {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int secim;
        do {
            System.out.println("""
                    ****** OKUL OTOMASYONU ******
                    1- Ogrenci Ekle
                    2- Ogrenci Listele
                    3- Ogrenci Duzenle
                    4- Ders Ekle
                    5- Ders Listele
                    6- Ders Duzenle
                    7- Ders Sil
                    0- CIKIS
                                   
                    """);
            System.out.print("Lutfen seciminizi giriniz....: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 1:
                    ogrenciEkle();
                    break;
                case 2:
                    ogrenciListele();
                    break;
                case 3:
                    ogrenciGuncelle();
                    break;
                case 4:
                    dersEkle();
                    break;
                case 5:
                    dersListele();
                    break;
                case 6:
                    dersGuncelle();
                    break;
                case 7:
                    dersSil();
                    break;
                    
                case 0:
                    System.out.println("Cisik yapildi...");
                    break;
                default:
                    System.out.println("Gecersiz secim yapildi...");
            }
        } while (secim != 0); //seçim 0 değil ise dönmeye devam et.
        System.out.println("Program Sonlandı...");

    }

    private static void dersSil() {
        System.out.print("Silinecek dersin id numarasini giriniz: ");
        int silinecekDersId = scanner.nextInt();  scanner.nextLine();

        new DersRepository().delete(silinecekDersId);
    }

    private static void dersGuncelle() {
        System.out.print("Guncellenecek dersin id numarasini giriniz: ");
        int guncellenecekDersId = scanner.nextInt();  scanner.nextLine();

        System.out.println("Ders adi: ");
        String ad = scanner.nextLine();

        Ders guncellenecekDers = new Ders(guncellenecekDersId,ad);
        new DersRepository().update(guncellenecekDers);

    }

    private static void dersListele() {
        new DersRepository().findAll().forEach(System.err::println);
    }

    private static void dersEkle() {
        System.out.print("Ders adi: ");
        String ad = scanner.nextLine();
        new DersRepository().save(new Ders(ad));
    }

    private static void ogrenciGuncelle() {

        System.out.print("Guncellenecek ogrencinin id numarasini giriniz: ");
        int guncellenecekOgrenciId = scanner.nextInt();  scanner.nextLine();
        System.out.println("Ogrenci adi: ");
        String ad = scanner.nextLine();
        System.out.println("Ogrenci soyadi: ");
        String soyad = scanner.nextLine();
        System.out.println("Ogrenci yas: ");
        int yas = scanner.nextInt(); scanner.nextLine();
        System.out.println("Veli adi: ");
        String veliad = scanner.nextLine();
        System.out.println("Iletisim tel: ");
        String iletisimtel = scanner.nextLine();
        Ogrenci guncellenenOgrenci = new Ogrenci(guncellenecekOgrenciId,ad,soyad,yas,veliad,iletisimtel);
        new OgrenciRepository().update(guncellenenOgrenci);
    }

    private static void ogrenciListele() {
        new OgrenciRepository().findAll().forEach(System.out::println);
    }


    private static void ogrenciEkle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ogrenci adi: ");
        String ad = scanner.nextLine();
        System.out.print("Ogrenci soyadi: ");
        String soyad = scanner.nextLine();
        System.out.print("Ogrenci yas: ");
        int yas = scanner.nextInt(); scanner.nextLine();
        System.out.print("Veli adi: ");
        String veliad = scanner.nextLine();
        System.out.print("Iletisim tel: ");
        String iletisimtel = scanner.nextLine();
        Ogrenci yeniOgrenci = new Ogrenci(ad,soyad,yas,veliad,iletisimtel);
        new OgrenciRepository().save(yeniOgrenci);

    }
   
}
