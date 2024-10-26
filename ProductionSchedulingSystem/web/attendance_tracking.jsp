
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Chấm Công và Theo Dõi Hiệu Suất</title>
        <link rel="stylesheet" href="styles.css">
    </head>

    <body>

        <div class="container">
            <jsp:include page="header.jsp" />

            <h2>Chấm Công Công Nhân</h2>
            <form id="attendanceForm">
                <label for="workerId">ID Công nhân:</label>
                <input type="text" id="workerId" name="workerId" required>

                <label for="productName">Tên sản phẩm:</label>
                <input type="text" id="productName" name="productName" required><br>

                <label for="producedQuantity">Số lượng hoàn thành:</label>
                <input type="number" id="producedQuantity" name="producedQuantity" required>

                <label for="alpha">Hệ số hiệu quả (alpha):</label>
                <input type="number" step="0.1" id="alpha" name="alpha" required>

                <button type="submit">Chấm Công</button>
            </form>

            <h3>Bảng chấm công</h3>
            <table id="attendanceTable">
                <tr>
                    <th>ID Công nhân</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng hoàn thành</th>
                    <th>Hệ số hiệu quả</th>
                </tr>
            </table>
        </div>

    </body>
</html>

