package org.aplas.bissmillah_uas.ui.kd;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.aplas.bissmillah_uas.Database;
import org.aplas.bissmillah_uas.R;
import org.aplas.bissmillah_uas.TambahKdActivity;
import org.aplas.bissmillah_uas.TambahSiswaActivity;
import org.aplas.bissmillah_uas.databinding.FragmentHomeBinding;
import org.aplas.bissmillah_uas.models.Kd;
import org.aplas.bissmillah_uas.models.Siswa;
import org.aplas.bissmillah_uas.ui.siswa.GalleryViewModel;
import org.aplas.bissmillah_uas.ui.siswa.SiswaAdapter;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {


    List<Kd> listKd = new ArrayList<>();
    RecyclerView recyclerView;
    FloatingActionButton bTambah;

    View root;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        final View root = inflater.inflate(R.layout.list_kd, container, false);
        recyclerView = root.findViewById(R.id.recycleKd);

        bTambah = root.findViewById(R.id.tambahKdFab);
        bTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), TambahKdActivity.class);
                startActivity(intent);

            }
        });
        Cursor cursorKd = Database.mDatabase.rawQuery("SELECT * FROM kd;", null);
        if (cursorKd.moveToFirst()) {
            do {
                Kd kd = new Kd();
                kd.setId(cursorKd.getInt(0));
                kd.setNokd(cursorKd.getString(1));
                kd.setNamakd(cursorKd.getString(2));


                listKd.add(kd);

            } while (cursorKd.moveToNext());

            KdAdapter kdAdapter = new KdAdapter(listKd, root.getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
            recyclerView.setAdapter(kdAdapter);
            cursorKd.close();
        }
        Log.d("Hai", "Kodingannya uda lewat sini lho");
        return root;
    }
}