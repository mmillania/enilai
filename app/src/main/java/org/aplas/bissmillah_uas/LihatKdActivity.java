package org.aplas.bissmillah_uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import org.aplas.bissmillah_uas.databinding.ActivityLihatKdBinding;

public class LihatKdActivity extends AppCompatActivity {
    ActivityLihatKdBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lihat_kd);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("id");
        Cursor cursorKd = Database.mDatabase.rawQuery("SELECT * FROM kd WHERE id=?;",
                new String[]{intent.getStringExtra("id")});

        if (cursorKd.moveToFirst()) {
            do {
                binding.editTextNoKD.setText("No Kompetensi Dasar : " +cursorKd.getString(1));
                binding.editTextKompetensiDasar.setText("Kompetensi Dasar : " +cursorKd.getString(2));
                binding.editTextTema1.setText("Tema KD 1 : " +cursorKd.getString(3));
                binding.editTextTema2.setText("Tema KD 2 : "+cursorKd.getString(4));
                binding.editTextTema3.setText("Tema KD 3 : "+cursorKd.getString(5));
                binding.editTextTema4.setText("Tema KD 4 : "+cursorKd.getString(6));

            } while (cursorKd.moveToNext());
        }
    }
}