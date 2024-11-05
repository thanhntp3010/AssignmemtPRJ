<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Production Scheduling System</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <header class="header-container">
            <h1>Hệ Thống Quản Lý Kế Hoạch Sản Xuất</h1>
            <nav>
                <ul>
                    <li><a href="managePlan">Quản Lý Kế Hoạch Sản Xuất</a></li>
                    <li><a href="worker_assignment.jsp">Phân Công Công Việc</a></li>
                    <li><a href="attendance_tracking.jsp">Chấm Công Công Nhân</a></li>
                    <li><a href="monthly_report.jsp">Báo Cáo Lương Cuối Tháng</a></li>
                        <c:if test="${sessionScope['LOGIN_USER']!=null}">
                        <li><a style="color: black">Xin chào, ${sessionScope['LOGIN_USER'].username}</a></li>
                        <li><a href="logout">Đăng xuất</a></li>
                    </c:if>
                    <c:if test="${sessionScope['LOGIN_USER']==null}">
                        <li><a href="login.jsp">Đăng Nhập</a></li>

                    </c:if>
                </ul>
            </nav>
        </header>
    </body>
</html>
