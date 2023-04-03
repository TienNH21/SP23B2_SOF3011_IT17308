package controllers;

import domain_model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repositories.NhanVienRepository;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    public LoginServlet() {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/login.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("maNv");
        String matKhau = request.getParameter("matKhau");
        NhanVien nv = this.nvRepo.login(ma, matKhau);
        HttpSession session = request.getSession();
        if (nv == null) {
            // Báo lỗi
            session.setAttribute("errorMessage", "Sai tài khoản/mật khẩu");
            response.sendRedirect("/SP23B2_SOF3011_IT17308_war_exploded/login");
        } else {
            // Đăng nhập thành công
            session.setAttribute("nv", nv);
            response.sendRedirect("/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/index");
        }
    }
}
