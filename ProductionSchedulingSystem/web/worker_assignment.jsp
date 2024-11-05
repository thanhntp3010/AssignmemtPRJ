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
            <form action="assignWorker" method="POST" id="workerAssignmentForm">
                <label for="product">Chọn sản phẩm</label>
                <select id="product" name="employeeId" class="form-control" required>
                    <c:forEach var="product" items="${products}">
                        <option value="${product.pId}">${product.pName}</option>
                    </c:forEach>
                </select>

                <label for="product">Chọn nhân viên</label>
                <select id="product" name="productId" class="form-control" required>
                    <c:forEach var="o" items="${employees}">
                        <option value="${o.eid}">${o.ename} - ${o.sname}</option>
                    </c:forEach>
                </select>
                
                <label for="quantity">Số lượng</label>
                <input type="number" id="quantity" name="quantity" required>
                
                <button type="submit">Phân Công</button>
            </form>

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
                        <td>${o.shiftId}</td>
                        <td>${o.employeeQuantity}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

