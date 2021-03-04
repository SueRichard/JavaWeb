function deleteCheck(id){
	var check=confirm("确认删除吗？");
	if(check){
		location="/delete?id="+id;
	}
}
function evaluation(obj,id){
	var tds=$(obj).parent().parent().find("td");
	$("#cuid").val(id);
	$("#cuName").val($(tds.eq(1)).text());
	$("#cuPrice").val($(tds.eq(2)).text());
	$("#cuInfo").val($(tds.eq(3)).text());
	$("#cuNum").val($(tds.eq(4)).text());
	$("#cuPeriod").val($(tds.eq(5)).text());
	$("#cuStartTime").val($(tds.eq(6)).text());
	$("#cuEndTime").val($(tds.eq(7)).text());
}