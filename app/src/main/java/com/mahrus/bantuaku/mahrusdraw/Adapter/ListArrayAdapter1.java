package com.mahrus.bantuaku.mahrusdraw.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mahrus.bantuaku.mahrusdraw.Model.ModelData1;
import com.mahrus.bantuaku.mahrusdraw.R;

import java.util.ArrayList;

/**
 * Created by JhonDev on 07/10/2016.
 */

public class ListArrayAdapter1 extends ArrayAdapter<ModelData1> {

    private ArrayList<ModelData1> list;
    private LayoutInflater inflater;
    private int res;

    public ListArrayAdapter1(Context context, int resource, ArrayList<ModelData1> list) {
        super(context, resource, list);
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        MyHolder holder = null;


        if (convertView == null) {

            convertView = inflater.inflate(res, parent, false);

            holder = new MyHolder();

            holder.ID = (TextView) convertView.findViewById(R.id.listID);
            holder.Nama = (TextView) convertView.findViewById(R.id.listNamaMhs);
            holder.Jenis = (TextView) convertView.findViewById(R.id.listJenisMhs);

            convertView.setTag(holder);

        } else {

            holder = (MyHolder) convertView.getTag();
        }

        holder.ID.setText("No. Makanan : "+list.get(position).getidMahasiswa());
        holder.Nama.setText("Nama Makanan : "+list.get(position).getNama());
        holder.Jenis.setText("Jenis Makanan : "+list.get(position).getKelas_mhs());

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void remove(ModelData1 object) {
        super.remove(object);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    static class MyHolder {

        TextView ID;
        TextView Nama;
        TextView Jenis;


    }
}
