package org.aplas.bissmillah_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static org.aplas.bissmillah_uas.Database.mDatabase;

public class UbahKdActivity extends AppCompatActivity {

    EditText editTextNoKD, editTextKompetensiDasar, editTextTema1,editTextTema2,editTextTema3,editTextTema4;
    Button bSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_kd);
        editTextNoKD = findViewById(R.id.editTextNoKD);
        editTextKompetensiDasar = findViewById(R.id.editTextKompetensiDasar);
        editTextTema1 = findViewById(R.id.editTextTema1);
        editTextTema2 = findViewById(R.id.editTextTema2);
        editTextTema3 = findViewById(R.id.editTextTema3);
        editTextTema4 = findViewById(R.id.editTextTema4);
        bSimpan = findViewById(R.id.bSimpan);

        Intent intent = getIntent();
        //ambil data
        final String id = intent.getStringExtra("id");
        Cursor cursorKd = Database.mDatabase.rawQuery("SELECT * FROM kd WHERE id=?;",
                new String[]{intent.getStringExtra("id")});

        if (cursorKd.moveToFirst()) {
            do {
                editTextNoKD.setText(cursorKd.getString(1));
                editTextKompetensiDasar.setText(cursorKd.getString(2));
                editTextTema1.setText(cursorKd.getString(3));
                editTextTema2.setText(cursorKd.getString(4));
                editTextTema3.setText(cursorKd.getString(5));
                editTextTema4.setText(cursorKd.getString(6));

            } while (cursorKd.moveToNext());
        }


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
                    //update tabel di database
                    String sql = "UPDATE kd \n" +
                            "SET nokd = ?, \n" +
                            "namakd = ?, \n" +
                            "t1 = ?, \n" +
                            "t2 = ?, \n" +
                            "t3 = ?, \n" +
                            "t4 = ? \n" +
                            "WHERE id = ?;\n";
                    mDatabase.execSQL(sql, new String[]{
                            editTextNoKD.getText().toString(),
                            editTextKompetensiDasar.getText().toString(),
                            editTextTema1.getText().toString(),
                            editTextTema2.getText().toString(),
                            editTextTema3.getText().toString(),
                            editTextTema4.getText().toString(),
                            id
                    });
                    Toast.makeText(UbahKdActivity.this, "Data Kompetensi Dasar berhasil diperbarui!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UbahKdActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        });

    }
}