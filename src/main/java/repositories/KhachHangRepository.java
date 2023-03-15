package repositories;

import view_model.QLKhachHang;

import java.util.ArrayList;

public class KhachHangRepository {
    private ArrayList<QLKhachHang> list;

    public KhachHangRepository()
    {
        this.list = new ArrayList<>();
    }

    public void insert(QLKhachHang qlkh)
    {
        this.list.add(qlkh);
    }

    public void update(QLKhachHang qlkh)
    {
        for (int i = 0; i < this.list.size(); i++) {
            QLKhachHang vm = this.list.get(i);
            if (vm.getMa().equals(qlkh.getMa())) {
                this.list.set(i, qlkh);
            }
        }
    }

    public void delete(QLKhachHang qlkh)
    {
        for (int i = 0; i < this.list.size(); i++) {
            QLKhachHang vm = this.list.get(i);
            if (vm.getMa().equals(qlkh.getMa())) {
                this.list.remove(i);
            }
        }
    }

    public ArrayList<QLKhachHang> findAll()
    {
        return this.list;
    }

    public QLKhachHang findByMa(String ma)
    {
        for (int i = 0; i < this.list.size(); i++) {
            QLKhachHang vm = this.list.get(i);
            if (vm.getMa().equals(ma)) {
                return vm;
            }
        }

        return null;
    }
}