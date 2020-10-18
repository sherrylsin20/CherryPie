package sherryl.sindarto.projectakhir.Data;

import java.util.List;

import sherryl.sindarto.projectakhir.Model.Makanan;

public class Order {
    private int id;
    private List<Makanan> makanans;
    private boolean status;

    public Order(int id, List<Makanan> makanans, boolean status) {
        this.id = id;
        this.makanans = makanans;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Makanan> getMakanans() {
        return makanans;
    }

    public void setMakanans(List<Makanan> makanans) {
        this.makanans = makanans;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
