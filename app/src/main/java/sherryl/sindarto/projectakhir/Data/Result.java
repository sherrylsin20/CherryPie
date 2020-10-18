package sherryl.sindarto.projectakhir.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("nomor_orderan")
    @Expose
    private int nomor_orderan;
    @SerializedName("nama_makanan")
    @Expose
    private String nama_makanan;
    @SerializedName("jumlah")
    @Expose
    private double jumlah;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("status_pembayaran")
    @Expose
    private boolean status;

    public int getNomor_orderan() {
        return nomor_orderan;
    }

    public void setNomor_orderan(int nomor_orderan) {
        this.nomor_orderan = nomor_orderan;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
