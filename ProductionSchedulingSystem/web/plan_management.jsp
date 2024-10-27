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
            <form id="productionPlanForm">
                <label for="productName">Tên sản phẩm:</label>
                <input type="text" id="productName" name="productName" required>

                <label for="quantity">Số lượng:</label>
                <input type="number" id="quantity" name="quantity" required>

                <label for="shift">Ca làm việc:</label>
                <select id="shift" name="shift">
                    <option value="K1">K1 (6:00 - 14:00)</option>
                    <option value="K2">K2 (14:00 - 22:00)</option>
                    <option value="K3">K3 (22:00 - 6:00)</option>
                </select>
                <br>

                <label for="department">Xưởng</label>
                <select id="department" name="did">
                    <c:forEach var="o" items="${departments}">
                        <option value="${o.dId}">${o.dName}</option>

                    </c:forEach>

                </select>

                <label for="date">Ngày sản xuất:</label>
                <input type="date" id="date" name="date" required>

                <button type="submit">Thêm Kế Hoạch</button>
            </form>

            <h3>Danh sách kế hoạch sản xuất</h3>
            <table id="productionPlansTable">
                <tr>
                    <th>Sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Ca làm việc</th>
                    <th>Ngày sản xuất</th>
                </tr>
            </table>
        </div>
    </body>
</html>
