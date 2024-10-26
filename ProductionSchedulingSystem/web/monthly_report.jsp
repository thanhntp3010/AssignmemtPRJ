
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Báo Cáo Lương Cuối Tháng</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
            <h2>Báo Cáo Lương Cuối Tháng</h2>
            <table id="salaryReportTable">
                <tr>
                    <th>ID Công nhân</th>
                    <th>Tên công nhân</th>
                    <th>Số ngày làm việc</th>
                    <th>Lương cuối tháng</th>
                </tr>
            </table>
        </div>
    </body>
</html>
