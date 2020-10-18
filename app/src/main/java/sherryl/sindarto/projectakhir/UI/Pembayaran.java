package sherryl.sindarto.projectakhir.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

import sherryl.sindarto.projectakhir.Adapter.Adapter;
import sherryl.sindarto.projectakhir.Data.Order;
import sherryl.sindarto.projectakhir.Data.Result;
import sherryl.sindarto.projectakhir.Model.Makanan;
import sherryl.sindarto.projectakhir.R;

public class Pembayaran extends AppCompatActivity {

    private RecyclerView rv;

    TextView namaResto, totalHarga;
    Button buttonBayar;

    Random random = new Random();

    int idOrder;
    private ArrayList<Makanan> makanans;
    private Order order;

    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        makanans = getIntent().getParcelableArrayListExtra("makanan");

        namaResto = findViewById(R.id.textViewNamaResto);
        String nama = getIntent().getStringExtra("nama resto");
        namaResto.setText(nama);

        totalHarga = findViewById(R.id.textViewTotalHarga);
        double total = getIntent().getDoubleExtra("total harga", 0);
        totalHarga.setText(String.valueOf(total));

        idOrder = new Random().nextInt();

        order = new Order(idOrder, makanans, false);


        buttonBayar = findViewById(R.id.buttonBayar);
        buttonBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference();
                reff.child("Orders").child(String.valueOf(idOrder)).setValue(order);
                Toast.makeText(Pembayaran.this, "Berhasil order, silahkan bayar di kasir!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Pembayaran.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this);
        adapter.setOrder(makanans);
        rv.setAdapter(adapter);
    }
}
