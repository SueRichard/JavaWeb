// 暂未使用
function recharge(credit) {
    var charge = confirm("你的积分为" + credit + "，不足100，是否充值？");
    if (charge) {
        location = "/recharge.jsp";
    }
}
// 此方法有点复杂,已调换start
function nolike(){
	$("#likes").css("display","none");
	$("#nolike").css("display","inline");
}
function like(){
	$("#likes").css("display","inline");
	$("#nolike").css("display","none");
}
// 此方法有点复杂,已调换end

function switchPicture(id){
	var i =0;
	var src=$("#likeImg").attr("src");
	if(src=="img/hand.png"){
		$("#likeImg").attr("src","img/colorlessHand.png");
		i=-1;
	}else if(src=="img/colorlessHand.png"){
		$("#likeImg").attr("src","img/hand.png");
		i=1;
	}
	$.post("/updateCriticismLike",{num:i,id:id},function(result){
		$("#likeNumber").text(result);
	});
}