package controllers.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;
import view_model.QLKhachHang;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

@WebServlet({
    "/khach-hang/index",    // GET
    "/khach-hang/create",   // GET
    "/khach-hang/store",    // POST
    "/khach-hang/edit",     // GET
    "/khach-hang/update",   // POST
    "/khach-hang/delete",   // GET
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public KhachHangServlet()
    {
        this.khRepo = new KhachHangRepository();
        this.khRepo.insert(new QLKhachHang("PH1", "Ng", "Van", "AAA", "12/12/2020", "0123123123", "HN", "123456", "VN", "HN"));
        this.khRepo.insert(new QLKhachHang("PH2", "Tran", "Van", "B", "12/12/2018", "0123123423", "ND", "123456", "VN", "HN"));
    }

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
             this.edit(request, response);
        } else if (uri.contains("delete")) {
             this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang qlkh = this.khRepo.findByMa(ma);
        request.setAttribute("kh", qlkh);
        request.getRequestDispatcher("/views/khach_hang/edit.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSach", this.khRepo.findAll());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp")
            .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        QLKhachHang qlkh = this.khRepo.findByMa(ma);
        if (qlkh == null) {
            System.out.println("Không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.khRepo.delete(qlkh);
            response.sendRedirect("/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/index");
        }
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/index");
        }
    }

    protected void update(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        QLKhachHang qlkh = new QLKhachHang();

        try {
            BeanUtils.populate(qlkh, request.getParameterMap());
            this.khRepo.update(qlkh);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/index");
    }

    protected void store(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String ten_dem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String ngay_sinh = request.getParameter("ngay_sinh");
        String sdt = request.getParameter("sdt");
        String dia_chi = request.getParameter("dia_chi");
        String mat_khau = request.getParameter("mat_khau");
        String quoc_gia = request.getParameter("quoc_gia");
        String thanh_pho = request.getParameter("thanh_pho");

        QLKhachHang qlkh = new QLKhachHang(ma, ho, ten_dem, ten, ngay_sinh, sdt, dia_chi, mat_khau, quoc_gia, thanh_pho);
        this.khRepo.insert(qlkh);
        System.out.println("Thêm thành công");
        response.sendRedirect("/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/index");
    }
}
