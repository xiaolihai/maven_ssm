<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- .box-footer-->
<div class="box-footer">
    <div class="pull-left">
        <div class="form-group form-inline">
            总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页
            <select class="form-control" id="changePageSize" onchange="changePageSize()">
                <c:forEach begin="1" end="5" var="i">
                    <option <c:if test="${pageInfo.pageSize==i}">selected</c:if>>${i}</option>
                </c:forEach>


            </select> 条
        </div>
    </div>

    <div class="box-tools pull-right">
        <ul class="pagination">
            <li>
                <a href="${url}?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>
            </li>
            <li><a href="${url}?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>
            <c:forEach begin="${pageInfo.navigateFirstPage}" end="${pageInfo.navigateLastPage}" var="pageNum">
                <c:if test="${pageInfo.pageNum==pageNum}" >
                    <li class="active">
                        <a href="javascript:void(0)">${pageNum}</a>
                    </li>
                </c:if>
                <c:if test="${pageInfo.pageNum!=pageNum}">
                    <li><a href="${url}?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>
                </c:if>
            </c:forEach>
            <li><a href="${url}?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
            <li>
                <a href="${url}?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>
            </li>
        </ul>
    </div>

</div>
<!-- /.box-footer-->
