<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Quản Lý Kế Hoạch Sản Xuất</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <h2>Quản Lý Kế Hoạch Sản Xuất</h2>
            <form action="addPlan" method="POST">
                <label for="name">Tên kế hoạch</label>
                <input type="text" id="name" name="name" required>

                <label for="department">Xưởng</label>
                <select id="department" name="did">
                    <c:forEach var="o" items="${departments}">
                        <option value="${o.dId}">${o.dName}</option>
                    </c:forEach>
                </select><br>

                <label for="date">Ngày bắt đầu</label>
                <input type="date" id="date" name="startDate" required>

                <label for="date">Ngày kết thúc</label>
                <input type="date" id="date" name="endDate" required>

                <button type="submit">Thêm Kế Hoạch</button>
            </form>

            <h3>Danh sách kế hoạch sản xuất</h3>
            <table id="productionPlansTable" class="table table-striped">
                <tr>
                    <th>Tên kế hoạch</th>
                    <th>Xưởng sản xuất</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                    <th>Gán đầu việc</th>
                    <th>Chi tiết</th>
                    <th>Hành động</th>
                </tr>
                <c:forEach var="o" items="${plans}">
                    <tr>
                        <td>${o.plName}</td>
                        <td>${o.department.dName}</td>
                        <td>${o.startDate}</td>
                        <td>${o.endDate}</td>
                        <td>
                            <button type="button" class="btn btn-primary assign-task-btn" data-toggle="modal" data-target="#assignTaskModal" data-planid="${o.plId}">
                                Gán đầu việc
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-info view-detail-btn" data-toggle="modal" data-target="#viewDetailModal" data-planid="${o.plId}">
                                Chi tiết
                            </button>
                        </td>

                        <td>
                            <a href="editPlan?id=${o.plId}">Sửa</a> | <a href="deletePlan?id=${o.plId}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="modal fade" id="assignTaskModal" tabindex="-1" aria-labelledby="assignTaskModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addPlanHeader" method="POST">
                        <div class="modal-header">
                            <h5 class="modal-title" id="assignTaskModalLabel">Gán Đầu Việc</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" id="modalPlanId" name="planId">

                            <label for="product">Chọn sản phẩm:</label>
                            <select id="product" name="productId" class="form-control" required>
                                <c:forEach var="product" items="${products}">
                                    <option value="${product.pId}">${product.pName}</option>
                                </c:forEach>
                            </select>

                            <label for="quantity">Số lượng:</label>
                            <input type="number" id="quantity" name="quantity" class="form-control" required>

                            <label for="estimatedeffort">Ước lượng:</label>
                            <input type="number" id="estimatedeffort" name="estimatedeffort" class="form-control" required>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Lưu</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script>
            $(document).on('click', '.assign-task-btn', function () {
                var planId = $(this).data('planid');
                $('#modalPlanId').val(planId);
            });
        </script>
    </body>
    <div class="modal fade" id="viewDetailModal" tabindex="-1" aria-labelledby="viewDetailModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="viewDetailModalLabel">Chi Tiết Đầu Việc</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID Đầu Việc</th>
                                <th>Tên Sản Phẩm</th>
                                <th>Số Lượng</th>
                                <th>Ước Lượng Công Việc</th>
                            </tr>
                        </thead>
                        <tbody id="taskDetailsBody">
                            <!-- Dữ liệu sẽ được điền từ AJAX -->
                        </tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).on('click', '.view-detail-btn', function () {
            var planId = $(this).data('planid');

            $.ajax({
                url: 'getPlanHeaders', 
                type: 'GET',
                data: {planId: planId},
                success: function (response) {
                    $('#taskDetailsBody').empty();

                    response.forEach(function (task) {
                        var row = `
                        <tr>
                            <td>${task.phId}</td>
                            <td>${task.productName}</td>
                            <td>${task.quantity}</td>
                            <td>${task.estimatedEffort}</td>
                        </tr>`;
                        $('#taskDetailsBody').append(row);
                    });
                },
                error: function () {
                    alert('Không thể tải chi tiết đầu việc.');
                }
            });
        });
    </script>


</html>
