<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="Paging" uri="/WEB-INF/tld/Paging.tld" %>
<jsp:include page="../../include/zmos-head.jsp"/>
<jsp:include page="../../include/zmos-sys-menu.jsp"/>
<script type="text/javascript" src="/static/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $('.portal-all_menu li').each(function () {
        document.getElementById(this.id).className = "";
        document.getElementById("menu-click").className = "active";
    });
</script>
<div class="admin">
    <form method="post" action="/sys/clicklist" id="queryPage"
          name="queryPage">
        <input type="hidden" id="beginPage" name="curPage" value="${curPage}"/>
        <div class="panel admin-panel">
            <div class="panel-head"><strong>流量统计</strong></div>
            <div class="padding border-bottom">
                日期范围：
                <input type="text" id="start_date" name="startTime" class="Wdate" style="width:125px;height:25px;" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${startTime}"/>
                ~
                <input type="text" id="end_date" name="endTime" class="Wdate" style="width:125px;height:25px;" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${endTime}"/>
                <a href="javascript:searchParam()">
                    <input type="button"
                           class="button button-small bg-blue margin-big-left"
                           value="检索"/>
                </a>
                <b><span style="color:red">${errorCode}</span></b>
            </div>
            <table class="table table-hover">
                <tr>
                    <th width="5%">ID</th>
                    <th width="10%">uid</th>
                    <th width="10%">流量（PV）</th>
                    <th width="10%">统计时间</th>
                </tr>
                <c:forEach items="${paginationSupport.items}" var="data">
                    <tr>
                        <td>${data.id}</td>
                        <td>${data.uid}
                            (<Paging:account uid="${data.uid}"></Paging:account>)
                        </td>
                        <td>${data.accessCount}</td>
                        <td title="${data.addtime}">${data.addtime}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="panel-foot text-center">
                <Paging:paging pageContent="paginationSupport"></Paging:paging>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    function searchParam()
    {
        queryPage.submit();
    }
</script>
<%
    request.getSession().removeAttribute("errorCode");
%>