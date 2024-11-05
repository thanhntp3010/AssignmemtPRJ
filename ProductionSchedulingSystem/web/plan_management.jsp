<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Quản Lý Kế Hoạch Sản Xuất</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles.css">

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <c:if test="${sessionScope['LOGIN_USER'].roleId != 5}">
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
            </c:if>

            <h3>Danh sách kế hoạch sản xuất</h3>
            <table id="productionPlansTable" class="table table-striped">
                <tr>
                    <th>Tên kế hoạch</th>
                    <th>Xưởng sản xuất</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                    <th>Gán đầu việc</th>
                        <c:if test="${sessionScope['LOGIN_USER'].roleId == 5}">
                        <th>Chi tiết</th>

                    </c:if>
                    <c:if test="${sessionScope['LOGIN_USER'].roleId != 5}">
                        <th>Hành động</th>
                        </c:if>
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
                        <c:if test="${sessionScope['LOGIN_USER'].roleId == 5}">
                            <td>
                                <button type="button" class="btn btn-info view-detail-btn" data-toggle="modal" data-target="#viewDetailModal" data-planid="${o.plId}">
                                    Chi tiết
                                </button>
                            </td>
                        </c:if>
                        <c:if test="${sessionScope['LOGIN_USER'].roleId != 5}">
                            <td>
                                <button type="button" class="btn btn-warning edit-plan-btn" data-toggle="modal" data-target="#editPlanModal" data-planid="${o.plId}" data-name="${o.plName}" data-department="${o.department.dId}" data-startdate="${o.startDate}" data-enddate="${o.endDate}">
                                    Sửa
                                </button> 
                                <button type="button" class="btn btn-danger delete-plan-btn" data-toggle="modal" data-target="#deletePlanModal" data-planid="${o.plId}">
                                    Xóa
                                </button>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <!-- Modal Sửa kế hoạch -->
        <div class="modal fade" id="editPlanModal" tabindex="-1" role="dialog" aria-labelledby="editPlanModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <form id="editPlanForm" action="editPlan" method="POST">
                        <div class="modal-header">
                            <h5 class="modal-title" id="editPlanModalLabel">Sửa Kế Hoạch</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" id="editPlanId" name="id">
                            <label for="editName">Tên kế hoạch</label>
                            <input type="text" id="editName" name="name" required><br>

                            <label for="editDepartment">Xưởng</label>
                            <select id="editDepartment" name="did">
                                <c:forEach var="o" items="${departments}">
                                    <option value="${o.dId}">${o.dName}</option>
                                </c:forEach>
                            </select><br>

                            <label for="editStartDate">Ngày bắt đầu</label>
                            <input type="date" id="editStartDate" name="startDate" required><br>

                            <label for="editEndDate">Ngày kết thúc</label>
                            <input type="date" id="editEndDate" name="endDate" required>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                            <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal Xóa kế hoạch -->
        <div class="modal fade" id="deletePlanModal" tabindex="-1" role="dialog" aria-labelledby="deletePlanModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deletePlanModalLabel">Xóa Kế Hoạch</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Bạn có chắc chắn muốn xóa kế hoạch này không?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                        <a href="#" id="confirmDeleteBtn" class="btn btn-danger">Xóa</a>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $(document).on('click', '.edit-plan-btn', function () {
                var planId = $(this).data('planid');
                var name = $(this).data('name');
                var departmentId = $(this).data('department');
                var startDate = $(this).data('startdate');
                var endDate = $(this).data('enddate');

                $('#editPlanId').val(planId);
                $('#editName').val(name);
                $('#editDepartment').val(departmentId);
                $('#editStartDate').val(startDate);
                $('#editEndDate').val(endDate);
            });

            $(document).on('click', '.delete-plan-btn', function () {
                var planId = $(this).data('planid');

                $('#confirmDeleteBtn').attr('href', 'deletePlan?id=' + planId);
            });

        </script>


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
                                <th>Sản Phẩm</th>
                                <th>Số Lượng</th>
                                <th>Ước Lượng Công Việc</th>
                                <th>Gán Nhân Viên</th>
                            </tr>
                        </thead>
                        <tbody id="taskDetailsBody">
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
                url: 'planHeader',
                type: 'GET',
                data: {planId: planId},
                dataType: 'json',
                success: function (response) {
                    console.log("Response:", response);
                    $('#taskDetailsBody').empty();

                    if (Array.isArray(response)) {
                        $.ajax({
                            url: 'employee', 
                            type: 'GET',
                            dataType: 'json',
                            success: function (employees) {
                                console.log("Employees:", employees);
                                response.forEach(function (task) {
                                    console.log("Task:", task);

                                    var employeeOptions = "<option value=''>Chọn nhân viên</option>";
                                    if (Array.isArray(employees)) {
                                        employees.forEach(function (employee) {
                                            employeeOptions += "<option value='" + employee.eid + "'>" + employee.ename + " - " +
                                                  employee.sname  + "</option>";
                                        });
                                    }

                                    var row = "<tr>" +
                                            "<td>" + task.phId + "</td>" +
                                            "<td>" + task.productName + "</td>" +
                                            "<td>" + task.quantity + "</td>" +
                                            "<td>" + task.estimatedEffort + "</td>" +
                                            "<td>" +
                                            "<form action='assignTask' method='POST' class='assign-task-form'>" +
                                            "<select class='form-control' name='employeeId' required>" +
                                            employeeOptions + 
                                            "</select>" +
                                            "<input type='number' class='form-control' name='quantity' placeholder='Nhập số lượng' min='1' required />" +
                                            "<input type='hidden' name='taskId' value='" + task.phId + "' />" + 
                                            "<button type='submit' class='btn btn-primary mt-2'>Gán</button>" +
                                            "</form>" +
                                            "</td>" +
                                            "</tr>";

                                    $('#taskDetailsBody').append(row);
                                    console.log(row);
                                });
                            },
                            error: function (xhr, status, error) {
                                console.error("Error loading employees:", status, error);
                                alert('Không thể tải danh sách nhân viên.');
                            }
                        });
                    } else {
                        console.warn("Response is not an array");
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Error:", status, error);
                    alert('Không thể tải chi tiết đầu việc.');
                }
            });
        });
    </script>




</html>
