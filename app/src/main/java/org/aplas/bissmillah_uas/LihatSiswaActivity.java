package org.aplas.bissmillah_uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import org.aplas.bissmillah_uas.databinding.ActivityLihatSiswaBinding;

public class LihatSiswaActivity extends AppCompatActivity {
    ActivityLihatSiswaBinding binding ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lihat_siswa);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
        Cursor cursorSiswa = Database.mDatabase.rawQuery("SELECT * FROM siswa WHERE id=?;",
                new String[]{intent.getStringExtra("id")});

        if (cursorSiswa.moveToFirst()) {
            do {
                binding.editTextNama.setText("Nama : " + cursorSiswa.getString(1));
                binding.editTextNomer.setText("NISN : " +cursorSiswa.getString(2));
                binding.editTextKelas.setText("Kelas : " +cursorSiswa.getString(3));
                binding.spinnerSemester.setText("Semester : " +cursorSiswa.getString(4));
                binding.eNilaiTugas1.setText("Nilai Tugas 1 : " +cursorSiswa.getString(5));
                binding.eNilaiTugas2.setText("Nilai Tugas 2 : " +cursorSiswa.getString(6));
                binding.eNilaiTugas3.setText("Nilai Tugas 3 : " +cursorSiswa.getString(7));
                binding.eNilaiTugas4.setText("Nilai Tugas 4 : " +cursorSiswa.getString(8));
                binding.eNilaiTugas5.setText("Nilai Tugas 5 : " +cursorSiswa.getString(9));
                binding.eNilaiTugas6.setText("Nilai Tugas 6 : " +cursorSiswa.getString(10));
                binding.eNilaiTugas7.setText("Nilai Tugas 7 : " +cursorSiswa.getString(11));
                binding.eNilaiTugas8.setText("Nilai Tugas 8 : " +cursorSiswa.getString(12));
                binding.eNilaiTugas9.setText("Nilai Tugas 9 : " +cursorSiswa.getString(13));
                binding.eNilaiTugas10.setText("Nilai Tugas 10 : " +cursorSiswa.getString(14));
                binding.eNilaiTugas11.setText("Nilai Tugas 11 : " +cursorSiswa.getString(15));
                binding.eNilaiTugas12.setText("Nilai Tugas 12 : " +cursorSiswa.getString(16));
                binding.eNilaiTugas13.setText("Nilai Tugas 13 : " +cursorSiswa.getString(17));
                binding.eNilaiTugas14.setText("Nilai Tugas 14 : " +cursorSiswa.getString(18));
                binding.eNilaiTugas15.setText("Nilai Tugas 15 : " +cursorSiswa.getString(19));
                binding.eNilaiTugas16.setText("Nilai Tugas 16 : " +cursorSiswa.getString(20));
                binding.eNilaiTugas17.setText("Nilai Tugas 17 : " +cursorSiswa.getString(21));
                binding.eNilaiTugas18.setText("Nilai Tugas 18 : " +cursorSiswa.getString(22));
                binding.eNilaiTugas19.setText("Nilai Tugas 19 : " +cursorSiswa.getString(23));
                binding.eNilaiTugas20.setText("Nilai Tugas 20 : " +cursorSiswa.getString(24));
                binding.eNilaiTugas21.setText("Nilai Tugas 21 : " +cursorSiswa.getString(25));
                binding.eNilaiTugas22.setText("Nilai Tugas 22 : " +cursorSiswa.getString(26));
                binding.eNPH.setText("Nilai Total Tugas Harian : " +cursorSiswa.getString(27));
                binding.eNPTS.setText("Nilai Ujian Tengah Semester : " +cursorSiswa.getString(28));
                binding.eNPAS.setText("Nilai Ujian Akhir Semester : " +cursorSiswa.getString(29));
                binding.eSpiritual.setText("Nilai Spiritual : " +cursorSiswa.getString(30));
                binding.eSosial.setText("Nilai Sosial : " +cursorSiswa.getString(31));
                binding.textViewHasilNilaiAkhir.setText(cursorSiswa.getString(32));
                binding.textViewHasilNilaiRapot.setText(cursorSiswa.getString(33));



            } while (cursorSiswa.moveToNext());


        }

    }
}