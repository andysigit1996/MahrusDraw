package com.mahrus.bantuaku.mahrusdraw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mahrus.bantuaku.mahrusdraw.API.ApiService1;
import com.mahrus.bantuaku.mahrusdraw.Adapter.ListArrayAdapter1;
import com.mahrus.bantuaku.mahrusdraw.Model.ModelData1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaftarMakanan extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ArrayList<ModelData1> datamahasiswa = new ArrayList<ModelData1>();
    ListView listview;
    ListArrayAdapter1 adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_makanan);

        layout_loading = (LinearLayout) findViewById(R.id.layout_loading);

        text_load = (TextView) findViewById(R.id.text_load);
        icon_load = (ImageView) findViewById(R.id.icon_load);

        listview = (ListView) findViewById(R.id.listMhsMhs);
        listview.setOnItemClickListener(DaftarMakanan.this);
        listview.setDividerHeight(0);
        setup();

    }

    public void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService1 service = retrofit.create(ApiService1.class);

        Call<List<ModelData1>> call = service.getSemuaMhs();
        call.enqueue(new Callback<List<ModelData1>>() {
            @Override
            public void onResponse(Call<List<ModelData1>> call, Response<List<ModelData1>> response) {

                if (response.isSuccessful()) {
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++) {

                        ModelData1 data = new ModelData1(
                                response.body().get(i).getidMahasiswa(),
                                response.body().get(i).getNama(),
                                response.body().get(i).getKelas_mhs());
                        datamahasiswa.add(data);
                        Log.d("RESPON", "onResponse: " + response.body().get(i).getidMahasiswa());

                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayAdapter1(DaftarMakanan.this, R.layout.row_mahasiswa1, datamahasiswa);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar mahasiswa Kosong";
                        text_load.setText(error);
                        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_data_kosong1);
                        icon_load.setImageBitmap(icon);
                    } else {
                        layout_loading.setVisibility(View.GONE);
                    }
                } else {
                    String error = "Error Retrive Data from Server !!!";
                    text_load.setText(error);
                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network1);
                    icon_load.setImageBitmap(icon);

                }

            }

            @Override
            public void onFailure(Call<List<ModelData1>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network1);
                icon_load.setImageBitmap(icon);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            adapter.clear();
            setup();
        }
    }
}
