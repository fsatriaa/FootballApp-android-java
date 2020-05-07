package com.fdev22.footballapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fdev22.footballapp.R;

public class DetailActivity extends AppCompatActivity {

    private TextView tvDeskripsi, tvNama, tvStadium, tvKapasitas, tvWeb;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvDeskripsi = findViewById(R.id.tv_isi);
        String isi = getIntent().getStringExtra("deskripsi");
        tvDeskripsi.setText(isi);
        tvDeskripsi.setMovementMethod(new ScrollingMovementMethod());

        tvNama = findViewById(R.id.tv_nama);
        String nama = getIntent().getStringExtra("nama");
        tvNama.setText(nama);

        ivLogo = findViewById(R.id.iv_logo);
        String logo = getIntent().getStringExtra("logo");
        Glide.with(DetailActivity.this)
                //load url
                .load(logo)
                //load gambar awal sebelum load internet muncul
                .placeholder(R.drawable.broken_image)
                //load gambar saat terjadi kesalahan muat gambar
                .error(R.drawable.broken_image)
                .into(ivLogo);

        tvStadium = findViewById(R.id.tv_stadium);
        String stadium = getIntent().getStringExtra("stadium");
        tvStadium.setText(stadium);

        tvKapasitas = findViewById(R.id.tv_kapasitas);
        String kapasitas = getIntent().getStringExtra("kapasitas");
        tvKapasitas.setText(kapasitas);

        tvWeb = findViewById(R.id.tv_web);
        String web = getIntent().getStringExtra("web");
        tvWeb.setText(web);
    }
}
