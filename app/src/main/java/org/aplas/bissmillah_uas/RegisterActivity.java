package org.aplas.bissmillah_uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.aplas.bissmillah_uas.databinding.ActivityRegisterBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namalengkap = binding.eNamaLengkap.getText().toString().trim();
                String nip = binding.eNIP.getText().toString().trim();
                String alamat = binding.eAlamat.getText().toString().trim();
                String mapel = binding.eMapel.getText().toString().trim();
                String username = binding.eUsername.getText().toString().trim();
                String password = binding.ePassword.getText().toString().trim();
                //getting the current time for joining date
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String joiningdate = sdf.format(cal.getTime());


                //validasi menambahkan data registerS
                if (namalengkap.equals("") || nip.equals("") || alamat.equals("") || mapel.equals("")
                        || username.equals("") || password.equals("")){
                    Toast.makeText(binding.getRoot().getContext(), "Harap isi semua data!",
                            Toast.LENGTH_SHORT).show();

                }else{

                    String insertSQL = "INSERT INTO user \n" +
                            "(namalengkap, nip, alamat, mapel, username, password, joiningdate)\n" +
                            "VALUES \n" +
                            "(?,?,?,?,?,?,?);";

                    Database.mDatabase.execSQL(insertSQL, new String[]{namalengkap, nip, alamat,
                            mapel, username, password, joiningdate});

                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(binding.getRoot().getContext(), "Akun berhasil dibuat",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}