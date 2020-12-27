package org.aplas.bissmillah_uas.ui.siswa;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.aplas.bissmillah_uas.Database;
import org.aplas.bissmillah_uas.R;
import org.aplas.bissmillah_uas.TambahSiswaActivity;
import org.aplas.bissmillah_uas.models.Siswa;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    List<Siswa> listSiswa = new ArrayList<>();
    RecyclerView recyclerView;
    FloatingActionButton bTambah;

    View root;


    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        root = inflater.inflate(R.layout.list_siswa, container, false);
        recyclerView = root.findViewById(R.id.recycleSiswa);

        bTambah = root.findViewById(R.id.tambahFab);
        bTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), TambahSiswaActivity.class);
                startActivity(intent);
            }
        });
        Cursor cursorSiswa = Database.mDatabase.rawQuery("SELECT * FROM siswa;", null);
        if (cursorSiswa.moveToFirst()) {
            do {
                Siswa siswa = new Siswa();
                siswa.setId(cursorSiswa.getInt(0));
                siswa.setNama(cursorSiswa.getString(1));
                siswa.setNisn(cursorSiswa.getString(2));
                siswa.setKelas(cursorSiswa.getString(3));
                siswa.setSemester(cursorSiswa.getString(4));

                listSiswa.add(siswa);

            } while (cursorSiswa.moveToNext());

            SiswaAdapter siswaAdapter = new SiswaAdapter(listSiswa, root.getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
            recyclerView.setAdapter(siswaAdapter);
            cursorSiswa.close();
        }
        Log.d("Hai", "Kodingannya uda lewat sini lho");
        return root;
    }
}