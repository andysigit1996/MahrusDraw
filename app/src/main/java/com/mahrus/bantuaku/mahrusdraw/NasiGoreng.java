package com.mahrus.bantuaku.mahrusdraw;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;

import android.view.View;

public class NasiGoreng extends Activity {

    private LinearLayout NasiGoreng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasi_goreng);

        Button btn = (Button) findViewById(R.id.mkn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NasiGoreng.this, DaftarMakanan.class));
                finish();
            }
        });

        Button btn1 = (Button) findViewById(R.id.mkn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NasiGoreng.this, DaftarMahasiswa.class));
                finish();
            }
        });
    }
}
