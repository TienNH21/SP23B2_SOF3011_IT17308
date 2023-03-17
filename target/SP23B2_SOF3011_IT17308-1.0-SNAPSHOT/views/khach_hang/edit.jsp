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
          action="/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/update?ma=${ kh.ma }">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" class="form-control" value="${ kh.ma }" disabled />
                </div>
                <div class="col-6">
                    <label>Họ</label>
                    <input type="text" name="ho" class="form-control" value="${ kh.ho }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên đệm</label>
                    <input type="text" name="ten_dem" class="form-control" value="${ kh.ten_dem }" />
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" value="${ kh.ten }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <input type="date" name="ngay_sinh" class="form-control" value="${ kh.ngay_sinh }" />
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <input type="tel" name="sdt" class="form-control" value="${ kh.sdt }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <input type="text" name="dia_chi" class="form-control" value="${ kh.dia_chi }" />
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <input type="password" name="password" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <select name="quoc_gia" class="form-select">
                        <option value="vn" ${ kh.quoc_gia == "vn" ? "selected" : "" }>Việt Nam</option>
                        <option value="en" ${ kh.quoc_gia == "en" ? "selected" : "" }>Anh</option>
                    </select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="quoc_gia" class="form-select">
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
