package org.aplas.bissmillah_uas.ui.kd;

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
import org.aplas.bissmillah_uas.UbahKdActivity;
import org.aplas.bissmillah_uas.UbahSiswaActivity;
import org.aplas.bissmillah_uas.models.Kd;
import org.aplas.bissmillah_uas.models.Siswa;
import org.aplas.bissmillah_uas.ui.siswa.SiswaAdapter;

import java.util.List;

import static org.aplas.bissmillah_uas.Database.mDatabase;

public class KdAdapter extends RecyclerView.Adapter<KdAdapter.KdViewHolder> {

    List<Kd> listKd;
    Context context;
    public KdAdapter(List<Kd>listKd, Context context){
        this.listKd = listKd;
        this.context=context;
    }
    @NonNull
    @Override
    public KdAdapter.KdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_kd, parent, false);
        return new KdAdapter.KdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KdAdapter.KdViewHolder holder, final int position) {
        holder.textViewNoKD.setText(listKd.get(position).getNokd());
        holder.textViewKompetensiDasar.setText(listKd.get(position).getNamakd());

        holder.bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UbahKdActivity.class);
                intent.putExtra("id",String.valueOf(listKd.get(position).getId()));
                context.startActivity(intent);
            }
        });


        holder.bLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LihatKdActivity.class);
                intent.putExtra("id",String.valueOf(listKd.get(position).getId()));
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
                        String sql = "DELETE FROM kd WHERE id = ?";
                        mDatabase.execSQL(sql, new Integer[]{listKd.get(position).getId()});
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
        return listKd.size();
    }

    public class KdViewHolder extends RecyclerView.ViewHolder{
        //getting views
        TextView textViewNoKD;
        TextView textViewKompetensiDasar;

        Button bLihat;
        Button bEdit;
        Button bHapus;

        public KdViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNoKD = itemView.findViewById(R.id.textViewNoKD);
            textViewKompetensiDasar = itemView.findViewById(R.id.textViewKompetensiDasar);
            bLihat = itemView.findViewById(R.id.bLihat);
            bEdit = itemView.findViewById(R.id.bEdit);
            bHapus = itemView.findViewById(R.id.bHapus);


        }
    }
}
