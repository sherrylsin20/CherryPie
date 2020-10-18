package sherryl.sindarto.projectakhir.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Makanan implements Parcelable {
    private String nama_makanan;
    private double harga;
    private double total;

    public Makanan(String nama_makanan, double harga, double total) {
        this.nama_makanan = nama_makanan;
        this.harga = harga;
        this.total = total;
    }

    public Makanan(Parcel source) {
        this.nama_makanan = source.readString();
        this.harga = source.readDouble();
        this.total = source.readDouble();
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_makanan);
        dest.writeDouble(this.harga);
        dest.writeDouble(this.total);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        @Override
        public Makanan createFromParcel(Parcel source) {
            return new Makanan(source);
        }

        @Override
        public Makanan[] newArray(int size) {
            return new Makanan[size];
        }
    };
}
