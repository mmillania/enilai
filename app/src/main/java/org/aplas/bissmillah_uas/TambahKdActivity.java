package org.aplas.bissmillah_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static org.aplas.bissmillah_uas.Database.mDatabase;

public class TambahKdActivity extends AppCompatActivity {

    EditText editTextNoKD, editTextKompetensiDasar, editTextTema1,editTextTema2,editTextTema3,editTextTema4;
    Button bSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kd);
        editTextNoKD = findViewById(R.id.editTextNoKD);
        editTextKompetensiDasar = findViewById(R.id.editTextKompetensiDasar);
        editTextTema1 = findViewById(R.id.editTextTema1);
        editTextTema2 = findViewById(R.id.editTextTema2);
        editTextTema3 = findViewById(R.id.editTextTema3);
        editTextTema4 = findViewById(R.id.editTextTema4);
        bSimpan = findViewById(R.id.bSimpan);

        bSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !editTextNoKD.getText().toString().equals("")
                        &&  !editTextKompetensiDasar.getText().toString().equals("")
                        &&  !editTextTema1.getText().toString().equals("")
                        && !editTextTema2.getText().toString().equals("")
                        && !editTextTema3.getText().toString().equals("")
                        && !editTextTema4.getText().toString().equals("")
                ){
                    String insertSQL = "INSERT INTO kd \n" +
                            "(nokd, namakd, t1, t2, t3, t4)\n" +
                            "VALUES \n" +
                            "(?,?,?,?,?,?);";
                    mDatabase.execSQL(insertSQL, new String[]{
                            editTextNoKD.getText().toString(),
                            editTextKompetensiDasar.getText().toString(),
                            editTextTema1.getText().toString(),
                            editTextTema2.getText().toString(),
                            editTextTema3.getText().toString(),
                            editTextTema4.getText().toString(),
                    });
                    Toast.makeText(TambahKdActivity.this, "Data Kompetensi Dasar berhasil ditambahkan!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TambahKdActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        });

    }


}