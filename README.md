Nama  : Arta Eka Yuly Rajagukguk
NIM  : 123140209
Matkul  : Pengembangan Aplikasi Mobile

Deskripsi:
Aplikasi Android sederhana yang mensimulasikan news feed realtime menggunakan Kotlin. Berita muncul otomatis setiap 2 detik dan pengguna dapat menandai berita yang telah dibaca.

Fitur:
Berita muncul otomatis setiap 2 detik (Flow)
Menampilkan kategori berita (Hiburan, Musik, Kecantikan)
Transformasi data sebelum ditampilkan
Menghitung jumlah berita yang dibaca (StateFlow)
Proses asynchronous menggunakan Coroutines

Screenshot:
1. Mengedit build.gradle.kts (Module: app) untuk menambahkan dependency Compose, ViewModel, dan Coroutines.
   Melakukan Gradle Sync agar semua library terpasang
   
![Tampilan Aplikasi](gambar1.png)

2. Membuat class News.kt sebagai model data berita
![Tampilan Aplikasi](gambar2.png)

3. Membuat NewsRepository.kt untuk menghasilkan berita otomatis menggunakan Flow
![Tampilan Aplikasi](gambar3.png)

4. Membuat NewsViewModel.kt untuk mengelola data dan status aplikasi
![Tampilan Aplikasi](gambar4.png)

5. Menambahkan logic Flow, StateFlow, dan Coroutine pada ViewModel
![Tampilan Aplikasi](gambar5.png)

6. Mendesain tampilan aplikasi di MainActivity.kt menggunakan Jetpack Compose
![Tampilan Aplikasi](gambar6.png)
![Tampilan Aplikasi](gambar7.png)

7. Menjalankan aplikasi di emulator untuk memastikan fitur berjalan baik
   
![Screenshot hasil](Screenshot%202026-03-11%20051718.png)
