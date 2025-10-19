package com.workintech.sqlintro;

import com.workintech.sqlintro.repository.OgrenciRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(ResultAnalyzer.class)
class SqlIntroApplicationTests {

    private final OgrenciRepository ogrenciRepository;

    @Autowired
    public SqlIntroApplicationTests(OgrenciRepository ogrenciRepository) {
        this.ogrenciRepository = ogrenciRepository;
    }

    @DisplayName("Öğrenci tablosundaki tüm kayıtları listeleyin.")
    @Test
    void getAllStudentTest(){
        assertEquals(10, ogrenciRepository.findAll().size());
        assertEquals("Hülya", ogrenciRepository.findAll().get(0).getAd());
    }

    @DisplayName("Öğrenci tablosundaki kız öğrencileri listeleyin.")
    @Test
    void getAllGirlsTest(){
        assertEquals(5, ogrenciRepository.findGirls().size());
        assertEquals("Hülya", ogrenciRepository.findAll().get(0).getAd());
    }

    @DisplayName("Öğrenci tablosunda kaydı bulunan sınıfların adını her sınıf bir kez görüntülenecek şekilde listeleyiniz")
    @Test
    void getAllStudentBySpecialColumnsTest(){
        assertEquals(6, ogrenciRepository.findAllClasses().size());
    }

    @DisplayName("Öğrenci tablosunda, 10A sınıfında olan kız öğrencileri listeleyiniz.")
    @Test
    void getFind10AGirlsTest(){
        assertEquals(1, ogrenciRepository.find10AGirls().size());
        assertEquals("Hülya", ogrenciRepository.find10AGirls().get(0).getAd());
        assertEquals("Yiğit", ogrenciRepository.find10AGirls().get(0).getSoyad());
    }

    @DisplayName("Öğrenci numarası 5 ile 10 arasında olan Kız öğrencileri listeleyiniz.")
    @Test
    void getFindGirlsWithOgrnoTest(){
        assertEquals(3, ogrenciRepository.findGirlsWithOgrno().size());
        assertEquals("Betül", ogrenciRepository.findGirlsWithOgrno().get(0).getAd());
    }

    @DisplayName("Öğrencileri adına göre sıralayınız (alfabetik)")
    @Test
    void findStudentsAlphabeticallyTest(){
        assertEquals(10, ogrenciRepository.findStudentsAlphabetically().size());
        assertEquals("Betül", ogrenciRepository.findStudentsAlphabetically().get(0).getAd());
        assertEquals("Sema", ogrenciRepository.findStudentsAlphabetically()
                .get(ogrenciRepository.findStudentsAlphabetically().size()-1).getAd());
    }

    @DisplayName("10A sınıfındaki öğrencileri okul numarasına göre azalan olarak sıralayınız.")
    @Test
    void find10AStudentsByOgrNo(){
        assertEquals(1, ogrenciRepository.find10AStudentsByOgrNo().size());
        assertEquals("Hülya", ogrenciRepository.find10AStudentsByOgrNo().get(0).getAd());
    }

    @DisplayName("Öğrenciler tablosundaki en genç öğrenciyi listeleyiniz.")
    @Test
    public void findYoungestStudentTest(){
        assertEquals("Niyazi", ogrenciRepository.findYoungestStudent().getAd());
        assertEquals("Sevinç", ogrenciRepository.findYoungestStudent().getSoyad());
    }

    @DisplayName("Öğrenciler tablosundaki en yaşlı öğrenciyi listeleyiniz.")
    @Test
    void findElderStudentTest(){
        assertEquals("Kenan", ogrenciRepository.findElderStudent().getAd());
        assertEquals("Emin", ogrenciRepository.findElderStudent().getSoyad());
    }

    @DisplayName("İkinci harfi E olan kitapları listeleyiniz..")
    @Test
    public void findBooksSecondLetterOfNTest(){
        assertEquals(5, ogrenciRepository.findStudentsSecondLetterOfN().size());
    }
}