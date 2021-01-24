package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class submain_pemesanan extends AppCompatActivity implements View.OnClickListener {
    private EditText nama_pemesan;
    private EditText alamat_pesanan;

    private TextView harga_ayam;
    private TextView harga_wings;

    private CheckBox sambal_merah;
    private CheckBox sambal_ijo;
    private CheckBox lalapan;
    private CheckBox nasi;
    private Button btn_pesan;

    int ayamGoreng = 0;
    int satuanAyamGoreng = 10000;
    int hargaAyamGoreng = 0;

    int chickenWings = 0;
    int satuanChickenWigs = 15000;
    int hargaChickenWigs = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain_pemesanan);

        findAllViewsid();
        btn_pesan.setOnClickListener(this);
    }

    private void findAllViewsid() {
        nama_pemesan = (EditText) findViewById(R.id.nm_pemesan);
        alamat_pesanan = (EditText) findViewById(R.id.alamat_pemesan);

        harga_ayam = (TextView) findViewById(R.id.txt_harga_ayam);
        harga_wings = (TextView) findViewById(R.id.txt_harga_wings);

        sambal_merah = (CheckBox) findViewById(R.id.cb_merah);
        sambal_ijo = (CheckBox) findViewById(R.id.cb_ijo);
        lalapan = (CheckBox) findViewById(R.id.lalapan);
        nasi = (CheckBox) findViewById(R.id.nasi);
        btn_pesan = (Button) findViewById(R.id.btn_pesan);
    }

    @Override
    public void onClick(View view){
        Intent intent = new Intent (submain_pemesanan.this,submain_hasil_pesanan.class);
        intent.putExtra("nama", nama_pemesan.getText().toString());
        intent.putExtra("alamat", alamat_pesanan.getText().toString());

        intent.putExtra("hargaAyam", harga_ayam.getText().toString());
        intent.putExtra("hargaWings", harga_wings.getText().toString());

        intent.putExtra("sambalMerah", sambal_merah.isChecked());
        intent.putExtra("sambalIjo", sambal_ijo.isChecked());
        intent.putExtra("lalapan", lalapan.isChecked());
        intent.putExtra("nasi", nasi.isChecked());


                startActivity(intent);
    }


    // syntax menghitung

    // ayam goreng
    public void incrementAyamGoreng(View view) {
        ayamGoreng = ayamGoreng + 1 ;
        hargaAyamGoreng = ayamGoreng * satuanAyamGoreng;
        displayAyamGoreng(ayamGoreng);
        displayhargaAyamGoreng(hargaAyamGoreng);
    }

    public void decrementAyamGoreng(View view) {
        if (ayamGoreng < 1) {
            Toast.makeText(this,"Maaf, anda tidak bisa memesan kurang dari 0", Toast.LENGTH_SHORT). show();
            return;
        }
        ayamGoreng = ayamGoreng - 1;
        hargaAyamGoreng = ayamGoreng * satuanAyamGoreng;
        displayAyamGoreng(ayamGoreng);
        displayhargaAyamGoreng(hargaAyamGoreng);
    }

    private void displayAyamGoreng(int number) {
        TextView txtJumlahAyam = (TextView) findViewById(R.id.txt_jumlah_ayam);
        txtJumlahAyam.setText(""+number);
    }

    private void displayhargaAyamGoreng(int number) {
        TextView txtHargaAyam = (TextView) findViewById(R.id.txt_harga_ayam);
        txtHargaAyam.setText(""+number);
    }


    // chicken wigs
    public void incrementChickenWings(View view) {
        chickenWings = chickenWings + 1 ;
        hargaChickenWigs = chickenWings * satuanChickenWigs;
        displayChickenWigs(chickenWings);
        displayhargaChickenWigs(hargaChickenWigs);
    }

    public void decrementChickenWigs(View view) {
        if (chickenWings < 1) {
            Toast.makeText(this,"Maaf, anda tidak bisa memesan kurang dari 0", Toast.LENGTH_SHORT). show();
            return;
        }
        chickenWings = chickenWings - 1;
        hargaChickenWigs = chickenWings * satuanChickenWigs;
        displayChickenWigs(chickenWings);
        displayhargaChickenWigs(hargaChickenWigs);
    }

    private void displayChickenWigs(int number) {
        TextView txtJumlahWings = (TextView) findViewById(R.id.txt_jumlah_wings);
        txtJumlahWings.setText(""+number);
    }

    private void displayhargaChickenWigs(int number) {
        TextView txtHargaWings = (TextView) findViewById(R.id.txt_harga_wings);
        txtHargaWings.setText(""+number);
    }



}
