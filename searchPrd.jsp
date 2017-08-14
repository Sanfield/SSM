<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/store/css/mycss.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索商品</title>
<script type="text/javascript" src="/store/js/jquery-1.11.2.js"></script>
<script type="text/javascript">
 $(function(){
	$.get("/store/typeServlet",{"method":"agaxlist"},function(data){
		var $selTypeId=$("select[name='typeId']");//获取select的节点
		$.each(data,function(idx,element){
			var option=$("<option></option>");
			option.text(element.name);
			option.prop("value",element.product_type_id);
			$selTypeId.append(option);
		});
	},"json");
	
	$("#btnSearch").click(searchPrd);
 })
 //检索函数
 function searchPrd(){
	 var data={};
	 var prdName=$("input[name='pname']").val();
	 if(prdName){
		 data.PrdName=prdName;
	 }
	 var typeId=$("select[name='typeId']").val();
	 if(typeId){
		 data.typeId=typeId;
	 }
	 var lowPrice=$("input[name='lowPrice']").val();
	 if(lowPrice){
		 data.lowPrice=lowPrice;
	 }
	 var upPrice=$("input[name='upPrice']").val();
	 if(upPrice){
		 data.upPrice=upPrice;
	 }
	 console.info(data);
	 data.method="ajaxSearch";
	 $.post("/store/ProductServlet",data,function(d){
		 //回调函数；
		 var tbody=$("#tbody1");
		 tbody.empty();
		 if(d&&d.length >0){
			 $.each(d,function(index,element){
				 var tr=$("<tr></tr>");
				 var td=$("<td>");
			     td.append("<input name='selectedPrdId' type='checkbox' value='"+element.product_id+"'/>");
			     tr.append(td);
				 td = $("<td>");
				 td.text(element.name);
				 
				console.info(element.name);
					tr.append(td);
					td = $("<td>");
				if (element.protype && element.protype.name) {
						td.text(element.protype.name);
					}
					tr.append(td);
					
					td = $("<td>");
					td.text(element.description);
					tr.append(td);
					
					td = $("<td>");
					td.text(element.price);
					tr.append(td);
					
					td = $("<td>");
					var a = $("<a>");
					a.text("编辑");
					a.prop("href", "/store/typeServlet?method=edit&prdId="
							+ element.prdId);
					td.append(a);
					a = $("<a>");
					a.text("删除");
					a.prop("href", "javascript:void(0)");
					a.attr("onclick", "delProduct(" + element.prdId + ")");
					td.append(a);

					tr.append(td);

					tbody.append(tr);
			 })
		 }
	 },"json");
	 
 }
 function batchDelete(){
	 var ids=[];
	 $("input[name='selectedPrdId']:checked").each(function (idx,ele){
		 ids.push($(ele).val());
	 });
	// alert(ids.length);
	 if(ids.length==0){
		 alert("至少选一件");
	 }else{
		 var data={};
		 data.method="batchDelete";
		 data.prdId=ids.join(",");
		 $.post("/store/ProductServlet",data,function(d){
			 if(d&&d.result){
				 alert("共删除了"+d.count+"条商品");
				 searchPrd();
			 }else{
				 alert(d.msg);
			 }
		 },"json");
	 }
 }
</script>
</head>
<body>
名称:<input type="text" name="pname"></input>
类别:<select name="typeId">
	<option value="0">不限</option>
</select>
价格：<input type="text" name="lowPrice"></input>~<input type="text" name="upPrice"></input><br/>
<input type="button" id="btnSearch"  value="搜索"/>
<table class="mytb">
	<thead>
		<tr>
			<th>编号</th>	
		    <th>名称</th>
		    <th>类别</th>
		    <th>描述</th>
		    <th>价格</th>
		    <th>操作</th>
		</tr>
	</thead>
	<tbody id="tbody1">
	</tbody>
</table>
<input type="button" value="选中删除" id="deletedBtn" onclick="batchDelete();"/>
</body>
</html>