<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/17/23
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/SP23B2_SOF3011_IT17308_war_exploded/css/bootstrap.min.css" />

</head>
<body>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                    <a class="nav-link" href="/SP23B2_SOF3011_IT17308_war_exploded/khach-hang/index">Khách Hàng</a>
                    <a class="nav-link" href="#">Pricing</a>
                </div>
            </div>
        </div>
    </nav>

    <div class="row mt-3" style="min-height: 600px;">
        <div class="bg-warning col-3">Side bar</div>
        <div class="bg-light col-9">
            <jsp:include page="${ view }" />
        </div>
    </div>

    <div class="row mt-3 bg-dark ms-0">Footer</div>

    <script src="/SP23B2_SOF3011_IT17308_war_exploded/js/bootstrap.min.js"></script>

</body>
</html>
