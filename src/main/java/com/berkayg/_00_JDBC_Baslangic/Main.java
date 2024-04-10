package com.berkayg._00_JDBC_Baslangic;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * VERİ TABANI DRIVER:
 * Bir programlama dili ile veri tabanı arasında iletişim kurmayı sağlayan yazılım veya bileşendir.
 * Veri tabanı driver'ı ile:
 * Veri tabanı sunucusuna bağlantı kurabileceğim
 * Veri tabanı ile iletişim kurup komut gönderebilirim.
 * Sorgular gönderebilirim.
 * Geri dönen değerleri alabiliriz.
 *
 * Her bir VT üreticisi her bir programlama dili için driverlar üretirler.
 *
 * PostgreSQL Java Driver' a ihtiyacımız vardır
 * bunun için Maven Repository sitesine girdik.
 * postgresql jbc driver diyerek arattık.
 * Karşımıza çıkan en son sürümün Gradle bağımlılık cümlesini kopyaladık.
 * Projemizde build.gradle açtık.
 * Bu dosya içinde depencensies bloğu içine kopyaladığımız bağımlılık cümlesini ekledik:
 * dependencies {
 *     implementation group: 'org.postgresql', name: 'postgresql', version: '42.7.3'
 * }
 * dependencies : bağımlılık (Projemizde kullandığımız harici kütüphaneler)
 */

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //JDBC kullanımında ilk olarak yapılması gereken Driver ın devreye alınmasıdır:
        Driver.class.forName("org.postgresql.Driver");
        // Javadan postgresql server a gitmem gerekli.
        // hostname: localhost
        // port: 5432
        // username: postgres
        // password : root

        // ConnectionString - Bağlantı Cümlesi
        String connectionString = "jdbc:postgresql://localhost:5432/SatisDB";
        String username = "postgres";
        String password = "root";
        // Parametrelerle bir connection oluşturduk:
        Connection connection = DriverManager.getConnection(connectionString,username,password);

        // String olarak bir sql komutu yazalım:

        String ADRES_INSERT_SQL ="INSERT INTO tbladres(musteri_id,il,ilce) VALUES (60,'İstanbul','Beşiktaş')";
        // String olarak bir sorgu direkt connection nesnesi aracılığı ile çalıştırılamaz.
        // Bunun için öncelikle bu komutun(Statement) hazırlanması gerekir.

       PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
       // bu işlem sonucunda artık yazdığımız SQL ifadesi preparedStatement nesnesi ile çalıştırılabilir hale gelmiştir.
        preparedStatement.executeUpdate();  // bu adım sorgumuzun VT serverında çalıştırılmasını sağlar.

        /**
         * preparedStatement: SQL sorgularımızı çalıştırabileceğimiz bir interface dir.
         */

        connection.close();


    }
}