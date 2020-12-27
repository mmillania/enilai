package org.aplas.bissmillah_uas.ui.siswa;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.bissmillah_uas.HomeActivity;
import org.aplas.bissmillah_uas.LihatKdActivity;
import org.aplas.bissmillah_uas.LihatSiswaActivity;
import org.aplas.bissmillah_uas.MainActivity;
import org.aplas.bissmillah_uas.R;
import org.aplas.bissmillah_uas.UbahSiswaActivity;
import org.aplas.bissmillah_uas.models.Siswa;

import java.util.List;

import static org.aplas.bissmillah_uas.Database.mDatabase;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.SiswaViewHolder> {
    List<Siswa>listSiswa;
    Context context;
    public SiswaAdapter(List<Siswa>listSiswa, Context context){
    this.listSiswa = listSiswa;
    this.context=context;
    }

    @NonNull
    @Override
    //
    public SiswaAdapter.SiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_siswa, parent, false);
        return new SiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SiswaAdapter.SiswaViewHolder holder, final int position) {
        holder.textViewNama.setText(listSiswa.get(position).getNama());
        holder.textViewNomer.setText(listSiswa.get(position).getNisn());
        holder.textViewKelas.setText(listSiswa.get(position).getKelas());
        holder.textViewSemester.setText(listSiswa.get(position).getSemester());

        holder.bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UbahSiswaActivity.class);
                intent.putExtra("id",String.valueOf(listSiswa.get(position).getId()));
                context.startActivity(intent);

            }
        });

        holder.bLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LihatSiswaActivity.class);
                intent.putExtra("id",String.valueOf(listSiswa.get(position).getId()));
                context.startActivity(intent);
            }
        });

        holder.bHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Yakin ingin menghapus data ini?");
                builder.setPositiveButton("Yakin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String sql = "DELETE FROM siswa WHERE id = ?";
                        mDatabase.execSQL(sql, new Integer[]{listSiswa.get(position).getId()});
                        Intent intent = new Intent(context, HomeActivity.class);
                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }

    public class SiswaViewHolder extends RecyclerView.ViewHolder{
    //getting views
        TextView textViewNama;
        TextView textViewNomer;
        TextView textViewKelas;
        TextView textViewSemester;
        Button bLihat;
        Button bEdit;
        Button bHapus;

        public SiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNama = itemView.findViewById(R.id.textViewNama);
            textViewNomer = itemView.findViewById(R.id.textViewNomer);
            textViewKelas = itemView.findViewById(R.id.textViewKelas);
            textViewSemester = itemView.findViewById(R.id.textViewSemester);
            bLihat = itemView.findViewById(R.id.bLihat);
            bEdit = itemView.findViewById(R.id.bEdit);
            bHapus = itemView.findViewById(R.id.bHapus);


        }
    }
}
