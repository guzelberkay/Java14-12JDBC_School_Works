package com.berkayg._02_JDBC_SatisDB;

import com.berkayg._02_JDBC_SatisDB.entity.Musteri;
import com.berkayg._02_JDBC_SatisDB.repository.MusteriRepository;

import java.util.Optional;

public class Runner {
    public static void main(String[] args) {
        MusteriRepository musteriRepository = new MusteriRepository();
       // musteriRepository.save(new Musteri("Arda","Guler","E",431886112L,"wiacoQ1547.com","0857-963-8574"));
       // musteriRepository.findAll().forEach(System.err::println);

//        Optional<Musteri> arananMusteri = musteriRepository.findById(1007);
//        if (arananMusteri.isPresent())
//            System.out.println(arananMusteri);
//        arananMusteri.get().setEmail("arda@realmadrid.com");
//        musteriRepository.update(arananMusteri.get());
//        System.out.println("Guncelleme sonrasi");
//        Optional<Musteri> guncellenenMusteri = musteriRepository.findById(1007);
//        if (arananMusteri.isPresent())
//            System.out.println(guncellenenMusteri);

        musteriRepository.delete(1004);
        musteriRepository.findAll().forEach(System.err::println);
    }
}
