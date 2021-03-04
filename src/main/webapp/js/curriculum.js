function deleteCheck(id){
	var check=confirm("确认删除吗？");
	if(check){
		location="/delete?id="+id;
	}
}