<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Quản Lý Kế Hoạch Sản Xuất</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
            <h2>Quản Lý Kế Hoạch Sản Xuất</h2>
            <form action="addPlan" method="POST">
                <label for="name">Tên kế hoạch</label>
                <input type="text" id="name" name="name" required>

                <label for="department">Xưởng</label>
                <select id="department" name="did">
                    <c:forEach var="o" items="${departments}">
                        <option value="${o.dId}">${o.dName}</option>
                    </c:forEach>

                </select>

                <label for="date">Ngày bắt đầu</label>
                <input type="date" id="date" name="startDate" required>

                <label for="date">Ngày kết thúc</label>
                <input type="date" id="date" name="endDate" required>

                <button type="submit">Thêm Kế Hoạch</button>
            </form>

            <h3>Danh sách kế hoạch sản xuất</h3>
            <table id="productionPlansTable">
                <tr>
                    <th>Tên kế hoạch</th>
                    <th>Xưởng sản xuất</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                    <th>Chi tiết</th>
                    <th>Hành động</th>
                        <c:forEach var="o" items="${plans}">
                    <tr>
                        <td>${o.plName}</td>
                        <td>${o.department.dName}</td>
                        <td>${o.startDate}</td>
                        <td>${o.endDate}</td>
                        <td>${o.plId}</td>
                        <td>${o.plId}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>
