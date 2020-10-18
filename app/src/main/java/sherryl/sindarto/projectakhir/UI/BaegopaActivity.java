package sherryl.sindarto.projectakhir.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sherryl.sindarto.projectakhir.Data.Order;
import sherryl.sindarto.projectakhir.Model.Makanan;
import sherryl.sindarto.projectakhir.R;

public class BaegopaActivity extends AppCompatActivity {

    private Button buttonTambah, buttonTambah2, buttonPesan;
    private TextView tv_nama, tv_harga, tv_nama2, tv_harga2, tv_resto;
    public double total=0;
    private ArrayList<String> namaMakanan, hargaMakanan;
    private ArrayList<Makanan> makanans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baegopa);

        buttonTambah = findViewById(R.id.buttonTambah);
        buttonTambah2 = findViewById(R.id.buttonTambah2);
        buttonPesan = findViewById(R.id.buttonBayar);
        tv_nama = findViewById(R.id.textNamaMakanan);
        tv_harga = findViewById(R.id.textHarga);
        tv_nama2 = findViewById(R.id.textNamaMakanan2);
        tv_harga2 = findViewById(R.id.textHarga2);

        tv_resto = findViewById(R.id.textViewJudul);

        makanans = new ArrayList<>();

        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNew();
            }
        });

        buttonTambah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNew2();
            }
        });

        buttonPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPembayaran();
            }
        });

    }

    private void openPembayaran() {
        Intent intent = new Intent(this, Pembayaran.class);
        intent.putParcelableArrayListExtra("makanan", makanans);
        intent.putExtra("nama resto", tv_resto.getText().toString());
        intent.putExtra("total harga", total);
        startActivity(intent);
    }

    private void addNew() {
        String nama = tv_nama.getText().toString();
        String harga = tv_harga.getText().toString();
        total += Double.parseDouble(harga);

        makanans.add(new Makanan(nama, Double.parseDouble(harga), total));
        Toast.makeText(this, "Order berhasil masuk ke keranjang!", Toast.LENGTH_SHORT).show();
    }

    private void addNew2() {
        String nama2 = tv_nama2.getText().toString();
        String harga2 = tv_harga2.getText().toString();
        total += Double.parseDouble(harga2);

        makanans.add(new Makanan(nama2, Double.parseDouble(harga2), total));
        Toast.makeText(this, "Order berhasil masuk ke keranjang!", Toast.LENGTH_SHORT).show();
    }

}
