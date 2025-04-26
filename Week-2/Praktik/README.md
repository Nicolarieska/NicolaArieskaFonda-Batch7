# 🌡️ BELAJAR KONVERSI SUHU MELALUI PSEUDOCODE DAN OOP
![image](https://github.com/user-attachments/assets/8409beb0-ddb2-4a53-81ae-8be5061a3edd)

- **Algoritma dan Pseudocode** adalah dua hal yang sering muncul ketika kita baru masuk pada dunia IT. Dimana algoritma sendiri adalah serangkaian langkah yang terdefinisi secara logis dan sistematis dalam memecahkan masalah atau tujuan tertentu. Untuk menulis algoritma, langkah yang kita definisikan haruslah jelas, urut dan runtut walaupun terdapat sebagian masalah yang pada langkahnya dapat ditukar atau tidak harus urut.
  Sedangkan pseudocode adalah bagaimana cara kita dalam menuliskan algoritma yang kita buat dan dapat dipahami oleh manusia. Dalam penulisan Pseudocode, kita dapat menggunakan bahasa pemrograman tetapi tanpa sintak khusus seperti **IF, ELSE, RETURN, SET, DLL**. Dan berikut detail perbedaan Algoritma dan Pseudocode yaitu :
  
<div align="center">

| **Algoritma**                                                                                                                   | **Pseudocode**                                                                                                                          |
|:-------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------:|
| Algoritma digunakan untuk memberikan solusi terhadap masalah tertentu dalam bentuk langkah-langkah yang terdefinisi dengan baik | Pseudocode adalah deskripsi algoritma langkah demi langkah dalam struktur seperti kode yang menggunakan teks bahasa yang mudah dipahami | 
| Algoritma hanya menggunakan kata-kata bahasa sederhana                                                                          | kode palsu karena kata pseudo berarti palsu, menggunakan struktur seperti kode dan teks bahasa biasa                                    | 
| Tidak ada aturan dalam menulis algoritma                                                                                        | Ada aturan tertentu dalam penulisan pseudocode                                                                                          | 
| Algoritma dapat dianggap sebagai pseudocode                                                                                     | Pseudocode tidak dapat dianggap sebagai algoritma                                                                                       | 
| Sulit untuk dipahami dan ditafsirkan                                                                                            | Mudah dipahami dan diinterpretasikan                                                                                                    | 

</div>

- Setelah mengetahui perbedaan Algoritma dan Pseudocode, maka sekarang kita dapat membuat pseudocode untuk menyelesaikan masalah terkait konversi suhu. Satuan suhu yang sering kita jumpai adalah Celcius, Fahrenheit, Reamur dan Kelvin. Dan berikut adalah Pseudocode untuk konversi suhu tersebut yaitu :

```bash
START 

TAMPILKAN "PILIH MENU UNTUK KONVERSI SUHU :"
TAMPILKAN "1. Celcius ke Fahrenheit"
TAMPILKAN "2. Fahrenheit ke Celcius"
TAMPILKAN "3. Celcius ke Reamur"
TAMPILKAN "4. Reamur ke Celcius"
TAMPILKAN "5. Celcius ke Kelvin"
TAMPILKAN "6. Kelvin ke Celcius"

INPUT menu
INPUT nilaiSuhu

DEKLARASI hasilKonversi

SWITCH (menu):
    CASE 1:
        hasilKonversi = (nilaiSuhu * 9 / 5) + 32
        TAMPILKAN "Hasil Fahrenheit: " + hasilKonversi
        BREAK

    CASE 2:
        hasilKonversi = (nilaiSuhu - 32) * 5 / 9
        TAMPILKAN "Hasil Celcius: " + hasilKonversi
        BREAK

    CASE 3:
        hasilKonversi = nilaiSuhu * 4 / 5
        TAMPILKAN "Hasil Reamur: " + hasilKonversi
        BREAK

    CASE 4:
        hasilKonversi = nilaiSuhu * 5 / 4
        TAMPILKAN "Hasil Celcius: " + hasilKonversi
        BREAK

    CASE 5:
        hasilKonversi = nilaiSuhu + 273.15
        TAMPILKAN "Hasil Kelvin: " + hasilKonversi
        BREAK

    CASE 6:
        hasilKonversi = nilaiSuhu - 273.15
        TAMPILKAN "Hasil Celcius: " + hasilKonversi
        BREAK

    DEFAULT:
        TAMPILKAN "Menu Tidak Tersedia"
        BREAK

END SWITCH

END 
```
- Setelah membuat Pseudocode, Mungkinkah Pseudocode diatas dirubah menjadi bentuk Object Oriented Programming (OOP)? Ya, jawabannya tentu bisa namun terdapat sedikit modifikasi agar sesuai dengan kaidah pembuatan OOP. Untuk materi OOP sendiri dapat dilihat pada [**Materi OOP**](https://github.com/Nicolarieska/NicolaArieskaFonda-Batch7/blob/main/Week-2/README.md) yang berisi pengetahuan awal yang dibutuhkan untuk memahami Object Oriented Programming (OOP). Dan berikut hasil pembuatan OOP untuk konversi suhu adalah seperti dibawah ini :

```bash
START

CLASS KonversiSuhu:
    ATTRIBUTE nilaiSuhu (float)
    ATTRIBUTE satuanSuhu (String) // "C", "F", "R", "K"

    CONSTRUCTOR KonversiSuhu(nilaiSuhu, satuanSuhu):
        this.nilaiSuhu = nilaiSuhu
        this.satuanSuhu = satuanSuhu

    METHOD toCelcius():
        IF satuanSuhu == "C":
            RETURN nilaiSuhu
        ELSE IF satuanSuhu == "F":
            RETURN (nilaiSuhu - 32) * 5/9
        ELSE IF satuanSuhu == "R":
            RETURN nilaiSuhu * 5/4
        ELSE IF satuanSuhu == "K":
            RETURN nilaiSuhu - 273.15

    METHOD toFahrenheit():
        RETURN (toCelcius() * 9/5) + 32

    METHOD toReamur():
        RETURN toCelcius() * 4/5

    METHOD toKelvin():
        RETURN toCelcius() + 273.15

// --- MAIN PROGRAM ---
INPUT nilaiSuhu
INPUT satuanSuhu ("C", "F", "R", "K")

BUAT objek suhu = new KonversiSuhu(nilaiSuhu, satuanSuhu)

TAMPILKAN "Dalam Celcius: " + suhu.toCelcius()
TAMPILKAN "Dalam Fahrenheit: " + suhu.toFahrenheit()
TAMPILKAN "Dalam Reamur: " + suhu.toReamur()
TAMPILKAN "Dalam Kelvin: " + suhu.toKelvin()

END
```
- Langkah dalam pembuatan OOP pertama kali adalah melakukan pembuatan Class, Attribute dan Method. Class sendiri mempresentasikan sebuah objek yang akan diproses, Sedangkan untuk Attribute adalah hal hal yang berkaitan dengan Objek yang nantinya dapat diproses didalam Method. Dan untuk Method sendiri adalah perilaku yang dapat dilakukan oleh sebuah objek tersebut.
---
<p align="center"><strong>--- SELESAI ---</strong></p>








