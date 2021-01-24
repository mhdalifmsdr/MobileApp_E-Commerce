package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class submain_hasil_pesanan extends AppCompatActivity {

    private Button kirimPesanan;
    private CheckBox pesanSetuju;

    TextView Nama;
    TextView Alamat;

    TextView HargaAyam;
    TextView HargaWings;

    TextView sambalMerah;
    TextView sambalIjo;
    TextView Lalapan;
    TextView Nasi;
    TextView TotalPembayaran;

    String namaEmail = "";
    String alamatEmail = "";

    String hargaAyamEmail = "";
    String hargaWingsEmail = "";

    String hargaCbMerahEmail = "";
    String hargaCbIjoEmail = "";
    String hargaLalapanEmail = "";
    String hargaNasiEmail = "";

    String totalBayarEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submain_hasil_pesanan);

        Intent intent = getIntent();
        Nama = (TextView) findViewById(R.id.txt_nmPemesan);
        Alamat = (TextView) findViewById(R.id.txt_alamat);

        HargaAyam = (TextView) findViewById(R.id.txt_harga_ayam);
        HargaWings = (TextView) findViewById(R.id.txt_harga_wings);

        sambalMerah = (TextView) findViewById(R.id.txt_cbMerah);
        sambalIjo = (TextView) findViewById(R.id.txt_cbIjo);
        Lalapan = (TextView) findViewById(R.id.txt_lalapan);
        Nasi = (TextView) findViewById(R.id.txt_nasi);



        Nama.setText(intent.getExtras().getString("nama"));
        Alamat.setText(intent.getExtras().getString("alamat"));

        HargaAyam.setText(intent.getExtras().getString("hargaAyam"));
        HargaWings.setText(intent.getExtras().getString("hargaWings"));

        sambalMerah.setText(intent.getExtras().getString("sambalMerah"));
        sambalIjo.setText(intent.getExtras().getString("sambalIjo"));
        Lalapan.setText(intent.getExtras().getString("lalapan"));
        Nasi.setText(intent.getExtras().getString("nasi"));

        Boolean trueSambalMerah = getIntent().getExtras().getBoolean("sambalMerah");
        Boolean trueSambalIjo = getIntent().getExtras().getBoolean("sambalIjo");
        Boolean trueLalapan = getIntent().getExtras().getBoolean("lalapan");
        Boolean trueNasi = getIntent().getExtras().getBoolean("nasi");

        if(trueSambalMerah){
            sambalMerah.setText("3500");
        }else{
            sambalMerah.setText("0");
        }

        if(trueSambalIjo){
            sambalIjo.setText("4000");
        }else{
            sambalIjo.setText("0");
        }

        if(trueLalapan){
            Lalapan.setText("3000");
        }else{
            Lalapan.setText("0");
        }

        if(trueNasi){
            Nasi.setText("5000");
        }else{
            Nasi.setText("0");
        }

        //mengubah string menjadi int agar dapat di hitung
        String stringAyamGoreng = HargaAyam.getText(). toString();
        int intAyamGoreng = Integer.parseInt(stringAyamGoreng);

        String stringChickenWings = HargaWings.getText(). toString();
        int intChickenWings = Integer.parseInt(stringChickenWings);

        String stringSambalMerah= sambalMerah.getText(). toString();
        int intSambalMerah = Integer.parseInt(stringSambalMerah);

        String stringSambalIjo= sambalIjo.getText(). toString();
        int intSambalIjo = Integer.parseInt(stringSambalIjo);

        String stringLalapan= Lalapan.getText(). toString();
        int intLalapan = Integer.parseInt(stringLalapan);

        String stringNasi= Nasi.getText(). toString();
        int intNasi = Integer.parseInt(stringNasi);

        int total = intAyamGoreng + intChickenWings + intSambalMerah + intSambalIjo + intLalapan + intNasi;
        TotalPembayaran = (TextView) findViewById(R.id.txt_total_harga);
        TotalPembayaran.setText(total+"");
        kirimPesanan = (Button)findViewById(R.id.btn_pesan);

    }

    public String getNamaEmail(){
        TextView namaEmail = (TextView)findViewById(R.id.txt_nmPemesan);
        String nama = namaEmail.getText().toString();
        return nama;
    }

    public String getAlamatEmail(){
        TextView alamatEmail = (TextView)findViewById(R.id.txt_nmPemesan);
        String alamat = alamatEmail.getText().toString();
        return alamat;
    }

    public String getHargaAyamEmail(){
        TextView hargaAyamEmail = (TextView)findViewById(R.id.txt_harga_ayam);
        String hargaAyam = String.valueOf(hargaAyamEmail);
        return hargaAyam;
    }


    public String getHargaWingsEmail(){
        TextView hargaWingsEmail = (TextView)findViewById(R.id.txt_harga_wings);
        String hargaWings = String.valueOf(hargaWingsEmail);
        return hargaWings;
    }

    public String getHargaCbMerahEmail(){
        TextView hargaCbMerahEmail = (TextView)findViewById(R.id.txt_cbMerah);
        String hargaCbMerah = String.valueOf(hargaCbMerahEmail);
        return hargaCbMerah;
    }

    public String getHargaCbIjoEmail(){
        TextView hargaCbIjoEmail = (TextView)findViewById(R.id.txt_cbIjo);
        String hargaCbIjo = String.valueOf(hargaCbIjoEmail);
        return hargaCbIjo;
    }
    public String getHargaLalapanEmail(){
        TextView hargaLalapanEmail = (TextView)findViewById(R.id.txt_lalapan);
        String hargaLalapan = String.valueOf(hargaLalapanEmail);
        return hargaLalapan;
    }
    public String getHargaNasiEmail(){
        TextView hargaNasiEmail = (TextView)findViewById(R.id.txt_nasi);
        String hargaNasi = String.valueOf(hargaNasiEmail);
        return hargaNasi;
    }
    public String getTotalBayarEmail(){
        TextView totalBayarEmail = (TextView)findViewById(R.id.txt_total_harga);
        String totalBayar = String.valueOf(totalBayarEmail);
        return totalBayar;
    }




    public void onClick(View v) {
        pesanSetuju = (CheckBox) findViewById(R.id.cb_setuju);
        namaEmail = Nama.getText().toString();
        alamatEmail = Alamat.getText().toString();

        hargaAyamEmail = HargaAyam.getText().toString();
        hargaWingsEmail = HargaWings.getText().toString();

        hargaCbMerahEmail = sambalMerah.getText().toString();
        hargaCbIjoEmail = sambalIjo.getText().toString();
        hargaLalapanEmail = Lalapan.getText().toString();
        hargaNasiEmail = Nasi.getText().toString();
        totalBayarEmail = TotalPembayaran.getText().toString();





        String pesanan = String.format
                ("Nama Pemesan : %s" + "\nAlamat Pemesan : %s" + "\nAyam Goreng Original : %s" +
                "\nChicken Wings : %s" +
                "\nSambal Merah : %s" +
                "\nSambal Ijo : %s" +
                "\nLalapan : %s" +
                "\nNasi : %s" +
                "\nTotal Pembayaran : %s" +
                "\n", namaEmail, alamatEmail, hargaAyamEmail, hargaWingsEmail,hargaCbMerahEmail,hargaCbIjoEmail,
                hargaLalapanEmail, hargaNasiEmail, totalBayarEmail);


        if(pesanSetuju.isChecked()) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:alifmuhammad30@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Order Pesanan dari : " + namaEmail);
            intent.putExtra(Intent.EXTRA_TEXT, pesanan);
            startActivity(Intent.createChooser(intent, "Send Email"));
        }else{
            Toast.makeText(this, "Silakan checklist \"Pesanan sudah Benar\" untuk melanjutkan pengiriman email",
                    Toast.LENGTH_SHORT).show();


        }
    }
}
