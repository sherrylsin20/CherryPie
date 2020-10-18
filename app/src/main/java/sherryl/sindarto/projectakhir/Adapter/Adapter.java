package sherryl.sindarto.projectakhir.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sherryl.sindarto.projectakhir.Model.Makanan;
import sherryl.sindarto.projectakhir.R;

public class Adapter extends RecyclerView.Adapter<Adapter.OrderViewHolder>{
    private Context context;
    private ArrayList<Makanan> makanan;

    public Adapter(Context context){
        this.context = context;
    }
    public void setOrder(ArrayList<Makanan> makanan){
        this.makanan = makanan;
    }

    @NonNull
    @Override
    public Adapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_pesanan, parent, false);
        return new Adapter.OrderViewHolder(view);
    }
    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull Adapter.OrderViewHolder holder, int position){
        holder.nama.setText(makanan.get(position).getNama_makanan());
        holder.harga.setText(Double.toString(makanan.get(position).getHarga()));
    }
    public int getItemCount(){
        return makanan.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{
        private TextView nama, harga;
        public OrderViewHolder(@NonNull View itemView){
            super(itemView);
            nama = itemView.findViewById(R.id.textViewMakanan);
            harga = itemView.findViewById(R.id.textViewHarga);
        }
    }
}

