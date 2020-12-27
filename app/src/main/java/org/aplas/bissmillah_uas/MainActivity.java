package org.aplas.bissmillah_uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.aplas.bissmillah_uas.databinding.ActivityMainBinding;
import org.aplas.bissmillah_uas.models.User;
import org.aplas.bissmillah_uas.utils.Session;

import static org.aplas.bissmillah_uas.Database.DATABASE_NAME;
import static org.aplas.bissmillah_uas.Database.createKdTable;
import static org.aplas.bissmillah_uas.Database.createSiswaTable;
import static org.aplas.bissmillah_uas.Database.createUserTable;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Database.mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createSiswaTable();
        createKdTable();
        createUserTable();

        binding.bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.eUsername.getText().toString().trim();
                String password = binding.ePassword.getText().toString().trim();
                if(username.equals("") ||password.equals("")){
                    Toast.makeText(binding.getRoot().getContext(), "Silahkan masukkan data dengan benar!",
                            Toast.LENGTH_SHORT).show();
                }else{

                    Cursor cursorUser = Database.mDatabase.rawQuery("SELECT * FROM user", null);

                    //if the cursor has some data
                    if (cursorUser.moveToFirst()) {
                        //looping through all the records
                        do {
                            String usernameRes = cursorUser.getString(5);
                            String passwordRes = cursorUser.getString(6);

                            if(username.equals(usernameRes) && password.equals(passwordRes)){
                                Session.user=new User();
                                Session.user.setNamalengkap(cursorUser.getString(1));
                                Session.user.setNip(cursorUser.getInt(2));
                                Session.user.setAlamat(cursorUser.getString(3));
                                Session.user.setMapel(cursorUser.getString(4));
                                Session.user.setUsername(cursorUser.getString(5));
                                Session.user.setPassword(cursorUser.getString(6));

                                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                                startActivity(intent);
                                finish();
                            }

                        } while (cursorUser.moveToNext());
                    }

                }
            }
        });

        binding.bRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}