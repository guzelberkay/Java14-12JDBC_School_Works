package com.berkayg._01_JDBC_SchoolDB;

import com.berkayg._01_JDBC_SchoolDB.entity.Ogrenci;
import com.berkayg._01_JDBC_SchoolDB.repository.OgrenciRepository;

import java.util.Scanner;

public class Runner {
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
                case 0:
                    System.out.println("Cisik yapildi...");
                    break;
                default:
                    System.out.println("Gecersiz secim yapildi...");
            }
        } while (secim != 0); //seçim 0 değil ise dönmeye devam et.
        System.out.println("Program Sonlandı...");

    }

    private static void ogrenciGuncelle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guncellenecek ogrencinin id numarasını giriniz: ");
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
