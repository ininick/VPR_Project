# VPR_Project
PPTI 15 Cawu II Final Assignment 

Nama anggota kelompok:
Nickolas Mathew Geraldinho / 2602189511
Michello Rayhan Manuel / 2602189820
Jeremy Putra Wijaya / 2602189902

Penjelasan Class:
Class Cell: Class untuk setiap petak pada papan minesweeper, dengan atribut seperti apakah petak tersebut berisi bomb, sudah terbuka, dan sebagainya.
Class Board: Untuk papan minesweeper secara keseluruhan, dengan terdiri dari kumpulan Cell. Class ini juga memiliki method untuk menempatkan ranjau secara acak dan menghitung jumlah ranjau yang ada di sekitar sebuah petak.
Class Game: Merupakan program utama permainan minesweeper, dengan mengatur jalannya permainan dan menghubungkan antara Board dan GUI/Frame.
Class MinesweeperPanel: Memberikan tampilan GUI dari papan minesweeper, dengan menggunakan JButton untuk merepresentasikan setiap petak pada papan.
Class MinesweeperFrame: merepresentasikan frame GUI untuk permainan minesweeper.
Class MainGUI: sebagai kelas utama untuk menjalankan permainan di mode GUI.
Class GameOverFrame : Untuk menampilkan frame ketika permainan berakhir (memencet petak berisi bomb)
Class WinFrame : Untuk menampilkan frame ketika permainan dimenangkan (me-reveal semua petak yang bukan bomb, dan jumlah flag sama dengan jumlah bom)
