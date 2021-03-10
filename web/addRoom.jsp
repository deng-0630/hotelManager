<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/9
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h3{
            text-align: center;
        }
        table{
            width: 500px;
        }
        table tr{
            text-align: center;
            height: 40px;
        }
        table tr td:nth-of-type(2){
            color: red;
            text-align: left;
            padding-left:10px ;
        }
        table tr td:first-of-type:not(:last-of-type){
            background-color: #aaaaaa;
        }
        table tr:last-of-type td{
            text-align: center;
        }
    </style>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script>
        function validate() {
            var ok=true;
            $(":text").each(function (i,e) {
                if (e.value.trim()==""){
                    ok=false;
                   $(e).next().text($(e).parent().prev().text()+"不能为空");
                    return ok;
                }
            })
            if (ok==false)return ok;
            //下拉框验证
            if ($("select option:selected").val()=="0"){
                ok=false;
                $("table tr td select").next().text("下拉框不能是默认选项");
            }
            if (ok==false)return ok;
            //正整数验证
            var reg1=/^\d+$/;
            if(!reg1.test($(":input[name='peopleCount']").val().trim())){
                ok=false;
                $("input[name='peopleCount']").next().text("人数必须是正整数");
            }
            if (ok==false)return ok;
            var rag2=/^\d+(.\d{1,2})?$/;
            if(!rag2.test($(":input[name='rent']").val().trim())){
                ok=false;
                $("input[name='rent']").next().text("租金必须是正数，可以带2位小数");
            }
            return ok;
        }
        function checkrepeat(v) {
            $.post("check","rna="+v.value,function (data) {
                $("input[name='roomNo']").next().text(data==0?"房号可以使用":"房号已存在");
            })
        }
    </script>
</head>
<body>

<h3>旅馆房屋管理</h3>
<form action="addRoom" method="post" onsubmit="return validate()">
    <table border="1" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td>房间编号</td>
            <td>
                *
                <input type="text" name="roomNo" onblur="checkrepeat(this)">
                <span></span>
            </td>
        </tr>
        <tr>
            <td>房间类型</td>
            <td>
                *
                <select name="roomType">
                    <option value="0">选择房间类型</option>
                    <option value="普通单元间">普通单元间</option>
                    <option value="山景单元间">山景单元间</option>
                    <option value="海景单元间">海景单元间</option>
                    <option value="总统套房">总统套房</option>
                </select>
                <span></span>
            </td>
        </tr>
        <tr>
            <td>人数</td>
            <td>
                *
                <input type="text" name="peopleCount">
                <span></span>
            </td>
        </tr>
        <tr>
            <td>租金</td>
            <td>
                *
                <input type="text" name="rent">
                <span></span>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
