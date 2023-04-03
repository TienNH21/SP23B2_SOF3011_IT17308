package repositories;

import Utils.HibernateUtil;
import domain_model.KhachHang;
import domain_model.NhanVien;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

public class NhanVienRepository {
    private Session hSession;

    public NhanVienRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public NhanVien login(String ma, String matKhau)
    {
        String hql = "SELECT nv FROM NhanVien nv " +
                "WHERE nv.ma = ?1 AND nv.matKhau = ?2";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter(1, ma);
        q.setParameter(2, matKhau);

        try {
            NhanVien nv = q.getSingleResult();
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
