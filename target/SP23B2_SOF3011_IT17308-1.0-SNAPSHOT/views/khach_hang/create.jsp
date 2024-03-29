<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/10/23
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
    <link rel="stylesheet" href="/SP23B2_SOF3011_IT17308_war_exploded/css/bootstrap.min.css" />
</head>
<body>
    <div class="col-8 offset-2 bg-light">
        <form method="POST"
          action="/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/store">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="Ma" class="form-control" />
                </div>
                <div class="col-6">
                    <label>Họ</label>
                    <input type="text" name="Ho" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên đệm</label>
                    <input type="text" name="TenDem" class="form-control" />
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="Ten" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <input type="date" name="NgaySinh" class="form-control" />
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <input type="tel" name="Sdt" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <input type="text" name="DiaChi" class="form-control" />
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <input type="password" name="MatKhau" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <select name="QuocGia" class="form-select">
                        <option value="vn">Việt Nam</option>
                        <option value="en">Anh</option>
                    </select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="ThanhPho" class="form-select">
                        <option value="hanoi">Hà Nội</option>
                        <option value="london">London</option>
                    </select>
                </div>
            </div><div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
        </form>
    </div>

    <script src="/SP23B2_SOF3011_IT17308_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
