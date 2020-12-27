package org.aplas.bissmillah_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static org.aplas.bissmillah_uas.Database.mDatabase;

public class TambahSiswaActivity extends AppCompatActivity {
    EditText editTextNama, editTextNomer, editTextKelas, eNilaiTugas1, eNilaiTugas2, eNilaiTugas3,
            eNilaiTugas4, eNilaiTugas5, eNilaiTugas6, eNilaiTugas7, eNilaiTugas8, eNilaiTugas9, eNilaiTugas10,
            eNilaiTugas11, eNilaiTugas12, eNilaiTugas13, eNilaiTugas14, eNilaiTugas15, eNilaiTugas16, eNilaiTugas17,
            eNilaiTugas18, eNilaiTugas19, eNilaiTugas20, eNilaiTugas21, eNilaiTugas22, eNPH, eNPTS, eNPAS, eSpiritual, eSosial;
    Spinner spinnerSemester;
    TextView textViewHasilNilaiTugas, textViewHasilNilaiAkhir, textViewHasilNilaiRapot;
    Button bHitungNPH, bHitungNilaiAkhir, bSimpan;
    int nph;
    double totalAkhir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);
        editTextNama = findViewById(R.id.editTextNama);
        editTextNomer = findViewById(R.id.editTextNomer);
        editTextKelas = findViewById(R.id.editTextKelas);
        eNilaiTugas1 = findViewById(R.id.eNilaiTugas1);
        eNilaiTugas2 = findViewById(R.id.eNilaiTugas2);
        eNilaiTugas3 = findViewById(R.id.eNilaiTugas3);
        eNilaiTugas4 = findViewById(R.id.eNilaiTugas4);
        eNilaiTugas5 = findViewById(R.id.eNilaiTugas5);
        eNilaiTugas6 = findViewById(R.id.eNilaiTugas6);
        eNilaiTugas7 = findViewById(R.id.eNilaiTugas7);
        eNilaiTugas8 = findViewById(R.id.eNilaiTugas8);
        eNilaiTugas9 = findViewById(R.id.eNilaiTugas9);
        eNilaiTugas10 = findViewById(R.id.eNilaiTugas10);
        eNilaiTugas11 = findViewById(R.id.eNilaiTugas11);
        eNilaiTugas12 = findViewById(R.id.eNilaiTugas12);
        eNilaiTugas13 = findViewById(R.id.eNilaiTugas13);
        eNilaiTugas14 = findViewById(R.id.eNilaiTugas14);
        eNilaiTugas15 = findViewById(R.id.eNilaiTugas15);
        eNilaiTugas16 = findViewById(R.id.eNilaiTugas16);
        eNilaiTugas17 = findViewById(R.id.eNilaiTugas17);
        eNilaiTugas18 = findViewById(R.id.eNilaiTugas18);
        eNilaiTugas19 = findViewById(R.id.eNilaiTugas19);
        eNilaiTugas20 = findViewById(R.id.eNilaiTugas20);
        eNilaiTugas21 = findViewById(R.id.eNilaiTugas21);
        eNilaiTugas22 = findViewById(R.id.eNilaiTugas22);
        eNPH = findViewById(R.id.eNPH);
        eNPTS = findViewById(R.id.eNPTS);
        eNPAS = findViewById(R.id.eNPAS);
        eSpiritual = findViewById(R.id.eSpiritual);
        eSosial = findViewById(R.id.eSosial);
        spinnerSemester = (Spinner) findViewById(R.id.spinnerSemester);
        textViewHasilNilaiTugas = findViewById(R.id.textViewHasilNilaiTugas);
        textViewHasilNilaiAkhir = findViewById(R.id.textViewHasilNilaiAkhir);
        textViewHasilNilaiRapot = findViewById(R.id.textViewHasilNilaiRapot);
        bHitungNPH = findViewById(R.id.bHitungNPH);
        bHitungNilaiAkhir = findViewById(R.id.bHitungNilaiAkhir);
        bSimpan = findViewById(R.id.bSimpan);

        bHitungNPH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nph =
                        (
                                Integer.parseInt(eNilaiTugas1.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas2.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas3.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas4.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas5.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas6.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas7.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas8.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas9.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas10.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas11.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas12.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas13.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas14.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas15.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas16.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas17.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas18.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas19.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas20.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas21.getText().toString()) +
                                        Integer.parseInt(eNilaiTugas22.getText().toString())
                        ) / 22;
                eNPH.setText(String.valueOf(nph));
                textViewHasilNilaiTugas.setText(String.valueOf(nph));
            }
        });

        bHitungNilaiAkhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalAkhir = ( (2* Integer.parseInt(eNPH.getText().toString()) )+
                        Integer.parseInt(eNPTS.getText().toString()) +
                        Integer.parseInt(eNPAS.getText().toString())
                        ) / 4;
                textViewHasilNilaiAkhir.setText(String.valueOf(totalAkhir));
                if(totalAkhir >= 0 && totalAkhir <=  70){
                    textViewHasilNilaiRapot.setText("D");
                }else if(totalAkhir>=71 && totalAkhir<=79){
                    textViewHasilNilaiRapot.setText(("C"));
                }else if(totalAkhir>=80 && totalAkhir <=89){
                    textViewHasilNilaiRapot.setText("B");
                } else if(totalAkhir>=90 && totalAkhir<=100){
                    textViewHasilNilaiRapot.setText("A");
                }else{
                    textViewHasilNilaiRapot.setText("Error");
                }
            }
        });

        bSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (
                        !editTextNama.getText().toString().equals("")
                                && !editTextNomer.getText().toString().equals("")
                                && !editTextKelas.getText().toString().equals("")
                                && !spinnerSemester.getSelectedItem().toString().equals("")
                                && !editTextKelas.getText().toString().equals("")
                                && !eNilaiTugas1.getText().toString().equals("")
                                && !eNilaiTugas2.getText().toString().equals("")
                                && !eNilaiTugas3.getText().toString().equals("")
                                && !eNilaiTugas4.getText().toString().equals("")
                                && !eNilaiTugas5.getText().toString().equals("")
                                && !eNilaiTugas6.getText().toString().equals("")
                                && !eNilaiTugas7.getText().toString().equals("")
                                && !eNilaiTugas8.getText().toString().equals("")
                                && !eNilaiTugas9.getText().toString().equals("")
                                && !eNilaiTugas10.getText().toString().equals("")
                                && !eNilaiTugas11.getText().toString().equals("")
                                && !eNilaiTugas12.getText().toString().equals("")
                                && !eNilaiTugas13.getText().toString().equals("")
                                && !eNilaiTugas14.getText().toString().equals("")
                                && !eNilaiTugas15.getText().toString().equals("")
                                && !eNilaiTugas16.getText().toString().equals("")
                                && !eNilaiTugas17.getText().toString().equals("")
                                && !eNilaiTugas18.getText().toString().equals("")
                                && !eNilaiTugas19.getText().toString().equals("")
                                && !eNilaiTugas20.getText().toString().equals("")
                                && !eNilaiTugas21.getText().toString().equals("")
                                && !eNilaiTugas22.getText().toString().equals("")
                                && !eNPH.getText().toString().equals("")
                                && !eNPTS.getText().toString().equals("")
                                && !eNPAS.getText().toString().equals("")
                                && !eSpiritual.getText().toString().equals("")
                                && !eSosial.getText().toString().equals("")

                ) {
                    String insertSQL = "INSERT INTO siswa \n" +
                            "(nama, nisn, kelas, semester, " +
                            "nt1, nt2,nt3,nt4,nt5," +
                            "nt6,nt7,nt8,nt9,nt10," +
                            "nt11,nt12,nt13,nt14,nt15," +
                            "nt16,nt17,nt18,nt19,nt20," +
                            "nt21,nt22,nph,npts,npas," +
                            "nspiritual,nsosial,na,nrapot)\n" +
                            "VALUES \n" +
                            "(?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?,?,?," +
                            "?,?,?);";

                    mDatabase.execSQL(insertSQL, new String[]{
                            editTextNama.getText().toString(),
                            editTextNomer.getText().toString(),
                            editTextKelas.getText().toString(),
                            spinnerSemester.getSelectedItem().toString(),

                            eNilaiTugas1.getText().toString(),
                            eNilaiTugas2.getText().toString(),
                            eNilaiTugas3.getText().toString(),
                            eNilaiTugas4.getText().toString(),
                            eNilaiTugas5.getText().toString(),

                            eNilaiTugas6.getText().toString(),
                            eNilaiTugas7.getText().toString(),
                            eNilaiTugas8.getText().toString(),
                            eNilaiTugas9.getText().toString(),
                            eNilaiTugas10.getText().toString(),

                            eNilaiTugas11.getText().toString(),
                            eNilaiTugas12.getText().toString(),
                            eNilaiTugas13.getText().toString(),
                            eNilaiTugas14.getText().toString(),
                            eNilaiTugas15.getText().toString(),

                            eNilaiTugas16.getText().toString(),
                            eNilaiTugas17.getText().toString(),
                            eNilaiTugas18.getText().toString(),
                            eNilaiTugas19.getText().toString(),
                            eNilaiTugas20.getText().toString(),

                            eNilaiTugas21.getText().toString(),
                            eNilaiTugas22.getText().toString(),
                            eNPH.getText().toString(),
                            eNPTS.getText().toString(),
                            eNPAS.getText().toString(),

                            eSpiritual.getText().toString(),
                            eSosial.getText().toString(),
                            textViewHasilNilaiAkhir.getText().toString(),
                            textViewHasilNilaiRapot.getText().toString(),
                    });

                    Toast.makeText(TambahSiswaActivity.this, "Data Siswa berhasil ditambahkan!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TambahSiswaActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}