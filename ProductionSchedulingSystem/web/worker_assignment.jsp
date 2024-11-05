<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
            <h2>Phân Công Công Việc Cho Nhân viên</h2>

            <h3>Danh sách công việc phân công</h3>
            <table id="assignedTasksTable">
                <tr>
                    <th>Kế hoạch</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                    <th>Nhân viên</th>
                    <th>Sản phẩm</th>
                    <th>Ca làm việc</th>
                    <th>Số lượng</th>
                </tr>
                <c:forEach var="o" items="${list}">
                    <tr>
                        <td>${o.planName}</td>
                        <td>${o.startDate}</td>
                        <td>${o.endDate}</td>
                        <td>${o.name}</td>
                        <td>${o.productId}</td>
                        <td>K${o.shiftId}</td>
                        <td>${o.employeeQuantity}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

