<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/8
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      h3{
        text-align: center;
      }
      div{
        text-align: right;
        margin: 0 auto;
        width: 600px;
      }
      table{
        margin-top: 15px;
        width: 600px;
      }
      table tr{
        text-align: center;
      }
      table tr:first-of-type{
        background-color: #aaaaaa;
      }
      .state0{
        background-color: aqua;
      }
      .state1{
        background-color: white;
      }
    </style>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script>
      $(function () {

      })
      function orderRoom(btn) {

        var txt=$(btn).text();
        var ok=confirm("确定要执行"+txt+"操作吗");
        var state=txt=="订房"?0:1;
        var rid=$(btn).parent().parent().find("td:first-child").text();

        if (ok){
          $.post("orderRoom","rid="+rid+"&state="+state,function (date) {
            //返回更新后的房间状态 0||1
            $(btn).parent().parent().attr("class","state"+date);
            $(btn).text(date==0?"订房":"退房");
          })
        }
      }
    </script>
  </head>
  <body>
  <h3>旅館房屋管理</h3>
  <div>
    <a href="addRoom.jsp"> <button>新增房間</button>
    </a>
  </div>
  <table border="1" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <th>序號</th>
      <th>房間編號</th>
      <th>房間類型</th>
      <th>容納人數</th>
      <th>房間價格(/天)</th>
      <th>操作</th>
    </tr>
    <c:if test="${not empty room}">
      <c:forEach items="${room}" var="r">
        <tr class="state${r.isRental}">
          <td>${r.id}</td>
          <td>${r.roomNo}</td>
          <td>${r.roomType}</td>
          <td>${r.peopleConut}</td>
          <td>${r.rent}</td>
          <td><button onclick="orderRoom(this)">${r.isRental==0?"订房":"退房"}</button></td>
        </tr>
      </c:forEach>
    </c:if>

  </table>
  </body>
</html>
