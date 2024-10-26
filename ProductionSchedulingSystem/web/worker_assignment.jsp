
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Phân Công Công Việc</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
            <h2>Phân Công Công Việc Cho Công Nhân</h2>
            <form id="workerAssignmentForm">
                <label for="workerId">ID Công nhân:</label>
                <input type="text" id="workerId" name="workerId" required>

                <label for="productName">Tên sản phẩm:</label>
                <input type="text" id="productName" name="productName" required>

                <label for="shift">Ca làm việc:</label>
                <select id="shift" name="shift">
                    <option value="K1">K1 (6:00 - 14:00)</option>
                    <option value="K2">K2 (14:00 - 22:00)</option>
                    <option value="K3">K3 (22:00 - 6:00)</option>
                </select>

                <button type="submit">Phân Công</button>
            </form>

            <h3>Danh sách công việc phân công</h3>
            <table id="assignedTasksTable">
                <tr>
                    <th>ID Công nhân</th>
                    <th>Tên sản phẩm</th>
                    <th>Ca làm việc</th>
                </tr>

            </table>
        </div>
    </body>
</html>

