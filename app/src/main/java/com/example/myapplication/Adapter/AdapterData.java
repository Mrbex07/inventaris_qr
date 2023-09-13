package com.example.myapplication.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.ResponseModel;
import com.example.myapplication.Model.DataModel;
import com.example.myapplication.API.APIRequestData;
import com.example.myapplication.API.RetroServer;
import com.example.myapplication.R;
import com.example.myapplication.activity.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataModel> listData;
    private List<DataModel> listPa;
    private int idPa;

    public AdapterData(Context ctx, List<DataModel> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position){
        DataModel dm = listData.get(position);

        holder.vId.setText(String.valueOf(dm.getId()));
        holder.vKode_barang.setText(dm.getKode_barang());
        holder.vNama_barang.setText(dm.getNama_barang());
        holder.vDivisi.setText(dm.getDivisi());
    }
    @Override
    public int getItemCount(){
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView vId,vKode_barang,vNama_barang,vDivisi;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            vId = itemView.findViewById(R.id.v_id);
            vKode_barang = itemView.findViewById(R.id.v_kode);
            vNama_barang = itemView.findViewById(R.id.v_nama_barang);
            vDivisi = itemView.findViewById(R.id.v_divisi);
        }
    }

}
