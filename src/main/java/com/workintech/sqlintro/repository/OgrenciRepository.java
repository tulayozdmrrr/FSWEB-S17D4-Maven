package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    //Öğrenci tablosundaki tüm kayıtları listeleyin.
    String QUESTION_1 = "select * from ogrenci";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();

    //Öğrenci tablosundaki kız öğrencileri listeleyin.
    String QUESTION_2 = "select * from ogrenci where cinsiyet='K'";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();

    //Öğrenci tablosunda kaydı bulunan sınıfların adını her sınıf bir kez görüntülenecek şekilde listeleyiniz
    String QUESTION_3 = "select distinct sinif from ogrenci";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();

    //Öğrenci tablosunda, 10A sınıfında olan kız öğrencileri listeleyiniz.
    String QUESTION_4 = "select * from ogrenci where cinsiyet='K' and sinif='10A'";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();

    //Öğrenci numarası 5 ile 10 arasında olan Kız öğrencileri listeleyiniz.
    String QUESTION_5 = "select * from ogrenci where cinsiyet='K' and ogrno>5 and ogrno<10";
    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();

    // Öğrencileri adına göre sıralayınız (alfabetik)
    String QUESTION_6 = "select * from ogrenci order by ad collate \\\"tr_TR\\\" asc";
    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();

    // 10A sınıfındaki öğrencileri okul numarasına göre azalan olarak sıralayınız.
    String QUESTION_7 = "select * from ogrenci where sinif='10A' order by ogrno desc";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();

    //Öğrenciler tablosundaki en genç öğrenciyi listeleyiniz.
    String QUESTION_8 = "select * from ogrenci order by dtarih desc limit 1";
    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();

    //Öğrenciler tablosundaki en yaşlı öğrenciyi listeleyiniz.
    String QUESTION_9 = "select * from ogrenci order by dtarih limit 1";
    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();

    //İkinci harfi E olan ogrencileri listeleyiniz.
    String QUESTION_10 = "select * from ogrenci where ad ilike '_E%'";
    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();

}